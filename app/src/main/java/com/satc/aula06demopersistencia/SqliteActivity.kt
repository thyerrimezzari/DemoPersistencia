package com.satc.aula06demopersistencia

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.satc.aula06demopersistencia.adapter.User
import com.satc.aula06demopersistencia.adapter.UserAdapter
import com.satc.aula06demopersistencia.database.DbHelper
import java.util.ArrayList

class SqliteActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var btSave: Button
    private lateinit var dbHelper: DbHelper
    var userList = ArrayList<User>()
    private lateinit var userAdaper : UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite2)

        dbHelper = DbHelper(this)

        etName = findViewById(R.id.et_name)
        etEmail = findViewById(R.id.et_email)
        btSave = findViewById(R.id.bt_save)

        btSave.setOnClickListener(View.OnClickListener { save() })

        val recyclerView: RecyclerView = findViewById(R.id.rv_users)

        userAdaper = UserAdapter(userList)

        recyclerView.adapter = userAdaper
        recyclerView.layoutManager = LinearLayoutManager(this)

        load()
    }

    private fun load(){
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery(
            "SELECT id, name, email FROM usuarios", null
        )

        if (cursor.moveToFirst()) {
            val name = cursor.getString(with(cursor) { getColumnIndex("name") });
            val email = cursor.getString(with(cursor) { getColumnIndex("email") });

            var user = User()
            user.name = name
            user.email = email

            userList.add(user)
            userAdaper.notifyDataSetChanged()
        }
        cursor.close()


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

        // Para recarregar a lista podemos simplesmente chamar load()
        // ou...

        var user = User()
        user.name = etName.text.toString()
        user.email = etEmail.text.toString()

        userList.add(user)
        userAdaper.notifyItemChanged(userList.size - 1)
    }
}