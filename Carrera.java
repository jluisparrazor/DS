import java.util.ArrayList;

public abstract class Carrera {
    
    // Atributos privados
    private String nombreCarrera;
    private ArrayList<Bicicleta> participantes;
    
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

/* CLASE ABSTRACTA NO PUEDE SER INSTANCIADA
    // Constructor con parametros
    public Carrera(ArrayList<Bicicleta> participantes) {
        this.participantes = participantes;
    }

    // Constructor sin parametros
     public Carrera() {
        this.participantes = new ArrayList<Bicicleta>();
    }
*/