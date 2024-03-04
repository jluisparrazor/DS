import java.util.ArrayList;

public class CarreraMontana extends Carrera {  
     // Constructor con parametros
    public CarreraMontana(String nombre, ArrayList<Bicicleta> participantes) {
        this.nombreCarrera = nombre;
        this.participantes = participantes;
    }

    // Constructor sin parametros
    protected Carrera() {
        nombreCarrera = "";
        this.participantes = new ArrayList<Bicicleta>();
    }
    @Override
    public void Nombrar() {
        System.out.println("Carrera de Montaña: "+ this.getNombreCarrera());
    }
}