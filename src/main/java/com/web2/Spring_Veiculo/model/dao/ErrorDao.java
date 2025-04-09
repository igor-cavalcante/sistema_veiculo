package com.web2.Spring_Veiculo.model.dao;

public  class ErrorDao extends Exception {
    public ErrorDao() {
        super("Erro Dao");
    }
    public ErrorDao(String message) {
        super("Erro dao " + message);
    }
    public ErrorDao(String message, Throwable cause) {
        super(message, cause);
    }
    public ErrorDao(Throwable cause) {
        super(cause);
    }
    public ErrorDao(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);

    }
}
