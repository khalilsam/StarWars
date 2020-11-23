package io.thinkit.starwarsapp.view.ui.filmlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import io.thinkit.starwarsapp.R
import io.thinkit.starwarsapp.databinding.FragmentFilmListBinding
import io.thinkit.starwarsapp.view.adapters.FilmListAdapter
import io.thinkit.starwarsapp.viewmodel.FilmViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_film_list.*
import org.jetbrains.anko.longToast

class FilmListFragment : Fragment() {
    private lateinit var viewDataBinding: FragmentFilmListBinding
    private lateinit var adapter: FilmListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = FragmentFilmListBinding.inflate(inflater, container, false).apply {
            viewmodel = ViewModelProviders.of(this@FilmListFragment).get(FilmViewModel::class.java)
            setLifecycleOwner(viewLifecycleOwner)
        }
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.viewmodel?.fetchRepoList()
        setupAdapter()

        setupObservers()

    }

    private fun setupAdapter() {
        val viewModel = viewDataBinding.viewmodel
        if (viewModel != null) {
            adapter = FilmListAdapter(viewModel)
            val layoutManager = LinearLayoutManager(activity)
            repo_list_rv.layoutManager = layoutManager
            val itemDecorator =
                DividerItemDecoration(requireActivity(), DividerItemDecoration.VERTICAL);
            itemDecorator.setDrawable(
                ContextCompat.getDrawable(
                    requireActivity(),
                    R.drawable.divider
                )!!
            );
            repo_list_rv.addItemDecoration(itemDecorator)
            repo_list_rv.adapter = adapter
        }
    }

    private fun setupObservers() {
        viewDataBinding.viewmodel?.repoListLive?.observe(viewLifecycleOwner, Observer {
            adapter.updateRepoList(it)
        })
        viewDataBinding.viewmodel?.count?.observe(viewLifecycleOwner, {
            totalCount.text = "Total ${it} movies"
        })
        viewDataBinding.viewmodel?.toastMessage?.observe(viewLifecycleOwner, Observer {
            activity?.longToast(it)
        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val title = resources.getString(R.string.app_name)

        activity?.toolbar_title?.text = title


    }
}