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
    public void MostrarBicis() {
        for (int i=0; i < getBicicletas().size(); i++) {
            MostrarBici(i);
        }
    }

    @Override
    public void MostrarBici(int i) {
        System.out.println(getBicicletas().get(i).Nombrar());
    }

    @Override
    public void Nombrar() {
        System.out.println("Carrera de Montana: " + this.getNombreCarrera());
    }

    @Override
    public void run() {
        System.out.println("Están corriendo  "+ getNumBicicletas() + " bicis de montaña ");
        int retirar = (int) Math.round(getNumBicicletas() * 0.20);
        retirarBicis(retirar);
        System.out.println("Se han retirado "+ retirar + " bicis de montaña ");
        correr();
    }

}