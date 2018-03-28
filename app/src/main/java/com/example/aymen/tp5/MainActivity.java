package com.example.aymen.tp5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private    ListView list ;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            final Contact_DAO db= new Contact_DAO(this);
            list = (ListView)findViewById(R.id.list);
            registerForContextMenu(list);
            String[] Items ={"Afficher tous vos contacts","Ajouter un contact","Modifier un contact","Initialisation de la base !"};
            ArrayAdapter AD = new ArrayAdapter(this,R.layout.list_item,R.id.txt,Items);
            list.setTextFilterEnabled(true);
            list.setAdapter(AD);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if(position==0)
                    {
                        Intent i1 = new Intent(getApplicationContext(), ContactBDProject.class);


                        startActivity(i1);
                    }
                    else if (position==1)
                    {  Intent i2 = new Intent(getApplicationContext(), ajout_activity.class);


                        startActivity(i2);

                    }
                    else if (position==2)
                    {Intent i3 = new Intent(getApplicationContext(), modifier_contactlist.class);


                        startActivity(i3);


                    }
                    else if (position==3)

                    {

                        Log.d("Insert: ", "Inserting ..");
                        db.addContact(new Contact("adb", "9100000000"));
                        db.addContact(new Contact("jackline", "9199999999"));
                        db.addContact(new Contact("William", "9522222222"));
                        db.addContact(new Contact("Averel", "9533333333"));

                        // Reading all contacts
                        Log.d("Reading: ", "Reading all contacts..");
                        List<Contact> contacts = db.getAllContacts();

                        for (Contact cn : contacts) {
                            String log = "Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
                            // Writing Contacts to log
                            Log.d("Name: ", log);

                        }
                        Toast leToast = Toast.makeText(MainActivity.this, "Initialisée avec succes",
                                Toast.LENGTH_LONG);
                        leToast.show();
                    }

                }
            });


        }
}
