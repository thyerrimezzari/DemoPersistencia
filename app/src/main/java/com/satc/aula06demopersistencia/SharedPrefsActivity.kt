package com.satc.aula06demopersistencia

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SharedPrefsActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var btSave: Button
    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_prefs)

        prefs = getSharedPreferences(
            "com.satc.demopreferences.PERFIL",
            Context.MODE_PRIVATE) ?: return

        etName = findViewById(R.id.et_name)
        etEmail = findViewById(R.id.et_email)
        btSave = findViewById(R.id.bt_save)

        btSave.setOnClickListener(View.OnClickListener {
            save()
        })

        load()
    }

    private fun load(){
        etName.setText(prefs.getString("NOME","Nao encontrei o nome"))

        val email = prefs.getString("EMAIL","")
        etEmail.setText(email)
    }

    private fun save(){
        with (prefs.edit()) {
            putString("NOME", etName.text.toString())
            putString("EMAIL", etEmail.text.toString())
            commit()
        }

        Toast
            .makeText(this,
                "Dados salvos nas prefs",
                Toast.LENGTH_SHORT).show()
    }
}