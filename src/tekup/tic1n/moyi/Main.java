package tekup.tic1n.moyi;

import tekup.tic1n.moyi.menu.MedicationMenu;
import tekup.tic1n.moyi.menu.MoleculeMenu;

import static tekup.tic1n.moyi.utils.ConsoleUtil.readChoice;
import static tekup.tic1n.moyi.utils.ConsoleUtil.writeChoices;

public class Main {

    private static final String[] choices = {"Medication","Molecule","Dosage","Quit"};

    public static void main(String[] args) {

        MedicationMenu medicationMenu = new MedicationMenu();
        MoleculeMenu moleculeMenu = new MoleculeMenu();
        DosageMenu dosageMenu = new DosageMenu();

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
                case "Dosage":{
                    dosageMenu.showChoices();
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