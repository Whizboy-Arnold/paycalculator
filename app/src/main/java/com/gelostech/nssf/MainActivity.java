package com.gelostech.nssf;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.gelostech.nssf.data.Payment;

public class MainActivity extends AppCompatActivity {

    private Payment data;

    @Override
    protected void onStart() {
        super.onStart();

        final TextView textView=findViewById(R.id.nssf);
        final EditText cash=findViewById(R.id.basicpay);
        final EditText nocash=findViewById(R.id.nocash);
        final TextView pension=findViewById(R.id.penout);
        final TextView insurance=findViewById(R.id.cover);
        final CheckBox editself=findViewById(R.id.selfinput);


        cash.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    MainActivity.this.data.setBasicpay(Integer.parseInt(s.toString()));
                }catch(Exception r){
                    Log.e(" editgross ", r.toString());
                }
                textView.setText(Integer.toString(data.getNetPay()));
                insurance.setText(Integer.toString(data.calculateNHIF()));
                pension.setText(Integer.toString(data.calculateNssftotal()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        editself.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                MainActivity.this.data.setSelf(isChecked);
                textView.setText(Integer.toString(data.getNetPay()));
                insurance.setText(Integer.toString(data.calculateNHIF()));
                pension.setText(Integer.toString(data.calculateNssftotal()));

            }
        });
        nocash.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    MainActivity.this.data.setBenefits(Integer.parseInt(s.toString()));
                }catch(Exception r){
                    Log.e(" editgross ", r.toString());
                }
                textView.setText(Integer.toString(data.getNetPay()));
                insurance.setText(Integer.toString(data.calculateNHIF()));
                pension.setText(Integer.toString(data.calculateNssftotal()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //initalize dom
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        ///intialize data
        data=new Payment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
