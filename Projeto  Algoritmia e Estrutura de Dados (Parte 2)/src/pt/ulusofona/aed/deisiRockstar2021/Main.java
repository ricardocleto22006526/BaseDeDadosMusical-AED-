package pt.ulusofona.aed.deisiRockstar2021;

import java.io.*;
import java.util.*;

public class Main {
    
    //variaveis globais funcionam como memoria (guarda somente valores/contadores)
    static LinkedHashMap<String, Integer> tagsGlobais = new LinkedHashMap<>();
    static int[] linhaOKouNao = new int[2];
    static int[] linhaOKouNao1 = new int[2];
    static int[] linhaOKouNao2 = new int[2];
    static ArrayList<Song> arraySongsOutput = new ArrayList<>();
    static LinkedHashMap<String,Song> leituraSongs = new LinkedHashMap<>();
    static LinkedHashMap<String,Song> leituraDetails = new LinkedHashMap<>();
    static LinkedHashMap<String,Song> leituraArtists= new LinkedHashMap<>();

    public static void loadFiles() throws IOException{
        arraySongsOutput.clear(); leituraSongs.clear(); leituraDetails.clear(); leituraArtists.clear(); tagsGlobais.clear();

        ReduzirMain.leituraFicheiroSongs();
        ReduzirMain.leituraFicheiroDetails();
        ReduzirMain.leituraFicheiroArtists();

        arraySongsOutput = new ArrayList<>(leituraSongs.values());

    }

    public static ParseInfo getParseInfo(String fileName){
        ParseInfo resultado=new ParseInfo();
        if (fileName==null || !fileName.equals("songs.txt") && !fileName.equals("song_details.txt") && !fileName.equals("song_artists.txt")){
            return null;
        }

        if (fileName.equals("songs.txt")) {
            resultado.numLinhasOk = linhaOKouNao[0];
            resultado.numLinhasIgnored = linhaOKouNao[1];
            return resultado;
        }else if (fileName.equals("song_details.txt")) {
            resultado.numLinhasOk = linhaOKouNao1[0];
            resultado.numLinhasIgnored = linhaOKouNao1[1];
            return resultado;
        }else{
            resultado.numLinhasOk = linhaOKouNao2[0];
            resultado.numLinhasIgnored = linhaOKouNao2[1];
            return resultado;
        }
    }

    public static ArrayList<Song> getSongs(){
        return arraySongsOutput;
    }

    public static String getCreativeQuery(){ return "VIVACITY_DECREASING_MUSIC_IN_THE_YEAR"; }

    public static int getTypeOfSecondParameter(){ return 3; }

    public static String getVideoUrl(){ return "https://www.youtube.com/watch?v=fVjo7MBXeVo"; }

    public static String execute(String command){
        String[] query = command.split(" ");

        switch (query[0]) {

            case ("COUNT_SONGS_YEAR"): //FEITO (OBG)
                return String.valueOf(Perguntas.temasMusicaisAnoX(Integer.parseInt(query[1])));

            case ("COUNT_DUPLICATE_SONGS_YEAR"): //FEITO
                return String.valueOf(Perguntas.temasMusicaisDuplicadosAnoX(Integer.parseInt(query[1])));

            case ("GET_ARTISTS_FOR_TAG"): //FEITO (OBG)
                return Perguntas.getArtistsForTags(query[1]);

            case ("GET_MOST_DANCEABLE"): //FEITO (OBG)
                return Perguntas.mostDancable(Integer.parseInt(query[1]), Integer.parseInt(query[2]),Integer.parseInt(query[3]));

            case ("GET_ARTISTS_ONE_SONG"): //FALTA CORRIGIR
                //return Perguntas1.getArtistOneSong(Integer.parseInt(query[1]),Integer.parseInt(query[2]));

            case ("GET_TOP_ARTISTS_WITH_SONGS_BETWEEN"): //FALTA REFAZER
                //return Perguntas1.getArtistsBetween(Integer.parseInt(query[1]),Integer.parseInt(query[2]),Integer.parseInt(query[3]));

            case ("ADD_TAGS"): //FEITO (OBG)
                String[] divisao = command.split(";");
                divisao[0] = divisao[0].substring(9);
                ArrayList <String> tags = new ArrayList<>();
                for (int i = 1; i < divisao.length ; i++) { tags.add(divisao[i].toUpperCase()); }

                for (int i = 0; i < tags.size(); i++) {
                    if(tagsGlobais.containsKey(tags.get(i).toUpperCase())){
                        tagsGlobais.put(tags.get(i).toUpperCase(), tagsGlobais.get(tags.get(i))+1);
                    } else {
                        tagsGlobais.put(tags.get(i).toUpperCase(), 1);
                    }
                }

                return Perguntas.addTags(divisao[0],tags);

            default:
                return ReduzirMain.reduzirExecute(command);
        }
    }
    public static void menuMain(){
        System.out.println("Songs:" +getParseInfo("songs.txt"));
        System.out.println("Song_Details:" + getParseInfo("song_details.txt"));
        System.out.println("Song_Artists:" + getParseInfo("song_artists.txt"));

        System.out.println("Welcome to DEISI Rockstar!");
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        while (line != null && !line.equals("KTHXBYE")) {
            long start = System.currentTimeMillis();
            String result = execute(line);
            long end = System.currentTimeMillis();
            System.out.print(result);
            System.out.println("(took " + (end - start) + " ms)");
            line = in.nextLine();
        }
        System.out.println("Adeus.");
    }
    public static void main(String[] args) throws IOException {
        long inicio=System.currentTimeMillis();
        loadFiles();
        long fim=System.currentTimeMillis();
        System.out.println("TEMPO TOTAL:" +(fim-inicio) + "ms");
        menuMain();
    }
}
