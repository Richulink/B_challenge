package com.baufest.ingreso.strings;


import java.io.StringReader;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RepeatedCharacters {

    /**
     * El metodo debe retornar un booleano indicando si el parametro `cadena` cumple con alguna de las siguientes propiedades:
     * 1- Todos los caracteres aparecen la misma cantidad de veces.
     * Ejemplos: "aabbcc", "abcdef", "aaaaaa"
     * 2- Todos los caracteres aparecen la misma cantidad de veces, a excepcion de 1, que aparece un vez mas o una vez menos.
     * Ejemplos: "aabbccc", "aabbc", "aaaaccccc"
     *
     * @param cadena la cadena a evaluar
     * @return booleano indicando si la cadena cumple con las propiedades
     */

    public Boolean isValid(String cadena) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            if (map.containsKey(caracter)) {
                map.put(caracter, map.get(caracter) + 1);
            } else {
                map.put(caracter, 1);
            }
        }

        if (map.values().stream().allMatch(valor -> valor == map.values().stream().findFirst().get())) {
            System.out.println(respuesta++ + "..ValidSimple:  CARACTERES QUE SE REPITEM POR IGUAL ::" + map);
            return true;
        } else if (map.values().stream().anyMatch(v -> v == map.values().stream().findAny().get() - 1)) {
            System.out.println(respuesta++ + "..ExtraChar:  CON LA DIFERENCIA DE UNO MEMOS / retorna false");
            return false;
        } else if (map.values().stream().anyMatch(v -> v == map.values().stream().findAny().get() + 1)) {
            System.out.println(respuesta++ + "..ExtraChar:  CON LA DIFERENCIA DE UNO DE MAS / retorna true");
            return true;
        }else {
            System.out.println(respuesta++ + "..Error:  NO CUMPLE CON LAS ESPECTATIVAS...");
            return false;
        }

    }
    private static int respuesta = 0;
}












    



