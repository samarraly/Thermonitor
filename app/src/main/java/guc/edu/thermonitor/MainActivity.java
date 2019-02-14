package guc.edu.thermonitor;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bl;
    private EditText email, password;
    private Button bl2;
    private ProgressDialog loadingDialog;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bl = (Button) findViewById(R.id.login);
        bl2 = (Button) findViewById(R.id.button);
        email = (EditText) findViewById(R.id.email);
        firebaseAuth = FirebaseAuth.getInstance();
        password = (EditText) findViewById(R.id.password);
        loadingDialog = new ProgressDialog(this);
        bl.setOnClickListener(this);
        bl2.setOnClickListener(this);
        //    @Override
          //  public void onClick(View v) {
            //    OpenList();
           // }
        //});





    }

    public void Signin() {
        //if (email.getText().toString().equalsIgnoreCase("Samar")&&password.getText().toString().equalsIgnoreCase("631998") ) {


        // bl.setVisibility(View.INVISIBLE);
         String mail = email.getText().toString().trim();
        String pass = password.getText().toString().trim();
        if (TextUtils.isEmpty(mail) ){
            showmessage("PLEASE ENTER EMAIL");
            return;
        }
        if( TextUtils.isEmpty(pass)) {
            // Toast.makeText(this,"PLEASE VERIFY ALL FIELDS",Toast.LENGTH_LONG).show();
            showmessage("PLEASE ENTER PASSSWORD");
            return;
                }
        loadingDialog.setMessage("PLEASE WAIT.......");
        loadingDialog.show();
        firebaseAuth.signInWithEmailAndPassword(mail, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    loadingDialog.hide();
                    showmessage("SIGNED IN SUCCESSFULLY");
                    Intent in = new Intent(MainActivity.this, List.class);
                    startActivity(in);
                    //onStart();
                //    finish();

                }

                else {
                    loadingDialog.hide();
                    showmessage("COULD NOT SIGN IN . PLEASE TRY AGAIN " + task.getException().getMessage());
                }
                loadingDialog.dismiss();
            }
        });

    }

   // public void updateUI() {
       // startActivity(List);
     //   Intent in = new Intent(MainActivity.this, List.class);
       // startActivity(in);

    //}
    //      else
    //    {
    //      Toast.makeText(MainActivity.this,"SORRY,EMAIL OR PASSWORD IS INCORRECT",Toast.LENGTH_LONG).show();
    // }
    //}
    public void onClick(View v) {
      if(v==bl2) {


          Intent in = new Intent(MainActivity.this, RegisterActivity.class);
          startActivity(in);

      }
      if(v==bl){
      Signin();
      }
    }

   // public void OpenRegister() {
     //   Intent in = new Intent(MainActivity.this, RegisterActivity.class);
      //  startActivity(in);
   // }
    public void showmessage(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
    }

 //   public void onStart() {
   //     super.onStart();
   //     FirebaseUser user =firebaseAuth.getCurrentUser();
     //   if(user !=null){
       //     Intent in = new Intent(MainActivity.this, List.class);
       //     startActivity(in);
       // }
    //}
}
