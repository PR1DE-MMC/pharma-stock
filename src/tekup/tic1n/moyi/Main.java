package tekup.tic1n.moyi;

import tekup.tic1n.moyi.menu.MedicationMenu;
import tekup.tic1n.moyi.menu.MoleculeMenu;
import tekup.tic1n.moyi.menu.StockMenu;
import static tekup.tic1n.moyi.utils.ConsoleUtil.readChoice;
import static tekup.tic1n.moyi.utils.ConsoleUtil.writeChoices;

public class Main {

    private static final String[] choices = {"Medication","Molecule","Stock","Quit"};

    public static void main(String[] args) {

        MedicationMenu medicationMenu = new MedicationMenu();
        MoleculeMenu moleculeMenu = new MoleculeMenu();
        StockMenu stockMenu = new StockMenu();

        while(true){
            writeChoices(choices);
            switch((String) readChoice(choices)){
                case "Medication":{
                    medicationMenu.showChoices();
                    break;
                }
                case "Molecule":{
                    moleculeMenu.showChoices();
                    break;
                }
                case 'Stock':{
                    stockMenu.showChoices();
                    break;
                }
                case "Quit": {
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Not a valid choice!");
            }
        }
    }
}