package toniwar.projects.cleanarchitecture.presentation

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import toniwar.projects.cleanarchitecture.R
import toniwar.projects.cleanarchitecture.data.repository.UserRepositoryImplementation
import toniwar.projects.cleanarchitecture.data.storage.SharedPrefsUserStorage
import toniwar.projects.cleanarchitecture.domain.models.SaveUserName
import toniwar.projects.cleanarchitecture.domain.usecases.GetUserNameUseCase
import toniwar.projects.cleanarchitecture.domain.usecases.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {
    private val userStorage by  lazy { SharedPrefsUserStorage(applicationContext) }
    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {UserRepositoryImplementation(userStorage)}
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {GetUserNameUseCase(userRepository)}
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {SaveUserNameUseCase(userRepository)}

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditText = findViewById<EditText>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        sendButton.setOnClickListener {
            val text = dataEditText.text.toString()
            val value = SaveUserName(name = text)
            val result:Boolean = saveUserNameUseCase.execute(value = value)
            dataTextView.text = "Save result = $result"
        }
        receiveButton.setOnClickListener {
            val userName = getUserNameUseCase.execute()
            dataTextView.text ="${userName.firstName} ${userName.lastName}"
        }
    }
}