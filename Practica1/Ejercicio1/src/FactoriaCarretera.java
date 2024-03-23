import java.util.ArrayList;

public class FactoriaCarretera extends Thread implements FactoriaCarreraYBicicleta {
    
    public FactoriaCarretera() {

    }

    public CarreraCarretera crearCarrera(String nombre, ArrayList<Bicicleta> bicicletas) {
        CarreraCarretera objCarreraCarretera = new CarreraCarretera(nombre, bicicletas);

        return objCarreraCarretera;
    }

    public BicicletaCarretera crearBicicleta(int id) {
        BicicletaCarretera objBicicletaCarretera = new BicicletaCarretera(id);

        return objBicicletaCarretera;
    }
}