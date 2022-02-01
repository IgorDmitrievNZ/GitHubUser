package com.example.android.githubuser

class UsersListPresenter : IUserListPresenter {

    val users = mutableListOf<GithubUser>()
    override var itemClickListener: ((UserItemView) -> Unit)? = null

    override fun bindView(view: UserItemView) {
        val user = users[view.pos]
        view.setUserLogin(user.login)
    }

    override fun getCount() = users.size
}