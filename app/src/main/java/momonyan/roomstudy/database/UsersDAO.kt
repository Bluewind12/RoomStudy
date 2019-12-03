package momonyan.roomstudy.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UsersDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(users: Users)

    @Query("SELECT * FROM Users")
    fun findAll(): List<Users>

    //f:Man t:Woman
    @Query("SELECT * FROM Users WHERE gender == :gender")
    fun findGender(gender: Boolean): List<Users>

}