package br.com.vanessa.screenmatch.calculus;

import br.com.vanessa.screenmatch.models.Title;

public class CalcTime {
    private int totTime;

    public int getTotTime(){
        return this.totTime;
    }

    public void add(Title title){
        System.out.println("Adding duration in minutes " + title.getName());
        this.totTime += title.getDurationInMinutes();
    }
}
