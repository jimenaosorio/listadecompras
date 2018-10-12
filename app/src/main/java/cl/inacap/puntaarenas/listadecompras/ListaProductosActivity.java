package cl.inacap.puntaarenas.listadecompras;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import cl.inacap.puntaarenas.listadecompras.modelo.ComprasDatabaseHelper;
import cl.inacap.puntaarenas.listadecompras.modelo.Producto;

public class ListaProductosActivity extends ListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        cargarLista();
    }
    public void cargarLista()
    {
        final ListView lista=getListView();

        //Leer la lista de productos desde la base de datos
        ComprasDatabaseHelper helper=new ComprasDatabaseHelper(this);
        List<Producto> productosList=helper.listaProductos();

        ArrayAdapter<Producto> listaAdapter=
                new ArrayAdapter<Producto>(this,
                        android.R.layout.simple_list_item_1,
                        productosList);
        lista.setAdapter(listaAdapter);
        lista.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Object o=lista.getItemAtPosition(i);
                        String linea=o.toString();
                        //Obtener el nombre
                        String[] separar=linea.split(":");
                        //Llamar a DetallesActivity
                        Intent intent=new Intent(ListaProductosActivity.this,DetallesActivity.class);
                        intent.putExtra("nombreProducto",separar[0]);
                        startActivityForResult(intent,1);

                    }
                }
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {

                cargarLista();
            }
        }
    }

}
