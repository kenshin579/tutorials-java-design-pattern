package com.xyz.mvc;

import java.sql.*;
import java.util.Vector;

public class Database {

    private Connection con;
    private Statement stmt;
    private ResultSet rset;

    public Database() {
        this("");
    }

    public Database(String serverAddress) {
        try {
            // for Oracle
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            //con=DriverManager.getConnection("jdbc:oracle:thin:@"+serverAddress+":1521:ORCL","scott","tiger");

            // For MySQL
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + serverAddress + ":3306/student";
            String id = "root";
            String passwd = "1234";
            con = DriverManager.getConnection(url, id, passwd);
            con.setAutoCommit(false);
            stmt = con.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            rset.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insert(Student student) {
        try {
            stmt.executeUpdate(student.getInsertSQL());
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void update(Student student) {
        try {
            stmt.executeUpdate(student.getUpdateSQL());
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void delete(Student student) {
        try {
            stmt.executeUpdate(student.getDeleteSQL());
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    // specified member
    public Student select(Student student, String mode) {
        try {
            rset = stmt.executeQuery(student.getSelectSQL());
            if (rset.next()) {
                String name = rset.getString(1);
                String ssn = rset.getString(2);
                String phone = rset.getString(3);
                String email = rset.getString(4);
                if (mode.equals(Constants.FULL)) {
                    student = new FullTimeStudent(name, ssn, phone, email);
                } else if (mode.equals(Constants.PART)) {
                    student = new PartTimeStudent(name, ssn, phone, email);
                }
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    // get All com.xyz.mvc.Student
    public Student[] selectAll(Student student, String mode) {
        Vector v = new Vector();
        Student students[] = null;
        try {
            rset = stmt.executeQuery(student.getSelectAllSQL());
            while (rset.next()) {
                String name = rset.getString(1);
                String ssn = rset.getString(2);
                String phone = rset.getString(3);
                String email = rset.getString(4);
                if (mode.equals(Constants.FULL)) {
                    v.addElement(new FullTimeStudent(name, ssn, phone, email));
                } else if (mode.equals(Constants.PART)) {
                    v.addElement(new PartTimeStudent(name, ssn, phone, email));
                }
            }
            students = new Student[v.size()];
            v.copyInto(students);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return students;
    }
}
