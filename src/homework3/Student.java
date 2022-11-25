/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package homework3;

/**
 *
 * @author turker
 */
public class Student {

    private int ID;
    private String name, lastName;
    private String department, faculty;

    public Student() {

    }

    public Student(int ID, String name, String lastName, String faculty, String department) {
        this.ID = ID;
        this.name = name;
        this.lastName = lastName;
        this.department = department;
        this.faculty = faculty;

    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getID() {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getDepartment() {
        return this.department;
    }

    public String getFaculty() {
        return this.faculty;
    }

    public void display() {
        System.out.println("Name: " + name + ", Last name :" + lastName + ", Faculty : " + faculty + ", Department : "
                + department + ", ID : " + ID);
    }
}
