package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import modelo.*;

public class TestTP {
    public static void main(String[] args) {
    	
    	Sistema sis = new Sistema();
    	
        Torneo t = new Torneo(1, "T001", "Torneo Clausura 2025", "2025",
        		LocalDate.of(2025,10,1), LocalDate.of(2025,10,14),"todos contra todos (6 partidos en total)");

        Entrenador dtLeones   = new Entrenador("Carlos", "Gómez",   12345678, LocalDate.of(1975,1,1), "4-4-2");
        Entrenador dtTigres   = new Entrenador("Luis",   "Martínez",22345678, LocalDate.of(1976,1,1), "4-3-3");
        Entrenador dtHalcones = new Entrenador("Jorge",  "Pérez",   32345678, LocalDate.of(1977,1,1), "3-5-2");
        Entrenador dtLobos    = new Entrenador("Andrés", "Suárez",  42345678, LocalDate.of(1978,1,1), "5-3-2");

        Equipo leones   = new Equipo(1, "E001", "Leones",   LocalDate.of(2010,1,1), dtLeones);
        Equipo tigres   = new Equipo(2, "E002", "Tigres",   LocalDate.of(2012,3,15), dtTigres);
        Equipo halcones = new Equipo(3, "E003", "Halcones", LocalDate.of(2015,7,20), dtHalcones);
        Equipo lobos    = new Equipo(4, "E004", "Lobos",    LocalDate.of(2013,9,5),  dtLobos);

        t.agregarEquipo(leones);
        t.agregarEquipo(tigres);
        t.agregarEquipo(halcones);
        t.agregarEquipo(lobos);

        //LEONES
        Jugador juanPerez     = new Jugador("Juan","Pérez",   1001, LocalDate.of(2000,2,10), 1.80, "delantero",      9);
        Jugador martinLopez   = new Jugador("Martín","López", 1002, LocalDate.of(1998,6,12), 1.82, "defensor",       2);
        Jugador lucasDiaz     = new Jugador("Lucas","Díaz",   1003, LocalDate.of(2001,4,18), 1.75, "mediocampista",  8);
        Jugador francoRuiz    = new Jugador("Franco","Ruiz",  1004, LocalDate.of(1999,11,3), 1.85, "arquero",        1);
        Jugador agustinTorres = new Jugador("Agustín","Torres",1005, LocalDate.of(2002,7,21),1.78, "delantero",     11);
        leones.agregarJugador(juanPerez); 
        leones.agregarJugador(martinLopez);
        leones.agregarJugador(lucasDiaz); 
        leones.agregarJugador(francoRuiz);
        leones.agregarJugador(agustinTorres);

        //TIGRES
        Jugador diegoGonzalez = new Jugador("Diego","González",2001, LocalDate.of(1999,2,4), 1.83, "arquero",        1);
        Jugador nicolasRomero = new Jugador("Nicolás","Romero",2002, LocalDate.of(1997,9,10),1.80, "defensor",       2);
        Jugador rodrigoSosa   = new Jugador("Rodrigo","Sosa",  2003, LocalDate.of(2000,12,12),1.74,"mediocampista",  8);
        Jugador matiasVera    = new Jugador("Matías","Vera",  2004, LocalDate.of(2002,1,5), 1.79, "delantero",       9);
        Jugador pabloCastro   = new Jugador("Pablo","Castro", 2005, LocalDate.of(1998,5,22), 1.81, "defensor",       3);
        tigres.agregarJugador(diegoGonzalez); 
        tigres.agregarJugador(nicolasRomero);
        tigres.agregarJugador(rodrigoSosa);   
        tigres.agregarJugador(matiasVera);
        tigres.agregarJugador(pabloCastro);

        //HALCONES
        Jugador emilianoCabrera = new Jugador("Emiliano","Cabrera",3001, LocalDate.of(1999,3,14),1.86,"arquero",      1);
        Jugador javierMorales   = new Jugador("Javier","Morales",  3002, LocalDate.of(2001,10,19),1.79,"defensor",    2);
        Jugador gonzaloRivas    = new Jugador("Gonzalo","Rivas",   3003, LocalDate.of(2000,8,30),1.77,"mediocampista",8);
        Jugador lautaroFernandez= new Jugador("Lautaro","Fernández",3004,LocalDate.of(2003,2,17),1.83,"delantero",    9);
        Jugador mateoBlanco     = new Jugador("Mateo","Blanco",    3005, LocalDate.of(2002,4,23),1.72,"mediocampista",10);
        halcones.agregarJugador(emilianoCabrera); 
        halcones.agregarJugador(javierMorales);
        halcones.agregarJugador(gonzaloRivas);    
        halcones.agregarJugador(lautaroFernandez);
        halcones.agregarJugador(mateoBlanco);

        //LOBOS
        Jugador facundoHerrera = new Jugador("Facundo","Herrera",4001, LocalDate.of(1998,12,8),1.84,"arquero",        1);
        Jugador ignacioRamos   = new Jugador("Ignacio","Ramos",  4002, LocalDate.of(1999,9,1),1.80,"defensor",        2);
        Jugador tomasBenitez   = new Jugador("Tomás","Benítez",  4003, LocalDate.of(2000,5,15),1.74,"mediocampista",  8);
        Jugador sebastianLuna  = new Jugador("Sebastián","Luna", 4004, LocalDate.of(2001,7,7),1.81,"delantero",       9);
        Jugador enzoCorrea     = new Jugador("Enzo","Correa",    4005, LocalDate.of(2002,3,28),1.78,"defensor",       3);
        lobos.agregarJugador(facundoHerrera); 
        lobos.agregarJugador(ignacioRamos);
        lobos.agregarJugador(tomasBenitez);   
        lobos.agregarJugador(sebastianLuna);
        lobos.agregarJugador(enzoCorrea);

        Partido p1 = new Partido(1, LocalDateTime.of(LocalDate.of(2025,10,10), LocalTime.of(15,0)),  leones,   tigres,   2,1, "La Redonda");
        Partido p2 = new Partido(2, LocalDateTime.of(LocalDate.of(2025,10,17), LocalTime.of(16,0)),  halcones, lobos,    1,1, "La Redonda");
        Partido p3 = new Partido(3, LocalDateTime.of(LocalDate.of(2025,10,24), LocalTime.of(15,0)),  leones,   halcones, 3,0, "La Redonda");
        Partido p4 = new Partido(4, LocalDateTime.of(LocalDate.of(2025,10,31), LocalTime.of(16,0)),  tigres,   lobos,    0,2, "La Redonda");
        Partido p5 = new Partido(5, LocalDateTime.of(LocalDate.of(2025,10,7),  LocalTime.of(15,30)), leones,   lobos,    1,3, "La Redonda");
        Partido p6 = new Partido(6, LocalDateTime.of(LocalDate.of(2025,10,14), LocalTime.of(15,30)), tigres,   halcones, 2,2, "La Redonda");

        p1.agregarEstadistica(new EstadisticaJugador(juanPerez,     leones, 1, 0, 90));
        p1.agregarEstadistica(new EstadisticaJugador(agustinTorres, leones, 1, 0, 85));
        p1.agregarEstadistica(new EstadisticaJugador(matiasVera,    tigres, 1, 0, 90));

        p2.agregarEstadistica(new EstadisticaJugador(lautaroFernandez, halcones, 1, 0, 90));
        p2.agregarEstadistica(new EstadisticaJugador(sebastianLuna,    lobos,    1, 0, 90));

        p3.agregarEstadistica(new EstadisticaJugador(juanPerez,     leones, 2, 0, 90));
        p3.agregarEstadistica(new EstadisticaJugador(agustinTorres, leones, 1, 0, 90));

        p4.agregarEstadistica(new EstadisticaJugador(sebastianLuna, lobos, 1, 0, 90));
        p4.agregarEstadistica(new EstadisticaJugador(enzoCorrea,    lobos, 1, 0, 90));

        p5.agregarEstadistica(new EstadisticaJugador(agustinTorres, leones, 1, 0, 90));
        p5.agregarEstadistica(new EstadisticaJugador(sebastianLuna, lobos,  2, 0, 80));
        p5.agregarEstadistica(new EstadisticaJugador(enzoCorrea,    lobos,  1, 0, 90));

        p6.agregarEstadistica(new EstadisticaJugador(rodrigoSosa,     tigres,   1, 0, 80));
        p6.agregarEstadistica(new EstadisticaJugador(matiasVera,      tigres,   1, 0, 90));
        p6.agregarEstadistica(new EstadisticaJugador(gonzaloRivas,    halcones, 1, 0, 85));
        p6.agregarEstadistica(new EstadisticaJugador(lautaroFernandez,halcones, 1, 0, 90));

        t.agregarPartido(p1);
        t.agregarPartido(p2);
        t.agregarPartido(p3);
        t.agregarPartido(p4);
        t.agregarPartido(p5);
        t.agregarPartido(p6);

        //Mostrar Informacion del torneo
        sis.imprimirTorneo(t);
        
        
    }
}
