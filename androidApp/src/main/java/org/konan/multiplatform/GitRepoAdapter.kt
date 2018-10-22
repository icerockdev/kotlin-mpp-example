package org.konan.multiplatform

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import shared.model.entity.GitHubRepo
import org.konan.multiplatform.databinding.ItemRepoBinding

class GitRepoAdapter: RecyclerView.Adapter<GitRepoAdapter.BindingViewHolder<ItemRepoBinding>>() {

    var exampleList: List<GitHubRepo>? = null

    init {
        setHasStableIds(true)
    }

    override fun getItemCount(): Int = exampleList?.size ?: 0

    override fun getItemId(position: Int): Long = exampleList?.getOrNull(position)?.id?.toLong() ?: super.getItemId(position)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BindingViewHolder<ItemRepoBinding>(parent, R.layout.item_repo)

    override fun onBindViewHolder(holder: BindingViewHolder<ItemRepoBinding>, position: Int) {
        holder.binding.item = exampleList?.get(position)
        holder.binding.executePendingBindings()
    }

    class BindingViewHolder<BindingModel: ViewDataBinding> private constructor(val binding: BindingModel):
            RecyclerView.ViewHolder(binding.root) {
        constructor(parent: ViewGroup, @LayoutRes layoutRes: Int):
                this(DataBindingUtil.inflate(LayoutInflater.from(parent.context), layoutRes, parent, false))
    }
}