import java.util.ArrayList;

public class Texto implements Contenido {

    private String nombre;
    private int identificador;
    private boolean centrado;
    ArrayList<Contenido> contenido;

    Texto() {
        nombre = "SinNombre";
        identificador = -1;
        centrado = false;
        contenido = new ArrayList<Contenido>();
    }

    Texto(String nombre, int id) {
        this.nombre = nombre;
        this.identificador = id;
        this.centrado = false;
        contenido = new ArrayList<Contenido>();
    }

    Texto(String nombre, int id,boolean centrado, ArrayList<Contenido> contenido) {
        this.nombre = nombre;
        this.identificador = id;
        this.centrado = centrado;
        this.contenido = contenido;
    }

    public String getNombre() {
        return nombre;
    }
    public int getIdentificador() {
        return identificador;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setId(int id) {
        this.identificador = id;
    }
    public boolean getCentrado() {
        return centrado;
    }
    public void setCentrado(boolean centrado) {
        this.centrado = centrado;
    }

    public void nombrar() {
        String out = "";
        if (getCentrado()) {
            out += "Texto centrado ";
        } else {
            out += "Texto ";
        }
        out += getNombre() + " con identificador " + getIdentificador();
        System.out.println(out);
        if(contenido.size()>0) {
            System.out.print("  Elementos del texto " + getNombre() + ": ");
        }
        
        for(int i=0; i<contenido.size(); i++) {
            System.out.print(contenido.get(i).getNombre() + " ") ;
        }
        System.out.println();

    }
    public boolean add(Contenido cont) {
        boolean insertado = contenido.add(cont);

        if(insertado) {
            System.out.println("Se ha  insertado el contenido " + cont.getNombre() + " en " + this.getNombre());

        }
        else {
            System.out.println("No se ha podido insertar el contenido " + cont.getNombre() + " en " + this.getNombre());

        }
        return insertado;
    }

    public boolean add(ElementoWeb elem) {
        System.out.println("No se ha podido insertar el elemento " + elem.getNombre() + " en " + this.getNombre());
        return false;
    }

}
