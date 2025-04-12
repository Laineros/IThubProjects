package MusicRecommendation.Music;

import MusicRecommendation.Music.BDTables.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Song, String> {
    void deleteByName(String song_name);

    Optional<Song> findByName(String song_name);
}