import java.util.ArrayList;

public class FactoriaMontana implements FactoriaCarreraYBicicleta {
    public FactoriaMontana() {

    }

    public CarreraMontana crearCarrera(String nombre, ArrayList<Bicicleta> bicicletas) {
        CarreraMontana objCarreraMontana = new CarreraMontana(nombre, bicicletas);

        return objCarreraMontana;
    }

    public BicicletaMontana crearBicicleta(int id) {
        BicicletaMontana objBicicletaMontana = new BicicletaMontana(id);

        return objBicicletaMontana;
    }

}