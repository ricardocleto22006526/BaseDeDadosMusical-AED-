package pt.ulusofona.aed.deisiRockstar2021;

import java.util.*;

public class Perguntas1 {

    //FALTA FAZER (REFAZER)
    public static String getArtistsBetween(int nArtistas, int temaA, int temaB) {
        /*
        int count=0;

        ArrayList<ArtistsInfo> artistasInfo = new ArrayList<>();
        StringBuilder output = new StringBuilder();

        for (Song song : Main.arraySongsArtistsOutput) {

            //String idint=arraySongsArtistsOutput.get(i).artistas[0].nome;
            //song.artistas.length
            if (song.artistas != null) {
                for (int j = 0; j < song.artistas.size(); j++) {

                    if (artistasInfo.size() == 0) {
                        artistasInfo.add(new ArtistsInfo(Main.arraySongsArtistsOutput.get(j).artistas.get(j).nome, 1));
                        continue;
                    }

                    for (ArtistsInfo artistsInfo : artistasInfo) {
                        //arraySongsArtistsOutput.get(j).artistas[j].nome.equals(artistsInfo.nome)
                        if (song.artistas.get(j).nome.equals(artistsInfo.nome)) {
                            artistsInfo.quantidadeMusicas++;
                            break;
                        }
                        //artistasInfo.add(new ArtistsInfo(Main.arraySongsArtistsOutput.get(j).artistas[j].nome, 1));
                    }
                }
            }
        }

        artistasInfo.sort(Comparator.comparingInt((ArtistsInfo qntTemas) -> qntTemas.quantidadeMusicas).reversed());

        for (int i = 0; i < artistasInfo.size() && count < nArtistas ; i++) {
            int ola=artistasInfo.get(i).quantidadeMusicas;
            if ( temaA <= artistasInfo.get(i).quantidadeMusicas && artistasInfo.get(i).quantidadeMusicas <= temaB){
                output.append(artistasInfo.get(i).nome).append(" ").append(artistasInfo.get(i).quantidadeMusicas).append("\n");
                count++;
            }
            if (count==0){
                return "No results\n";
            }
        }

        return output.toString();

        ArrayList<String> artistasOutput = new ArrayList<>();
        ArrayList<String> idArtists = new ArrayList<>();

        for (int i = 0; i < Main.arraySongsOutput.size(); i++) {
            for (int j = 0; j < Main.arraySongsArtistsOutput.size(); j++) {
                if ( Main.arraySongsOutput.get(i).id.equals(Main.arraySongsArtistsOutput.get(j).id) ) {
                    idArtists.add(Main.arraySongsOutput.get(i).id);
                    quatDeTemas++;
                }
            }
        }

        for (int j = 0; j < Main.arraySongsArtistsOutput.size(); j++) {
            for (int c = 0; c < Main.arraySongsOutput.size(); c++) {
                if (Main.arraySongsOutput.get(c).id.equals(Main.arraySongsArtistsOutput.get(j).id)) {
                    artistasOutput.add(Main.arraySongsArtistsOutput.get(j).toString());
                }
            }
        }



        //COMO COLOCAR POR ORDEM DECRESCENTE ?
        //quatDeTemas.sort(Comparator.comparingDouble((Song song)-> song.grauDeDancabilidade).reversed());

         */

        return "";

    }

    public static ArrayList<String> getArtiststForTagsHelp(String tagsInput){

        ArrayList<String> listaArtista = new ArrayList<>();

        for (int i = 0; i < Main.arraySongsOutput.size() ; i++) {
            if (Main.arraySongsOutput.get(i).artistas!=null){
                for (int j = 0; j < Main.arraySongsOutput.get(i).artistas.size() ; j++) {
                    if (Main.arraySongsOutput.get(i).artistas!=null){
                        if (Main.arraySongsOutput.get(i).artistas.get(j).tags !=null){
                            for (int k = 0; k < Main.arraySongsOutput.get(i).artistas.get(j).tags.size() ; k++) {
                                if(Main.arraySongsOutput.get(i).artistas.get(j).tags.get(k).equals(tagsInput.toUpperCase())
                                        && !listaArtista.contains(Main.arraySongsOutput.get(i).artistas.get(j).nome)){

                                    listaArtista.add(Main.arraySongsOutput.get(i).artistas.get(j).nome);
                                }
                            }
                        }
                    }
                }
            }
        }
        return listaArtista;
    }

