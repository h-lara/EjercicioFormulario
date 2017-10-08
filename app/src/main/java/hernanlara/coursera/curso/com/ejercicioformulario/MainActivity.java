package hernanlara.coursera.curso.com.ejercicioformulario;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.PersistableBundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView  etNacimiento;
    public EditText etNombre,etTelefono,etEmail, etDescripcion;
    public int dia, mes, año;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNacimiento =(TextView) findViewById(R.id.etNacimiento);
        etNombre =(EditText) findViewById(R.id.etNombre);
        etTelefono =(EditText) findViewById(R.id.etTelefono);
        etEmail =(EditText) findViewById(R.id.etEmail);
        etDescripcion =(EditText) findViewById(R.id.etDescripcion);
        etNacimiento.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "START", Toast.LENGTH_LONG) .show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "reSTART", Toast.LENGTH_LONG) .show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "RESUME", Toast.LENGTH_LONG) .show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "PAUSEE", Toast.LENGTH_LONG) .show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "STOP", Toast.LENGTH_LONG) .show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "DESTROY", Toast.LENGTH_LONG) .show();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override


    public void onClick(View view) {
        if (view == etNacimiento) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MAY);
            año = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {

                            etNacimiento.setText(dayOfMonth + "/" + monthOfYear + "/" + year);
                        }
                    }
                    ,dia, mes, año);
            datePickerDialog.show();

        }}


    public void botonSiguiente(View view){
        String nombre = etNombre.getText().toString();
        String fechaNacimiento = etNacimiento.getText().toString();
        String telefono = etTelefono.getText().toString();
        String mail = etEmail.getText().toString();
        String descripcion = etDescripcion.getText().toString();

        Intent intent =new Intent(MainActivity.this, Detalle_contacto.class);
        intent.putExtra("NOMBRE", nombre);
        intent.putExtra("FECHA", fechaNacimiento);
        intent.putExtra("TELEFONO", telefono);
        intent.putExtra("EMAIL", mail);
        intent.putExtra("DESCRIPCION", descripcion);
        startActivity(intent);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("NOMBREr",etNombre.getText().toString() );
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        etNombre.setText("imposible");
    }
}

