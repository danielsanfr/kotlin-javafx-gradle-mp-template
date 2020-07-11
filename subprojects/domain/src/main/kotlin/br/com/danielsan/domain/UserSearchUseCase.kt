package br.com.danielsan.domain

import br.com.danielsan.domain.models.GithubUser
import br.com.danielsan.domain.repositories.GithubUserRepository

class UserSearchUseCase(private val githubUserRepository: GithubUserRepository) {
    suspend fun search(username: String): GithubUser = githubUserRepository.getUser(username)
}
