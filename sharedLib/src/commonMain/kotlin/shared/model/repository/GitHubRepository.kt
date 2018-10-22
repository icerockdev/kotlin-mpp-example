package shared.model.repository

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import shared.State
import shared.coroutines.UI
import shared.model.entity.GitHubRepo
import shared.model.network.GitHubApi

class GitHubRepository {
    private val mGitHubApi = GitHubApi()

    fun loadRepositories(receiver: (State<List<GitHubRepo>>) -> Unit) {
        receiver.invoke(State.Loading())
        GlobalScope.launch(UI) {
            try {
                val list = mGitHubApi.getRepoList()
                receiver.invoke(State.Data(list))
            } catch(exc: Throwable) {
                receiver.invoke(State.Error(exc))
            }
        }
    }
}
