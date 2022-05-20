package pt.ulusofona.aed.deisiRockstar2021;

import java.util.ArrayList;

public class LeituraFicheirosTestes1 {
    public static String reduzirExecuteTestes (String command){
        String[] query = command.split(" ");

        switch (query[0]){

            case ("REMOVE_TAGS"): //(OBG)
                String[] divisao1 = command.split(";");
                divisao1[0] = divisao1[0].substring(12);
                ArrayList<String> tags1 = new ArrayList<>();
                for (int i = 1; i < divisao1.length ; i++) { tags1.add(divisao1[i]); }
                return Perguntas.removeTags(divisao1[0],tags1);

            case ("MOST_FREQUENT_WORDS_IN_ARTIST_NAME"):
                //return Perguntas1.mostFrequentWordsInArtistName();

            case ("GET_UNIQUE_TAGS"):
                return "Nao Acabada";

            case ("GET_UNIQUE_TAGS_IN_BETWEEN_YEARS"):
                return  Perguntas.getUniqueTagsBetweenYears(Integer.parseInt(query[1]), Integer.parseInt(query[2]));

            case ("GET_RISING_STARS"):
                return "Nao Acabada1";

            case ("CLEANUP"):
                return "Nao Acabada2";

            case ("VIVACITY_DECREASING_MUSIC_IN_THE_YEAR"):
                //RETORNA AS INFORMACOES DAS MUSICAS QUE NESSE ANO TENHAM X vivacidade ate ao valor introduzido (ex: desde 1.0 ate ao valor que o utilizador colocar)
                int a = Integer.parseInt(query[1]);
                double b = Double.parseDouble(String.valueOf(query[2]));

                return Perguntas1.getCreativeQueryFunction(a,b);

            default:
                return "Illegal command. Try again\n";
        }
    }
}
