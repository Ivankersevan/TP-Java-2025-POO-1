package modelo;

import java.time.LocalDate;

public class Entrenador extends Persona {
    private String tacticaPreferida; 

    public Entrenador(String nombre, String apellido, long dni, LocalDate fn, String tacticaPreferida) {
        super(nombre, apellido, dni, fn);
        this.tacticaPreferida = tacticaPreferida;
    }

    public String getTacticaPreferida() { 
    	return tacticaPreferida; 
    	}
}
