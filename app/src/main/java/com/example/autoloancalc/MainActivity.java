package com.example.autoloancalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;


public class MainActivity extends AppCompatActivity {

    private TextInputEditText txtSalesTax1;
    private TextInputEditText txtPrice1;
    private TextInputEditText txtDown1;
    private TextInputEditText txtTradeIn1;
    private TextInputEditText txtAPR1;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtSalesTax1 = findViewById(R.id.txtSalesTax1);
        txtPrice1 = findViewById(R.id.txtPrice1);
        txtDown1 = findViewById(R.id.txtDown1);
        txtTradeIn1 = findViewById(R.id.txtTradeIn1);
        txtAPR1 = findViewById(R.id.txtAPR1);
        radioGroup = findViewById(R.id.radioGroup);
    }
    public void goToLoanReport(View view){
        int termId = radioGroup.getCheckedRadioButtonId();
        RadioButton termButton = findViewById(termId);
        try{
            double price = Double.valueOf(txtPrice1.getText().toString());
            double downPayment = Double.valueOf(txtDown1.getText().toString());
            double tradeIn = Double.valueOf(txtTradeIn1.getText().toString());
            int length = Integer.parseInt(termButton.getText().toString());
            double APR = Double.valueOf(txtAPR1.getText().toString());
            double salesTax = Double.valueOf(txtSalesTax1.getText().toString());
            AutoLoan loan = new AutoLoan(price,downPayment,tradeIn,length,APR,salesTax);
        } catch (Exception e){
            Toast.makeText(this, "you messed something up", Toast.LENGTH_SHORT).show();
        }

        Intent intent = new Intent(this,LoanReportActivity.class);
        startActivity(intent);

    }
}