package tads.eaj.ufrn.detonaseries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import tads.eaj.ufrn.detonaseries.database.AppDatabase
import tads.eaj.ufrn.detonaseries.databinding.ActivityCadastraBinding
import tads.eaj.ufrn.detonaseries.repository.SerieRepository

class CadastraActivity : AppCompatActivity() {

    lateinit var database:AppDatabase
    lateinit var binding:ActivityCadastraBinding
    lateinit var viewModel:CadastraActivityViewModel
    lateinit var repository: SerieRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cadastra)
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "database-name")
            .build()
        repository = SerieRepository(database.seriedao())
        val viewModelFactory = CadastraActivityViewModel.Factory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(CadastraActivityViewModel::class.java)

        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
    }
}