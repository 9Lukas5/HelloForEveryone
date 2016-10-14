/**
* Mein erstes Java-Programm.
* Übersetzen mit javac -d . HelloForEveryone.java
* Ausführen mit java de.hft_stuttgart.¬
* wilu1bif.HelloForEveryone
* 
* @author Lukas Wiest
*/

package de.hft_stuttgart.wilu1bif;

//imports
//packages for user input
import java.util.Scanner;
//packages for file output
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class HelloForEveryone
{

//global variables
public static String name;
public static String last_name;
public static String login;
public static String recall;
    
    //main method. Used in this program just to call the sub-methods
    public static void main(String [] args)
    {
        //1st part-task
        System.out.println("1. Teilaufgabe 'HelloWorld':");
        //call 1st part-task: method helloworld()
        helloworld();
        
        System.out.println(); //one empty line for better look on console
        
        //2nd part-task
        System.out.println("2. Teilaufgabe 'MyHello':");
        //call 2nd part-task: method myhello()
        myhello();
        
        while (recall.equals("y"))
        {
            save();
        }
    }

    /**
     * 1st part-task: helloworld
     */
    public static void helloworld()
    {
        System.out.println("Hello World!");
    }

    /**
     * 2nd part-task myhello
     */
    public static void myhello()
    {
        //local variables
        String choice;
        Scanner in;
        
        in = new Scanner(System.in);
        //ask user for his/her properties
        System.out.println("Bitte geben Sie ihren Name, Vornamen und Login"
                            + "an.");
        
        System.out.println("Nachname:");
        last_name      = in.nextLine();
        System.out.println("Vorname:");
        name = in.nextLine();
        System.out.println("Login:");
        login     = in.nextLine();
        
        //print given inputs for control
        System.out.println("Vorname: " + name);
        System.out.println("Nachname: " + last_name);
        System.out.println("Nutzername: " + login);
        System.out.println("HFT-Email: " + login + "@hft-stuttgart.de");
        
        System.out.println();
        
        //ask user if the properties should be saved
        do {
            System.out.println("Moechtest du die Daten im aktuellen"
                             + "Arbeitsverzeichnis ablegen? (y/n)");
            choice = in.nextLine();
                if (!choice.equals("y") & !choice.equals("n")) {
                    System.out.println("Fehler: Keine Gueltige Auswahl"
                                     + "getroffen!");
                    System.out.println();
                }
        } while (!choice.equals("y") & !choice.equals("n"));
        
        //if-else loop to check answer
        if (choice.equals("y")){
            save();
        }
    }

    public static void save()
    {
        //local variables
        Scanner in;
        File file;
        String file_path;
        PrintWriter out;
        
        //initialize some things
        in = new Scanner (System.in);
        out = null; //define new PrintWriter
        
        //Get save path from user
        System.out.println("Bitte vollstaendigen Pfad zum speichern angeben \n"
                         + "Beispiel: P:/myVariables.txt");
        file_path = in.nextLine();
        file = new File (file_path); //define new file
        
        //check if defined file exist. If not, create it
        try
        {
            if (file.exists()==false) file.createNewFile();
            
            //open file without overwriting
            out = new PrintWriter (new FileWriter(file, true));
            
        }
        catch (IOException error)
        {
            //error.printStackTrace();
            System.out.println("\n Es ist ein Fehler aufgetreten,"
                             + " naechster Verscuch \n");
            error = null;
            recall = "y";
            return;
        }
        
        //write the previously made inputs into the opened file
        out.println("Das sind deine persönlichen UserVariablen aus den"
                  + "gemachten Eingaben: \n");
        out.println("Name, Vorname: " + last_name + ", " + name);
        out.println("        Login: " + login);
        out.println("       E-Mail: " + login + "@hft-stuttgart.de");
        out.close(); //close file. Else the changes WILL NOT be saved
        
        System.out.println("Datei erfolgreich gespeichert. Auf Wiedersehen");
        recall = "n";
    }
}
