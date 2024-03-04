public class FactoriaMontana implements FactoriaCarreraYBicicleta{
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
}