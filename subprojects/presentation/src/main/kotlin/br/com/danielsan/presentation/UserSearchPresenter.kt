package br.com.danielsan.presentation

import br.com.danielsan.domain.UserSearchUseCase
import br.com.danielsan.presentation.models.User

class UserSearchPresenter(
    private val userSearchUseCase: UserSearchUseCase,
    private val userSearchView: UserSearchView
) {
    suspend fun onUserToSearch(username: String) {
        val githubUser = userSearchUseCase.search(username)
        userSearchView.showUser(User(githubUser.name, githubUser.bio ?: "Empty bio"))
    }
}
