
public class BicicletaMontana extends Bicicleta {
    BicicletaMontana(int identificador) {
        super(identificador);
    }

    BicicletaMontana() {
        super();
    }

    @Override
    public void Nombrar() {
        System.out.println("Bicicleta de montaña");
    }
}