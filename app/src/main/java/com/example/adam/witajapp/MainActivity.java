package com.example.adam.witajapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    EditText editName;
    EditText editLast;

    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName = (EditText) findViewById(R.id.editText);
        editLast = (EditText) findViewById(R.id.editText2);
        editLast.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ButtonLogin(null);
                    return true;
                }
                return false;
            }
        });
        sharedPref = getSharedPreferences("checkLog", 0);

        Boolean userLogon = sharedPref.getBoolean(getString(R.string.user_logon), false);




        if(userLogon){

            String savedUserLogin = sharedPref.getString(getString(R.string.saved_user_login),"");
            editName.setText(savedUserLogin);
            String savedUserLast = sharedPref.getString(getString(R.string.saved_user_last),"");
            editLast.setText(savedUserLast);
            //ButtonLogin(null);


        }
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

        switch(item.getItemId()) {
            case R.id.action_arrow:
                ButtonLogin(null);
                return true;
        }


        return super.onOptionsItemSelected(item);
    }


    public void ButtonLogin(View view){




        String FirstName =  editName.getText().toString();
        String LastName = editLast.getText().toString();
        System.out.println("ClICK" + FirstName);
        String Name = "Adam";
        //Toast.makeText(this, "Wpisane Imie " + FirstName + ". Wpisane Nazwisko " + LastName,Toast.LENGTH_SHORT).show();

        if(Name.equals(FirstName)){
            Intent intent = new Intent(getApplicationContext(), navi.class);
            intent.putExtra("FirstName", FirstName);
            intent.putExtra("LastName", LastName);

            editor = sharedPref.edit();
            editor.putString(getString(R.string.saved_user_login),FirstName);
            editor.putString(getString(R.string.saved_user_last),LastName);
            editor.putBoolean(getString(R.string.user_logon), true);
            editor.commit();

           startActivity(intent);



        }
        else{
        System.out.println("ELSE");

        }





    }
}
