
package Entidades;

public class Inscripcion {
    
    private int id;
    private Alumno alumno;
    private Materia materia;
    private Double nota;

    public Inscripcion() {
    }

    public Inscripcion(Alumno alumno, Materia materia, Double nota) {
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }

    public Inscripcion(int id, Alumno alumno, Materia materia, Double nota) {
        this.id = id;
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "id=" + id + ", nota=" + nota +"apellidoAlumno="+alumno.getApellido()+
                "materia"+materia.getNombre()+'}';
    }
    
    
    
}
