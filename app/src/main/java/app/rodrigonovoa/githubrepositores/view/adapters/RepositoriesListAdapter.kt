package app.rodrigonovoa.githubrepositores.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import app.rodrigonovoa.githubrepositores.R
import app.rodrigonovoa.githubrepositores.model.RepositoryResponse

class RepositoriesListAdapter(
    private val list: List<RepositoryResponse>,
    private val onClickListener: OnClickListener
) :
    RecyclerView.Adapter<RepositoriesListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardViewRepository: CardView
        val tvRepositoryName: TextView
        val tvRepositoryDescription: TextView
        val tvRepositoryLanguage: TextView
        val tvRepositoryUpdatedDate: TextView

        init {
            tvRepositoryName = view.findViewById(R.id.tv_repository_name)
            tvRepositoryDescription = view.findViewById(R.id.tv_repository_description)
            cardViewRepository = view.findViewById(R.id.cv_repository)
            tvRepositoryLanguage = view.findViewById(R.id.tv_repository_language)
            tvRepositoryUpdatedDate = view.findViewById(R.id.tv_repository_updated_date)
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
        viewHolder.tvRepositoryLanguage.text = repository.language
        viewHolder.tvRepositoryUpdatedDate.text = "Last Update: " + formatDateToYearMonthDay(repository.updated_at)

        viewHolder.cardViewRepository.setOnClickListener {
            onClickListener.onClick(getUserUrl(repository.owner.login), repository.html_url)
        }
    }

    class OnClickListener(val clickListener: (userUrl: String, repoUrl: String) -> Unit) {
        fun onClick(userUrl: String, repoUrl: String) = clickListener(userUrl, repoUrl)
    }

    private fun formatDateToYearMonthDay(date: String): String{
        return date.take(10)
    }

    private fun getUserUrl(login: String): String{
        return "https://github.com/"+login
    }

    override fun getItemCount() = list.size
}