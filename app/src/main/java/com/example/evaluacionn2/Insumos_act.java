package com.example.evaluacionn2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Clases.AdminSQLiteOpenHelper;

public class Insumos_act extends AppCompatActivity {

    private EditText edcodigo, ednombre, edprecio, edstock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos_act);

        edcodigo = (EditText)findViewById(R.id.et_codigo);
        ednombre = (EditText)findViewById(R.id.et_nombre);
        edprecio = (EditText)findViewById(R.id.et_precio);
        edstock = (EditText)findViewById(R.id.et_stock);
    }

    public void AñadirInsumos(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase db =admin.getWritableDatabase();

        if(!edcodigo.getText().toString().isEmpty())
        {
            ContentValues cont = new ContentValues();

            cont.put("codigo", edcodigo.getText().toString());
            cont.put("nombre", ednombre.getText().toString());
            cont.put("precio", edprecio.getText().toString());
            cont.put("stock", edstock.getText().toString());

            db.insert("insumos", null, cont);
            db.close();

            Toast.makeText(this, "Has guardado un insumo", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Debe ingresar el codigo del insumo", Toast.LENGTH_SHORT).show();
        }

    }
    public void MostrarInsumos(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase db =admin.getWritableDatabase();

        String codigo = edcodigo.getText().toString();

        if(!codigo.isEmpty())
        {
            Cursor fila = db.rawQuery("SELECT nombre, precio, stock FROM insumos WHERE codigo="+codigo, null);

            if(fila.moveToFirst())
            {
                ednombre.setText(fila.getString(0));
                edprecio.setText(fila.getString(1));
                edstock.setText(fila.getString(2));
            }
            else
            {
                Toast.makeText(this, "No hay campos en la tabla insumos", Toast.LENGTH_SHORT).show();
            }

        }else
        {
            Toast.makeText(this, "No hay insumos con el codigo asociado", Toast.LENGTH_SHORT).show();
        }

    }
    public void EliminarInsumos(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase db =admin.getWritableDatabase();

        String codigo = edcodigo.getText().toString();

        db.delete("insumos", "codigo="+codigo, null);
        db.close();

        Toast.makeText(this, "Has eliminado un insumo", Toast.LENGTH_SHORT).show();
    }
    public void ActualizarInsumos(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase db =admin.getWritableDatabase();

        String codigo = edcodigo.getText().toString();

        ContentValues cont = new ContentValues();

        cont.put("codigo", edcodigo.getText().toString());
        cont.put("nombre", ednombre.getText().toString());
        cont.put("precio", edprecio.getText().toString());
        cont.put("stock", edstock.getText().toString());

        if(!codigo.isEmpty())
        {
            db.update("insumos", cont, "codigo="+codigo, null);
            db.close();

            Toast.makeText(this, "Ha actualizado  un insumo", Toast.LENGTH_SHORT).show();
        }

    }
}