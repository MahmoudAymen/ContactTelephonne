package com.example.aymen.tp5;

/**
 * Created by aymen on 01/03/2017.
 */
public class Contact {
    //private variables

    String _name;
    String _phone_number;

    // Empty constructor
    public Contact(){

    }
    // constructor
    public Contact( String name, String _phone_number){

        this._name = name;
        this._phone_number = _phone_number;
    }

    // constructor

    // getting ID


    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }

    // getting phone number
    public String getPhoneNumber(){
        return this._phone_number;
    }

    // setting phone number
    public void setPhoneNumber(String phone_number){
        this._phone_number = phone_number;
    }
}
