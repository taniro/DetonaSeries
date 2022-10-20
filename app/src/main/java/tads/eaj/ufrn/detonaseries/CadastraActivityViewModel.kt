package tads.eaj.ufrn.detonaseries

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import tads.eaj.ufrn.detonaseries.model.Serie
import tads.eaj.ufrn.detonaseries.repository.SerieRepository

class CadastraActivityViewModel(val repository: SerieRepository) : ViewModel() {
    private var _serie = MutableLiveData<Serie>()
    var serie: LiveData<Serie> = _serie

    init {
        _serie.value = Serie("", "", 2000, 3f)
    }

    fun handleCadastraSerieButton(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                serie.value?.let { repository.insert(it) }
            }
        }
    }


    class Factory(val repository: SerieRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CadastraActivityViewModel::class.java)){
                return CadastraActivityViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}