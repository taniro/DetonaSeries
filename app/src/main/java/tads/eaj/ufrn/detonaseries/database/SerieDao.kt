package tads.eaj.ufrn.detonaseries.database

import androidx.room.*
import tads.eaj.ufrn.detonaseries.model.Serie

@Dao
interface SerieDao {
    @Insert
    fun create(s:Serie):Long
    @Delete
    fun remove(s:Serie)
    @Update
    fun update(s:Serie)
    @Query("SELECT * FROM Serie")
    fun list():List<Serie>
    @Query("SELECT * FROM Serie WHERE id = :id")
    fun listById(id:Long):Serie?
}