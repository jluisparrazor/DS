
public class BicicletaCarretera extends Bicicleta {
    BicicletaCarretera(int identificador) {
        super(identificador);
    }

    @Override
    public void Nombrar() {
        System.out.println("Bicicleta de carretera");
    }
}