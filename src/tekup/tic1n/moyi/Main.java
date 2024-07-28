package tekup.tic1n.moyi;

import tekup.tic1n.moyi.menus.*;
import tekup.tic1n.moyi.services.impl.*;
import tekup.tic1n.moyi.services.singletons.*;

import static tekup.tic1n.moyi.utils.ConsoleUtil.readChoice;
import static tekup.tic1n.moyi.utils.ConsoleUtil.writeChoices;

public class Main {

    private static final String[] choices = {"medication", "molecule", "dosage", "receipt", "stock", "quit"};

    public static void main(String[] args) {

        MedicationMenu medicationMenu = new MedicationMenu();
        MoleculeMenu moleculeMenu = new MoleculeMenu();
        DosageMenu dosageMenu = new DosageMenu();
        StockMenu stockMenu = new StockMenu();
        ReceiptMenu receiptMenu = new ReceiptMenu();

        while(true){
            writeChoices(choices);
            switch((String) readChoice(choices)){
                case "medication": {
                    medicationMenu.showChoices();
                    break;
                }
                case "molecule": {
                    moleculeMenu.showChoices();
                    break;
                }
                case "dosage": {
                    dosageMenu.showChoices();
                    break;
                }
                case "stock": {
                    stockMenu.showChoices();
                    break;
                }
                case "receipt":{
                    receiptMenu.showChoices();
                    break;
                }
                case "quit": {
                    medicationMenu.destroy();
                    moleculeMenu.destroy();
                    dosageMenu.destroy();
                    receiptMenu.destroy();
                    stockMenu.destroy();
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Not a valid choice!");
            }
        }
    }
}