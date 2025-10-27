package modelo;

import java.time.LocalDate;

public abstract class Persona {
    protected String nombre;
    protected String apellido;
    protected long dni;
    protected LocalDate fechaNacimiento;

    public Persona(String nombre, String apellido, long dni, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() { 
    	return nombre; 
    	}
    
    public String getApellido() { 
    	return apellido; 
    	}
    
    public long getDni() { 
    	return dni; 
    	}
    
    public LocalDate getFechaNacimiento() { 
    	return fechaNacimiento; 
    	}

    @Override
    public boolean equals(Object o) {
        if (this == o) {
        	return true;
        	}
        if (!(o instanceof Persona)) {
        	return false;
        	}
        Persona persona = (Persona) o;
        return dni == persona.dni;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " (DNI " + dni + ")";
    }
}
