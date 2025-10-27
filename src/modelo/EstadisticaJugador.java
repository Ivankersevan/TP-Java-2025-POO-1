package modelo;

public class EstadisticaJugador {
    private Jugador jugador;
    private Equipo equipo; 
    private int goles;
    private int asistencias;
    private int minutos;

    public EstadisticaJugador(Jugador jugador, Equipo equipo, int goles, int asistencias, int minutos) {
        this.jugador = jugador;
        this.equipo = equipo;
        this.goles = goles;
        this.asistencias = asistencias;
        this.minutos = minutos;
    }

    public Jugador getJugador() { 
    	return jugador; 
    	}
    
    public Equipo getEquipo() { 
    	return equipo; 
    	}
    
    public int getGoles() { 
    	return goles; 
    	}
    
    public int getAsistencias() { 
    	return asistencias; 
    	}
    
    public int getMinutos() {
    	return minutos;
    	}
}
