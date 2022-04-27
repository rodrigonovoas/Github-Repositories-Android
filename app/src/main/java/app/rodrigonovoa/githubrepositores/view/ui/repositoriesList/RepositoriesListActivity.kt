package app.rodrigonovoa.githubrepositores.view.ui.repositoriesList

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

    private fun repositoriesObserver(){
        this.viewModel.repositoryList.observe(this) { repositories ->
            if (repositories != null) {
                binding.rcRepositoriesList.layoutManager = LinearLayoutManager(this)
                binding.rcRepositoriesList.adapter = RepositoriesListAdapter(repositories)
            }
        }
    }
}