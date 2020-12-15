package com.gyalzay.datepickeractivity

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var btnDateJoined: Button
    private lateinit var btnDOB: Button
    private lateinit var tvDisplayDOB: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDateJoined = findViewById(R.id.btnDateJoined)
        btnDOB = findViewById(R.id.btnDOB)
        tvDisplayDOB = findViewById(R.id.tvDisplayDOB)

        btnDateJoined.setOnClickListener {
            dateJoined()
        }

        btnDOB.setOnClickListener {
            dateOfBirth()
        }
    }

    private fun dateJoined(){

    }

    private fun dateOfBirth(){
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val dates = SimpleDateFormat("MM/dd/yyyy")
        val currentDate = LocalDateTime.now()

        val datepickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener{ view, year, monthOfYear, dayOfMonth ->
                tvDisplayDOB.text = "Selected Date : $dayOfMonth/$monthOfYear/$year"
            },
            year,
            month,
            day
        )
        val date1: Date = dates.parse(currentDate)

        val yearWorked = (datepickerDialog - currentDate)
        yearWorked.show()
/*        datepickerDialog.show()*/
    }
}