package com.song.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepository {
    private final List<Song> list = new ArrayList<Song>();

    public List<Song> getAllSongs() {
        return list;
    }

    public Song getSongById(Integer id) {
        return list.get(id);
    }

    public void addSong(Song s) {
        list.add(s);
    }

    public void updateSong(Song s) {
        int index = list.indexOf(s);
        list.set(index, s);
    }

    public void removeSong(Song s) {
        list.remove(s);
    }
}
