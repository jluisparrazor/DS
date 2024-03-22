

public class Imagen implements Contenido {
    private String nombre;
    private int identificador;
    private boolean centrado;
   
    Imagen() {
        nombre = "SinNombre";
        identificador = -1;
        centrado = false;
    }
    
    Imagen(String nombre, int id) {
        this.nombre = nombre;
        this.identificador = id;
        this.centrado = false;
    }

    Imagen(String nombre, int id, boolean centrado) {
        this.nombre = nombre;
        this.identificador = id;
        this.centrado = centrado;
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
            out += "    Imagen centrada ";
        } else {
            out += "    Imagen ";
        }
        out += getNombre() + " con identificador " + getIdentificador();
        System.out.println(out);
    }
    
    public boolean add(Contenido elem) {
        System.out.println("No se ha podido insertar el contenido " + elem.getNombre() + " en " + this.getNombre());
        return false;
    }

    public boolean add(ElementoWeb elem) {
        System.out.println("No se ha podido insertar el elemento " + elem.getNombre() + " en " + this.getNombre());
        return false;
    }
}
