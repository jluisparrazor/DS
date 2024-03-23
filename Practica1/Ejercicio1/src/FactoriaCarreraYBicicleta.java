import java.util.ArrayList;

public interface FactoriaCarreraYBicicleta {
    Carrera crearCarrera(String nombre, ArrayList<Bicicleta> bicicletas);

    Bicicleta crearBicicleta(int num);
}