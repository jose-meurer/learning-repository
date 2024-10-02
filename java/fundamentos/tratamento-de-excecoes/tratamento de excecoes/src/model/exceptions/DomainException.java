package model.exceptions;

public class DomainException extends Exception {
    //Exception = Obriga a tratar o erro.
    //RuntimeException = Não obriga a tratar o erro.

    public DomainException(String msg) {
        super(msg);
    }
}
