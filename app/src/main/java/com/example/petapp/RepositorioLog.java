package com.example.petapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class RepositorioLog extends SQLiteOpenHelper {
    public RepositorioLog(@Nullable Context context) {
        super(context, "log", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table LOG" +
                "(id integer not null primary key," +
                "dataOperacao text," + " operacao text, " + "nome text)";
        sqLiteDatabase.execSQL(sql);
        Log.i("log", "Criado a tabelta log");

    }

    public void adcionarLog(LOG log){
        String sql = "insert into pet values(null,'" + log.nome + "','" + log.dataOperacao + "','" + log.operacao + ")";
        Log.i("log", "SQL insert log:" + sql);
        super.getWritableDatabase().execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
