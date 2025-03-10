package com.example.sexta;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sexta.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Evento del botón
        binding.btnConvertir.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String inputText = binding.txtDato.getText().toString();

                if (inputText.isEmpty()) {

                    Toast.makeText(MainActivity.this, "Ingrese un valor", Toast.LENGTH_SHORT).show();
                    return;

                }

                double inputValue = Double.parseDouble(inputText);
                double result;

                if (binding.radioTemp.isChecked()) {

                    result = (inputValue * 9 / 5) + 32;
                    binding.txtResultado.setText("Resultado: " + result + " °F");

                } else if (binding.radioMoneda.isChecked()) {

                    double exchangeRate = 18.0;
                    result = inputValue / exchangeRate;
                    binding.txtResultado.setText("Resultado: $" + String.format("%.2f", result) + " USD");

                } else {

                    Toast.makeText(MainActivity.this, "Seleccione una opción", Toast.LENGTH_SHORT).show();

                }
            }

        });

    }
}