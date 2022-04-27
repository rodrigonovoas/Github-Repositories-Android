package app.rodrigonovoa.githubrepositores.view.ui.repositoriesList

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.rodrigonovoa.githubrepositores.model.GithubRepository
import app.rodrigonovoa.githubrepositores.model.RepositoryResponse
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RepositoriesListViewModel(private val repository: GithubRepository): ViewModel() {
    private val _repositoryList = MutableLiveData<List<RepositoryResponse>?>().apply { postValue(null)}
    val repositoryList: LiveData<List<RepositoryResponse>?> get() = _repositoryList

    @InternalCoroutinesApi
    fun getRepositoriesFromApi(){
        viewModelScope.launch {
            repository.getRepositoriesFromApi()
                .catch {
                    // error handling
                }
                .collect {
                    _repositoryList.postValue(it.body())
                }
        }
    }
}