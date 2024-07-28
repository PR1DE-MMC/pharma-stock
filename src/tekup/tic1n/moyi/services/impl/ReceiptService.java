package tekup.tic1n.moyi.services.impl;

import tekup.tic1n.moyi.models.Receipt;
import tekup.tic1n.moyi.models.Stock;
import tekup.tic1n.moyi.models.enumeration.PaymentType;
import tekup.tic1n.moyi.services.AbstractService;
import tekup.tic1n.moyi.services.exceptions.InvalidMedicationException;
import tekup.tic1n.moyi.services.singletons.StockServiceSingleton;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Objects.isNull;
import static tekup.tic1n.moyi.utils.ConsoleUtil.*;
import static tekup.tic1n.moyi.utils.ConsoleUtil.readChoice;
import static tekup.tic1n.moyi.utils.FileSystemUtil.readObjects;

public class ReceiptService extends AbstractService<Receipt> {

    private static final String FILE_NAME = "receipt_db";
    private final StockService stockService;

    public ReceiptService() {
        super(readObjects(FILE_NAME, Receipt.class), FILE_NAME);
        this.stockService = StockServiceSingleton.getInstance();
    }

    @Override
    public int create() {
        Receipt newReceipt = new Receipt(count()+1);
        newReceipt.setReceiptDate(LocalDate.now());
        newReceipt.setReceiptTime(LocalTime.now());
        PaymentType paymentType = null;
        List<Stock> medications = new ArrayList<>();
        int medicationNumber = readInt(">>> How Many Medications would you like to add?\n>>>");

        for (int i = 0; i < medicationNumber; i++) {
            Stock receiptStock = new Stock(i);
            int medCount = 0;
            stockService.showAll();
            try {
                int medId = readInt(">>>Enter Medication ID to add to Receipt: \n>>>");
                Stock actualStock = stockService.getByMedicationId(medId).orElseThrow(InvalidMedicationException::new);
                medCount = readInt(">>> How Much of it would you like to add? \n>>>");
                int availableQuantity = Math.min(actualStock.getQuantity(), medCount);
                receiptStock.setQuantity(availableQuantity);
                receiptStock.setMedication(actualStock.getMedication());
                stockService.reduceStock(medId, availableQuantity);
                medications.add(receiptStock);
            } catch (InvalidMedicationException e) {
                System.out.println(e.getMessage());
                String createChoice = readLine(">>> Would you like to create a new Stock? ([Y]es | [N]o)\n>>>)");
                if ("y".equalsIgnoreCase(createChoice)) {
                    int newMedId = stockService.create();
                    Stock actualStock = stockService.getByMedicationId(newMedId).orElseThrow(InvalidMedicationException::new);
                    medCount = readInt(">>> How Much of it would you like to add? \n>>>");
                    int availableQuantity = Math.min(actualStock.getQuantity(), medCount);
                    receiptStock.setQuantity(availableQuantity);
                    receiptStock.setMedication(actualStock.getMedication());
                    stockService.reduceStock(newMedId, availableQuantity);
                    medications.add(receiptStock);
                }
            }
        }

        while(isNull(paymentType)){
            System.out.println(">>>Enter Payment Type: ");
            writeChoices(PaymentType.values());

            paymentType = (PaymentType) readChoice(PaymentType.values());
        }

        newReceipt.setMedications(medications);

        newReceipt.setTotalAmount(
                (float) medications.stream()
                .mapToDouble(
                    medication -> medication.getQuantity() * medication.getMedication().getPrice()
                ).sum()
        );

        System.out.println("=> Added Receipt: " + newReceipt.toString());
        items.add(newReceipt);
        return newReceipt.getId();
    }

    public double getTotal(){
        return items.stream().mapToDouble(Receipt::getTotalAmount).sum();
    }

    public void showTotal(){
        System.out.println("=> The Total Amount is : " + getTotal() + " TND");
    }

    public void sort(boolean descending){
        Collections.sort(items);
        if(descending){
            Collections.reverse(items);
        }
    }

    public void showSorted(){
        sort(readBoolean("\">>> Would you like to sort them as Descending? ([Y]es | [N]o)\\n>>>)\""));
        items.forEach(receipt -> System.out.println(receipt.toString()));
    }

}
