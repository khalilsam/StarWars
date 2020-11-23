package io.thinkit.starwarsapp.view.ui.filmdetails

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import io.thinkit.starwarsapp.R
import io.thinkit.starwarsapp.databinding.FragmentFilmDetailBinding
import io.thinkit.starwarsapp.viewmodel.FilmViewModel
import kotlinx.android.synthetic.main.activity_main.*


class FilmDetailFragment : Fragment() {
    private lateinit var viewModel: FilmViewModel
    private lateinit var binding: FragmentFilmDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (requireActivity() as AppCompatActivity).run {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_chevron)
        }


        viewModel = ViewModelProviders.of(requireActivity()).get(FilmViewModel::class.java)
        binding = FragmentFilmDetailBinding.inflate(
            inflater, container, false
        )
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val url = arguments?.let { FilmDetailFragmentArgs.fromBundle(it).url }

        binding.viewModel?.getFilmByid(url ?: "")

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val title = arguments?.let { FilmDetailFragmentArgs.fromBundle(it).title }
        activity?.toolbar_title?.text = title
        activity?.toolbar_title?.gravity = Gravity.CENTER

    }

    override fun onResume() {
        super.onResume()
        (requireActivity() as AppCompatActivity).run {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_chevron)
        }
    }
}