package app.rodrigonovoa.githubrepositores.repository

import app.rodrigonovoa.githubrepositores.model.RepositoryResponse
import app.rodrigonovoa.githubrepositores.model.UserListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {
    @GET("users/rodrigonovoas/repos")
    fun getRepositories() : Call<List<RepositoryResponse>>

    @GET("search/users")
    fun getUsersWithQuery(@Query("q") query: String, @Query("page") numPage: Int): Call<UserListResponse>
}