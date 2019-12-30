/*package com.example.ashik.studentbudgetmanagement;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import static android.R.attr.button;
import static android.os.Build.VERSION_CODES.M;

public class DateDialog extends AppCompatActivity implements View.OnClickListener{


    private Button button1;
    private DatePickerDialog datePickerDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawar);
        button1.setOnClickListener(this);

}

    @Override
    public void onClick(View v) {

        DatePicker datePicker = new DatePicker(this);
        final int currentDay = datePicker.getDayOfMonth();
        final int currentMonth = (datePicker.getMonth())+1;
        final int currentYear = datePicker.getYear();


        datePickerDialog =  new DatePickerDialog(this,

                new DatePickerDialog.OnDateSetListener(){


                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        Toast.makeText(DateDialog.this,currentYear + "/" + currentMonth + "/" + currentDay,Toast.LENGTH_LONG).show();

                    }
                },currentYear,currentMonth,currentDay);

        datePickerDialog.show();

    }
}*/
