import java.util.ArrayList;

public class CarreraMontana extends Carrera {

    public CarreraMontana() {
    }

    public CarreraMontana(String nombre) {
        super(nombre);
    }

    @Override
    public void Nombrar() {
        System.out.println("Carrera de Montaña: " + this.getNombreCarrera());
    }
}