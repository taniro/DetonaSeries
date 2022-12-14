package tads.eaj.ufrn.detonaseries

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import tads.eaj.ufrn.detonaseries.databinding.ActivityMainBinding
import java.io.IOException
import java.net.URL

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        viewModel.cadastraButtonState.observe(this){
            if (it){
                val intent = Intent(this, CadastraActivity::class.java)
                startActivity(intent)
                viewModel.handleCadastraClickFinished()
            }
        }
    }
}