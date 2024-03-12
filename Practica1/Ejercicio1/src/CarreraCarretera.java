
public class CarreraCarretera extends Carrera {

    public CarreraCarretera() {
    }

    public CarreraCarretera(String nombre) {
        super(nombre);
    }

    @Override
    public void Nombrar() {
        System.out.println("Carrera de Carretera: " + this.getNombreCarrera());
    }

}