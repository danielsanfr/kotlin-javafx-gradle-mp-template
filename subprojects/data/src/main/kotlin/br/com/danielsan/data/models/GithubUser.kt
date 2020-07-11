package br.com.danielsan.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubUser(
    val id: Int,
    val name: String,
    val login: String,
    val bio: String?,
    val followers: Int,
    val following: Int,
    @SerialName("avatar_url")
    val avatarUrl: String,
    @SerialName("public_repos")
    val publicRepos: Int,
    @SerialName("public_gists")
    val publicGists: Int,
    @SerialName("twitter_username")
    val twitterUsername: String?
)
