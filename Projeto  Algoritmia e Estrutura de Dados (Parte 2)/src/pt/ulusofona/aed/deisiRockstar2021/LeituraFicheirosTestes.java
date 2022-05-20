package pt.ulusofona.aed.deisiRockstar2021;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeituraFicheirosTestes {
    public static void loadFilesTestes() throws IOException {
        Main.arraySongsOutput.clear(); Main.leituraSongs.clear(); Main.leituraDetails.clear(); Main.leituraArtists.clear();

        leituraFicheiroSongsTestes();
        leituraFicheiroDetailsTestes();
        leituraFicheiroArtistsTestes();

        Main.arraySongsOutput = new ArrayList<>(Main.leituraSongs.values());
    }

    public static void leituraFicheiroSongsTestes (){
        try{
            Main.linhaOKouNao[0]=0;
            Main.linhaOKouNao[1]=0;

            //Arrays.fill(arraySongsOutput,null); //Limpa o array que guarda as musicas
            long inicio1=System.currentTimeMillis();
            FileReader fr = new FileReader("test-files/songs.txt");
            BufferedReader reader = new BufferedReader(fr);

            String linha = null;

            while((linha = reader.readLine()) != null) {

                // partir a linha no caractere separador
                String[] dados = linha.split("@");

                //verifica se a linha tem os parametros necessarios
                if (dados.length!=3){
                    Main.linhaOKouNao[1]++;
                    continue;
                }

                //Vai preencher as posicoes do array
                String id = dados[0].trim();
                String nome = dados[1].trim();  //.replaceFirst("\"","");             // replace("\"","");
                int anoLancamento = Integer.parseInt(dados[2].trim());

                if (id.equals("") || nome.equals("") || anoLancamento < 1900 || anoLancamento > 2021){
                    Main.linhaOKouNao[1]++;
                    continue;
                }

                // criar o obj Utilizador
                Song songs = new Song(id,nome,anoLancamento);

                if(Main.leituraSongs.containsKey(id)){
                    Main.linhaOKouNao[1]++;
                    continue;
                }

                if (Main.leituraSongs.get(id)==null){
                    Main.leituraSongs.put(id,songs);
                    Main.linhaOKouNao[0]++;
                }

                //arraySongsOutput[counterLinhasSong]=songs;
                //counterLinhasSong++;

            }
            reader.close(); long end1=System.currentTimeMillis();
            System.out.println("SONGS.txt:"+(end1-inicio1));
        } catch (FileNotFoundException e) { System.out.println("Ficheiro não encontrado");
        } catch (IOException e) { System.out.println("Ocorreu um erro durante a leitura."); }
    }

    public static void leituraFicheiroDetailsTestes (){
        try{

            Main.linhaOKouNao1[0]=0;
            Main.linhaOKouNao1[1]=0;
            long inicio1=System.currentTimeMillis();
            FileReader fr = new FileReader("test-files/song_details.txt");
            BufferedReader reader = new BufferedReader(fr);

            String linha = null;

            while((linha = reader.readLine()) != null) {

                // partir a linha no caractere separador
                String[] dados = linha.split("@");

                //verifica se a linha tem os parametros necessarios
                if (dados.length!=7){ Main.linhaOKouNao1[1]++; continue; }

                /*
                //FAZ A LIMPEZA DAS VARIAVEIS INVALIDAS
                int duracaoDoTema; //= Integer.parseInt(dados[1].trim());
                int letraExplicita; //=Integer.parseInt(dados[2].trim());
                int popularidade; //=Integer.parseInt(dados[3].trim());

                try {
                     duracaoDoTema=Integer.parseInt(dados[1].trim());
                     letraExplicita=Integer.parseInt(dados[2].trim());
                     popularidade=Integer.parseInt(dados[3].trim());
                }
                catch (NumberFormatException e){
                     duracaoDoTema = -1;
                     letraExplicita = -1;
                     popularidade = -1;
                }

                if (duracaoDoTema < 0 || letraExplicita < 0 || popularidade < 0){
                    Main.linhaOKouNao1[1]++;
                    continue;
                }
                 */


                //Vai preencher as posicoes do array
                String id = dados[0].trim(); int duracaoDoTema = Integer.parseInt(dados[1].trim()); int letraExplicita=Integer.parseInt(dados[2].trim());
                dados[2]= String.valueOf(ReduzirMain.explicitoOuNao(letraExplicita)).trim(); int popularidade=Integer.parseInt(dados[3].trim());
                double grauDeDancabilidade=Double.parseDouble(dados[4].trim()); double grauDeVivacidade=Double.parseDouble(dados[5].trim());
                double volumeMedio=Double.parseDouble(dados[6].trim());

                if (id.equals("") || (letraExplicita!=0 && letraExplicita!=1)){ Main.linhaOKouNao1[1]++; continue; }

                Song song_details = new Song(id,duracaoDoTema,ReduzirMain.explicitoOuNao(letraExplicita),popularidade,grauDeDancabilidade,grauDeVivacidade,volumeMedio);

                if (!Main.leituraSongs.containsKey(id)){
                    Main.linhaOKouNao1[1]++;
                    continue;
                }

                if (Main.leituraSongs.get(id)==null) {
                    Main.leituraDetails.put(id, song_details);
                    Main.linhaOKouNao1[0]++;
                }else{
                    if (Main.leituraSongs.get(id).duracaoDoTema==0){
                        Main.leituraSongs.get(id).duracaoDoTema=duracaoDoTema; Main.leituraSongs.get(id).letraExplicita=ReduzirMain.explicitoOuNao(letraExplicita);
                        Main.leituraSongs.get(id).popularidade=popularidade; Main.leituraSongs.get(id).grauDeDancabilidade=grauDeDancabilidade;
                        Main.leituraSongs.get(id).grauDeVivacidade=grauDeVivacidade; Main.leituraSongs.get(id).volumeMedio=volumeMedio; Main.linhaOKouNao1[0]++;
                    }else{ Main.linhaOKouNao1[1]++; }
                }
            }
            reader.close();long end1=System.currentTimeMillis();
            System.out.println("SONGS_Details.txt:"+(end1-inicio1));
        } catch (FileNotFoundException e) { System.out.println("Ficheiro não encontrado");
        } catch (IOException e) { System.out.println("Ocorreu um erro durante a leitura."); }
    }

    public static void leituraFicheiroArtistsTestes(){
        try{
            Main.linhaOKouNao2[0]=0;
            Main.linhaOKouNao2[1]=0;
            long inicio1=System.currentTimeMillis();
            FileReader fr = new FileReader("test-files/song_artists.txt");
            BufferedReader reader = new BufferedReader(fr);

            String linha = null;

            while((linha = reader.readLine()) != null) {

                // partir a linha no caractere separador
                String[] dados = linha.split("@");

                //verifica se a linha tem os parametros necessarios

                if (dados.length!=2){
                    Main.linhaOKouNao2[1]++;
                    continue;
                }


                //Vai preencher as posicoes do array
                String[] nomesArtistas; String id = dados[0].trim(); ArrayList<Artista> artistas; nomesArtistas = dados[1].split(","); artistas=new ArrayList<>();

                retirarComplexidadeArtistasLimparCaracteresTestes(nomesArtistas,artistas);




                if ( retirarComplexidadeArtistasVerificarSeNomeArtistaEValidoTestes(nomesArtistas) || id.equals("")){
                    Main.linhaOKouNao2[1]++;
                    continue;
                }


                Song song_artists = new Song(id,artistas);

                if (Main.leituraArtists.containsKey(id)){
                    Main.linhaOKouNao2[1]++;
                    continue;
                }


                if (Main.leituraSongs.get(id)==null){
                    Main.leituraArtists.put(id,song_artists);
                    Main.linhaOKouNao2[1]++;
                }else{
                    Main.leituraSongs.get(id).artistas=artistas;
                    Main.linhaOKouNao2[0]++;
                }

            }
            reader.close();
            long end1=System.currentTimeMillis();
            System.out.println("SONGS_artists.txt:"+(end1-inicio1));
        } catch (FileNotFoundException e) { System.out.println("Ficheiro não encontrado");
        } catch (IOException e) {System.out.println("Ocorreu um erro durante a leitura.");}
    }

    //AJUDA leituraFicheiroArtists
    public static void retirarComplexidadeArtistasLimparCaracteresTestes(String[] nomesArtistas, ArrayList<Artista> artistas){

        for (String nomesArtista : nomesArtistas) {
            artistas.add(new Artista(nomesArtista.trim().replace("']","").replace("['","")
                    .replace("\"","").replace("'","").split(",")[0].trim()));
        }

    }
    //AJUDA leituraFicheiroArtists
    public static boolean retirarComplexidadeArtistasVerificarSeNomeArtistaEValidoTestes(String[] nomesArtistas){
        boolean entrou1=false;
        for (String artista : nomesArtistas) {
            if ( condicoesTestes(artista) ) {
                entrou1 = true;
                break;
            }
        }
        return entrou1;
    }
    //AJUDA retirarComplexidadeArtistasVerificarSeNomeArtistaEValido
    public static boolean condicoesTestes(String artista){
        boolean condicao=artista.equals(" [''") || artista.equals("'']") || artista.equals(" ']\"") || artista.equals("") || artista.equals(" ")
                || artista.equals(" ['']") || artista.equals(" '']\"")|| artista.equals("''") || artista.equals("' '") || artista.equals(" \"[''");

        return condicao;
    }

    public static String executeTestes(String command){
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

            case ("GET_ARTISTS_ONE_SONG"): //ERRADO, FALTA CORRIGIR
                return Perguntas1.getArtistOneSong(Integer.parseInt(query[1]),Integer.parseInt(query[2]));

            case ("GET_TOP_ARTISTS_WITH_SONGS_BETWEEN"): //FALTA REFAZER
                // return Perguntas1.getArtistsBetween(Integer.parseInt(query[1]),Integer.parseInt(query[2]),Integer.parseInt(query[3]));

            case ("ADD_TAGS"): //FEITO (OBG)
                String[] divisao = command.split(";");
                divisao[0] = divisao[0].substring(9);
                ArrayList <String> tags = new ArrayList<>();
                for (int i = 1; i < divisao.length ; i++) { tags.add(divisao[i].toUpperCase()); }

                for (int i = 0; i < tags.size(); i++) {
                    if(Main.tagsGlobais.containsKey(tags.get(i))){
                        Main.tagsGlobais.put(tags.get(i).toUpperCase(), Main.tagsGlobais.get(tags.get(i))+1);
                    } else {
                        Main.tagsGlobais.put(tags.get(i).toUpperCase(), 1);
                    }
                }
                return Perguntas.addTags(divisao[0],tags);
            default:
                return LeituraFicheirosTestes1.reduzirExecuteTestes(command);
        }
    }
}
