package toniwar.projects.cleanarchitecture.data.repository

import android.annotation.SuppressLint
import android.content.Context
import toniwar.projects.cleanarchitecture.data.storage.UserStorage
import toniwar.projects.cleanarchitecture.domain.models.SaveUserName
import toniwar.projects.cleanarchitecture.domain.models.UserName
import toniwar.projects.cleanarchitecture.domain.repository.UserRepository



class UserRepositoryImplementation(private val userStorage: UserStorage): UserRepository {

    @SuppressLint("CommitPrefEdits")
    override fun saveName(saveParam: SaveUserName):Boolean{
        return userStorage.save(saveParam)

    }

    override fun getName(): UserName{
        return userStorage.getName()

    }
}