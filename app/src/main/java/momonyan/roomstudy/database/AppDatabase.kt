package momonyan.roomstudy.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UsersDAO::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usersDAO(): UsersDAO
}