package MusicRecommendation.Music.BDTables;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MoodRepository extends JpaRepository<Mood, Long> {
    Optional<Mood> findByMoodName(String mood_name);
}
