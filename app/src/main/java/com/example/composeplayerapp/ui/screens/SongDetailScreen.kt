package com.example.composeplayerapp.ui.screens

import MediaPlayerCard
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.composeplayerapp.SongViewModel

@Composable
fun SongDetailScreen(
    id: Int,
    viewModel: SongViewModel = viewModel()
) {

    LaunchedEffect(id) {
        viewModel.loadSongById(id)
    }

    val song = viewModel.song.value


    song?.let {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = "Song ID: ${it.id}")
            Text(text = "Title: ${it.title}")
            Text(text = "Artist: ${it.artist}")
            Text(text = "Duration: ${it.duration}")
            Image(
                painter = rememberImagePainter(it.imageUrl),
                contentDescription = null,
                modifier = Modifier.size(128.dp)
            )
            MediaPlayerCard(song = song)
        }
    } ?: run {
        Text(text = "Song not found.")
    }
}