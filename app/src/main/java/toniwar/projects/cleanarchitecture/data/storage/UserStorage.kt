package toniwar.projects.cleanarchitecture.data.storage

import toniwar.projects.cleanarchitecture.domain.models.SaveUserName
import toniwar.projects.cleanarchitecture.domain.models.UserName

interface UserStorage {
    fun save(saveParam: SaveUserName): Boolean

    fun getName(): UserName
}