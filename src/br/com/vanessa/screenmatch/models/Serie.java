package br.com.vanessa.screenmatch.models;

public class Serie extends Title{
    private int seasons;
    private boolean active;
    private int episodeBySeason;
    private int minutesByEpisode;

    public Serie(String name, int yearRelease){
        super(name, yearRelease);
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getEpisodeBySeason() {
        return episodeBySeason;
    }

    public void setEpisodeBySeason(int episodeBySeason) {
        this.episodeBySeason = episodeBySeason;
    }

    public int getMinutesByEpisode() {
        return minutesByEpisode;
    }

    public void setMinutesByEpisode(int minutesByEpisode) {
        this.minutesByEpisode = minutesByEpisode;
    }
    @Override
    public String toString(){
        return "Série: " + this.getName() + "(" + this.getYearRelease() + ")";
    }
}
