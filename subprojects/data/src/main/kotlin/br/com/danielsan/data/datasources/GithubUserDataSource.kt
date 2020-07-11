package br.com.danielsan.data.datasources

import br.com.danielsan.domain.models.GithubUser
import br.com.danielsan.data.models.GithubUser as UserResponse
import br.com.danielsan.domain.repositories.GithubUserRepository
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import kotlinx.serialization.json.Json

class GithubUserDataSource : GithubUserRepository {
    private val client = HttpClient() {
        install(JsonFeature) {
            serializer = KotlinxSerializer(Json { ignoreUnknownKeys = true })
        }
    }

    override suspend fun getUser(username: String): GithubUser {
        val userResponse: UserResponse = client.get("https://api.github.com/users/$username")
        return GithubUser(
            userResponse.id,
            userResponse.name,
            userResponse.login,
            userResponse.bio,
            userResponse.followers,
            userResponse.following,
            userResponse.avatarUrl,
            userResponse.publicRepos,
            userResponse.publicGists,
            userResponse.twitterUsername
        )
    }
}
