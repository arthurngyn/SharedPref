package com.example.sharedprefrences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val btnSave = findViewById<Button>(R.id.save)
        val btnload = findViewById<Button>(R.id.load)
        val adult = findViewById<Switch>(R.id.adult)
        val edtName = findViewById<EditText>(R.id.name)
        val edtAge = findViewById<EditText>(R.id.age)
        val editor = sharedPref.edit()

        btnSave.setOnClickListener{
            val name = edtName.text.toString()
            val age = edtAge.text.toString().toInt()
            val isAdult = adult.isChecked

            editor.apply{
                putString("name", name)
                putInt("age", age)
                putBoolean("isAdult", isAdult)
                apply()
            }
        }
        btnload.setOnClickListener{
            val name = sharedPref.getString("name", null)
            val age = sharedPref.getInt("age", 0)
            val isAdult = sharedPref.getBoolean("isAdult", false)

            edtName.setText(name)
            edtAge.setText(age.toString())
            adult.isChecked = isAdult
        }
    }
}