package pt.ulusofona.aed.deisiRockstar2021;

import java.util.ArrayList;

public class Artista {
    String id;
    String nome;
    ArrayList <String> tags = new ArrayList<>();

    public Artista() {
    }

    public Artista(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Artista(String nome){
        this.nome = nome;
    }
}
