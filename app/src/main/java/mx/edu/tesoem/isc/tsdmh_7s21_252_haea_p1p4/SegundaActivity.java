package mx.edu.tesoem.isc.tsdmh_7s21_252_haea_p1p4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SegundaActivity extends AppCompatActivity {

    EditText txtnumero, txtcorreo;
    Button btndatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segunda);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtnumero = findViewById(R.id.txtnumero);
        txtcorreo = findViewById(R.id.txtcorreo);
        btndatos = findViewById(R.id.btndatos);

        Bundle datos = getIntent().getExtras();
        String nombre = datos.getString("nombre");
        String edad = datos.getString("edad");

        btndatos.setOnClickListener(v -> {

            Intent intent = new Intent();
            intent.putExtra("nombre", nombre);
            intent.putExtra("edad", edad);
            intent.putExtra("numero", txtnumero.getText().toString());
            intent.putExtra("correo", txtcorreo.getText().toString());

            setResult(RESULT_OK, intent);
            finish();
        });

        }


    }
