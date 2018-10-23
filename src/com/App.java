package com;

import com.dao.PisiciDao;
import com.daoimpl.CainiDaoImpl;
import com.daoimpl.PisiciDaoImpl;
import com.entities.Caini;
import com.entities.Pisici;
import com.javatosql.ed.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class App {

    public static void main(String[] args) {

        //Working with table Caini

        /* CainiDaoImpl cdi = new CainiDaoImpl();
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
        }*/

        //Working with table Pisici

        PisiciDaoImpl psi = new PisiciDaoImpl();
        //Pisici pisica1 = new Pisici(3, "Lama", "Aiagri", 7);
        //psi.insert(pisica1);

        //Pisici pisici = psi.selectById(2);
        //System.out.println(pisici.getId() + " " + pisici.getName() + " " + pisici.getRace() + " " + pisici.getSoftnessScale());

        // psi.deleteById(3);

        //Pisici pisica2 = new Pisici("Marta", "Siameza", 6);
        // psi.update(pisica2 , 3);

        List<Pisici> pisiciList = psi.selectAll();
        for (Pisici pisic : pisiciList) {
            System.out.println(pisic.getId() + " " + pisic.getName() + " " + pisic.getRace() + " " + pisic.getSoftnessScale());
        }
    }
}
