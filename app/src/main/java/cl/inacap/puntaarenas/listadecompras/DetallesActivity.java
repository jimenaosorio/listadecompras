package cl.inacap.puntaarenas.listadecompras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cl.inacap.puntaarenas.listadecompras.modelo.ListaDeCompras;
import cl.inacap.puntaarenas.listadecompras.modelo.Producto;

public class DetallesActivity extends AppCompatActivity {
    public Producto producto;
    public Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        //Obtener el producto
        intent=getIntent();
        int id=(Integer)intent.getExtras().get("idProducto");
        producto= ListaDeCompras.getInstancia().getProducto(id);

        //Mostrar la informacion del producto
        TextView txtNombre=(TextView)findViewById(R.id.txtNombre);
        txtNombre.setText(producto.getNombre());

        TextView txtUnidad=(TextView)findViewById(R.id.txtUnidad);
        txtUnidad.setText(producto.getCantidad()+" "+producto.getUnidad());
        TextView txtEstado=(TextView)findViewById(R.id.txtEstado);
        Button cambiar=(Button)findViewById(R.id.estado);
        if(producto.isEstado()){
            txtEstado.setText("Pendiente");
            cambiar.setText("Marcar como comprado");
        }
        else{
            txtEstado.setText("Comprado");
            cambiar.setText("Marcar como pendiente");
        }
    }

    public void cambiarEstado(View view){
        producto.setEstado(!producto.isEstado());
        setResult(RESULT_OK, intent);
        finish();

    }
}
