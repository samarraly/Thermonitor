package guc.edu.thermonitor;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button bl;
    private EditText email, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bl = (Button) findViewById(R.id.login);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        bl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenList();
            }
        });


    }
            public void OpenList() {
              if (email.getText().toString().equalsIgnoreCase("Samar")&&password.getText().toString().equalsIgnoreCase("631998") ) {
                  Intent in = new Intent(MainActivity.this, List.class);
                  startActivity(in);
              }
              else
              {
                  Toast.makeText(MainActivity.this,"SORRY,EMAIL OR PASSWORD IS INCORRECT",Toast.LENGTH_LONG).show();
              }
            }





}