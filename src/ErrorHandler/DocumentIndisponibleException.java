package ErrorHandler;

public class DocumentIndisponibleException extends Exception{
    @Override
    public String toString() {
        return "DOCUMENT INDISPONIBLE !!";
    }
}
