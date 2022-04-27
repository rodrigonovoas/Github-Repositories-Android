package app.rodrigonovoa.githubrepositores.view.adapters

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import app.rodrigonovoa.githubrepositores.R
import app.rodrigonovoa.githubrepositores.model.RepositoryResponse
import timber.log.Timber

class RepositoriesListAdapter(private val list: List<RepositoryResponse>, private val onClickListener: OnClickListener):
    RecyclerView.Adapter<RepositoriesListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardViewRepository: CardView
        val tvRepositoryName: TextView
        val tvRepositoryDescription: TextView

        init {
            tvRepositoryName = view.findViewById(R.id.tv_repository_name)
            tvRepositoryDescription = view.findViewById(R.id.tv_repository_description)
            cardViewRepository = view.findViewById(R.id.cv_repository)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_repositories_list, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val repository = list[position]

        viewHolder.tvRepositoryName.text = repository.name
        viewHolder.tvRepositoryDescription.text = repository.description

        viewHolder.cardViewRepository.setOnClickListener {
            onClickListener.onClick(getUserUrl(repository.owner.login), repository.html_url)
            // return@setOnLongClickListener true
        }
    }

    class OnClickListener(val clickListener: (userUrl: String, repoUrl: String) -> Unit) {
        fun onClick(userUrl: String, repoUrl: String) = clickListener(userUrl, repoUrl)
    }

    private fun getUserUrl(login: String): String{
        return "https://github.com/"+login
    }

    override fun getItemCount() = list.size
}