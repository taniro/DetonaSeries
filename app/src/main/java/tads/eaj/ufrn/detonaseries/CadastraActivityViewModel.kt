package tads.eaj.ufrn.detonaseries

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import tads.eaj.ufrn.detonaseries.model.Serie

class CadastraActivityViewModel :ViewModel() {
    private var _serie = MutableLiveData<Serie>()
    var serie:LiveData<Serie> = _serie

    private var _cadastraSerieButtonState = MutableLiveData<Boolean>(false)
    var cadastraSerieButtonState:LiveData<Boolean> = _cadastraSerieButtonState

    init {
        _serie.value = Serie("", "", 2000, 3f)
    }

    fun handleCadastraSerieButton(){
        _cadastraSerieButtonState.value = true
    }

    fun handleCadastraSerieButtonFinished(){
        _cadastraSerieButtonState.value = false
    }
}