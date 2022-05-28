package app.rodrigonovoa.githubrepositores.view.ui.configDialog

import android.app.Dialog
import android.content.Context
import android.view.Window
import app.rodrigonovoa.githubrepositores.R
import app.rodrigonovoa.githubrepositores.view.ui.repositoriesList.RepositoriesListViewModel
import kotlinx.coroutines.InternalCoroutinesApi

class ConfigurationDialog(private val context: Context, private val viewModel: RepositoriesListViewModel) {
    var dialog: Dialog = Dialog(context)

    init {
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.fragment_configuration)
    }

    @OptIn(InternalCoroutinesApi::class)
    fun showDialog() {
        // val yesBtn = dialog.findViewById(R.id.yesBtn) as Button
        dialog.show()
        viewModel.getUsersFromApi("Rodri")
    }
}