    public static Artista removeTagsHelp(String nomeDoArtista, ArrayList<String> tagsAretirar, Artista tagsOutput){

        for (int i = 0; i < Main.arraySongsOutput.size(); i++) {
            if (Main.arraySongsOutput.get(i).artistas != null) {
                for (int j = 0; j < Main.arraySongsOutput.get(i).artistas.size(); j++) {
                    if (Main.arraySongsOutput.get(i).artistas.get(j).nome.equals(nomeDoArtista)) {
                        tagsOutput = Main.arraySongsOutput.get(i).artistas.get(j);
                        if (Main.arraySongsOutput.get(i).artistas.get(j).tags != null) {
                            for (int k = 0; k < tagsAretirar.size(); k++) {
                                if(Main.arraySongsOutput.get(i).artistas.get(j).tags.contains(tagsAretirar.get(k).toUpperCase())){
                                    Main.arraySongsOutput.get(i).artistas.get(j).tags.remove(tagsAretirar.get(k).toUpperCase());
                                }
                            }
                        }
                    }
                }
            }
        }
        return tagsOutput;
    }

    public static String getCreativeQueryFunction(int ano, double grauvivacidade){
        //VIVACITY_DECREASING_MUSIC_IN_THE_YEAR 1920 0.650
        LinkedList<Song> musicasComVivacidadeMaisElevada = new LinkedList<>();
        StringBuilder musicasOutput = new StringBuilder();

        for (Song song: Main.arraySongsOutput) {
            if (song.grauDeVivacidade==0){ //ignora linhas cuja vivacidade e 0
                continue;
            }
            if(song.anoLancamento==ano && song.grauDeVivacidade>grauvivacidade){
                musicasComVivacidadeMaisElevada.add(song);
            }
        }

        musicasComVivacidadeMaisElevada.sort(Comparator.comparingDouble((Song song) -> song.grauDeVivacidade).reversed());

        for (int j = 0; j < musicasComVivacidadeMaisElevada.size(); j++) {
            for (int c = 0; c < Main.arraySongsOutput.size(); c++) {
                if (Main.arraySongsOutput.get(c).id.equals(musicasComVivacidadeMaisElevada.get(j).id)) {
                    musicasOutput.append(Main.arraySongsOutput.get(c).titulo).append(" ").append(":").append(" ").append(Main.arraySongsOutput.get(c).anoLancamento)
                    .append(" ").append(":").append(" ").append(musicasComVivacidadeMaisElevada.get(j).grauDeVivacidade).append("\n");
                }
            }
        }

        return musicasOutput.toString();
    }
    /*
    public static String mostFrequentWordsInArtistName(){return "";}
     */
    //FALTA REFAZER
    public static int countNumeroDeTemasOneSong(String artista,LinkedList<Song> musicasDentroDestesAnos ){
        int count = 0;

        for (Song musicasDentroDestesAno : musicasDentroDestesAnos) {
            for (int j = 0; j < musicasDentroDestesAno.artistas.size(); j++) {
                if (musicasDentroDestesAno.artistas.get(j).nome.equals(artista)) {
                    count++;
                }
            }
        }
        return count;
    }
    public static void getArtistsOneSongReduzComplexidade(LinkedList<Song> musicasDentroDestesAnos, LinkedHashMap<String,Integer> artistaENrTemas
            ,LinkedList <Integer> musicaAno,LinkedList <String> musicaTitulo){

        for (Song musicasDentroDestesAno : musicasDentroDestesAnos) {
            for (int j = 0; musicasDentroDestesAno.artistas != null && j < musicasDentroDestesAno.artistas.size(); j++) {
                artistaENrTemas.put(musicasDentroDestesAno.artistas.get(j).nome, countNumeroDeTemasOneSong(musicasDentroDestesAno.artistas.get(j).nome,musicasDentroDestesAnos));
                musicaAno.add(musicasDentroDestesAno.anoLancamento);
                musicaTitulo.add(musicasDentroDestesAno.titulo);
                //artistas.add(musicasDentroDestesAno.artistas.get(j).nome);
            }
        }
    }
    public static String getArtistOneSong(int inicio, int fim) {

        StringBuilder output = new StringBuilder();
        LinkedList<Song> musicasDentroDestesAnos = new LinkedList<>();
        LinkedHashMap<String,Integer> artistaENrTemas = new LinkedHashMap<>();
        LinkedList <String> artistas = new LinkedList<>();
        LinkedList <Integer> musicaAno = new LinkedList<>();
        LinkedList <String> musicaTitulo = new LinkedList<>();


        if (inicio > fim || inicio == fim) {
            return "Invalid period";
        }


        for (Song song: Main.arraySongsOutput) {
            if (song.anoLancamento >= inicio && song.anoLancamento <= fim){
                musicasDentroDestesAnos.add(song);
            }
        }

        getArtistsOneSongReduzComplexidade(musicasDentroDestesAnos, artistaENrTemas,musicaAno,musicaTitulo);

        for (Map.Entry<String, Integer> entry : artistaENrTemas.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value.equals(1)){
                artistas.add(key);
            }
        }

        artistas.sort(String::compareToIgnoreCase);


        for (int i = 0; i < artistas.size() ; i++) {
            output.append(artistas.get(i)).append(" ").append("|").append(" ").append(musicaTitulo.get(i))
            .append(" ").append("|").append(" ").append(musicaAno.get(i)).append("\n");
        }

        return output.toString();

    }
}
