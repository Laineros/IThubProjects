package MusicRecommendation.Music.BDTables;

import jakarta.persistence.*;

@Entity
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_song;
    @Column(name = "song_name", unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mood_id")
    private Mood mood;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "music_type_id")
    private MusicType musicType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "with_lyrics_id")
    private WithLyrics withLyrics;

    public Long getId_song() {
        return id_song;
    }

    public void setId_song(Long id) {
        this.id_song = id;
    }

    public String getSong_name() {
        return name;
    }

    public void setSong_name(String song_name) {
        this.name = song_name;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public MusicType getMusicType() {
        return musicType;
    }

    public void setMusicType(MusicType musicType) {
        this.musicType = musicType;
    }

    public WithLyrics getWithLyrics() {
        return withLyrics;
    }

    public void setWithLyrics(WithLyrics withLyrics) {
        this.withLyrics = withLyrics;
    }
}