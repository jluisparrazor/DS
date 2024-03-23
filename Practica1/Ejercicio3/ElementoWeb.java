public interface ElementoWeb {
    
    String getNombre();
    int getIdentificador();
    void setNombre(String nombre);
    void setId(int id);
    void nombrar();
    boolean add(ElementoWeb elem);
};
