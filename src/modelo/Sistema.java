package modelo;


import java.util.List;


public class Sistema {

    public void imprimirPosiciones(List<Torneo.Posicion> tabla) {
        System.out.println("Posiciones");
        int pos = 1;
        for (Torneo.Posicion p : tabla) {
            System.out.println(pos + " " + p.equipo.getNombre() + " " + p.puntos);
            pos++;
        }
        System.out.println();
    }

    public void imprimirGoleadores(List<Torneo.Goleador> lista) {
        System.out.println("Goleadores");
        for (Torneo.Goleador g : lista) {
            System.out.println(g.jugador.getNombre() + " " + g.jugador.getApellido() +
                               "  " + g.equipo.getNombre() + "  " + g.goles);
        }
        System.out.println();
    }

    public void imprimirEquipos(List<Equipo> equipos, String titulo) {
        System.out.println(titulo);
        for (Equipo e : equipos) System.out.println(e.getNombre());
        System.out.println();
    }

    public void imprimirJugadores(List<Jugador> jugadores, String titulo) {
        System.out.println(titulo);
        for (Jugador j : jugadores) {
            System.out.println(j.getNombre() + " " + j.getApellido() + "  " + j.getFechaNacimiento());
        }
        System.out.println();
    }

    public void imprimirEntrenadores(List<Entrenador> entrenadores, String titulo) {
        System.out.println(titulo);
        for (Entrenador dt : entrenadores) {
            System.out.println(dt.getNombre() + " " + dt.getApellido() + "  " + dt.getTacticaPreferida());
        }
        System.out.println();
    }

    public void imprimirPuntosPorEquipo(Torneo t) {
    	t.mostrarPuntosEquipos();
    }
    
    public void imprimirPosiciones(Torneo t) {
    	t.mostrarPosiciones();
    }

    public void ImprimirEquipos(Torneo t) {
    	t.mostrarEquipos();
    }
    
    public void imprimirEstadistica(Torneo t) {
    	t.mostrarEstadisticas();
    }
    
    public void imprimirPartidos(Torneo t) {
    	t.mostrarPartidos();
    }
    
    public void imprimirGoleadores(Torneo t) {
    	t.mostrarGoleradores();
    }
    
    public void imprimirInfoTorneo(Torneo t) {
    	t.mostrarTorneo();
    }
    
    public void imprimirTorneo(Torneo t) {
    	t.mostrarTorneo();
    	t.mostrarEquipos();
    	t.mostrarPartidos();
    	t.mostrarEstadisticas();
    	t.mostrarPuntosEquipos();
    	t.mostrarPosiciones();
    	t.mostrarGoleradores();
    }
    
}
