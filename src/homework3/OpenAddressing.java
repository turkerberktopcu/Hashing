/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package homework3;

/**
 *
 * @author turker
 */

import static java.lang.System.currentTimeMillis;
import java.util.HashSet;

public class OpenAddressing extends Hashing {

    int tableSize;
    int size;
    Student table[]; // hash table
    long start, end;

    public OpenAddressing(StudentData data) {
        tableSize = 401;
        size = 0; // for number of students in array
        table = new Student[tableSize];

        // Fetch the students from the ArrayList, then hash and allocate them into the
        // table you created.
        int dataSize = data.studentList.size(); // dataSize = 81 000
        start = currentTimeMillis();
        for (int i = 0; i < dataSize; i++) {
            insert(data.studentList.get(i)); // calling insert function for each student

        }
        end = currentTimeMillis();
        System.out.println("OPEN ADDRESSING");
        System.out.println(
                "\n(part a)Fetch the students from the ArrayList, then hash and allocate them into the table we created in "
                        + timedif() + " milliseconds\n");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------------------");

        // part b -------- Search and bring hundred random students from table----------
        System.out.println("Randomy choice sturent from table :");
        start = currentTimeMillis();
        for (int count = 0; count < 100; count++) {

            HashSet<Integer> set = new HashSet<>(); // for different 100 students
            int index_std = (int) (Math.random() * 81000);
            while (set.contains(set))
                index_std = (int) (Math.random() * 81000);
            set.add(index_std);

            Student std = data.studentList.get(index_std); // a random student from arraylist data

            for (int i = 0; i < tableSize; i++) { // probing i={0,1,2,...tableSize-1}
                int index = funcProb(std.getID(), i);
                if (table[index] == null)
                    break; // checking slot is null or not
                if (table[index].equals(std)) { // slot is not null then checking objects equality
                    System.out.print((count + 1) + ". student => ");
                    std.display(); // displaying found student
                    break;
                }
            }
        }
        end = currentTimeMillis();

        System.out.println("\n(part b)Search and bring hundred random students from the table in " + timedif()
                + " milliseconds.\n\n");
        // System.out.println("Table Size : " + table.length) ;
        // display() ;

    }

    public void insert(Student std) {

        if (size == table.length) { // if table is full then calling tableDoubling method
            tableDoubling();
        }

        for (int i = 0; i < tableSize; i++) { // probing i = {0,1,2, ... ,tableSize-1 }
            int index = funcProb(std.getID(), i);
            // System.out.println("index :"+index);
            if (table[index] == null) {
                table[index] = std;
                size++;
                break;
            }

        }

    }

    // ------------------- double the table if it is full
    // ---------------------------
    private void tableDoubling() {

        tableSize = doubleNextPrime(tableSize); // table new size
        // System.out.println("TableDuoble prime : "+tableSize) ;

        Student[] newTable = new Student[tableSize]; // new table to move all student objects into
        size = 0; // for now new table size is 0

        // System.out.println("TableDuoble prime : "+tableSize+" size : "+size) ;

        for (int k = 0; k < table.length; k++) { // move old table to new table
            for (int i = 0; i < table.length; i++) { // probing ith for values {0,1,2, ... ,tableSize-1 } but funcProb
                                                     // uses new tablesize
                int index = funcProb(table[k].getID(), i);
                if (newTable[index] == null) { // found a null empty place
                    newTable[index] = table[k];
                    size++; // increased table size by 1
                    break; // break inner for loop since kth students is placed at the new table
                }
            }
        }
        table = newTable; // array and newArray are showing same table
    }

    // ---- return the smallest prime number bigger than the twice of the size of
    // the table ----
    private int doubleNextPrime(int num) {

        int prime = 2 * num;
        while (!isPrime(prime))
            prime++;

        return prime;
    }

    // ------------ helper method to find number is prime or not
    private boolean isPrime(int x) {

        for (int i = 2; i < Math.sqrt(x); i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }

    // -------------- first hash function ------------------------
    @Override
    public int funcH1(int x) {

        return (3 * x + 23 / 1001) % tableSize; // (change number 23 with a prime number which is bigger than 1001)

    }

    // ------------ second hash function ----------------------------
    @Override
    public int funcH2(int x) {

        return (5 * x + 31 / 1001) % tableSize;

    }

    // ------------------ probe method p(x,i) -------------------------
    @Override
    public int funcProb(int x, int i) {

        return (funcH1(x) + i * funcH2(x)) % tableSize;
    }

    // ------------ display array ---------------
    public void display() {
        int count = 0;
        for (int i = 0; i < tableSize; i++) {
            if (table[i] == null)
                continue;
            else {
                table[i].display();
                count++;
            }
        }
    }

    // ----------- time difference method ------------
    public long timedif() {
        return (end - start);
    }
}
