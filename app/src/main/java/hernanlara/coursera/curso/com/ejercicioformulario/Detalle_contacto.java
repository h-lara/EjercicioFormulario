package hernanlara.coursera.curso.com.ejercicioformulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Detalle_contacto extends AppCompatActivity {
    TextView tvNombre;
    TextView tvNacimiento;
    TextView tvTelefono;
    TextView tvEmail;
    TextView tvDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        tvNombre = (TextView)findViewById(R.id.tvNombre);
        tvNacimiento =(TextView)findViewById(R.id.tvNacimiento);
        tvTelefono =(TextView)findViewById(R.id.tvTelefono);
        tvEmail =(TextView)findViewById(R.id.tvEmail);
        tvDescripcion = (TextView)findViewById(R.id.tvDescripcion);

        Bundle datos = getIntent().getExtras();
        String nombre = datos.getString("NOMBRE");
        String nacimiento =datos.getString("FECHA");
        String telefono =datos.getString("TELEFONO");
        String email= datos.getString("EMAIL");
        String descripcion = datos.getString("DESCRIPCIÓN");



        tvNombre.setText(nombre);
        tvNacimiento.setText(nacimiento);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);}


        public void botonEditar (View view){

            Intent intent =new Intent (Detalle_contacto.this, MainActivity.class);
            startActivity(intent);

        ;


        }
}



