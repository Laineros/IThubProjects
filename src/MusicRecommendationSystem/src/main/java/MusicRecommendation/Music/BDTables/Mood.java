package MusicRecommendation.Music.BDTables;

import jakarta.persistence.*;

@Entity
@Table(name = "mood")
public class Mood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // или GenerationType.SEQUENCE
    private Long id_mood;

    @Column(name = "mood_name")
    private String moodName;

    public void setId_mood(Long id) {
        this.id_mood = id;
    }

    public Long getId_mood() {
        return id_mood;
    }

    public String getMoodName() {
        return moodName;
    }

    public void setMoodName(String mood_name) {
        this.moodName = mood_name;
    }
}
