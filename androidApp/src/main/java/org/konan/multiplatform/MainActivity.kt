package org.konan.multiplatform

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import shared.State
import shared.MainViewModel
import shared.model.repository.GitHubRepository
import org.konan.multiplatform.databinding.ActivityMainBinding
import shared.model.entity.GitHubRepo

class MainActivity: AppCompatActivity(), MainViewModel.Listener {
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mAdapter: GitRepoAdapter

    private lateinit var mViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mViewModel = MainViewModel(GitHubRepository(), this)
        mBinding.viewModel = mViewModel

        mAdapter = GitRepoAdapter()
        mBinding.itemList.adapter = mAdapter
    }

    override fun showState(state: State<List<GitHubRepo>>) {
        if (state.isSuccess()) {
            mAdapter.exampleList = state.dataValue()
        }
        mBinding.state = state
    }
}