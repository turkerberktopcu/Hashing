/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package homework3;

/**
 *
 * @author turker
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    File file;
    Scanner sc;

    public FileReader(String fileName) throws FileNotFoundException {
        file = new File(fileName);
        sc = new Scanner(file);
    }

    public String getNextName() {
        if (sc.hasNext())
            return sc.next();
        else
            return null;
    }

}