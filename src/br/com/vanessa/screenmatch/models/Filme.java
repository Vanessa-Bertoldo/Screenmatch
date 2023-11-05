package br.com.vanessa.screenmatch.models;

import br.com.vanessa.screenmatch.calculus.Classification;

public class Filme extends Title implements Classification {

    private String director;

    public Filme(String name, int yearRelease) {
        super(name, yearRelease);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getClassification() {
        return (int) average() / 2;
    }
    @Override
    public String toString(){
        return "Filme: " + this.getName() + " (" + this.getYearRelease() + ")";
    }
}
