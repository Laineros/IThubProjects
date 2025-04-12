package MusicRecommendation.Music.BDTables;

import jakarta.persistence.*;

@Entity
@Table(name = "with_lyrics")
public class WithLyrics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_with_lyrics;

    @Column(name = "with_lyrics_name")
    private String withLyricsName;

    public Long getId_with_lyrics() {
        return id_with_lyrics;
    }

    public void setId_with_lyrics(Long id) {
        this.id_with_lyrics = id;
    }

    public String getWithLyricsName() {
        return withLyricsName;
    }

    public void setWithLyricsName(String with_lyrics_name) {
        this.withLyricsName = with_lyrics_name;
    }
}
