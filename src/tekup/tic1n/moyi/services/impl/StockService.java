package tekup.tic1n.moyi.services.impl;

import tekup.tic1n.moyi.models.Medication;
import tekup.tic1n.moyi.models.Stock;
import tekup.tic1n.moyi.services.AbstractService;
import tekup.tic1n.moyi.services.exceptions.InvalidMedicationException;
import tekup.tic1n.moyi.services.singletons.MedicationServiceSingleton;

import java.util.Optional;

import static java.util.Objects.isNull;
import static tekup.tic1n.moyi.utils.ConsoleUtil.readInt;
import static tekup.tic1n.moyi.utils.ConsoleUtil.readLine;
import static tekup.tic1n.moyi.utils.FileSystemUtil.readObjects;

public class StockService extends AbstractService<Stock> {

    private static final String FILE_NAME = "stock_db";

    private final MedicationService medicationService;

    public StockService() {
        super(readObjects(FILE_NAME, Stock.class), FILE_NAME);
        this.medicationService = MedicationServiceSingleton.getInstance();
    }

    @Override
    public int create() {
        Stock newStock = new Stock(count()+1);
        Medication medicationToAssign = null;
        int quantity = 0;

        while (isNull(medicationToAssign)) {
            try {
                int medId = readInt(">>>Enter Medication ID to assign to stock: \n>>>");
                medicationToAssign = medicationService.getById(medId).orElseThrow(InvalidMedicationException::new);
            } catch (InvalidMedicationException e) {
                System.out.println(e.getMessage());
                String createChoice = readLine(">>> Would you like to create a new Medication? ([Y]es | [N]o)\n>>>)");
                if ("y".equalsIgnoreCase(createChoice)) {
                    int newMedId = medicationService.create();
                    medicationToAssign = medicationService.getById(newMedId).orElseThrow(InvalidMedicationException::new);
                }
            }
        }

        while(quantity <= 0){
            quantity = readInt(">>>Enter Medication Quantity: \n>>>");
        }
        newStock.setMedication(medicationToAssign);
        newStock.setQuantity(quantity);
        items.add(newStock);
        System.out.println("=> Added Stock: " + newStock.toString());

        return newStock.getId();
    }

    public void reduceStock(int medicationId, int quantity){
        Stock stockToUpdate = items.stream()
                .filter(stock -> stock.getMedication().getId() == medicationId)
                .findFirst()
                .map(stock -> {
                    stock.decreaseQuantity(quantity);
                    return stock;
                })
                .orElseThrow(InvalidMedicationException::new);
        System.out.println("=> Updated Stock: " + stockToUpdate.toString());
    }

    public void increaseStock(int medicationId, int quantity){
        Stock stockToUpdate = items.stream()
                .filter(stock -> stock.getMedication().getId() == medicationId)
                .findFirst()
                .map(stock -> {
                    stock.increaseQuantity(quantity);
                    return stock;
                })
                .orElseThrow(InvalidMedicationException::new);
        System.out.println("=> Updated Stock: " + stockToUpdate.toString());
    }

    public void increaseStock(){
        while(true){
            try {
                int medId = readInt(">>>Enter Medication ID: \n>>>");
                int quantity = readInt(">>>Enter Medication Added Quantity: \n>>>");
                increaseStock(medId, quantity);
                break;
            }
            catch (InvalidMedicationException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void reduceStock(){
        while(true){
            try {
                int medId = readInt(">>>Enter Medication ID: \n>>>");
                int quantity = readInt(">>>Enter Medication Quantity To reduce: \n>>>");
                reduceStock(medId, quantity);
                break;
            }
            catch (InvalidMedicationException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Optional<Stock> getByMedicationId(int medicationId){
        return items.stream()
                .filter(stock -> stock.getMedication().getId() == medicationId)
                .findFirst();
    }

    public int getAvailableStock(int medicationId){
         Stock stockToGet = items.stream()
                .filter(stock -> stock.getMedication().getId() == medicationId)
                .findFirst()
                .orElseThrow(InvalidMedicationException::new);

         return stockToGet.getQuantity();
    }

    public void getAvailableStock(){
        int medId = readInt(">>>Enter Medication ID: \n>>>");
        getByMedicationId(medId).ifPresent(System.out::println);
    }

}
