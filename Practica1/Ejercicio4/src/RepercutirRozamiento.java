public class RepercutirRozamiento implements Filtro{
    final int decrementoVelocidad = 1;
    
    public RepercutirRozamiento(){}

    public double ejecutar(double revoluciones, EstadoMotor estadoMotor){
        if (revoluciones > decrementoVelocidad)
            return revoluciones - decrementoVelocidad;
        else 
            return 0;
    }
}
