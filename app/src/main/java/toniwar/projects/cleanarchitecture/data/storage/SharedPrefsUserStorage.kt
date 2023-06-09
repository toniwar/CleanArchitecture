package toniwar.projects.cleanarchitecture.data.storage

import android.content.Context
import toniwar.projects.cleanarchitecture.domain.models.SaveUserName
import toniwar.projects.cleanarchitecture.domain.models.UserName

private const val SHARED_PREFS_NAME = "User name"
private const val FIRST_NAME_KEY = "First name key"
private const val LAST_NAME_KEY = "Last name key"

class SharedPrefsUserStorage(context: Context): UserStorage {
    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
    override fun save(saveParam: SaveUserName): Boolean {
        sharedPreferences.edit().putString(FIRST_NAME_KEY, saveParam.name).apply()
        return saveParam.name.isNotEmpty()
    }

    override fun getName(): UserName {
        val firstName = sharedPreferences.getString(FIRST_NAME_KEY, "")?:""
        val lastName = sharedPreferences.getString(LAST_NAME_KEY, "")?:""
        return UserName(firstName, lastName)

    }
}