package pe.idat.appmvvmapirest.posts.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pe.idat.appmvvmapirest.posts.data.network.response.PostResponse



@Composable
fun ListaPostScreen(postViewModel: PostViewModel) {
    LaunchedEffect(Unit) {
        postViewModel.getPost()
    }

    val posts by remember { postViewModel.posts }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(posts) { post ->
                itemPost(post)
            }
        }
    }
}


@Composable
fun itemPost(postResponse: PostResponse) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = MaterialTheme.shapes.large,
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "User ID: ${postResponse.userId}")
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "ID: ${postResponse.id}")
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = postResponse.title, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = postResponse.body)
        }
    }
}