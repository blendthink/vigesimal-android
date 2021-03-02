package dev.honwakalab.vigesimal.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.honwakalab.vigesimal.android.databinding.ActivityMainBinding
import dev.honwakalab.vigesimal.lib.shared.VigesimalConverter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        val decimal = VigesimalConverter.toDecimal("ja")
        binding.result.text = decimal.toPlainString()

        setContentView(binding.root)
    }
}