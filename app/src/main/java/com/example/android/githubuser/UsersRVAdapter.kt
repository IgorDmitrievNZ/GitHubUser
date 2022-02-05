package com.example.android.githubuser

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.githubuser.databinding.ItemUserBinding

class UsersRVAdapter(private val presenter: IUserListPresenter) :
    RecyclerView.Adapter<UsersRVAdapter.UsersViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UsersViewHolder {
        val binding =
            ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewHolder = UsersViewHolder(binding).apply {
            itemView.setOnClickListener {
                presenter.itemClickListener?.invoke(this)
            }
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        presenter.bindView(holder.apply { pos = position })
    }

    override fun getItemCount() = presenter.getCount()

    inner class UsersViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root), UserItemView {

        override var pos = -1

        override fun setUserLogin(text: String) {
            binding.tvLogin.text = text
        }
    }
}