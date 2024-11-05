package com.mashaq.f55123003;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Deklarasi variabel untuk komponen UI
    private EditText edtWidth, edtHeight, edtLength;
    private Button btnCalculate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            edtWidth = findViewById(R.id.edt_lebar);
            edtHeight = findViewById(R.id.edt_tinggi);
            edtLength = findViewById(R.id.edt_panjang);
            btnCalculate = findViewById(R.id.btn_calculate);
            tvResult = findViewById(R.id.tv_result);
            btnCalculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_calculate) {
            String inputpanjang = edtLength.getText().toString().trim();
            String inputlebar = edtWidth.getText().toString().trim();
            String inputtinggi = edtHeight.getText().toString().trim();
            boolean isEmptyFields = false;
            if (TextUtils.isEmpty(inputpanjang)) {
                isEmptyFields = true;
                edtLength.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputlebar)) {
                isEmptyFields = true;
                edtWidth.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputtinggi)) {
                isEmptyFields = true;
                edtHeight.setError("Field ini tidak boleh kosong");
            }
            if (!isEmptyFields) {
                double volume = Double.parseDouble(inputpanjang) *
                        Double.parseDouble(inputlebar) * Double.parseDouble(inputtinggi);
                tvResult.setText(String.valueOf(volume));
            }
        }
    }
}