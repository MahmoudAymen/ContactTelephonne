package com.example.aymen.tp5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ajout_activity extends AppCompatActivity {

    EditText name;
    EditText phone;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_activity);
        final Contact_DAO bd= new Contact_DAO(this);
        bd.open();

        name=(EditText)findViewById(R.id.name);
        phone=(EditText)findViewById(R.id.phone);
        add=(Button)findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contact c = new Contact();

                String nom = name.getText().toString();
                String number = phone.getText().toString();

                bd.addContact(new Contact(nom, number));


                Toast leToast = Toast.makeText(ajout_activity.this, "Ajouté avec succes",
                        Toast.LENGTH_LONG);
                leToast.show();
                Intent i1 = new Intent(getApplicationContext(), ContactBDProject.class);


                startActivity(i1);


            }


        });

    }
}
