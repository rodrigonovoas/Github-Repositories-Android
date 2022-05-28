package app.rodrigonovoa.githubrepositores.model

data class RepositoryResponse(
    val id: Int,
    val updated_at: String,
    val name: String,
    val description: String,
    val language: String,
    val owner: OwnerResponse,
    val html_url: String
)