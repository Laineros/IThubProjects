package MusicRecommendation.Music.BDTables;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicTypeRepository extends JpaRepository<MusicType, Long> {
    Optional<MusicType> findByMusicTypeName(String musicType);
}
