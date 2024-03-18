import java.util.ArrayList;

public class CadenaFiltros {

    private ArrayList<Filtro> filtros; 
    private Objetivo salpicadero;

    CadenaFiltros(Objetivo objetivo){
        salpicadero = objetivo;
        filtros = new ArrayList<Filtro>();
    }

    public double ejecutar(double revoluciones, EstadoMotor estadoMotor){
        for(int i = 0; i < filtros.size() ; i++){
            revoluciones = filtros.get(i).ejecutar(revoluciones, estadoMotor);
        }

        salpicadero.ejecutar(revoluciones, estadoMotor);

        return revoluciones;
    }

    void addFiltro( Filtro filtro){
        filtros.add(filtro);
    }
}
