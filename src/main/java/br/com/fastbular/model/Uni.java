package br.com.fastbular.model;

public class Uni {

    private String id;
    private String name;

    public Uni(String name) {
        this.name = name;
    }
    public Uni(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(Uni uni) {
    }

    public String getId() {
        return id;
    }
}