import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        ArrayList<BicicletaMontana> bicicletasMontana = new ArrayList<BicicletaMontana>();
        ArrayList<BicicletaCarretera> bicicletasCarretera = new ArrayList<BicicletaCarretera>();

        for (int i = 0; i < 10; i++) {
            bicicletasMontana.add(new BicicletaMontana(i));
            bicicletasCarretera.add(new BicicletaCarretera(i));
        }

        // Las bicicletas se crean con las factoriascarretera y factoriamontana
    }
}
