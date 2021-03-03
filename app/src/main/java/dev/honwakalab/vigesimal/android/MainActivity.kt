package dev.honwakalab.vigesimal.android

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import com.google.android.material.snackbar.Snackbar
import dev.honwakalab.vigesimal.android.databinding.ActivityMainBinding
import dev.honwakalab.vigesimal.lib.shared.VigesimalConverter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        binding.convertButton.setOnClickListener {

            // hide keyboard
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)

            val inputText = binding.input.text.toString()
            if (inputText.isBlank()) {
                binding.result.text = null
                return@setOnClickListener
            }

            try {
                val decimal = VigesimalConverter.toDecimal(inputText)
                binding.result.text = decimal.toPlainString()
            } catch (e: IllegalArgumentException) {
                Snackbar.make(
                        binding.root,
                        R.string.snackbar_text_failed_convert,
                        Snackbar.LENGTH_SHORT,
                ).show()
            }
        }

        setContentView(binding.root)
    }
}