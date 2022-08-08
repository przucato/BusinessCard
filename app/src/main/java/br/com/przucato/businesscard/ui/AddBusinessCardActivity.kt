package br.com.przucato.businesscard.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import br.com.przucato.businesscard.App
import br.com.przucato.businesscard.R
import br.com.przucato.businesscard.data.BusinessCard
import br.com.przucato.businesscard.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    private val binding by lazy {
        ActivityAddBusinessCardBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners() {
        binding.closeButton.setOnClickListener {
            finish()
        }

        binding.confirmAddCardButton.setOnClickListener {
            val businessCard = BusinessCard(
                name = binding.textInputName.editText?.text.toString(),
                phone = binding.textInputPhone.editText?.text.toString(),
                email = binding.textInputEmail.editText?.text.toString(),
                company = binding.textInputCompany.editText?.text.toString(),
                backgroundColor = binding.textInputColor.editText?.text.toString()
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.toast_show_success, Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}