package tads.eaj.ufrn.detonaseries.database

import androidx.room.Database
import androidx.room.RoomDatabase
import tads.eaj.ufrn.detonaseries.model.Serie


@Database(entities = [Serie::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun seriedao():SerieDao
}