package tekup.tic1n.moyi.service.exception;

public class InvalidMoleculeException extends RuntimeException{
    public InvalidMoleculeException(){
        super("The Molecule Id you Provided is absent in Database!");
    }
}
