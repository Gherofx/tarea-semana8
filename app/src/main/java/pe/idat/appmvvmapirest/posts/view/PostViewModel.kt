package pe.idat.appmvvmapirest.posts.view

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.idat.appmvvmapirest.posts.data.network.response.PostResponse
import pe.idat.appmvvmapirest.posts.domain.GetPostUseCase
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val postUseCase: GetPostUseCase)  : ViewModel() {
        var posts =mutableStateOf<List<PostResponse>>(emptyList())

    fun getPost(){
        viewModelScope.launch {
            val response= postUseCase()
            posts.value = response
            //Log.i("PostLIST", postUseCase().toString())
        }
    }

}