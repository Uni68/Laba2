package com.example.laba2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.abs
import com.example.laba2.databinding.ActivityMainBinding
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener(){
            onCalculate()
        }
    }

    private fun showToast(message: String)
    {
        val toast = Toast.makeText(this@MainActivity, message, Toast.LENGTH_LONG)
        toast.show()
    }

    private fun onCalculate() {
        val numA: Double? = binding.editTextTextPersonName1.text.toString().toDoubleOrNull()
        val numB: Double? = binding.editTextTextPersonName2.text.toString().toDoubleOrNull()
        val numC: Double? = binding.editTextTextPersonName3.text.toString().toDoubleOrNull()

        if (numA == null || numB == null || numC == null) {
            showToast("Заполните все поля")
            return;
        }
        if (abs(numA) + abs(numB) + abs(numC) == 0.0) {
            showToast("Бесконечное множество корней")
            return
        }
        val x1: Double
        val x2: Double

        if (numA == 0.0 && numB != 0.0) {
            val x: Double = (-1 * numC) / numB
            showToast("A == 0. Линейное уравнение: $x")
            return
        } else if (numA == 0.0 && numB == 0.0 && numC != 0.0) {
            showToast("Корней нет")
            return
        }

        val discriminant: Double = Math.pow(numB, 2.0) - 4 * numA * numC;

        if (discriminant < 0) {
            showToast("D < 0. Корней нет");
        } else if (discriminant == 0.0) {
            x1 = -numB / (2 * numA)
            showToast("D = 0. Уравнение имеет один корень: x1 = $x1")
        } else {
            x1 = (-numB + sqrt(discriminant)) / (2 * numA)
            x2 = (-numB - sqrt(discriminant)) / (2 * numA)
            showToast("D > 0. Корни уравнения: x1 = $x1 .\n x2 = $x2")
        }
    }
}