package com.example.composeplayerapp.ui.screens

import SongList
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.composeplayerapp.Greeting
import com.example.composeplayerapp.data.Song
import com.example.composeplayerapp.data.songList
import com.example.composeplayerapp.ui.theme.MusicStreamingAppTheme

@Composable
fun HomeScreen(navController: NavController) {
    var selectedSong by remember { mutableStateOf<Song?>(null) }

    var number: Int = 1

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    )
    {
        Column(modifier = Modifier) {
            SongList(
                songList = songList,
                navController = navController
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MusicStreamingAppTheme {
        Greeting("Android")
    }
}