package br.com.vanessa.screenmatch.calculus;

public class Rating {
    public void rating(Classification classification){
        if(classification.getClassification() >= 4){
            System.out.println("Good rating");
        } else if (classification.getClassification() >= 2){
            System.out.println("Bad rating");
        } else {
            System.out.println("bad rating");
        }
    }
}
