import java.util.ArrayList;

public class FactoriaCarretera implements FactoriaCarreraYBicicleta {
    public FactoriaCarretera() {

    }

    public CarreraCarretera crearCarrera() {
        CarreraCarretera objCarreraCarretera = new CarreraCarretera();

        return objCarreraCarretera;
    }

    public BicicletaCarretera crearBicicleta() {
        BicicletaCarretera objBicicletaCarretera = new BicicletaCarretera();

        return objBicicletaCarretera;
    }

    public ArrayList<BicicletaCarretera> crearBicicletas(int numBicicletas) {
        ArrayList<BicicletaCarretera> bicicletas = new ArrayList<BicicletaCarretera>();
        for (int i = 0; i < numBicicletas; i++) {
            bicicletas.add(new BicicletaCarretera(i + 1));
        }
        return bicicletas;
    }
}