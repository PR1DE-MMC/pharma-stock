package tekup.tic1n.moyi.services.exceptions;

public class InvalidMedicationException extends RuntimeException{
    public InvalidMedicationException(){
        super("The Medication Id you Provided is absent in Database!");
    }
}
