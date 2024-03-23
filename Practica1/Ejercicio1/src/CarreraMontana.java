import java.util.ArrayList;

public class CarreraMontana extends Carrera implements Runnable{

    // Cosntructor sin parametros
    public CarreraMontana() {
    }

    //
    public CarreraMontana(String nombre, ArrayList<Bicicleta> bicicletas) {
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
        System.out.println("Carrera de Montana: " + this.getNombreCarrera());
    }

    @Override
    public void run() {
        Nombrar();
        correr();
        int retirar = (int) Math.round(getNumBicicletas() * 0.20);
        System.out.println("Retirando "+ retirar + " bicis de montaña: ");
        retirarBicis(retirar);

        System.out.println("\nBicicletas restantes: ");
        correr();


    }

}