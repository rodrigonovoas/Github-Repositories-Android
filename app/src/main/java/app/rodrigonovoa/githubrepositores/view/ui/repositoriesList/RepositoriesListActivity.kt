package app.rodrigonovoa.githubrepositores.view.ui.repositoriesList

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.rodrigonovoa.githubrepositores.R
import app.rodrigonovoa.githubrepositores.databinding.ActivityGithubRepositoriesBinding
import app.rodrigonovoa.githubrepositores.view.adapters.RepositoriesListAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import timber.log.Timber

@InternalCoroutinesApi
class RepositoriesListActivity : AppCompatActivity() {
    private val viewModel: RepositoriesListViewModel by inject()
    private lateinit var binding: ActivityGithubRepositoriesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGithubRepositoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        repositoriesObserver()
    }

    init {
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getRepositoriesFromApi()
        }
    }

    private fun repositoriesObserver() {
        this.viewModel.repositoryList.observe(this) { repositories ->
            if (repositories != null) {
                binding.rcRepositoriesList.layoutManager = LinearLayoutManager(this)
                binding.rcRepositoriesList.adapter =
                    RepositoriesListAdapter(
                        repositories,
                        RepositoriesListAdapter.OnClickListener { userUrl, repoUrl ->
                            createRepositoryUrlDialog(
                                this@RepositoriesListActivity,
                                userUrl,
                                repoUrl
                            ).show()
                        })
            }
        }
    }

    private fun createRepositoryUrlDialog(context: Context, userUrl: String, repoUrl: String): AlertDialog{
        val builder = AlertDialog.Builder(context)
        builder.setMessage(R.string.browser_dialog_title)
            .setPositiveButton(R.string.browser_dialog_user_url,
                DialogInterface.OnClickListener { dialog, id ->
                    openWebBrowser(context, userUrl)
                })
            .setNeutralButton(R.string.browser_dialog_repository_url,
                DialogInterface.OnClickListener { dialog, id ->
                    openWebBrowser(context, repoUrl)
                })

        return builder.create()
    }

    private fun openWebBrowser(context: Context, url: String){
        val openURL = Intent(Intent.ACTION_VIEW)
        openURL.data = Uri.parse(url)
        context.startActivity(openURL)
    }
}