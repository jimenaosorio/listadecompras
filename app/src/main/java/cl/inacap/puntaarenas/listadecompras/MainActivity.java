package cl.inacap.puntaarenas.listadecompras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import cl.inacap.puntaarenas.listadecompras.modelo.ListaDeCompras;
import cl.inacap.puntaarenas.listadecompras.modelo.Producto;

public class MainActivity extends AppCompatActivity {
    private ListaDeCompras lista=ListaDeCompras.getInstancia();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void verLista(View view){

        ArrayList<Producto> productos=lista.getListaDeCompras();
        if(productos.size()>0) {
            Intent intent=new Intent(this,ListaProductosActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this,"Lista vacia",Toast.LENGTH_SHORT).show();
        }
    }
    public void ingresarNuevo(View view){

            Intent intent = new Intent(this, NuevoProductoActivity.class);
            startActivity(intent);

    }

    public void eliminarComprados(View view){
        lista.eliminarComprados();
        Toast.makeText(this,"Se han eliminado los productos comprados",Toast.LENGTH_SHORT).show();
    }
}
