package io.thinkit.starwarsapp.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.thinkit.starwarsapp.databinding.ViewFilmListItemBinding
import io.thinkit.starwarsapp.model.Film
import io.thinkit.starwarsapp.view.adapters.viewholders.FilmListViewHolder
import io.thinkit.starwarsapp.viewmodel.FilmViewModel

class FilmListAdapter(private  val filmViewModel: FilmViewModel) : RecyclerView.Adapter<FilmListViewHolder>(){
    var filmList:List<Film> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmListViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val dataBinding= ViewFilmListItemBinding.inflate(inflater,parent,false)
        return FilmListViewHolder(dataBinding)
    }

    override fun onBindViewHolder(holder: FilmListViewHolder, position: Int) {
        holder.setup(filmList[position])
    }

    override fun getItemCount()=filmList.size

    fun updateRepoList(filmList: List<Film>) {
        this.filmList = filmList
        notifyDataSetChanged()
    }


}