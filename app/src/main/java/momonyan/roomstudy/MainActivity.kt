package momonyan.roomstudy

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import momonyan.roomstudy.database.AppDatabase
import momonyan.roomstudy.database.Users
import momonyan.roomstudy.recycler_view_content.RecyclerAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase

    private lateinit var data: List<Users>
    private var item = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database =
            Room.databaseBuilder(this, AppDatabase::class.java, "UsersData.db").build()

        data = database.usersDAO().findAll()

        mainRecyclerView.adapter = RecyclerAdapter(this, data)
        mainRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            //　アイテムが選択された時
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                item = spinnerParent.selectedItem as String

            }
            //　アイテムが選択されなかった
            override fun onNothingSelected(parent: AdapterView<*>?) {
                //
            }
        }

        button.setOnClickListener {
            if (item == "男") {
                data = database.usersDAO().findGender(false)
            } else if (item == "女") {
                data = database.usersDAO().findGender(true)
            } else {
                data = database.usersDAO().findAll()
            }
        }
    }
}
