package pt.ulusofona.aed.deisiRockstar2021;

import java.util.*;


public class Perguntas {
    //AJUDA A CONTAR O NUMERO DE TEMAS DOS ARTISTAS
    public static int countNumeroDeTemas(String artista){
        int count = 0;

        for (int i = 0; i < Main.arraySongsOutput.size(); i++) {
            for (int j = 0; j < Main.arraySongsOutput.get(i).artistas.size(); j++) {
                if (Main.arraySongsOutput.get(i).artistas.get(j).nome.equals(artista)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int temasMusicaisAnoX(int ano) {

        int count = 0;

        for (int i = 0; i < Main.arraySongsOutput.size(); i++) {
            if (Main.arraySongsOutput.get(i).anoLancamento == ano) {
                count++;
            }
        }
        return count;
    }

    public static int temasMusicaisDuplicadosAnoX(int ano) {

        HashSet<String> temasDuplicados = new HashSet<>();
        HashSet<Song> temas = new HashSet<>();

        for (Song song: Main.arraySongsOutput) {
            if (song.anoLancamento==ano){
                temas.add(song);
            }
        }

       int count = 0;

        for(Song song: temas){
            if (temasDuplicados.contains(song.titulo)){
                count++;
            }else{
                temasDuplicados.add(song.titulo);
            }
        }

        return count;
    }

    public static String mostDancable(int anoInicio, int anoFim, int qntasMusicas) {

        LinkedList<Song> musicasComDancabilidadeElevada = new LinkedList<>();
        StringBuilder musicasOutput = new StringBuilder();

        for (Song song: Main.arraySongsOutput) {
            if(song.anoLancamento >= anoInicio && song.anoLancamento <= anoFim){
                musicasComDancabilidadeElevada.add(song);
            }
        }

        musicasComDancabilidadeElevada.sort(Comparator.comparingDouble((Song song) -> song.grauDeDancabilidade).reversed());

        for (int j = 0; (j < qntasMusicas) && (j < musicasComDancabilidadeElevada.size()); j++) {
            for (int c = 0; c < Main.arraySongsOutput.size(); c++) {
                if (Main.arraySongsOutput.get(c).id.equals(musicasComDancabilidadeElevada.get(j).id)) {
                    musicasOutput.append(Main.arraySongsOutput.get(c).titulo).append(" ").append(":").append(" ").append(Main.arraySongsOutput.get(c).anoLancamento)
                    .append(" ").append(":").append(" ").append(musicasComDancabilidadeElevada.get(j).grauDeDancabilidade).append("\n");
                }
            }
        }

        return musicasOutput.toString();
    }

    public static String addTags (String nomeDoArtista, ArrayList<String> tags){

        Artista tagsOutput=null;

        for (int i = 0; i < Main.arraySongsOutput.size() ; i++) {
            if (Main.arraySongsOutput.get(i).artistas!=null){
                for (int j = 0; j < Main.arraySongsOutput.get(i).artistas.size(); j++) {
                    if (Main.arraySongsOutput.get(i).artistas.get(j).nome.equals(nomeDoArtista)){
                        tagsOutput=Main.arraySongsOutput.get(i).artistas.get(j);
                        if (Main.arraySongsOutput.get(i).artistas.get(j).tags != null){
                            for (int k = 0; k < tags.size(); k++) {
                                if(!Main.arraySongsOutput.get(i).artistas.get(j).tags.contains(tags.get(k).toUpperCase())){
                                    Main.arraySongsOutput.get(i).artistas.get(j).tags.add(tags.get(k).toUpperCase());
                                }
                            }
                        }
                    }
                }
            }
        }

        StringBuilder output = new StringBuilder();
        if (tagsOutput !=null ){
            output.append(nomeDoArtista).append(" | ");
            for (int i = 0; i < tagsOutput.tags.size(); i++) {
                output.append(tagsOutput.tags.get(i).toUpperCase());

                if (i != tagsOutput.tags.size()-1){
                    output.append(",");
                }
            }
        }else{
            return "Inexistent artist";
        }

       return String.valueOf(output);
    }

    public static String getArtistsForTags (String tagsInput){

        StringBuilder output = new StringBuilder();
        ArrayList<String> listaArtista = Perguntas1.getArtiststForTagsHelp(tagsInput);

       // output.append(Main.arraySongsOutput.get(i).artistas.get(j).nome);
        for(int i = 0; i < listaArtista.size(); i++){
            output.append(listaArtista.get(i));
            if(i != listaArtista.size() - 1){
                output.append(";");
            }
        }

        if(output.length()==0){
            return "No results";
        }

        return output.toString();
    }

    public static String removeTags(String nomeDoArtista, ArrayList<String> tagsAretirar) {
        Artista tagsOutput = null;

        tagsOutput = Perguntas1.removeTagsHelp(nomeDoArtista,tagsAretirar,tagsOutput);

        StringBuilder output = new StringBuilder();
        if (tagsOutput != null ){
            output.append(nomeDoArtista).append(" | ");
            for (int i = 0; i < tagsOutput.tags.size(); i++) {
                output.append(tagsOutput.tags.get(i).toUpperCase());
                if (i != tagsOutput.tags.size()-1){
                    output.append(",");
                }
            }

            if (tagsOutput.tags.size()==0){
                output.append("No tags");
            }

        }else{

            return "Inexistent artist";
        }

        return String.valueOf(output);
    }

    //Inacabado
    public static int countNumeroDeTemasUniqueTags(String artista,LinkedList<Song> artistasEntreAnos){
        int count = 0;

        for (Song musicasDentroDestesAno : artistasEntreAnos) {
            for (int j = 0; j < musicasDentroDestesAno.artistas.size(); j++) {
                if (musicasDentroDestesAno.artistas.get(j).nome.equals(artista)) {
                    count++;
                }
            }
        }
        return count;
    }
    public static LinkedList<String> getUniqueTagsBetweenYearsHelp(LinkedList<Song> artistasEntreAnos,LinkedList<String> tags){
        //countNumeroDeTemasUniqueTags(artistasEntreAnos.get(i).artistas.get(j).nome,artistasEntreAnos) >= 1

        for (int i = 0; i < artistasEntreAnos.size(); i++) {
            for (int j = 0; j < artistasEntreAnos.get(i).artistas.size(); j++) {
                if (artistasEntreAnos.get(i).artistas.get(j).nome !=null){
                    for (int k = 0; k < artistasEntreAnos.get(i).artistas.get(j).tags.size(); k++) {
                        if (tags.contains(artistasEntreAnos.get(i).artistas.get(j).tags.get(k))){
                            continue;
                        }else{
                            tags.add(artistasEntreAnos.get(i).artistas.get(j).tags.get(k));
                        }
                    }
                }
            }
        }
        return tags;
    }
    public static String getUniqueTagsBetweenYears(int anoInicio, int anoFim){

        LinkedList<String> tags = new LinkedList<>();
        LinkedList<Song> artistasEntreAnos = new LinkedList<>();
        ArrayList<String> contador = new ArrayList<>();
        LinkedHashMap<String, Integer> tagEContador = new LinkedHashMap();

        for (Song song: Main.arraySongsOutput) {
            if(song.anoLancamento >= anoInicio && song.anoLancamento <= anoFim){
                artistasEntreAnos.add(song);
            }
        }

        tags=getUniqueTagsBetweenYearsHelp(artistasEntreAnos, tags);

        contador = new ArrayList<>(Main.tagsGlobais.keySet());

        contador.sort(Comparator.comparingInt((String ola) -> Main.tagsGlobais.get(ola)).reversed());

        StringBuilder output = new StringBuilder();

        if (Main.tagsGlobais.size()==0){
            return "No results";
        }

        for (int i = 0; i < contador.size(); i++) {
            output.append(contador.get(i).toUpperCase()).append(" ").append(Main.tagsGlobais.get(contador.get(i).toUpperCase())).append("\n");
        }

        return output.toString();
    }
}