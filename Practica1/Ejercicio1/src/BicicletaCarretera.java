
public class BicicletaCarretera extends Bicicleta {
   
    BicicletaCarretera() {
        super();
    }

    BicicletaCarretera(int identificador) {
        super(identificador);
    }

    @Override
    public String Nombrar() {
        return ("La bicicleta de carretera con identificador " + identificador);
    }
}