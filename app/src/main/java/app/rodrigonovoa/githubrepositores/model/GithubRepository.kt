package app.rodrigonovoa.githubrepositores.model

import app.rodrigonovoa.githubrepositores.repository.GithubService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class GithubRepository(private val service: GithubService) {
    suspend fun getRepositoriesFromApi(user: String): Flow<Response<List<RepositoryResponse>>> = flow {
        val repositories = service.getRepositories(user).execute()

        emit(repositories)
    }.flowOn(Dispatchers.IO)

    suspend fun getUsersFromApi(query: String): Flow<Response<UserListResponse>> = flow {
        val users = service.getUsersWithQuery(query, 1).execute()
        emit(users)
    }.flowOn(Dispatchers.IO)
}