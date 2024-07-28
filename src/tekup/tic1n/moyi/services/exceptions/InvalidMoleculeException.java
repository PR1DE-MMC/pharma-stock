package tekup.tic1n.moyi.services.exceptions;

public class InvalidMoleculeException extends RuntimeException{
    public InvalidMoleculeException(){
        super("The Molecule Id you Provided is absent in Database!");
    }
}
