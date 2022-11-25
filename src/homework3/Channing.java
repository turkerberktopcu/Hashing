/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package homework3;

import static java.lang.System.currentTimeMillis;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Channing extends Hashing {

    long start, end;
    private int tableSize = 4001; // initial table size
    private List<Student>[] list; // linkedlist table

    // ------------------------------------------------------------------------------
    public Channing(StudentData data) {

        // ------------ table initialization ------------
        list = new LinkedList[tableSize];
        for (int i = 0; i < tableSize; i++)
            list[i] = new LinkedList<Student>(); // initialize table linklist

        // part a --------- adding student to table ----------
        int dataSize = data.studentList.size();
        start = currentTimeMillis();
        for (int i = 0; i < dataSize; i++) {

            Student std = data.studentList.get(i);
            // using hash function to find linkedlist(place) which the student will be put
            // into
            List<Student> whichList = list[funcH1(std.getID())];
            whichList.add(std); // adding linkList

        }
        end = currentTimeMillis();
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("CHANNING ");
        System.out.println(
                "\n(part a) Fetch the students from the ArrayList, then hash and allocate them into the table we created in "
                        + (end - start) + " millisecond\n");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------------------");
        // display() ;

        // part b -------- Search and bring hundred random students from table----------
        start = currentTimeMillis();
        System.out.println("Randomly choice student from table : ");
        for (int count = 0; count < 100; count++) {

            HashSet<Integer> set = new HashSet<>(); // for different 100 students
            int index_std = (int) (Math.random() * 81000);
            while (set.contains(set))
                index_std = (int) (Math.random() * 81000);
            set.add(index_std);

            Student std = data.studentList.get(index_std);
            int id_std = funcH1(std.getID());

            if (list[id_std].contains(std)) {
                System.out.print((count + 1) + ". student => ");
                std.display(); // displaying found student
            }
        }
        end = currentTimeMillis();
        System.out.println("\n(part b ) Search and bring students in " + (end - start) + " milliseconds  ");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------------------");
    }

    // ------------------ hash method for chaning algorithm-------------
    @Override
    public int funcH1(int x) {

        return (3 * x + 23 / 1001) % tableSize; // (change number 23 with a prime number which is bigger than 1001 )
    }

    // --------------------- dispaly hash table ---------------------
    public void display() {
        for (int i = 0; i < 4001; i++) {

            for (int j = 0; j < list[i].size(); j++)
                list[i].get(j).display();
            System.out.println("------------------------------------------");
        }
    }

    @Override
    public int funcH2(int x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int funcProb(int x, int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
