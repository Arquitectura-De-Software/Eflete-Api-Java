package com.grupo4.eflete.Model;

public enum CodigoEstadoEnvio {
    INICIADO(1), TOMADO(2), CARGANDO(3), ENPROCESO(4), DESCARGANDO(5), FINALIZADO(6);

    private final int value;
    private CodigoEstadoEnvio(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
