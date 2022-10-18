package tads.eaj.ufrn.detonaseries


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel(){

    private var _cadastraButtonState = MutableLiveData<Boolean>(false)
    var cadastraButtonState:LiveData<Boolean> = _cadastraButtonState


    fun handleCadastraClick(){
        _cadastraButtonState.value = true
    }

    fun handleCadastraClickFinished(){
        _cadastraButtonState.value = false
    }
}