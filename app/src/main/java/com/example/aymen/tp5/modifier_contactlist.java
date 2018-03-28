package com.example.aymen.tp5;

import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class modifier_contactlist extends AppCompatActivity {
    ListView lv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_contactlist);
        final Contact_DAO bd= new Contact_DAO(this);

        lv= (ListView) findViewById(R.id.lv);
        final List<Contact> contact = bd.getAllContacts();
        final List<String> c = new ArrayList<String>();
        Iterator<Contact> it = contact.iterator();
        while (it.hasNext()) {
            Contact ct = it.next();
            c.add(ct.getName());

        }
      /*  final List<String> contact = new ArrayList<String>();
        for (int i=1;i<bd.getContactsCount();i++)
        {       if(bd.getContact(i)==null)
        { i++;}
        else

        {
        contact.add(bd.getContact(i).getName());}}*/


        ArrayAdapter AD = new ArrayAdapter(this,R.layout.list_item2,R.id.text,c);
        lv.setTextFilterEnabled(true);
        lv.setAdapter(AD);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String ctmodifier= c.get(position);
                Intent i = new Intent(getApplicationContext(), ContactAModifierActivity.class);
                Bundle b= new Bundle();
                b.putSerializable(SyncStateContract.Constants.DATA,ctmodifier);
                i.putExtras(b);
                startActivity(i);

            }
        });


    }
}
