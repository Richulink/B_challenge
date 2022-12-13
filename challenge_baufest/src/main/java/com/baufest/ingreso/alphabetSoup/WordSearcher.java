package com.baufest.ingreso.alphabetSoup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordSearcher {

    private char soup[][];

    public WordSearcher(char soup[][]) {
        this.soup = soup;
    }

    /**
     * El objetivo de este ejercicio es implementar una función que determine si una palabra está en una sopa de letras.
     * <p>
     * ### Reglas
     * - Las palabras pueden estar dispuestas direcciones horizontal o vertical, _no_ en diagonal.
     * - Las palabras pueden estar orientadas en cualquier sentido, esto es, de derecha a izquierda o viceversa, y de arriba
     * para abajo o viceversa.
     * - El cambio de dirección puede estar a media palabra, de modo que, por ejemplo, parte de la palabra
     * esté horizontal y de izquierda a derecha, parte esté vertical y de arriba hacia abajo, y otra parte horizontal
     * de derecha a la izquierda.
     *
     * @param word Palabra a buscar en la sopa de letras.
     * @return {@link Boolean}	true si la palabra se encuentra
     * en la sopa de letras.
     */


    public boolean isPresent(String word) {


        List<String> horizontalWords = Arrays.stream(soup).map(row -> new String(row)).collect(Collectors.toList());
        List<String> verticalWords = new ArrayList<>();
        boolean isPresent = horizontalWords.stream().anyMatch(row -> row.contains(word));
        for (int i = 0; i < soup[0].length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < soup.length; j++) {
                sb.append(soup[j][i]);
            }
            verticalWords.add(sb.toString());
        }

        if (isPresent) {
            return true;
        } else if (verticalWords.stream().anyMatch(row -> row.contains(word))) {
            return true;
        } else {
            return false;
        }

    }
}


    
   




