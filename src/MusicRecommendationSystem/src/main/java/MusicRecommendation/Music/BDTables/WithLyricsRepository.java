package MusicRecommendation.Music.BDTables;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WithLyricsRepository extends JpaRepository<WithLyrics, Long> {
    Optional<WithLyrics> findByWithLyricsName(String withLyrics);
}