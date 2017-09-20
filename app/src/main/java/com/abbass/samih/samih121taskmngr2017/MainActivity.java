package com.abbass.samih.samih121taskmngr2017;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

//                                                  4.
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //1. design by xml file
    //.2
    private Button btnDate;
    private TextView tvShowDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //3.
        btnDate= (Button) findViewById(R.id.btnDate);
        tvShowDate= (TextView) findViewById(R.id.tvShowDate);

        //5. mostly forgotten
        //register the listener to the button
        btnDate.setOnClickListener(this);//this because the current (this) class implements this listener


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.itmPage2:
                Intent i=new Intent(getBaseContext(),Page2Activity.class);
                startActivity(i);
                break;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        //6.
        if(view==btnDate)
        {
            //To get current Date
            Calendar c= Calendar.getInstance();
            int year=c.get(Calendar.YEAR);
            int month=c.get(Calendar.MONTH);
            int day=c.get(Calendar.DAY_OF_MONTH);

            //Build Ondateset Listenr
            DatePickerDialog.OnDateSetListener dateListener=new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int y, int m, int d)
                {
                    tvShowDate.setText(d+"/"+m+"/"+y);
                }
            };

            //Building Date Dialog
            DatePickerDialog datePickerDialog=
                    new DatePickerDialog(this,dateListener,year,month,day);
            datePickerDialog.show();


        }
    }
}
