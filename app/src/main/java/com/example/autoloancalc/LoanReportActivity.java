package com.example.autoloancalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class LoanReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_report);

        TextView CarP = findViewById(R.id.CarP);
        TextView downP = findViewById(R.id.downP);
        TextView tradeP = findViewById(R.id.tradeP);
        TextView taxP = findViewById(R.id.taxP);
        TextView totLoan = findViewById(R.id.totLoan);
        TextView totInter = findViewById(R.id.totInter);
        TextView totLI = findViewById(R.id.totLI);
        TextView monthP = findViewById(R.id.monthP);

        getSupportActionBar().setTitle("Loan Report");

        Intent intent = getIntent();
        AutoLoan loan = intent.getParcelableExtra("loan");

        CarP.setText(String.format(Locale.US,"$%.2f",loan.getPrice()));
        downP.setText(String.format(Locale.US,"-$%.2f",loan.getDownPayment()));
        tradeP.setText(String.format(Locale.US,"-$%.2f",loan.getTradeInValue()));
        taxP.setText(String.format(Locale.US,"+$%.2f",loan.getSalesTax()));
        totLoan.setText(String.format(Locale.US,"$%.2f",loan.getTotalLoan()));
        totInter.setText(String.format(Locale.US,"+$%.2f",loan.getTotalInterest()));
        totLI.setText(String.format(Locale.US,"$%.2f",loan.getTotalAmount()));
        monthP.setText(String.format(Locale.US,"$%.2f",loan.getMonthlyPayment()));

    }
    public void goDataEntry(View view){
        finish();
    }
}