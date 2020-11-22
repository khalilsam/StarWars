package io.thinkit.starwarsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import io.thinkit.starwarsapp.model.Film
import io.thinkit.starwarsapp.model.api.RepoRepository
import io.thinkit.starwarsapp.view.ui.utils.Constants.DateUtils.Companion.convertStringDate
import io.thinkit.starwarsapp.viewmodel.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class FilmViewModel : BaseViewModel() {

    val repoListLive = MutableLiveData<List<Film>>()
    val count=MutableLiveData<Int>()
    var film = MutableLiveData<Film>()


    fun fetchRepoList() {
        dataLoading.value = true
        CoroutineScope(Dispatchers.IO).launch {
            RepoRepository.getInstance().getRepoList { isSuccess, response ->
                dataLoading.value = false
                if (isSuccess) {
                    repoListLive.value = response?.results
                    count.value=response?.count
                    empty.value = false
                } else {
                    empty.value = true
                }
            }
        }
    }
    fun getFilmByid( url:String)
    {
        dataLoading.value=true
        CoroutineScope(Dispatchers.IO).launch {
            RepoRepository.getInstance().getFilmById(url, { isSuccess, response ->
                dataLoading.value = false
                if (isSuccess) {
                    film.value = response?.apply {
                        opening_crawl = opening_crawl.replace("\r\n"
                                ,"")
                        created =convertStringDate(created,"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                        edited =convertStringDate(edited,"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                        release_date=convertStringDate(release_date,"yyyy-MM-dd")
                    }
                    empty.value = false
                } else {
                    empty.value = true
                }
            })
        }

    }



}