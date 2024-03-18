public class Objetivo {
    private double vLineal, distancia, revoluciones;
    long tiempoActual, tiempoAnterior;
    static final double radio = 0.15;
    
    Objetivo()
    {
        tiempoActual = System.currentTimeMillis();
        vLineal = 0;
        distancia = 0;
        revoluciones = 0;
    }
        

	public void ejecutar(double revol, EstadoMotor EstadoMotor)
        {
        tiempoAnterior = tiempoActual;
        tiempoActual = System.currentTimeMillis();
        revoluciones = revol;
        vLineal = 2 * Math.PI * radio * revoluciones * (60.0 / 1000.0);
        distancia += vLineal / 3600000 * (tiempoActual - tiempoAnterior);
	}
        
        public double getVelocidad(){return this.vLineal;}
        
        public double getDistancia(){return this.distancia;}
        
        public double getRevoluciones(){return this.revoluciones;}
        
        public void setVelocidad(double v){this.vLineal = v;}
        
        public void setDistancia(double d){this.distancia = d;}
        
        public void setRevoluciones(double r){this.revoluciones = r;}

}

