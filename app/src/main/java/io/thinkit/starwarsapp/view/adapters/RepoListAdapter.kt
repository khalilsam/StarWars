package io.thinkit.starwarsapp.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.thinkit.starwarsapp.databinding.ViewRepoListItemBinding
import io.thinkit.starwarsapp.model.Film
import io.thinkit.starwarsapp.view.adapters.viewholders.RepoListViewHolder
import io.thinkit.starwarsapp.viewmodel.FilmViewModel

class RepoListAdapter(private  val filmViewModel: FilmViewModel) : RecyclerView.Adapter<RepoListViewHolder>(){
    var filmList:List<Film> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoListViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val dataBinding= ViewRepoListItemBinding.inflate(inflater,parent,false)
        return RepoListViewHolder(dataBinding, filmViewModel)
    }

    override fun onBindViewHolder(holder: RepoListViewHolder, position: Int) {
        holder.setup(filmList[position])
    }

    override fun getItemCount()=filmList.size

    fun updateRepoList(filmList: List<Film>) {
        this.filmList = filmList
        notifyDataSetChanged()
    }


}