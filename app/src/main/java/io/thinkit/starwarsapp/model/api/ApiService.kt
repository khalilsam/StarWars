package io.thinkit.starwarsapp.model.api

import io.thinkit.starwarsapp.model.Film
import io.thinkit.starwarsapp.model.SwApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface ApiService {
    @GET("films")
    fun getFilmsList():Call<SwApiResponse>

    @GET()
    fun getFilmById(@Url url:String):Call<Film>
}