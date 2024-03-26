package com.satc.aula06demopersistencia

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.satc.aula06demopersistencia.database.DbHelper

class SqliteActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var btSave: Button
    private lateinit var dbHelper: DbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite2)

        dbHelper = DbHelper(this)

        etName = findViewById(R.id.et_name)
        etEmail = findViewById(R.id.et_email)
        btSave = findViewById(R.id.bt_save)

        btSave.setOnClickListener(View.OnClickListener { save() })
    }

    private fun load(){
        val db = dbHelper.readableDatabase
    }

    private fun save(){
        val db = dbHelper.writableDatabase
        var userData = ContentValues().apply {
            put("name", etName.text.toString())
            put("email", etEmail.text.toString())
        }

        // inserindo a nova linha no banco, na tabela "usuarios" (primeiro argumento)
        // o retorno da execução de sucesso da função "insert" é o novo ID (chave-primária)
        // que este novo usuário salvo no banco acaba de receber

        val newRowId = db?.insert("usuarios", null, userData)

        Toast.makeText(this, "Dados salvos com SQLITE", Toast.LENGTH_SHORT).show()

    }
}