import java.util.ArrayList;

public abstract class Carrera {
    // Atributos privados
    private String nombreCarrera;
    private ArrayList<Bicicleta> participantes;
    
    // Constructor con parametros
    protected Carrera(String nombre, ArrayList<Bicicleta> participantes) {
        nombreCarrera = nombre;
        this.participantes = participantes;
    }

    // Constructor sin parametros
    protected Carrera() {
        nombreCarrera = "";
        this.participantes = new ArrayList<Bicicleta>();
    }

// Metodos setter y getter
    public ArrayList<Bicicleta> getParticipantes() {
        return this.participantes;
    }

    public void setParticipantes(ArrayList<Bicicleta> participantes) {
        this.participantes = participantes;
    }

    public String getNombreCarrera() {
        return this.nombreCarrera;
    }

    public void setNombre(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public abstract void Nombrar(); // Decir nombre de la carrera
}

