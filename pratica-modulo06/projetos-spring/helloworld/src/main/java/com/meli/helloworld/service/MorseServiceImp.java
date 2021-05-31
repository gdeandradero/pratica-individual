package com.meli.helloworld.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MorseServiceImp implements MorseService {

    @Override
    public String translateMorseCode(String morseCode) {
        Map<String, String> dictionaryMorse = fillMap();

        String[] words = morseCode.split("   ");
        String result = "";

        /*
         * Percorre todas as palavras
         */
        for (String word : words){
            int starterIndex = 0;
            boolean onlyOneLetter = true;
            /*
             * Percorre todas as letras de uma palavra
             */
            for (int i = 0; i < word.length(); i++){
                /*
                 * Verifica se a letra foi digitada inteira
                 */
                if (word.charAt(i) == ' '){
                    int j = starterIndex;
                    String mapSearch = "";
                    /*
                     * Pega o código morse da letra para mais tarde procurar no map
                     */
                    while (j != i){
                        mapSearch += word.charAt(j);
                        j++;
                    }
                    starterIndex = i + 1;
                    result += dictionaryMorse.get(mapSearch);
                    onlyOneLetter = false;
                } else {
                    onlyOneLetter = true;
                }
            }
            if (onlyOneLetter) {
                String mapSearch = "";
                while (starterIndex != word.length()){
                    mapSearch += word.charAt(starterIndex);
                    starterIndex++;
                }
                result += dictionaryMorse.get(mapSearch);
            }
            result += " ";
        }
        return result;
    }

    /*
     * -- . .-. -.-. .- -.. ---   .-.. .. -... .-. .
     */

    public Map<String, String> fillMap(){
        Map<String, String> dictionaryMorse = new HashMap<String, String>();
        dictionaryMorse.put(".-", "A");
        dictionaryMorse.put("-...", "B");
        dictionaryMorse.put("-.-.", "C");
        dictionaryMorse.put("-..", "D");
        dictionaryMorse.put(".", "E");
        dictionaryMorse.put("..-.", "F");
        dictionaryMorse.put("--.", "G");
        dictionaryMorse.put("....", "H");
        dictionaryMorse.put("..", "I");
        dictionaryMorse.put(".---", "J");
        dictionaryMorse.put("-.-", "K");
        dictionaryMorse.put(".-..", "L");
        dictionaryMorse.put("--", "M");
        dictionaryMorse.put("-.", "N");
        dictionaryMorse.put("---", "O");
        dictionaryMorse.put(".--.", "P");
        dictionaryMorse.put("--.-", "Q");
        dictionaryMorse.put(".-.", "R");
        dictionaryMorse.put("...", "S");
        dictionaryMorse.put("-", "T");
        dictionaryMorse.put("..-", "U");
        dictionaryMorse.put("...-", "V");
        dictionaryMorse.put(".--", "W");
        dictionaryMorse.put("-..-", "X");
        dictionaryMorse.put("-.--", "Y");
        dictionaryMorse.put("--..", "Z");

        return dictionaryMorse;
    }

}
