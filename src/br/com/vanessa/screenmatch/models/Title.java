package br.com.vanessa.screenmatch.models;

import br.com.vanessa.screenmatch.exception.ExceededLength;
import com.google.gson.annotations.SerializedName;

public class Title implements Comparable<Title>{
    @SerializedName("Title")
    private String name;
    @SerializedName("Year")
    private int yearRelease;
    private boolean addInPlan;
    private int totRating;
    private double sumRating;
    private int durationInMinutes;

    public Title(){}

    public Title(String name, int yearRelease) {
        this.name = name;
        this.yearRelease = yearRelease;
    }

    public Title(TitleOmdb titleOmbd) {
        this.name = titleOmbd.title();
        this.yearRelease = Integer.parseInt(titleOmbd.year().substring(0,4));

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearRelease() {
        return yearRelease;
    }

    public void setYearRelease(int yearRelease) {
        this.yearRelease = yearRelease;
    }

    public boolean isAddInPlan() {
        return addInPlan;
    }

    public void setAddInPlan(boolean addInPlan) {
        this.addInPlan = addInPlan;
    }

    public int getTotRating() {
        return totRating;
    }

    public void setTotRating(int totRating) {
        this.totRating = totRating;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public void showDetails(){
        System.out.println("Name: " + name);
        System.out.println("Year: " + yearRelease);
    }

    public void evaluation(double grade){
        sumRating += grade;
        totRating ++ ;
    }

    public double average(){
        return sumRating / totRating;
    }

    public int compareTo(Title otherTitle){
        return this.getName().compareTo(otherTitle.getName());
    }

    @Override
    public String toString() {
        return "Title{" +
                "name='" + name + '\'' +
                ", yearRelease=" + yearRelease +
                '}';
    }
}
