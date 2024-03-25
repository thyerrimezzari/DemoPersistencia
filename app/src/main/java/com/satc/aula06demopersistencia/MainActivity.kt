package com.satc.aula06demopersistencia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.bt_shared).setOnClickListener(View.OnClickListener {
            val it = Intent(this, SharedPrefsActivity::class.java)
            startActivity(it)
        })


        findViewById<Button>(R.id.bt_sqlite).setOnClickListener {
            val it = Intent(this, SqliteActivity::class.java)
            startActivity(it)
        }
    }
}