package io.thinkit.starwarsapp.view.adapters.viewholders

import androidx.databinding.ViewDataBinding
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import io.thinkit.starwarsapp.BR
import io.thinkit.starwarsapp.R
import io.thinkit.starwarsapp.model.Film
import io.thinkit.starwarsapp.viewmodel.FilmViewModel
import org.jetbrains.anko.bundleOf
import org.jetbrains.anko.sdk27.coroutines.onClick

class RepoListViewHolder constructor(private val dataBinding: ViewDataBinding, private val filmViewModel: FilmViewModel)
    : RecyclerView.ViewHolder(dataBinding.root) {

    fun setup(itemData: Film) {
     dataBinding.setVariable(BR.itemData,itemData)
        dataBinding.executePendingBindings()
        itemView.onClick {
            val bundle = bundleOf(Pair("url", itemData.url),Pair("title",itemData.title))
            itemView.findNavController().navigate(R.id.action_repoListFragment_to_repoDetailFragment, bundle)
        }
    }
}