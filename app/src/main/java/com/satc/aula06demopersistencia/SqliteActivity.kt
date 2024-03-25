package com.satc.aula06demopersistencia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class SqliteActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var btSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite2)

        etName = findViewById(R.id.et_name)
        etEmail = findViewById(R.id.et_email)
        btSave = findViewById(R.id.bt_save)

        btSave.setOnClickListener(View.OnClickListener { save() })
    }

    private fun load(){}
    private fun save(){}
}