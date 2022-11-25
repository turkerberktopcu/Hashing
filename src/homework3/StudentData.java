/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package homework3;

/**
 *
 * @author turker
 */
import java.util.HashSet;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class StudentData {

    // hashset for different id number in same department
    private HashSet<Integer> set = new HashSet<Integer>();
    // array list for 81 000 students
    public ArrayList<Student> studentList = new ArrayList<Student>();

    private FileReader female = new FileReader("female.txt");
    private FileReader male = new FileReader("male.txt");
    private FileReader lastName = new FileReader("lastName.txt");

    private String faculty[] = { "xx", "yy", "zz", "tt", "pp", "ss", "ll", "mm", "nn" }; // faculty names
    private int fac_code[] = { 17, 23, 31, 37, 41, 53, 61, 67, 71 }; // faculty code for student id

    private String department[] = { "aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", "kk" }; // department names
    private int dep_code[] = { 11, 22, 33, 44, 55, 66, 77, 88, 99 }; // department code for students id
    private Student std;

    public StudentData() throws FileNotFoundException {

        int year = 13;
        while (year < 23) { // year < 23
            for (int i = 0; i < faculty.length; i++) {
                for (int j = 0; j < department.length; j++) {

                    // 100 student at a department
                    set.clear();
                    int count = 0;
                    while (count < 100) {
                        int id = createID(year, fac_code[i], dep_code[j]);

                        int flag = (int) (Math.random() * 2);
                        if (flag == 0) { // generate female student

                            std = new Student(id, female.getNextName(), lastName.getNextName(), faculty[i],
                                    department[j]);
                        } else { // generate male student
                            std = new Student(id, male.getNextName(), lastName.getNextName(), faculty[i],
                                    department[j]);
                        }

                        studentList.add(std);

                        // std.display();
                        count++;
                    }
                }
            }

            year++;
        }

    }

    public int createID(int year, int fac, int dep) {

        // if random method gives same number for same department students, code snip
        // will change it
        int nnn = (int) (Math.random() * 1000);
        while (set.contains(nnn)) {
            nnn = (int) (Math.random() * 1000);
        }
        set.add(nnn);
        // creat unique id number
        return year * 10000000 + fac * 100000 + dep * 1000 + nnn;

    }

}
