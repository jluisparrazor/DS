public class Cliente {
    private GestorFiltros gestorFiltros;

    public Cliente(GestorFiltros gestorFiltros){
        this.gestorFiltros = gestorFiltros;
    }

    public double ejecutar(double revoluciones, EstadoMotor estadoMotor){
        return gestorFiltros.ejecutar(revoluciones, estadoMotor);
    }
}
