package app.rodrigonovoa.githubrepositores.view.ui.configDialog

import android.app.Dialog
import android.content.Context
import android.view.Window
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import app.rodrigonovoa.githubrepositores.R
import app.rodrigonovoa.githubrepositores.persistance.UserSingleton
import app.rodrigonovoa.githubrepositores.view.adapters.RepositoriesListAdapter
import app.rodrigonovoa.githubrepositores.view.ui.repositoriesList.RepositoriesListViewModel
import kotlinx.coroutines.InternalCoroutinesApi

class ConfigurationDialog(
    private val context: Context,
    private val viewModel: RepositoriesListViewModel
) {
    var dialog: Dialog = Dialog(context)

    init {
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.fragment_configuration)
    }

    @OptIn(InternalCoroutinesApi::class)
    fun showDialog() {
        val edtUser = dialog.findViewById(R.id.edt_new_user) as EditText
        val imvSearch = dialog.findViewById<ImageButton>(R.id.imv_username_search)
        val tvCurrentUser =  dialog.findViewById<TextView>(R.id.tv_current_user)

        tvCurrentUser.setText(UserSingleton.username)
        imvSearch.setOnClickListener { viewModel.getUsersFromApi(edtUser.text.toString()) }

        dialog.show()
    }

    fun closeDialog(){
        dialog.dismiss()
    }
}