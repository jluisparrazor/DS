abstract class Bicicleta {
    public int identificador;
    
    public Bicicleta() {
        identificador = -1;
    }

    public Bicicleta(int id) {
        identificador = id;
    }
    
    public abstract String Nombrar();
}