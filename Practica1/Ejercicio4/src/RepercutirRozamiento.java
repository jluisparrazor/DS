public class RepercutirRozamiento implements Filtro{
    public double ejecutar(double revoluciones, EstadoMotor estadoMotor){
        revoluciones --;
        return revoluciones;
    }
}
