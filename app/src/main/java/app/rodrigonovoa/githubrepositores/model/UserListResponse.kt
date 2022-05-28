package app.rodrigonovoa.githubrepositores.model

data class UserListResponse(val total_count: Int, val incomplete_results: Boolean, val items: List<UserResponse>)