package io.thinkit.starwarsapp.model

import io.thinkit.starwarsapp.model.api.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmRepository {

    // GET repo list
    fun getRepoList(onResult: (isSuccess: Boolean, response: SwApiResponse?) -> Unit) {

        ApiClient.instance.getFilmsList().enqueue(object : Callback<SwApiResponse> {
            override fun onResponse(
                call: Call<SwApiResponse>?,
                response: Response<SwApiResponse>?
            ) {
                if (response != null && response.isSuccessful) {
                    onResult(true, response.body())
                } else
                    onResult(false, null)
            }

            override fun onFailure(call: Call<SwApiResponse>?, t: Throwable?) {
                onResult(false, null)
            }

        })
    }

    // get Film by id
    fun getFilmById(url: String, onResult: (isSuccess: Boolean, response: Film?) -> Unit) {
        ApiClient.instance.getFilmById(url).enqueue(object : Callback<Film> {
            override fun onResponse(call: Call<Film>, response: Response<Film>) {
                if (response != null && response.isSuccessful) {
                    onResult(true, response.body())
                } else
                    onResult(false, null)
            }

            override fun onFailure(call: Call<Film>, t: Throwable) {
                onResult(false, null)
            }

        })


    }


    companion object {
        private var INSTANCE: FilmRepository? = null
        fun getInstance() = INSTANCE
            ?: FilmRepository().also {
                INSTANCE = it
            }
    }
}