package shared

import shared.model.entity.GitHubRepo
import shared.model.repository.GitHubRepository

class MainViewModel(private val gitHubRepository: GitHubRepository,
                    private var listener: Listener) {

    init {
        loadList()
    }

    fun loadList() {
        gitHubRepository.loadRepositories {
            listener.showState(it)
        }
    }

    interface Listener {
        fun showState(state: State<List<GitHubRepo>>)
    }
}