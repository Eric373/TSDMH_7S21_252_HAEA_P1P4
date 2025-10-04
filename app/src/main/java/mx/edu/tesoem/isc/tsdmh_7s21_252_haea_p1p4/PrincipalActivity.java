package mx.edu.tesoem.isc.tsdmh_7s21_252_haea_p1p4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PrincipalActivity extends AppCompatActivity {

    TextView txtnombre, txtedad;

    TextView txtnumero, txtcorreo, lblnombre, lbledad;
    Button btnsigue;

    ActivityResultLauncher<Intent> ActividadResultado = registerForActivityResult(
        new ActivityResultContracts.StartActivityForResult(), result -> {
        if (result.getResultCode() == RESULT_OK && result.getData() != null) {
            String nombre = result.getData().getStringExtra("nombre");
            String edad = result.getData().getStringExtra("edad");
            String numero = result.getData().getStringExtra("numero");
            String correo = result.getData().getStringExtra("correo");

            lblnombre.setText("Nombre: " + nombre);
            lbledad.setText("Edad: " + edad);
            txtnumero.setText("Número: " + numero);
            txtcorreo.setText("Correo: " + correo);
        }
    });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtnombre = findViewById(R.id.txtnombre);
        txtedad = findViewById(R.id.txtedad);
        btnsigue = findViewById(R.id.btnsigue);
        txtnumero = findViewById(R.id.txtnumero);
        txtcorreo = findViewById(R.id.txtcorreo);
        lblnombre = findViewById(R.id.lblnombre);
        lbledad = findViewById(R.id.lbledad);

        btnsigue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrincipalActivity.this, SegundaActivity.class);
                intent.putExtra("nombre", txtnombre.getText().toString());
                intent.putExtra("edad", txtedad.getText().toString());
                ActividadResultado.launch(intent);

            }
        });

    }
}