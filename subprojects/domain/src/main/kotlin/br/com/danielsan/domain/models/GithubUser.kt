package br.com.danielsan.domain.models

data class GithubUser(
    val id: Int,
    val name: String,
    val login: String,
    val bio: String?,
    val followers: Int,
    val following: Int,
    val avatarUrl: String,
    val publicRepos: Int,
    val publicGists: Int,
    val twitterUsername: String?
)
