
public class BicicletaMontana extends Bicicleta {
    // Constructor sin parametros
    BicicletaMontana() {
        super();
    }

    // Constructor con parametros
    BicicletaMontana(int identificador) {
        super(identificador);
    }



    @Override
    public String Nombrar() {
        return ("La bicicleta de Montaña con identificador " + identificador);
    }
}