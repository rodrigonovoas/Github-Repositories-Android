package app.rodrigonovoa.githubrepositores.di

import app.rodrigonovoa.githubrepositores.view.ui.repositoriesList.RepositoriesListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {
    viewModel{ RepositoriesListViewModel(get()) }
}