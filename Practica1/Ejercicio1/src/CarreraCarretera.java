import java.util.ArrayList;

public class CarreraCarretera extends Carrera implements Runnable{

    public CarreraCarretera() {
    }

    public CarreraCarretera(String nombre, ArrayList<Bicicleta> bicicletas) {
        super(nombre, bicicletas);
    }

    @Override
    public String MostrarBicis() {
        String mostrar = "";
        for (int i=0; i < getBicicletas().size(); i++) {
            mostrar += getBicicletas().get(i).Nombrar() + "\n";
        }

        return mostrar;
    }
    @Override
    public void Nombrar() {
        System.out.println("Carrera de Carretera: " + this.getNombreCarrera());
    }

    @Override
    public void run() {
        Nombrar();
        correr();
        int retirar = (int) Math.round(getNumBicicletas() * 0.10);
        System.out.println("Retirando "+ retirar + " bicis de carretera: ");
        retirarBicis(retirar);

        System.out.println("\nBicicletas restantes: ");
        correr();

    }
}