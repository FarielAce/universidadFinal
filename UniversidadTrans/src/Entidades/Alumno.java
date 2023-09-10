
package Entidades;

import java.time.LocalDate;

public class Alumno {
    
    private int id;
    private String apellido;
    private String nombre;
    private int dni;
    private LocalDate fechaNac;
    private boolean estado;
    public Alumno() {
    }

    public Alumno(String apellido, String nombre, int dni, LocalDate fechaNac, boolean estado) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNac = fechaNac;
        this.estado = estado;
    }

    public Alumno(int id, String apellido, String nombre, int dni, LocalDate fechaNac, boolean estado) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNac = fechaNac;
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", apellido=" + apellido + ", nombre=" + nombre + ", dni=" + dni + ", fechaNac=" + fechaNac + '}';
    }
    
    
    
}
