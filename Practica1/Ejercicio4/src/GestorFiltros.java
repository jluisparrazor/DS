public class GestorFiltros {
    private CadenaFiltros cadenaFiltros;

    public GestorFiltros(Objetivo salpicadero){
        cadenaFiltros = new CadenaFiltros(salpicadero);
    }

    public void addFiltro( Filtro filtro){
        cadenaFiltros.addFiltro(filtro);
    }

    public double ejecutar(double revoluciones, EstadoMotor estadoMotor){
        return cadenaFiltros.ejecutar(revoluciones, estadoMotor);
    }
}
