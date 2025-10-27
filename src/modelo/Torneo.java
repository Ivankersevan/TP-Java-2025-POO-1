package modelo;

import java.time.LocalDate;
import java.util.*;

public class Torneo {
    private int id;
    private String codigo;
    private String nombre;
    private String temporada;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<Equipo> equipos = new ArrayList<>();
    private List<Partido> partidos = new ArrayList<>();
    private String partidosInfo;

    public Torneo(int id, String codigo, String nombre, String temporada,
                  LocalDate fechaInicio, LocalDate fechaFin, String infoPartido) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.temporada = temporada;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.partidosInfo = infoPartido;
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
    
    public String getTemporada() { 
    	return temporada; 
    	}
    
    public LocalDate getFechaInicio() {
    	return fechaInicio; 
    	}
    
    public LocalDate getFechaFin() {
    	return fechaFin; 
    	}
    
    public List<Equipo> getEquipos() {
    	return equipos; 
    	}
    
    public List<Partido> getPartidos() {
    	return partidos; 
    	}

    public void agregarEquipo(Equipo e) { 
    	equipos.add(e); 
    	}
    
    public void agregarPartido(Partido p) {
    	partidos.add(p); 
    	}
    
    public String getPartidoInfo() {
    	return partidosInfo;
    }

    // clase auxiliar que no depende de esta
    public static class Ganador {
        public final LocalDate fecha;
        public final Equipo equipo;
        public final int goles;
        public Ganador(LocalDate fecha, Equipo equipo, int goles) {
            this.fecha = fecha; 
            this.equipo = equipo; 
            this.goles = goles;
        }
    }

    public List<Ganador> traerGanadoresPorNumeroPartido(int numero) {
        List<Ganador> r = new ArrayList<>();
        for (Partido p : partidos) {
            if (p.getNumero() == numero) {
                if (p.getGolesLocal() > p.getGolesVisitante()) {
                    r.add(new Ganador(p.getFechaHora().toLocalDate(), p.getLocal(), p.getGolesLocal()));
                } else if (p.getGolesVisitante() > p.getGolesLocal()) {
                    r.add(new Ganador(p.getFechaHora().toLocalDate(), p.getVisitante(), p.getGolesVisitante()));
                }
            }
        }
        return r;
    }

   
    public List<Entrenador> traerEntrenadoresPorTactica(String tactica) {
        List<Entrenador> r = new ArrayList<>();
        for (Equipo e : equipos) {
            if (e.getEntrenador() != null && e.getEntrenador().getTacticaPreferida().equals(tactica)) {
                r.add(e.getEntrenador());
            }
        }
        return r;
    }

  
    public List<Jugador> traerJugadoresEntreFechas(LocalDate desde, LocalDate hasta) {
        List<Jugador> r = new ArrayList<>();
        for (Equipo e : equipos) {
            for (Jugador j : e.getJugadores()) {
                if (!j.getFechaNacimiento().isBefore(desde) && !j.getFechaNacimiento().isAfter(hasta)) {
                    r.add(j);
                }
            }
        }
        return r;
    }

 
    public List<Equipo> traerEquiposFundadosAntes(LocalDate fecha) {
        List<Equipo> r = new ArrayList<>();
        for (Equipo e : equipos) {
            if (e.getFechaFundacion().isBefore(fecha)) { 
            	r.add(e);
            	}
        }
        return r;
    }


    public double alturaPromedioEquipo(Equipo e) { 
    	return e.alturaPromedio(); 
    	}


    public Equipo equipoConMayorAlturaPromedio() {
        Equipo mejor = null;
        double best = -1;
        for (Equipo e : equipos) {
            double prom = e.alturaPromedio();
            if (prom > best) { 
            	best = prom; mejor = e; 
            	}
        }
        return mejor;
    }

    public int puntosDe(Equipo e) {
        int pts = 0;
        for (Partido p : partidos) {
        	pts += p.puntosPara(e);
        }
        
        return pts;
    }

    // clase auxiliar que no depende de esta
    public static class Posicion {
        public final Equipo equipo;
        public final int puntos;
        
        public Posicion(Equipo equipo, int puntos) { 
        	this.equipo = equipo; this.puntos = puntos; 
        	}
        
