package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Equipo {
    private int id;
    private String codigo; 
    private String nombre;
    private LocalDate fechaFundacion;
    private Entrenador entrenador;
    private List<Jugador> jugadores = new ArrayList<>();

    public Equipo(int id, String codigo, String nombre, LocalDate fechaFundacion, Entrenador entrenador) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.fechaFundacion = fechaFundacion;
        this.entrenador = entrenador;
    }

    public int getId() { 
    	return id; 
    	}
    
    public String getCodigo() { 
    	return codigo; 
    	}
    
    public String getNombre() { 
    	return nombre; 
    	}
    
    public LocalDate getFechaFundacion() { 
    	return fechaFundacion; 
    	}
    
    public Entrenador getEntrenador() { 
    	return entrenador; 
    	}
    
    public List<Jugador> getJugadores() { 
    	return jugadores; 
    	}

    public void agregarJugador(Jugador j) { 
    	jugadores.add(j); 
    	}

    public double alturaPromedio() {
        if (jugadores.isEmpty()) {
        	return 0.0;
        }
        
        double suma = 0.0;
        for (Jugador j : jugadores) {
        	suma += j.getAltura();
        }
        
        return suma / jugadores.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
        	return true;
        }
        
        if (!(o instanceof Equipo)) { 
        	return false;
        	}
        
        Equipo equipo = (Equipo) o;
        return Objects.equals(codigo, equipo.codigo);
    }



    @Override
	public String toString() {
		return "Equipo [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", fechaFundacion=" + fechaFundacion
				+ ", entrenador=" + entrenador + ", jugadores=" + jugadores + "]";
	}
}
