package com.baufest.ingreso.sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorting {

    /**
     * Se debe ordenar primero por puntuación de manera descendente, luego por nombre de manera ascendente.
     *
     * @param jugadores la lista de jugadores a ordenar
     * @return la lista ordenada de jugadores
     */


    public static List<Jugador> ordenarPorPuntuacionYNombre(List<Jugador> jugadores) {

        jugadores.sort(Comparator.comparing(Jugador::getPuntuacion, Collections.reverseOrder())
                .thenComparing(Jugador::getNombre));

        return jugadores;
    }

    /**
     * Se debe ordenar primero por puntuación de manera descendente. Cuando 2 jugadores tienen igual cantidad de puntos,
     * el que tiene menos perdidas se lo considerara el mayor. Luego a igual puntos y perdidas se seguirá usando el
     * nombre de manera ascendente.
     *
     * @param jugadores la lista de jugadores a ordenar
     * @return la lista ordenada de jugadores
     */
    public static List<Jugador> ordenarPorPuntuacionPerdidasYNombre(List<Jugador> jugadores) {

        jugadores.sort(Comparator.comparing(Jugador::getPuntuacion, Collections.reverseOrder()));
        jugadores.sort((jugador1, jugador2) -> {
            if (jugador1.getPuntuacion() == jugador2.getPuntuacion()) {
                if (jugador1.getPerdidas() < jugador2.getPerdidas()) {
                    return -1;
                }
            } else {
                return jugador2.getPuntuacion() - jugador1.getPuntuacion();
            }
            return 1;
        });
        return jugadores;

    }
}
