import java.util.ArrayList;
import java.util.Random;

public abstract class Carrera extends Thread{
    // Atributos privados
    private String nombreCarrera;
    // private const duracion = 60;
    private ArrayList<Bicicleta> bicicletas;

    // Constructor con parametros
    protected Carrera(String nombre, ArrayList<Bicicleta> bicicletas) {
        this.nombreCarrera = nombre;
        this.bicicletas = bicicletas;
    }

    // Constructor sin parametros
    protected Carrera(String nombre) {
        nombreCarrera = nombre;
        this.bicicletas = new ArrayList<Bicicleta>();
    }

    protected Carrera() {
        nombreCarrera = "";
        this.bicicletas = new ArrayList<Bicicleta>();
    }

    // Metodos setter y getter
    public ArrayList<Bicicleta> getBicicletas() {
        return this.bicicletas;
    }

    public int getNumBicicletas() {
        return bicicletas.size();
    }

    public void setBicicletas(ArrayList<Bicicleta> bicicletas) {
        this.bicicletas = bicicletas;
    }

    public String getNombreCarrera() {
        return this.nombreCarrera;
    }

    public void setNombre(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
        
    }
    
    public void correr() {
        System.out.println(MostrarBicis());
    }

    public boolean retirarBici(int pos) {
        boolean retirada = false;  
        
        if(pos<bicicletas.size()) {
            retirada = true; // Retirada correctamente 
            String bicicleta = bicicletas.get(pos).Nombrar();
            System.out.println(bicicleta + " se ha retirado");
            this.bicicletas.remove(pos);
        }

        return retirada;
    }

    public void retirarBicis(int n_Retiradas) {
        Random ran = new Random();
        int tam_necesario = this.bicicletas.size() - n_Retiradas;
        while (this.bicicletas.size() > tam_necesario) {
            int x = ran.nextInt(this.bicicletas.size());
            retirarBici(x);
        }

    }
    

    public abstract String MostrarBicis(); //Mostrar todas las bicis

    public abstract void Nombrar(); // Decir nombre de la carrera 

    public abstract void run();
}
