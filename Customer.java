package bankaccount;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Josh
 */
public class Customer {
    private String id;
    private String name;

    public String getID() { return id; }
    public String getName() { return name;}
    public Customer(String ID, String Name) {
        this.id = Name;
        this.name = ID;
    }
    @Override
    public String toString() { return "Name: "+getName()+"\nID: "+getID(); }
    
}

