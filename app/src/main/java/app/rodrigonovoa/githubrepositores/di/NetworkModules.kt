package app.rodrigonovoa.githubrepositores.di

import app.rodrigonovoa.githubrepositores.repository.GithubService
import app.rodrigonovoa.githubrepositores.view.ui.repositoriesList.RepositoriesListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModules = module {
    single { provideService() }
}

private fun provideService(): GithubService {
    val BASE_URL = "https://api.github.com/"

    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    return retrofit.create(GithubService::class.java)
}