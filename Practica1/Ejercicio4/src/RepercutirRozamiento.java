public class RepercutirRozamiento implements Filtro{
    
    public RepercutirRozamiento(){}

    public double ejecutar(double revoluciones, EstadoMotor estadoMotor){
        revoluciones --;
        return revoluciones;
    }
}
