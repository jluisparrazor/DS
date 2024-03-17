public class Objetivo {
    private double vLineal = 0;
	private double distancia = 0;
	private double revoluciones = 0;
        long inicio = 0;
        long actual = 0;
        long anterior = 0;
        static final double radio = 0.15;
        
        Objetivo()
        {
            this.inicio = System.currentTimeMillis();
        }
        

	public void ejecutar(double revol, EstadoMotor EstadoMotor)
        {
            // Acelerando o frenando
            if(EstadoMotor == EstadoMotor.ACELERANDO || EstadoMotor == EstadoMotor.ACELERANDO)
            {
                this.anterior = this.actual;
                this.actual = System.currentTimeMillis();
                this.vLineal = 2*Math.PI*radio*revol*((double)(60.0/1000.0));
                this.revoluciones = revol;
                this.distancia += this.vLineal * ((this.actual - anterior))/3600000;
            }
            
            // Ni acelerando ni frenando, pero velocidad constante
            if(EstadoMotor == EstadoMotor.ENCENDIDO)
            {
                this.anterior = this.actual;
                this.actual = System.currentTimeMillis();
                this.vLineal = 2*Math.PI*radio*revol*((double)(60.0/1000.0));
                this.revoluciones = revol;
                this.distancia += this.vLineal * ((this.actual - anterior))/3600000;
            }
            
            else {
                this.actual = System.currentTimeMillis();
            }
	}
        
        public double getVelocidad(){return this.vLineal;}
        
        public double getDistancia(){return this.distancia;}
        
        public double getRevoluciones(){return this.revoluciones;}
        
        public void setVelocidad(double v){this.vLineal = v;}
        
        public void setDistancia(double d){this.distancia = d;}
        
        public void setRevoluciones(double r){this.revoluciones = r;}

}

