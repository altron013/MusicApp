package com.example.composeplayerapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.composeplayerapp.data.Song

class SongViewModel(private val repository: SongRepository = SongRepository()) : ViewModel() {
    private val _song = mutableStateOf<Song?>(null)
    val song: State<Song?> = _song

    fun loadSongById(id: Int) {
        _song.value = repository.getSongById(id)
    }
}
