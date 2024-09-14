package com.example.composeplayerapp

import com.example.composeplayerapp.data.Song
import com.example.composeplayerapp.data.songList

class SongRepository {
    fun getSongById(id: Int): Song? {
        return songList.find { it.id == id }
    }
}