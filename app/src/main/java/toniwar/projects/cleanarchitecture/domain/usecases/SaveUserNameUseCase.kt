package toniwar.projects.cleanarchitecture.domain.usecases

import toniwar.projects.cleanarchitecture.domain.models.SaveUserName
import toniwar.projects.cleanarchitecture.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(value: SaveUserName) : Boolean{
        val oldUserName = userRepository.getName()
        if(oldUserName.firstName == value.name){
            return true
        }
        return userRepository.saveName(value)

    }
}