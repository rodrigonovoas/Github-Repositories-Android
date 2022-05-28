package app.rodrigonovoa.githubrepositores.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.rodrigonovoa.githubrepositores.R
import app.rodrigonovoa.githubrepositores.model.UserResponse
import com.bumptech.glide.Glide

class UsersListAdapter(
    private val list: List<UserResponse>,
    private val onClickListener: UsersListAdapter.OnClickListener
) :
    RecyclerView.Adapter<UsersListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvUsername: TextView
        val imvUser: ImageView
        val llParent: LinearLayout

        init {
            tvUsername = view.findViewById(R.id.tv_username)
            imvUser = view.findViewById(R.id.imv_user)
            llParent = view.findViewById(R.id.ll_users_list_parent)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_users_list, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val user = list[position]

        viewHolder.tvUsername.text = user.login

        viewHolder.llParent.setOnClickListener { onClickListener.onClick(user.login) }

        if(user.avatar_url.isNotEmpty()){
            loadUserImageIntoImageview(viewHolder.imvUser.context, user.avatar_url, viewHolder.imvUser)
        }
    }

    private fun loadUserImageIntoImageview(context: Context, url: String, imv: ImageView){
        Glide.with(context).load(url).into(imv)
    }

    class OnClickListener(val clickListener: (login: String) -> Unit) {
        fun onClick(login: String) = clickListener(login)
    }

    override fun getItemCount() = list.size
}