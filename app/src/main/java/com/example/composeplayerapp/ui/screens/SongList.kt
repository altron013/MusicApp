
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.composeplayerapp.data.Song

@Composable
fun SongList(
    navController: NavController,
    songList: List<Song>
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(songList) { song ->
            SongCard(song = song, onClick = {
                navController.navigate("detail/${song.id}") // Navigate with id
            })
        }
    }
}


