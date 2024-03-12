import java.util.ArrayList;

public class CadenaFiltros {
    private ArrayList<Filtro> filtros = new ArrayList<>();
    private Objetivo objetivo;

    public void addFiltro(Filtro filtro){
        filtros.add(filtro);
    }

    public void setObjetivo(Objetivo objetivo){
        this.objetivo = objetivo;
    }

}
