public class RepercutirRozamiento implements Filtro{
    
    public RepercutirRozamiento(){}

    public double ejecutar(double revoluciones, EstadoMotor estadoMotor){
        if(revoluciones > 0){
            revoluciones --;
        }else{
            revoluciones = 0;
        }
        
        return revoluciones;
    }
}
