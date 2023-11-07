package br.com.vanessa.screenmatch.exception;

public class ExceededLength extends RuntimeException {
    private String message;
    public ExceededLength(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
