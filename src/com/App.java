package com;

import com.daoimpl.CainiDaoImpl;
import com.entities.Caini;
import com.javatosql.ed.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class App {

    public static void main(String[] args) {
        CainiDaoImpl cdi = new CainiDaoImpl();
        //Caini caini = new Caini(3,"Mucus", "Doberman",5);
        // cdi.insert(caini);

        // Caini caini = cdi.selectById(3);
        //System.out.println(caini.getId() +" " +  caini.getName()+ " " + caini.getRace() +" " + caini.getAngerScale());

        //cdi.delete(3);
        //Caini caini2 =  new Caini("Thomas", "Corgi", 3);
        //cdi.update(caini2, 3);

        List<Caini> cainiList = cdi.selectAll();
        for (Caini caine : cainiList) {
            System.out.println(caine.getId() + " " + caine.getName() + " " + caine.getRace() + " " + caine.getAngerScale());
        }
    }
}