        @Override public String toString() { 
        	return equipo.getNombre() + " " + puntos; 
        	}
    }

    public List<Posicion> tablaPosiciones() {
        List<Posicion> tabla = new ArrayList<>();
        for (Equipo e : equipos) {
        	tabla.add(new Posicion(e, puntosDe(e)));
        }
        //Ordena puntos de tablas segun los puntos de cada equipo (Funcion Anonima)
        tabla.sort((a,b) -> Integer.compare(b.puntos, a.puntos));
        return tabla;
    }

  
    public int totalGoles(Jugador j) {
        int tot = 0;
        for (Partido p : partidos) {
            for (EstadisticaJugador ej : p.getEstadisticas()) {
                if (ej.getJugador().equals(j)) { 
                	tot += ej.getGoles();
                	}
            }
        }
        return tot;
    }
    
    public int totalAsistencias(Jugador j) {
        int tot = 0;
        for (Partido p : partidos) {
            for (EstadisticaJugador ej : p.getEstadisticas()) {
                if (ej.getJugador().equals(j)) {
                	tot += ej.getAsistencias();
                	}
            }
        }
        return tot;
    }

    // clase auxiliar que no depende de esta
    public static class Goleador {
        public final Jugador jugador;
        public final Equipo equipo;
        public final int goles;
        
        public Goleador(Jugador j, Equipo e, int g) { this.jugador = j; this.equipo = e; this.goles = g; 
        }
        
        @Override public String toString() { 
        	return jugador.getNombre()+" "+jugador.getApellido()+" - "+equipo.getNombre()+" "+goles; 
        	}
    }

	 private int buscarPosGoleador(List<Goleador> lista, Jugador j) {
	     int pos = -1;
	     int i = 0;
	     boolean encontrado = false;
	     while (i < lista.size() && !encontrado) {
	         if (lista.get(i).jugador.equals(j)) {
	             pos = i;
	             encontrado = true;
	         } else {
	             i++;
	         }
	     }
	     return pos;
	 }
	
	 private void ordenarPorGolesDesc(List<Goleador> lista) {
	     int i = 0;
	     while (i < lista.size() - 1) {
	         int j = i + 1;
	         while (j < lista.size()) {
	             if (lista.get(j).goles > lista.get(i).goles) {
	                 Goleador aux = lista.get(i);
	                 lista.set(i, lista.get(j));
	                 lista.set(j, aux);
	             }
	             j++;
	         }
	         i++;
	     }
	 }
	
	 public List<Goleador> tablaGoleadores() {
	     List<Goleador> lista = new ArrayList<Goleador>();
	     int i = 0;
	     while (i < partidos.size()) {
	         Partido p = partidos.get(i);
	         List<EstadisticaJugador> est = p.getEstadisticas();
	         int j = 0;
	         while (j < est.size()) {
	             EstadisticaJugador ej = est.get(j);
	             int pos = buscarPosGoleador(lista, ej.getJugador());
	
	             if (pos != -1) {
	                 Goleador viejo = lista.get(pos);
	                 Goleador nuevo = new Goleador(
	                         viejo.jugador,
	                         viejo.equipo,
	                         viejo.goles + ej.getGoles()
	                 );
	                 lista.set(pos, nuevo);
	             } else {
	                 lista.add(new Goleador(
	                         ej.getJugador(),
	                         ej.getEquipo(),
	                         ej.getGoles()
	                 ));
	             }
	             j++;
	         }
	         i++;
	     }
	
	     ordenarPorGolesDesc(lista);
	
	     return lista;
	 }
	 
	 //Impresion de informacion del Torneo
	 public void mostrarTorneo() {
		System.out.println("Torneo: ID " + this.getId() + " | " + this.getNombre() + " (" + this.getTemporada() + ")");
        System.out.println("ID=" + this.getId() + "  Código=" + this.getCodigo());
        System.out.println("Inicio=" + this.getFechaInicio() + "  Fin=" + this.getFechaFin());
        System.out.print("Participantes: " + this.equipos.size() + " Equipos: (");
        for (Equipo e : this.equipos){
        	System.out.print(" " + e.getNombre());
        }
        System.out.println(" )");
        System.out.println("Partidos: " + this.partidosInfo);
        System.out.println();
	 }
	 
