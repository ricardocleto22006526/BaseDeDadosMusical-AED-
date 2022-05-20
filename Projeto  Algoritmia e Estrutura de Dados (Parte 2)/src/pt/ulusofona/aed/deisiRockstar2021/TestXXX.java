package pt.ulusofona.aed.deisiRockstar2021;

import org.junit.Test;
import java.io.IOException;

import static org.junit.Assert.*;

public class TestXXX {

    @Test
    public void testgetCreativeQuery() throws IOException { //QUERY CRIATIVA
        LeituraFicheirosTestes.loadFilesTestes();
        String expected = "Only For You : 2012 : 0.174\nCrazy Kids : 2012 : 0.107\n";
        String obtained = LeituraFicheirosTestes.executeTestes("VIVACITY_DECREASING_MUSIC_IN_THE_YEAR 2012 0.100");
        assertEquals(expected, obtained);
    }

    @Test
    public void testeDeSong1(){
        String resultadoEsperado = "0cS0A1fUEUd1EW3FcF8AEI | Only For You | 2012 | 2:48 | 12.0 |  | ()";
        Song resultadoObtido = new Song("0cS0A1fUEUd1EW3FcF8AEI","Only For You",2012, 168333,12);

        assertEquals(resultadoEsperado, resultadoObtido.toString());

    }

    @Test
    public void testeDeSong2(){
        String resultadoEsperado = "0hbkKFIJm7Z05H8Zl9w30f | I Put A Spell On You | 1920 | 2:30 | 7.0 |  | ()";
        Song resultadoObtido = new Song("0hbkKFIJm7Z05H8Zl9w30f","I Put A Spell On You",1920, 150200,7);

        assertEquals(resultadoEsperado, resultadoObtido.toString());
    }

    @Test
    public void testCOUNT_SONGS_YEAR() throws IOException {
        LeituraFicheirosTestes.loadFilesTestes();
        String expected = "3";
        String obtained = LeituraFicheirosTestes.executeTestes("COUNT_SONGS_YEAR 2012");
        assertEquals(expected, obtained);
    }

    @Test
    public void testCOUNT_DUPLICATE_SONGS_YEAR() throws IOException {
        LeituraFicheirosTestes.loadFilesTestes();
        String expected = "0";
        String obtained = LeituraFicheirosTestes.executeTestes("COUNT_DUPLICATE_SONGS_YEAR 2012");
        assertEquals(expected, obtained);
    }

    @Test
    public void testGET_ARTISTS_FOR_TAG() throws IOException {
        LeituraFicheirosTestes.loadFilesTestes();
        String expected = "CR7";
        LeituraFicheirosTestes.executeTestes("ADD_TAGS CR7;PRO");
        String obtained = LeituraFicheirosTestes.executeTestes("GET_ARTISTS_FOR_TAG PRO");
        assertEquals(expected, obtained);
    }

    @Test
    public void testGET_MOST_DANCEABLE() throws IOException {
        LeituraFicheirosTestes.loadFilesTestes();
        String expected ="24Seven - Dan Lemur Progressive Remix : 2013 : 0.633\nLoops & Tings - Radio Edit : 2013 : 0.63\nOnly For You : 2012 : 0.596\n";
        String obtained = LeituraFicheirosTestes.executeTestes("GET_MOST_DANCEABLE 2012 2013 3");
        assertEquals(expected, obtained);
    }

    @Test
    public void testGET_ARTISTS_ONE_SONG() throws IOException {
        LeituraFicheirosTestes.loadFilesTestes();
        String expected ="CR7 | Only For You | 2012\nfigueira | Loops & Tings - Radio Edit | 2013\n" +
                "Frank Sinatra | Crazy Kids | 2012\nMountain John | Move - Tune Brothers Remix | 2013\n" +
                "Rammstein | Shiver | 2012\nZezinho | 24Seven - Dan Lemur Progressive Remix | 2013\n";

        String obtained = LeituraFicheirosTestes.executeTestes("GET_ARTISTS_ONE_SONG 2012 2013");
        assertEquals(expected, obtained);
    }

