package ru.today.news.ui.search.searchRecyclerView

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView
import ru.today.news.R
import ru.today.news.data.remote.responses.articles.ArticlesItem
import ru.today.news.di.scopes.PerFragment
import ru.today.news.ui.main.articlesRecyclerview.ArticleViewHolder
import ru.today.news.util.Utils
import javax.inject.Inject

@PerFragment
class SearchAdapter
@Inject
constructor()
    : RecyclerView.Adapter<ArticleViewHolder>(), FastScrollRecyclerView.SectionedAdapter {

    var articlesList = emptyList<ArticlesItem>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ArticleViewHolder {
        return Utils.createViewHolder(viewGroup, R.layout.card_article, ::ArticleViewHolder)
    }

    override fun onBindViewHolder(articlesViewHolder: ArticleViewHolder, position: Int) {
        articlesViewHolder.viewModel.update(articlesList[position], position == articlesList.size - 1)
        articlesViewHolder.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return articlesList.size
    }

    override fun getSectionName(position: Int): String {
        return articlesList[position].title!!.substring(0, 1)
    }
}