package app.rodrigonovoa.githubrepositores.repository

import app.rodrigonovoa.githubrepositores.model.RepositoryResponse
import app.rodrigonovoa.githubrepositores.model.UserListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {
    @GET("users/{user}/repos")
    fun getRepositories(@Path("user") user: String) : Call<List<RepositoryResponse>>

    @GET("search/users")
    fun getUsersWithQuery(@Query("q") query: String, @Query("page") numPage: Int): Call<UserListResponse>
}