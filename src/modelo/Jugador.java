package modelo;

public class Jugador extends Persona {
    private double altura;     
    private String posicion;   
    private int numeroCamiseta;

    public Jugador(String nombre, String apellido, long dni, java.time.LocalDate fn, double altura, String posicion, int numeroCamiseta) {
        super(nombre, apellido, dni, fn);
        this.altura = altura;
        this.posicion = posicion;
        this.numeroCamiseta = numeroCamiseta;
    }

    public double getAltura() { 
    	return altura; 
    	}
    
    public String getPosicion() { 
    	return posicion; 
    	}
    
    public int getNumeroCamiseta() { 
    	return numeroCamiseta; 
    	}
}
