package com.crudsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.crudsqlite.db.DbContactos;

public class NuevoActivity extends AppCompatActivity {

    EditText txtNombre, txtCorreo, txtNumero;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        txtNombre = findViewById(R.id.txtNombre);
        txtCorreo = findViewById(R.id.txtCorreo);
        txtNumero = findViewById(R.id.txtNumero);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbContactos dbContactos = new DbContactos(NuevoActivity.this);
                long id = dbContactos.insertaContacto(txtNombre.getText().toString(),
                        txtNumero.getText().toString(), txtCorreo.getText().toString());
                if(id > 0){
                    Toast.makeText(NuevoActivity.this, "CONTACTO GUARDADO",
                            Toast.LENGTH_LONG).show();
                    limpiar();
                }else{
                    Toast.makeText(NuevoActivity.this, "CONTACTO NO GUARDADO",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void limpiar(){
        txtNombre.setText("");
        txtNumero.setText("");
        txtCorreo.setText("");
    }
}