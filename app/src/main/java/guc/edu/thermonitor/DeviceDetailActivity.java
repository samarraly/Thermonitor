package guc.edu.thermonitor;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DeviceDetailActivity extends AppCompatActivity {
   Button delete;
   Button logout;
   FirebaseUser auth;
   ProgressDialog progrees;
   private TextView MsgTxt;
   private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
   private DatabaseReference mRootReference = firebaseDatabase.getReference();
   private DatabaseReference mChildResference = mRootReference.child("message");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_detail);
        delete = (Button)findViewById(R.id.buttondelete);
        logout=(Button)findViewById(R.id.buttonlogout);
        auth= FirebaseAuth.getInstance().getCurrentUser();
        MsgTxt=(TextView)findViewById(R.id.messsge);
        progrees=new ProgressDialog(this);
        MsgTxt.setText("Message Appear here");

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             FirebaseUser  user= FirebaseAuth.getInstance().getCurrentUser();


            if (user!=null){
                progrees.setMessage("Deactiviting ......please wait");
                progrees.show();
                user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            progrees.hide();
                            Toast.makeText(DeviceDetailActivity.this,"Account Deactivated",Toast.LENGTH_LONG).show();
                            finish();
                            startActivity(new Intent(DeviceDetailActivity.this,MainActivity.class));
                        }
                        else {
                            progrees.hide();
                            Toast.makeText(DeviceDetailActivity.this, "Account cannot be Deactivated", Toast.LENGTH_LONG).show();
                        }
                    }
                });



            }




            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 FirebaseAuth.getInstance().signOut();
                 startActivity(new Intent(DeviceDetailActivity.this,MainActivity.class));
            }
        });





    }

    @Override
    protected void onStart() {
        super.onStart();
        mChildResference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String message = dataSnapshot.getValue(String.class);
                MsgTxt.setText(message);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
