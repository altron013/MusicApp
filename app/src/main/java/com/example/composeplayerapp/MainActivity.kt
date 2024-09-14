package com.example.composeplayerapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeplayerapp.ui.screens.HomeScreen
import com.example.composeplayerapp.ui.screens.SongDetailScreen
import com.example.composeplayerapp.ui.theme.MusicStreamingAppTheme

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MusicStreamingAppTheme {
                lateinit var navController: NavHostController

                Scaffold(topBar = {
//                    TopAppBar(
//                        title = { androidx.compose.material.Text(text = "Music Streaming App") },
//                        backgroundColor = MaterialTheme.colors.primary
//                    )
                }) {
                    navController = rememberNavController()
                    NavHost(navController = navController,
                        startDestination = "home",
                        builder = {

                            composable("home") {
                                HomeScreen(navController = navController)
                            }
                            composable("detail/{id}") { backStackEntry ->
                                val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
                                id?.let {
                                    SongDetailScreen(id = it)
                                }
                            }
                        })
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MusicStreamingAppTheme {
        Greeting("Android")
    }
}
