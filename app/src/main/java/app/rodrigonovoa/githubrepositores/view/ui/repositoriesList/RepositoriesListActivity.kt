package app.rodrigonovoa.githubrepositores.view.ui.repositoriesList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import app.rodrigonovoa.githubrepositores.R
import app.rodrigonovoa.githubrepositores.repository.GithubService
import org.koin.android.ext.android.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoriesListActivity : AppCompatActivity() {
    private val viewModel: RepositoriesListViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github_repositories)
    }
}