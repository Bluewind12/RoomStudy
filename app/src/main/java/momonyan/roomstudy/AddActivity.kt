package momonyan.roomstudy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.add_item_layout.*
import momonyan.roomstudy.database.AppDatabase
import momonyan.roomstudy.database.Users

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_item_layout)
        button2.setOnClickListener {
            val name = addNameEdit.text.toString()
            val age = addAgeEdit.text.toString().toInt()
            val gender = toggleButton2.isChecked
            val hobby = if (addHobbyEdit.text.toString() == "") {
                null
            } else {
                addHobbyEdit.text.toString()
            }
            val userData = Users(name = name, age = age, gender = gender, hobby = hobby)
            val database =
                Room.databaseBuilder(this, AppDatabase::class.java, "UsersData.db").build()

            Completable.fromAction { database.usersDAO().insertUsers(userData) }
                .subscribeOn(Schedulers.io())
                .subscribe()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}