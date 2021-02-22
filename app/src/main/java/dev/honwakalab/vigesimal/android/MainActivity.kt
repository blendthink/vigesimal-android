package dev.honwakalab.vigesimal.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dev.honwakalab.vigesimal.lib.shared.VigesimalConverter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val decimal = VigesimalConverter.toDecimal("ja")
        Log.d("blendthink", decimal.toPlainString())
    }
}