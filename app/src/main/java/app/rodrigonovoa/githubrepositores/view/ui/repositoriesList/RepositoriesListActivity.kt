package app.rodrigonovoa.githubrepositores.view.ui.repositoriesList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.rodrigonovoa.githubrepositores.R
import org.koin.android.ext.android.inject

class RepositoriesListActivity : AppCompatActivity() {
    private val viewModel: RepositoriesListViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github_repositories)
    }
}