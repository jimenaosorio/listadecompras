package cl.inacap.puntaarenas.listadecompras.modelo;

import cl.inacap.puntaarenas.listadecompras.R;

public class Producto {
    private String nombre;
    private int cantidad;
    private String unidad;
    private boolean estado;
    private static final boolean PENDIENTE=true;

    public Producto(String nombre, int cantidad, String unidad, boolean estado) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.estado = estado;
    }

    public Producto(String nombre, int cantidad, String unidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.estado=PENDIENTE;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    @Override
    public String toString() {
        String comprado;
        if(estado) comprado="pendiente";
        else comprado="comprado";
        return nombre + ": " + comprado;
    }
}
