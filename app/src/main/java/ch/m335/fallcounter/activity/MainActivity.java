package ch.m335.fallcounter.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

import ch.m335.fallcounter.R;
import ch.m335.fallcounter.services.DataHandler;

public class MainActivity extends AppCompatActivity {
    EditText editTextDate1;
    EditText editTextDate2;
    Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataHandler dataHandler = new DataHandler(getSharedPreferences("FallCounter", Context.MODE_PRIVATE));

        editTextDate1 = findViewById(R.id.startDate);
        editTextDate2 = findViewById(R.id.endDate);

        editTextDate1.setOnClickListener(v -> showDatePickerDialog(editTextDate1));
        editTextDate2.setOnClickListener(v -> showDatePickerDialog(editTextDate2));
    }

    private void showDatePickerDialog(EditText editTextDate) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        editTextDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );

        datePickerDialog.show();
    }


}