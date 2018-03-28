package com.example.aymen.tp5;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactBDProject extends AppCompatActivity {
    //TableLayout t;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_bdproject);
         /* t=(TableLayout)findViewById(R.id.tab);
        t.removeAllViews()*/;
        lv= (ListView)findViewById(R.id.liv);
        final Contact_DAO bd= new Contact_DAO(this);
        bd.open();
       /* final List<Contact> arContact=bd.getAllContacts();
        Iterator<Contact> it = arContact.iterator();
  while (it.hasNext()) {
            Contact ct = it.next();
// création d'une nouvelle TableRow
            TableRow row = new TableRow(this);



            TextView tNom = new TextView(this);
            tNom.setText(ct.getName());
            tNom.setPadding(5,5,5,5);
            row.addView(tNom);
            TextView tphone = new TextView(this);
            tphone.setText(String.valueOf(ct.getPhoneNumber()));
            tphone.setPadding(5,5,5,5);
            row.addView(tphone);

            t.addView(row, new TableLayout.LayoutParams
                    (AbsListView.LayoutParams.WRAP_CONTENT,
                            AbsListView.LayoutParams.WRAP_CONTENT));

    }*/





        final List<Contact> contact = bd.getAllContacts();
        final List<String> c = new ArrayList<String>();
        Iterator<Contact> it = contact.iterator();
        while (it.hasNext()) {
            Contact ct = it.next();
            c.add(ct.getName() +"  "+ ct.getPhoneNumber());

        }

        /*for (int i=1;i<bd.getContactsCount();i++)
        {       if(bd.getContact(i)==null)
        { i++;}
            else

        { contact.add(bd.getContact(i).getName() +"  "+ bd.getContact(i).getPhoneNumber());}


        }*/
        ArrayAdapter AD = new ArrayAdapter(this,R.layout.list_item3,R.id.text,c);
        lv.setTextFilterEnabled(true);
        lv.setAdapter(AD);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog alertDialog;
                alertDialog = new AlertDialog.Builder(ContactBDProject.this).create();
                alertDialog.setTitle("Confirmation");
                alertDialog.setMessage(" Voulez vous vraiement le supprimer ?");
                alertDialog.setButton( -1,"oui", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        bd.deleteContact(position+1);
                        dialog.dismiss();
                        Toast leToast = Toast.makeText(ContactBDProject.this, "Supprimé  avec succes",
                                Toast.LENGTH_LONG);
                        leToast.show();
                    }
                });
                alertDialog.setButton(-2,"non", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
                // Create the AlertDialog object and return it
                alertDialog.show();


            }
        });



    }



}

