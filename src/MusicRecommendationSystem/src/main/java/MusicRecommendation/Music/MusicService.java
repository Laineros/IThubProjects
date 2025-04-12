package MusicRecommendation.Music;


import MusicRecommendation.Music.BDTables.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MusicService {

    private final SongRepository songRepository;
    private final MoodRepository moodRepository;
    private final MusicTypeRepository musicTypeRepository;
    private final WithLyricsRepository withLyricsRepository;

    @Autowired
    public MusicService(SongRepository songRepository, MoodRepository moodRepository,
                        MusicTypeRepository musicTypeRepository, WithLyricsRepository withLyricsRepository) {
        this.songRepository = songRepository;
        this.moodRepository = moodRepository;
        this.musicTypeRepository = musicTypeRepository;
        this.withLyricsRepository = withLyricsRepository;
    }

    public List<Song> getSongs() {
        return songRepository.findAll();
    }

    public List<Song> getRecommendations(UserPreferences preferences) {
        Optional<Mood> mood = moodRepository.findByMoodName(preferences.getMood());
        Optional<MusicType> musicType = musicTypeRepository.findByMusicTypeName(preferences.getMusicType());
        Optional<WithLyrics> withLyrics = withLyricsRepository.findByWithLyricsName(preferences.getWithLyrics());

        if (!mood.isPresent() || !musicType.isPresent() || !withLyrics.isPresent()) {
            return List.of();
        }

        return songRepository.findAll().stream()
                .filter(song -> song.getMood().equals(mood.get()) &&
                        song.getMusicType().equals(musicType.get()) &&
                        song.getWithLyrics().equals(withLyrics.get()))
                .collect(Collectors.toList());
    }

    public List<Song> getSongByName(String searchText) {
        return songRepository.findAll().stream()
                .filter(song -> song.getSong_name().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Song addSong(Song song) {
        songRepository.save(song);
        return song;
    }
    public Song updateSong(Song updatedSong) {
        Optional<Song> existingSong = songRepository.findByName(updatedSong.getSong_name());

        if (existingSong.isPresent()) {
            Song songToUpdate = existingSong.get();
            songToUpdate.setSong_name(updatedSong.getSong_name());
            songRepository.save(songToUpdate);
            return songToUpdate;
        }
        return null;
    }
    @Transactional
    public void deleteSong(String song_name) {
        songRepository.deleteByName(song_name);
    }
}