RESULT AND DISCUSSION 
-----------------------

FileReader class 
 
 -constructor fuction with file name as a parameter is opened file, and snanner obj for reading file 
 -getNextName() method return  next name from file 

Student class 
  
  defined two constructor one of them is non-parameter and second is with parameters .
  Necessary getter and setter function and also display method to check

StudentData class  
  
  Arraylist for maintaining students data 
  HashSet to avoid having the same number of students in the same department 
  Three ReadFile objects for femela, male, and lastName files  
  Faculty names and faculty code are randomly generated, the same for department and department code  

   StudentData constructor 
   18 000 students are created in this method. 
          -10 times outer while loop for years
          -Outer for loop for 9 faculty and inner for loop for 9 departments 
          -Clear the hashset because of taking same NNN number for students from different departments
          -100 times inner while loop for 100 students at the same department 
          -Adding all generated students to ArrayList 


Hashing abstract class  
    abstract three methods 
    * funcH1() first hashing function 
    * funcH2() second hashing function 
    * funcProp() method to prob for open addressing  

Channing class extends Hashing abstract class 
   
    Constructor function is defined with StudentData object as a parameter. In the consturactor, Firstly
    list is initialized than calculated hash value for each students and put the corresponding linkedlist and also 
    time is calculated. (for part a )
    
    Then for part b, randomly 100 students are choosed from Arraylist then searched at the table then bring them.     
    
    In this class, there are some methods are used. They are funcH1 for hash function,and display method to see the
    intermediare result.
   
    After running the progran there is not empty linked list but the size of 2236 linked lists are greater than 20 
    and less then 36. Just only one list size is equal to 36.Fetch the students from the ArrayList, then hash and 
   allocate them into the table we created aproximetly in 10 millisecond. Search and bring students about 30 milliseconds.  
   
OpenAddressing class extends Hashing abstract class
   
    In that class, we started table size 401 as a prime numbers.Constructor is defined with StudentData paramenter.
    First 401 data is placed table using funcProb method.This point is a little bit hash since sometimes finding a place
    for lastly data is required more probing becauses long clustering.As we expected. Then if table size is full, table doubling 
    operation is done.In that prosess old table values are transformed to new table again using functProb method with new table 
    size.     
    
    For part b, 100 random students are choice form arraylist then search and bring in calculated time.
    Some helper functions are insert, tableDoubling, doubleNextPrime,isPrime,funcH1,funcH2,funcProb, display, timedif.
    
    All student is placed in insert method using funcProb method and if table is full tableDoubling method is called.  

    Normally open addressing gives better result but the load factor is close to 0.5. But in this study we get 1 
    so that open addressing result in lots of probing to find place  especially last item. Fetch the students from the ArrayList, 
    then hash and allocate them into the table we created approximately in 30 milliseconds.Search and bring hundred random students
    from the table approximately 70 milliseconds.

    Final size of table is equal to 104417. As it is seen table size is bigger than student size.We deduce lots of memory usage. 


========================
BUILD OUTPUT DESCRIPTION
========================

When you build an Java application project that has a main class, the IDE
automatically copies all of the JAR
files on the projects classpath to your projects dist/lib folder. The IDE
also adds each of the JAR files to the Class-Path element in the application
JAR files manifest file (MANIFEST.MF).

To run the project from the command line, go to the dist folder and
type the following:

java -jar "HomeWork3.jar" 

To distribute this project, zip up the dist folder (including the lib folder)
and distribute the ZIP file.

Notes:

* If two JAR files on the project classpath have the same name, only the first
JAR file is copied to the lib folder.
* Only JAR files are copied to the lib folder.
If the classpath contains other types of files or folders, these files (folders)
are not copied.
* If a library on the projects classpath also has a Class-Path element
specified in the manifest,the content of the Class-Path element has to be on
the projects runtime path.
* To set a main class in a standard Java project, right-click the project node
in the Projects window and choose Properties. Then click Run and enter the
class name in the Main Class field. Alternatively, you can manually type the
class name in the manifest Main-Class element.
=================================================================================






