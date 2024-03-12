import java.util.ArrayList;
import java.util.Scanner;

public class main{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa un número: ");
        double N = scanner.nextInt();
        scanner.close();

        FactoriaCarreraYBicicleta factoriaMontana = new FactoriaMontana();
        FactoriaCarreraYBicicleta factoriaCarretera = new FactoriaCarretera();
        ArrayList<Bicicleta> bicicletasMontana = new ArrayList<Bicicleta>();
        ArrayList<Bicicleta> bicicletasCarretera = new ArrayList<Bicicleta>();
        
        for (int i = 0; i < N; i++) {
            bicicletasMontana.add(factoriaMontana.crearBicicleta(i));
            bicicletasCarretera.add(factoriaCarretera.crearBicicleta(i));
        }

        Carrera carreraMontana = factoriaMontana.crearCarrera(" ALBACETE ", bicicletasMontana);
        Carrera carreraCarretera = factoriaCarretera.crearCarrera(" MURCIA ", bicicletasCarretera);


        System.out.println("\n");

        carreraMontana.start();
        carreraCarretera.start();
        
    }
}


// implementar de la clase runnable, implementar metodo run, que tiene que inciar la carrera con un meotod correr
// metodo eliminar bici, que primero corran todas, luego se eliminan el 20% de las de montaña O 10% de las de carretera
// Y MUESTREN UN MENSAJE POR PONTALLA estilo la bici X no ha sido capaz de terminar el recorrido







        /*
         * ArrayList<BicicletaMontana> bicicletasMontana = new
         * ArrayList<BicicletaMontana>();
         * FactoriaMontana factoriaMontana = new FactoriaMontana();
         * ArrayList<BicicletaCarretera> bicicletasCarretera = new
         * ArrayList<BicicletaCarretera>();
         * FactoriaCarretera factoriaCarretera = new FactoriaCarretera();
         * 
         * bicicletasMontana = factoriaMontana.crearBicicletas(10);
         * bicicletasCarretera = factoriaCarretera.crearBicicletas(10);
         * // Las bicicletas se crean con las factoriascarretera y factoriamontana
         */
        