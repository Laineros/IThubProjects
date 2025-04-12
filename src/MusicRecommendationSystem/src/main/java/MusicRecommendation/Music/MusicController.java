package MusicRecommendation.Music;

import MusicRecommendation.Music.BDTables.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/music-recommendation")
public class MusicController {

    private final MusicService musicService;

    @Autowired
    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    @PostMapping("/recommend")
    public String getRecommendation(@RequestBody UserPreferences preferences) {
        List<Song> recommendedSongs = musicService.getRecommendations(preferences);

        if (recommendedSongs.isEmpty()) {
            return "Подходящей рекомендации для вашего запроса не найдено, попробуйте изменить настройки";
        } else {
            // Возвращаем список песен
            return "Рекомендую вам композицию: " + recommendedSongs.stream()
                    .map(Song::getSong_name)
                    .collect(Collectors.joining(", "));
        }
    }
}
