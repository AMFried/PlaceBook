package com.raywenderlich.placebook.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.raywenderlich.placebook.model.Bookmark

@Database(entities = arrayOf(Bookmark::class), version = 1)
abstract class PlaceBookDatabase : RoomDatabase(){
    abstract fun bookmarkDao(): BookmarkDao
    companion object {
        private var instance: PlaceBookDatabase? = null
        fun getInstance(context: Context): PlaceBookDatabase {
            if(instance == null){
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    PlaceBookDatabase::class.java,
                    "PlaceBook").build()

            }
            return instance as PlaceBookDatabase
        }
    }
}