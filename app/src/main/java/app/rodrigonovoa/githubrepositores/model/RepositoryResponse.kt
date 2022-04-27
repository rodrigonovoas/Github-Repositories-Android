package app.rodrigonovoa.githubrepositores.model

data class RepositoryResponse(
    val id: Int,
    val name: String,
    val description: String,
    val owner: OwnerResponse,
    val html_url: String
)