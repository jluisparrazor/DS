import java.util.ArrayList;

public class Pagina implements ElementoWeb {
    private String nombre;
    private int identificador;
    ArrayList<ElementoWeb> elementos;
     
    Pagina() {
        nombre = "SinNombre";
        identificador = -1;
        elementos = new ArrayList<ElementoWeb>();
    }
    
    Pagina(String nombre, int id, ArrayList<ElementoWeb> elem) {
        this.nombre = nombre;
        this.identificador = id;
        this.elementos = elem;
    }
    Pagina(String nombre, int id) {
        this.nombre = nombre;
        this.identificador = id;
        elementos = new ArrayList<ElementoWeb>();
        
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
    public void nombrar() {
        
        System.out.println("Página " + getNombre() + " con identificador " + getIdentificador());
        
        if(elementos.size() > 0) {
            System.out.print("  Elementos de la página " + getNombre() + ": ");
        }
        
        for(int i=0; i<elementos.size(); i++) {
           System.out.print(elementos.get(i).getNombre() + " ") ;
        }
        System.out.println();
    }

    public boolean add(ElementoWeb elem) {
        boolean insertado = elementos.add(elem);

        if(insertado) {
            System.out.println("Se ha  insertado el elemento " + elem.getNombre() + " en " + this.getNombre());

        }
        else {
            System.out.println("No se ha podido insertar el elemento " + elem.getNombre() + " en " + this.getNombre());

        }
        return insertado;
    }
}
