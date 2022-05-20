package pt.ulusofona.aed.deisiRockstar2021;

import java.util.ArrayList;

public class Song {
    String id;
    String titulo;
    ArrayList<Artista> artistas = new ArrayList<>();
    int anoLancamento;
    int duracaoDoTema;
    boolean letraExplicita;
    int popularidade;
    double grauDeDancabilidade;
    double grauDeVivacidade;
    double volumeMedio;


    public Song(String id, String titulo, ArrayList<Artista> artistas, int anoLancamento, int duracaoDoTema, boolean letraExplicita,
                int popularidade, double grauDeDancabilidade, double grauDeVivacidade, double volumeMedio) {
        this.id = id;
        this.titulo = titulo;
        this.artistas = artistas;
        this.anoLancamento = anoLancamento;
        this.duracaoDoTema = duracaoDoTema;
        this.letraExplicita = letraExplicita;
        this.popularidade = popularidade;
        this.grauDeDancabilidade = grauDeDancabilidade;
        this.grauDeVivacidade = grauDeVivacidade;
        this.volumeMedio = volumeMedio;
    }

    public Song(String id, int duracaoDoTema, int popularidade) {
        this.id = id;
        this.duracaoDoTema = duracaoDoTema;
        this.popularidade = popularidade;
    }

    public Song() {
    }

    public Song(String id, String titulo, int anoLancamento) {
        this.id = id;
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
    }

    public Song(String id, String titulo, int anoLancamento, int duracaoDoTema, int popularidade) {
        this.id = id;
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.duracaoDoTema = duracaoDoTema;
        this.popularidade = popularidade;
    }

    public Song(String id, int duracaoDoTema, boolean letraExplicita, int popularidade, double grauDeDancabilidade, double grauDeVivacidade, double volumeMedio) {
        this.id = id;
        this.duracaoDoTema = duracaoDoTema;
        this.letraExplicita = letraExplicita;
        this.popularidade = popularidade;
        this.grauDeDancabilidade = grauDeDancabilidade;
        this.grauDeVivacidade = grauDeVivacidade;
        this.volumeMedio = volumeMedio;
    }

    public Song(String id, ArrayList<Artista> artistas) {
        this.id = id;
        this.artistas = artistas;
    }


    public Song(String titulo, int anoLancamento) {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
    }

    public Song(int duracaoDoTema, boolean letraExplicita, int popularidade, double grauDeDancabilidade, double grauDeVivacidade, double volumeMedio) {
        this.duracaoDoTema = duracaoDoTema;
        this.letraExplicita = letraExplicita;
        this.popularidade = popularidade;
        this.grauDeDancabilidade = grauDeDancabilidade;
        this.grauDeVivacidade = grauDeVivacidade;
        this.volumeMedio = volumeMedio;
    }

    public Song(ArrayList<Artista> artistas) {
        this.artistas = artistas;
    }

    @Override
    public String toString() {
        double popularidadeDouble = popularidade;
        int count = 0;
        StringBuilder text = new StringBuilder();
        StringBuilder countNrTemas = new StringBuilder();

        if (artistas.size() == 0) {
            return id + " " + "|" + " " + titulo + " " + "|" + " " + anoLancamento + " " + "|" + " " + (duracaoDoTema / 1000) / 60 + ":" + duracaoDoTema / (1000) % 60
                    + " " + "|" + " " + popularidadeDouble + " " + "|" + " " + " " + "|" + " " + "(" + ")";
        }

        /*
        for (Song song: Main.arraySongsOutput) {
            for (int i = 0; song.artistas != null && i < song.artistas.size() ; i++) {
                if (song.artistas.get(i).nome.equals(artistas.get(i).nome)){
                    count++;
                }
            }
        }

         */
        int primeiraVez = 0;


        for (int j = 0; j < artistas.size(); j++) {
            count = Perguntas.countNumeroDeTemas(artistas.get(j).nome);
            if (primeiraVez == 0) {
                countNrTemas.append(count);
                primeiraVez++;
            } else {
                countNrTemas.append(" / ").append(count);

            }
        }


        for (int i = 0; i < artistas.size(); i++) {
            if (i == artistas.size() - 1) {
                text.append(artistas.get(i).nome);
                break;
            } else {
                text.append(artistas.get(i).nome).append(" / ");
            }
        }


        return id + " " + "|" + " " + titulo + " " + "|" + " " + anoLancamento + " " + "|" + " " + (duracaoDoTema / 1000) / 60 + ":" + duracaoDoTema / (1000) % 60
                + " " + "|" + " " + popularidadeDouble + " " + "|" + " " + text + " " + "|" + " " + "(" + countNrTemas + ")";



        /*
        return id + " " +  "|" + " " + titulo + " " + "|" + " " + anoLancamento + " " + "|" + " " + duracaoDoTema + " " + "|" + " " + popularidade +" " + "|" + " " +
        Arrays.toString(artistas) + " " + "|" + " " + "(" + countTemas + ")";

        */
    }
}
