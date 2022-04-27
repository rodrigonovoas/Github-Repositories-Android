package app.rodrigonovoa.githubrepositores.repository

import app.rodrigonovoa.githubrepositores.model.RepositoryResponse
import retrofit2.Call
import retrofit2.http.GET

interface GithubService {
    @GET("users/rodrigonovoas/repos")
    fun getRepositories() : Call<List<RepositoryResponse>>
}