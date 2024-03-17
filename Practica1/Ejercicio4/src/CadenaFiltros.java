import java.util.ArrayList;

public class CadenaFiltros {

    private ArrayList<Filtro> filtros = new ArrayList<>();
    private Objetivo objetivo;

    CadenaFiltros(){
        filtros.clear();
    }

    public double ejecutar(double revoluciones, EstadoMotor estadoMotor){
        for(int i = 0; i < filtros.size() ; i++){
            revoluciones = filtros.get(i).ejecutar(revoluciones, estadoMotor);
        }
        return revoluciones;
    }

    void addFiltro( Filtro filtro){
        filtros.add(filtro);
    }
}