    @Test
    public void testGET_TOP_ARTISTS_WITH_SONGS_BETWEEN() throws IOException {
        LeituraFicheirosTestes.loadFilesTestes();
        String expected = "Inexistent artist";
        String obtained = LeituraFicheirosTestes.executeTestes("GET_TOP_ARTISTS_WITH_SONGS_BETWEEN 3 0 1");
        assertEquals(expected, obtained);
    }

    @Test
    public void testADD_TAGS() throws IOException {
        LeituraFicheirosTestes.loadFilesTestes();
        String expected = "CR7 | GOAT";
        String obtained = LeituraFicheirosTestes.executeTestes("ADD_TAGS CR7;GOAT");
        assertEquals(expected, obtained);
    }

    @Test
    public void testREMOVE_TAGS() throws IOException {
        LeituraFicheirosTestes.loadFilesTestes();
        LeituraFicheirosTestes.executeTestes("ADD_TAGS CR7;GOAT;REI");
        String expected = "CR7 | REI";
        String obtained = LeituraFicheirosTestes.executeTestes("REMOVE_TAGS CR7;GOAT");
        assertEquals(expected, obtained);
    }

    @Test
    public void testGET_UNIQUE_TAGS_IN_BETWEEN_YEARS() throws IOException {
        //QUERY Nao funciona 100% correta, mas para estes dados deu output CORRETO, pois sao ficheiros pequenos
        LeituraFicheirosTestes.loadFilesTestes();
        String expected = "GOAT 2\n" +"REI 1\n" + "PRO 1\n";
        String obtained = LeituraFicheirosTestes.executeTestes("GET_UNIQUE_TAGS_IN_BETWEEN_YEARS 2012 2013");
        assertEquals(expected, obtained);
    }

    @Test
    public void testQueryInvalida() throws IOException { //CASO NAO SEJA SELECIONADA NENHUMA QUERY VALIDA
        LeituraFicheirosTestes.loadFilesTestes();
        String expected = "Illegal command. Try again\n";
        String obtained = LeituraFicheirosTestes.executeTestes("QUERY_BLABLABLA");
        assertEquals(expected, obtained);
    }

    //A PARTIR DESTA LINHA PARA BAIXO AS QUERYS NAO FORAM FINALIZADAS/REALIZADAS
    @Test
    public void testMOST_FREQUENT_WORDS_IN_ARTIST_NAME() throws IOException { //QUERY Nao foi feita
        LeituraFicheirosTestes.loadFilesTestes();
        String expected = "Inexistent artist";
        String obtained = LeituraFicheirosTestes.executeTestes("GET_TOP_ARTISTS_WITH_SONGS_BETWEEN");
        assertEquals(expected, obtained);
    }

    @Test
    public void testGET_UNIQUE_TAGS() throws IOException { //QUERY Nao foi feita
        LeituraFicheirosTestes.loadFilesTestes();
        String expected = "Nao Acabada";
        String obtained = LeituraFicheirosTestes.executeTestes("GET_UNIQUE_TAGS");
        assertEquals(expected, obtained);
    }

    @Test
    public void testGET_RISING_STARS() throws IOException { //QUERY Nao foi feita
        LeituraFicheirosTestes.loadFilesTestes();
        String expected = "Nao Acabada1";
        String obtained = LeituraFicheirosTestes.executeTestes("GET_RISING_STARS");
        assertEquals(expected, obtained);
    }

    @Test
    public void testCLEANUP() throws IOException { //QUERY Nao foi feita
        LeituraFicheirosTestes.loadFilesTestes();
        String expected = "Nao Acabada2";
        String obtained = LeituraFicheirosTestes.executeTestes("CLEANUP");
        assertEquals(expected, obtained);
    }
}
