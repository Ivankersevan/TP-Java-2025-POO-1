package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Partido {
    private int numero;
    private LocalDateTime fechaHora;
    private Equipo local;
    private Equipo visitante;
    private int golesLocal;
    private int golesVisitante;
    private String estadio; 
    private List<EstadisticaJugador> estadisticas = new ArrayList<>();

    public Partido(int numero, LocalDateTime fechaHora, Equipo local, Equipo visitante,
                   int golesLocal, int golesVisitante, String estadio) {
        this.numero = numero;
        this.fechaHora = fechaHora;
        this.local = local;
        this.visitante = visitante;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
        this.estadio = estadio;
    }

    public int getNumero() { 
    	return numero; 
    	}
    
    public LocalDateTime getFechaHora() {
    	return fechaHora; 
    	}
    
    public Equipo getLocal() {
    	return local; 
    	}
    
    public Equipo getVisitante() {
    	return visitante; 
    	}
    
    public int getGolesLocal() {
    	return golesLocal; 
    	}
    
    public int getGolesVisitante() { 
    	return golesVisitante; 
    	}
    
    public List<EstadisticaJugador> getEstadisticas() {
    	return estadisticas; 
    	}
    
    public String getEstadio() {
    	return this.estadio;
    }
    
    public void agregarEstadistica(EstadisticaJugador ej) { 
    	estadisticas.add(ej); 
    	}

    public int puntosPara(Equipo e) {
    	int devolver = 0;
        if (golesLocal == golesVisitante) {
        	devolver = 1;
        	} 
        
        Equipo ganador = (golesLocal > golesVisitante) ? local : visitante;
        if (ganador.equals(e)) {
        	devolver = 3;
        }
        return devolver;
    }
}
