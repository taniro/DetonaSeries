package tads.eaj.ufrn.detonaseries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import tads.eaj.ufrn.detonaseries.database.AppDatabase
import tads.eaj.ufrn.detonaseries.databinding.ActivityCadastraBinding

class CadastraActivity : AppCompatActivity() {

    lateinit var database:AppDatabase
    lateinit var binding:ActivityCadastraBinding
    lateinit var viewModel:CadastraActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cadastra)
        viewModel = ViewModelProvider(this).get(CadastraActivityViewModel::class.java)

        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        database = Room.databaseBuilder(
                        applicationContext,
                        AppDatabase::class.java,
                    "database-name")
                        .allowMainThreadQueries()
                        .build()
        database.seriedao()


        Log.i("AULA", database.seriedao().list().toString())

        viewModel.cadastraSerieButtonState.observe(this){
            value ->
            if (value){
                viewModel.serie.value?.let { serie->
                    database.seriedao().create(serie)
                }
                viewModel.handleCadastraSerieButtonFinished()
            }
        }
    }
}