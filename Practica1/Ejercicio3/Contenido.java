

public interface Contenido extends ElementoWeb {
    
    String getNombre();
    int getIdentificador();
    void setNombre(String nombre);
    void setId(int id);
    boolean getCentrado();
    void setCentrado(boolean centrado);
    void nombrar();
    boolean add(Contenido cont);
}
