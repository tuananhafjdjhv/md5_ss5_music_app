package ra.spring_mvc_music_app.model.service;

import ra.spring_mvc_music_app.model.entity.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();

    Music findById(Long id);

    void deleteById(Long id);

    void save(Music s);
    void  update(Music s);
}
