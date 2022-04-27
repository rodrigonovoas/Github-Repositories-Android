package app.rodrigonovoa.githubrepositores.view.ui.repositoriesList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.rodrigonovoa.githubrepositores.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import timber.log.Timber

@InternalCoroutinesApi
class RepositoriesListActivity : AppCompatActivity() {
    private val viewModel: RepositoriesListViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github_repositories)

        repositoriesObserver()
    }

    init {
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getRepositoriesFromApi()
        }
    }

    private fun repositoriesObserver(){
        this.viewModel.repositoryList.observe(this) { repositories ->
            if(repositories!=null) Timber.i(repositories.toString())
        }
    }
}