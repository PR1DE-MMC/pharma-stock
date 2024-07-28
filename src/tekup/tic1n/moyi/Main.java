package tekup.tic1n.moyi;

import static tekup.tic1n.moyi.utils.ConsoleUtil.readChoice;
import static tekup.tic1n.moyi.utils.ConsoleUtil.writeChoices;

public class Main {

    private static final String[] choices = {"Quit"};

    public static void main(String[] args) {

        while(true){
            writeChoices(choices);
            switch((String) readChoice(choices)){
                case "quit": {
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Not a valid choice!");
            }
        }
    }
}