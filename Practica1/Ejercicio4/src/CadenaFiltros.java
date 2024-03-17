import java.util.ArrayList;

public class CadenaFiltros {

    private ArrayList<Filtro> filtros = new ArrayList<>();
    private Objetivo objetivo;

    CadenaFiltros(){
        filtros.clear();
    }

    public void addFiltro(Filtro filtro){
        filtros.add(new CalcularVelocidad());
        filtros.add(new RepercutirRozamiento());
    }

    public void setObjetivo(Objetivo objetivo){
        this.objetivo = objetivo;
    }

    public double ejecutar(double revoluciones, EstadoMotor estadoMotor){
        revoluciones = filtros.get(0).ejecutar(revoluciones, estadoMotor);
        revoluciones = filtros.get(1).ejecutar(revoluciones, estadoMotor);
        return revoluciones;
    }

}
