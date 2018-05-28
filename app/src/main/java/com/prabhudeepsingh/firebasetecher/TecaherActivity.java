package com.prabhudeepsingh.firebasetecher;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class TecaherActivity extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseFirestore firestore;

    void init() {
        firestore = FirebaseFirestore.getInstance();

        TeacherModel model = new TeacherModel("Prabhudeep", "Singh");

        //firestore.collection("teachers").document().set(model);

        auth = FirebaseAuth.getInstance();

        auth.signInWithEmailAndPassword("Prabhudeepsb@gmail.com", "aman2308")
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(TecaherActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(TecaherActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                    }
                });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tecaher);

        init();
    }
}