package cl.inacap.puntaarenas.listadecompras;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import cl.inacap.puntaarenas.listadecompras.modelo.Producto;

public class ListaProductosActivity extends ListActivity {

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        cargarLista();
    }
    public void cargarLista()
    {
        lista=getListView();
        ArrayAdapter<Producto> listaAdapter=
                new ArrayAdapter<Producto>(this,
                        android.R.layout.simple_list_item_1,
                        Producto.productos);
        lista.setAdapter(listaAdapter);
    }

    @Override
    public void onListItemClick(ListView listView,
                                View view,
                                int posicion,
                                long id){
        Intent intent=new Intent(ListaProductosActivity.this,
                DetallesActivity.class);
        intent.putExtra("idProducto",(int)id);
        startActivityForResult(intent,1);
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
