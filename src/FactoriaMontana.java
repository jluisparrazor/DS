import java.util.ArrayList;

public class FactoriaMontana implements FactoriaCarreraYBicicleta {
    public FactoriaMontana() {

    }

    public CarreraMontana crearCarrera() {
        CarreraMontana objCarreraMontana = new CarreraMontana();

        return objCarreraMontana;
    }

    public BicicletaMontana crearBicicleta() {
        BicicletaMontana objBicicletaMontana = new BicicletaMontana();

        return objBicicletaMontana;
    }

    public ArrayList<BicicletaMontana> crearBicicletas(int numBicicletas) {
        ArrayList<BicicletaMontana> bicicletas = new ArrayList<BicicletaMontana>();
        for (int i = 0; i < numBicicletas; i++) {
            bicicletas.add(new BicicletaMontana(i + 1));
        }
        return bicicletas;
    }
}