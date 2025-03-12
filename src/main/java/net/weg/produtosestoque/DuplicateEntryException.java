package net.weg.produtosestoque;

public class DuplicateEntryException extends RuntimeException {
    @Override
    public String getMessage() {
        return "there is already a product with this name in the database, please try again with another name";
    }
}
