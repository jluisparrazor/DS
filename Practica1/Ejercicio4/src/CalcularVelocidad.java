public class CalcularVelocidad implements Filtro {
    
    int incrementoVelocidad;

    public CalcularVelocidad(){
        incrementoVelocidad = 0;
    }

    public double ejecutar(double revoluciones, EstadoMotor estadoMotor){
        if( ( estadoMotor == EstadoMotor.APAGADO ) || (estadoMotor == EstadoMotor.ENCENDIDO)){
            incrementoVelocidad = 0;
        }else if ( estadoMotor == EstadoMotor.FRENANDO){
            incrementoVelocidad = -100;
        }else{
            incrementoVelocidad = +100;
        }
        
        double rev = revoluciones + incrementoVelocidad;

        if( rev > 5000)
            rev = 5000;

        return rev;
    }

}
