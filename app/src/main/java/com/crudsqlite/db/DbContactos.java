package com.crudsqlite.db;

//realizaremos transacciones a la tabla

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.crudsqlite.entidades.Contactos;

import java.util.ArrayList;

public class DbContactos extends Dbhelper {
    Context context;
    long id = 0;
    public DbContactos(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertaContacto(String nombre, String telefono, String correo_electronico) {
        try {
            Dbhelper dbhelper = new Dbhelper(context);
            SQLiteDatabase db = dbhelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("telefono", telefono);
            values.put("correo_electronico", correo_electronico);

            id = db.insert(TABLE_CONTACTOS, null, values);
        } catch (Exception ex) {
            ex.toString();
        }
        return id;
    }
    public ArrayList<Contactos> mostrarContactos(){

        Dbhelper dbhelper = new Dbhelper(context);
        SQLiteDatabase db = dbhelper.getWritableDatabase();

        ArrayList<Contactos> listaContactos = new ArrayList<>();
        Contactos contacto = null;
        Cursor cursorContacto = null;

        cursorContacto = db.rawQuery("SELECT * FROM " + TABLE_CONTACTOS, null);

        if (cursorContacto.moveToFirst()){
            do{
                contacto = new Contactos();
                contacto.setId(cursorContacto.getInt(0));
                contacto.setNombre(cursorContacto.getString(1));
                contacto.setTelefono(cursorContacto.getString(2));
                contacto.setCorreo(cursorContacto.getString(3));
                listaContactos.add(contacto);
            } while(cursorContacto.moveToNext());
        }
        cursorContacto.close();
        return listaContactos;
    }
}