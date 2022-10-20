package tads.eaj.ufrn.detonaseries.repository

import kotlinx.coroutines.flow.Flow
import tads.eaj.ufrn.detonaseries.database.SerieDao
import tads.eaj.ufrn.detonaseries.model.Serie


class SerieRepository(private val serieDao: SerieDao) {

    fun insert(serie: Serie){
        serieDao.create(serie)
    }

    fun update(serie: Serie){
        serieDao.update(serie)
    }

    fun getSerieById(id:Long): Serie? {
        return serieDao.listById(id)
    }

    fun getAllSerie(): Flow<List<Serie>> {
        return serieDao.list()
    }
}