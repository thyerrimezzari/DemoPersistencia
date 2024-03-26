package com.satc.aula06demopersistencia.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context: Context) : SQLiteOpenHelper(
    context,
    DATABASE_NAME,
    null,
    DATABASE_VERSION) {

    private val  SQL_CREATE_ENTRIES  = "CREATE TABLE IF NOT EXISTS usuarios (" +
            "id INTEGER  PRIMARY  KEY  autoincrement,"  + "name varchar(255) NOT NULL," +
            "email varchar(255) NOT NULL)"


    companion  object  {
        // nome e versão do banco
        const val DATABASE_NAME = "SatcDemo.db"
        const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        super.onDowngrade(db, oldVersion, newVersion)
    }
}