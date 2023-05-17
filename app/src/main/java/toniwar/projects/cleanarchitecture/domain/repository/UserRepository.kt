package toniwar.projects.cleanarchitecture.domain.repository

import toniwar.projects.cleanarchitecture.domain.models.SaveUserName
import toniwar.projects.cleanarchitecture.domain.models.UserName

interface UserRepository {
    fun saveName(saveParam: SaveUserName):Boolean

    fun getName(): UserName

}