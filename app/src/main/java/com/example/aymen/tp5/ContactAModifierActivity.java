package com.example.aymen.tp5;

import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContactAModifierActivity extends AppCompatActivity {
    EditText mname;
    EditText mphone;
    Button modifier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_amodifier);
        final Contact_DAO bd= new Contact_DAO(this);

        Bundle b= this.getIntent().getExtras();

        final String ct= (String)(b.getSerializable(SyncStateContract.Constants.DATA));

        mname= (EditText)findViewById(R.id.mnom);
        mphone=(EditText)findViewById(R.id.mphone);
        modifier=(Button)findViewById(R.id.modifier);
        mname.setText(ct);


        modifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bd.updateContact(new Contact(ct, mphone.getText().toString()));
                Toast leToast = Toast.makeText(ContactAModifierActivity.this, "Modifié avec succes",
                        Toast.LENGTH_LONG);
                leToast.show();
                Intent i1 = new Intent(getApplicationContext(), ContactBDProject.class);


                startActivity(i1);

            }


        });

    }
}
