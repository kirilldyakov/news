package ru.today.news.ui.main.viewpager.allarticles

import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import ru.today.news.R
import ru.today.news.ui.main.viewpager.ArticlesFragment
import ru.today.news.ui.main.viewpager.ArticlesView

class AllArticlesFragment(category: String?) : ArticlesFragment<IAllArticlesViewModel>(), ArticlesView {

    var category: String? = category

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.swipeRefreshLayout.setOnRefreshListener { viewModel.reloadData(category) }
        if (savedInstanceState == null) { binding.swipeRefreshLayout.isRefreshing = true }
        viewModel.reloadData(category)
    }


    // View

    override fun onRefresh(success: Boolean) {
        super.onRefresh(success)

        if (!success) {
            Snackbar.make(binding.recyclerView, getString(R.string.news_not_loaded), Snackbar.LENGTH_INDEFINITE)
                .setAction(R.string.snackbar_action_retry) { viewModel.reloadData(category) }
                .show()
        }
    }
}