	 public void mostrarGoleradores() {
		 System.out.println("Goleadores:");
	        List<Torneo.Goleador> goleadores = this.tablaGoleadores();
	        for (int i = 0; i < goleadores.size(); i++) {
	            Torneo.Goleador g = goleadores.get(i);
	            System.out.println((g.jugador.getNombre() + " " + g.jugador.getApellido()) +
	                               "  (" + g.equipo.getNombre() + ")  Goles=" + g.goles);
	        }
	        System.out.println();
	 }

	 public void mostrarPosiciones() {
		 System.out.println("Posiciones:");
	        List<Torneo.Posicion> tabla = this.tablaPosiciones();
	        for (int i = 0; i < tabla.size(); i++) {
	            Torneo.Posicion pos = tabla.get(i);
	            System.out.println((i + 1) + ". " + pos.equipo.getNombre() + "  Pts=" + pos.puntos);
	        }
	        System.out.println();
	 }
	 
	 public void mostrarPuntosEquipos() {
		    System.out.println("Puntos por equipo:");
		    List<Torneo.Posicion> tabla = this.tablaPosiciones();
		    for (int i = 0; i < tabla.size(); i++) {
		        Torneo.Posicion pos = tabla.get(i);
		        System.out.println(pos.equipo.getNombre() + ": " + pos.puntos);
		    }
		    System.out.println();
		}
	 
	 public void mostrarEstadisticas() {
		 List<Partido> partidos = this.getPartidos();
		 System.out.println("Estadísticas por partido:");
	        for (int i = 0; i < partidos.size(); i++) {
	            Partido p = partidos.get(i);
	            System.out.println("Partido " + p.getNumero() + " — " + p.getLocal().getNombre() + " " + p.getGolesLocal() +
	                               " - " + p.getGolesVisitante() + " " + p.getVisitante().getNombre());
	            List<EstadisticaJugador> es = p.getEstadisticas();
	            for (int j = 0; j < es.size(); j++) {
	                EstadisticaJugador ej = es.get(j);
	                System.out.println("   " + ej.getJugador().getNombre() + " " + ej.getJugador().getApellido() +
	                                   " | " + ej.getEquipo().getNombre() +
	                                   " | goles " + ej.getGoles() +
	                                   " | asist " + ej.getAsistencias() +
	                                   " | min " + ej.getMinutos());
	            }
	            System.out.println();
	        }
	 }
	 
	 public void mostrarPartidos() {
		 List<Partido> partidos = this.getPartidos();
	        System.out.println("Partidos (" + partidos.size() + "):");
	        for (int i = 0; i < partidos.size(); i++) {
	            Partido p = partidos.get(i);
	            System.out.println(
	                "N°" + p.getNumero() + "  " + p.getFechaHora() + "  " +
	                p.getLocal().getNombre() + " vs " + p.getVisitante().getNombre() +
	                "  Resultado " + p.getGolesLocal() + " - " + p.getGolesVisitante() +
	                "  Estadio: " + p.getEstadio()
	            );
	        }
	        System.out.println();
	 }
	 
	 public void mostrarEquipos() {
		 List<Equipo> equipos = this.getEquipos();
	        for (int i = 0; i < equipos.size(); i++) {
	            Equipo e = equipos.get(i);
	            Entrenador dt = e.getEntrenador();
	            System.out.println("Equipo: ID: " + e.getId() + " | " + e.getNombre() + "  (Código " + e.getCodigo() + ", Fundado " + e.getFechaFundacion() + ")");
	            System.out.println("DT: " + dt.getNombre() + " " + dt.getApellido() + "  DNI " + dt.getDni() + "  Táctica " + dt.getTacticaPreferida());
	            List<Jugador> js = e.getJugadores();
	            for (int j = 0; j < js.size(); j++) {
	                Jugador jj = js.get(j);
	                System.out.println(" - " + jj.getNombre() + " " + jj.getApellido() +
	                        " | " + jj.getPosicion() + " | altura " + jj.getAltura() +
	                        " | nacido " + jj.getFechaNacimiento());
	            }
	            System.out.println();
	        }
	 }
	 
	 
}
