package br.com.vanessa.screenmatch.models;

import br.com.vanessa.screenmatch.calculus.Classification;

public class Episode implements Classification {
    private int number;
    private String name;
    private String serie;
    private int totVisualization;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getTotVisualization() {
        return totVisualization;
    }

    public void setTotVisualization(int totVisualization) {
        this.totVisualization = totVisualization;
    }

    @Override
    public int getClassification() {
        if(totVisualization > 100){
            return 4;
        } else {
            return 2;
        }
    }
}
