package toniwar.projects.cleanarchitecture.domain.usecases

import toniwar.projects.cleanarchitecture.domain.models.UserName
import toniwar.projects.cleanarchitecture.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName{

        return userRepository.getName()

    }
}