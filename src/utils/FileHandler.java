package utils;

/**
 * @Author Alexander Olsson
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {



    /**
     * Metod för att skriva till fil, om filen inte finns så skapas en ny.
     * @param fileName filnamn att skriva till.
     * @param input input att skriva in i fil.
     */
    public void writer(String fileName,String input){

        try {
            FileWriter writer = new FileWriter(fileName);

            writer.write(input);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Metod för att läsa innehåll i fil.
     * @param fileName filnamn att läsa.
     */
    public void reader(String fileName){


        File file = new File(fileName);

        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
