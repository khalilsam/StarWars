package io.thinkit.starwarsapp.model.api

import io.thinkit.starwarsapp.model.Film
import io.thinkit.starwarsapp.model.SwApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoRepository
{

    // GET repo list
    fun getRepoList(onResult: (isSuccess: Boolean, response: SwApiResponse?) -> Unit) {

        ApiClient.instance.getFilmsList().enqueue(object : Callback<SwApiResponse> {
            override fun onResponse(call: Call<SwApiResponse>?, response: Response<SwApiResponse>?) {
                if (response != null && response.isSuccessful) {
                    onResult(true, response.body())
                }
                else
                    onResult(false, null)
            }

            override fun onFailure(call: Call<SwApiResponse>?, t: Throwable?) {
                onResult(false, null)
            }

        })
    }
// get Film by id
    fun getFilmById(url:String,onResult: (isSuccess: Boolean, response: Film?) -> Unit){
       ApiClient.instance.getFilmById(url).enqueue(object :Callback<Film> {
           override fun onResponse(call: Call<Film>, response: Response<Film>) {
               if (response != null && response.isSuccessful) {
                   onResult(true, response.body())
               }  else
                   onResult(false, null)
           }

           override fun onFailure(call: Call<Film>, t: Throwable) {
               onResult(false, null)
           }

       })


}


    companion object {
        private var INSTANCE: RepoRepository? = null
        fun getInstance() = INSTANCE
            ?: RepoRepository().also {
                INSTANCE = it
            }
    }
}