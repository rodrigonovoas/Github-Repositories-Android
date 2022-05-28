package app.rodrigonovoa.githubrepositores.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.rodrigonovoa.githubrepositores.R
import app.rodrigonovoa.githubrepositores.model.UserResponse

class UsersListAdapter(private val list: List<UserResponse>):
    RecyclerView.Adapter<UsersListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvUsername: TextView

        init {
            tvUsername = view.findViewById(R.id.tv_username)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_users_list, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val repository = list[position]

        viewHolder.tvUsername.text = repository.login
    }

    override fun getItemCount() = list.size
}