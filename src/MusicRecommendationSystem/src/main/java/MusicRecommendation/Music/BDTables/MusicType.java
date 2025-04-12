package MusicRecommendation.Music.BDTables;

import jakarta.persistence.*;

@Entity
@Table(name = "Music_type")
public class MusicType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_music_type;

    @Column(name = "music_type_name")
    private String musicTypeName;

    public String getMusicTypeName() {
        return musicTypeName;
    }

    public void setMusicTypeName(String music_type_name) {
        this.musicTypeName = music_type_name;
    }

    public Long getId_music_type() {
        return id_music_type;
    }

    public void setId_music_type(Long id) {
        this.id_music_type = id;
    }
}
