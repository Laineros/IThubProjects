package MusicRecommendation.Music;

public class UserPreferences {

    private String mood;
    private String musicType;
    private String withLyrics;

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getMusicType() {
        return musicType;
    }

    public void setMusicType(String musicType) {
        this.musicType = musicType;
    }

    public String getWithLyrics() {
        return withLyrics;
    }

    public void setWithLyrics(String withLyrics) {
        this.withLyrics = withLyrics;
    }
}
