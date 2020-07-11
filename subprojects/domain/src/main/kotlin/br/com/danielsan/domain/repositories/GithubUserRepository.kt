package br.com.danielsan.domain.repositories

import br.com.danielsan.domain.models.GithubUser

interface GithubUserRepository {
    suspend fun getUser(username: String): GithubUser
}
