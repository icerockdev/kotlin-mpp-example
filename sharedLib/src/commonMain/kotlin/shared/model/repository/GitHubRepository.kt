package shared.model.repository

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import shared.coroutines.UI
import shared.model.network.GitHubApi

class GitHubRepository {
    private val mGitHubApi = GitHubApi()

    fun loadRepositories() {
        GlobalScope.launch(UI) {
            try {
                val list = mGitHubApi.getRepoList()
                println("success: $list")
            } catch (exc: Throwable) {
                println("failed: $exc")
            }
        }
    }
}
