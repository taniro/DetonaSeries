package tads.eaj.ufrn.detonaseries.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow
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
    fun list(): Flow<List<Serie>>
    @Query("SELECT * FROM Serie WHERE id = :id")
    fun listById(id:Long):Serie?
}