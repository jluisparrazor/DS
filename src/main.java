import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        ArrayList<BicicletaMontana> bicicletasMontana = new ArrayList<BicicletaMontana>();
        FactoriaMontana factoriaMontana = new FactoriaMontana();
        ArrayList<BicicletaCarretera> bicicletasCarretera = new ArrayList<BicicletaCarretera>();
        FactoriaCarretera factoriaCarretera = new FactoriaCarretera();

        bicicletasMontana = factoriaMontana.crearBicicletas(10);
        bicicletasCarretera = factoriaCarretera.crearBicicletas(10);
        // Las bicicletas se crean con las factoriascarretera y factoriamontana
    }
}
