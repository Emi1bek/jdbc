package org.peaksoft;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
     //   Db.createTable();
      //System.out.println(Db.getCount());

        Db.addStudent("Emilbek",27);
        Db.addStudent("Asan",21);
        Db.addStudent("Uson",20);
        Db.addStudent("Ernist",31);
    }
}
