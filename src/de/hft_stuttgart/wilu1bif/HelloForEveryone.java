/**
* Mein erstes Java-Programm.
* Übersetzen mit javac -d . HelloForEveryone.java
* Ausführen mit java de.hft_stuttgart.¬
* wilu1bif.HelloForEveryone
* 
* @author Lukas Wiest
*/

package de.hft_stuttgart.wilu1bif;

//Paket für Tastatureingabe importieren
import java.util.Scanner;
//Pakete fuer Dateiausgabe importieren
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class HelloForEveryone {

    //Globale Variablen deklarieren
    public static String name;
    public static String last_name;
    public static String login;
    
    //Main Methode Nutzung in diesem Fall lediglich zum Aufruf der eigenen
    //UnterMethoden
    public static void main(String [] args) {
        //Erste Teilaufgabe
        System.out.println("1. Teilaufgabe 'HelloWorld':");
        //Aufruf der ersten Teilaufgabe: Methode HelloWorld()
        HelloWorld();
        
        System.out.println(); //Eine Leerzeile Ausgaben zur besseren Darstellung
        
        //Zweite Teilaufgabe
        System.out.println("2. Teilaufgabe 'MyHello':");
        //Aufruf der zweiten Teilaufgabe: Methode MyHello()
        MyHello();
    }

    /**
     * Erste Teilaufgabe: HelloWorld 
     */
    public static void HelloWorld() {
        System.out.println("Hello World!");
    }

    /**
     * Zweite Teilaufgabe: MyHello
     */
    public static void MyHello() {
        Scanner scanner = new Scanner(System.in);
        //Aufgabenstellung
        System.out.println("Bitte geben Sie ihren Name, Vornamen und Login"
                            + "an.");
        
        //Abfrage
        System.out.println("Nachname:");
        last_name      = scanner.nextLine();
        System.out.println("Vorname:");
        name = scanner.nextLine();
        System.out.println("Login:");
        login     = scanner.nextLine();
        
        System.out.println("Vorname: " + name);
        System.out.println("Nachname: " + last_name);
        System.out.println("Nutzername: " + login);
        System.out.println("HFT-Email: " + login + "@hft-stuttgart.de");
        
        System.out.println();
        
        //Abfrage Daten abspeichern
        System.out.println("Moechtest du die Daten in deinem P: Laufwerk ablegen? (y/n)");
        String choice = scanner.nextLine();
        
        //while-Schleife zur Sicherstellung der korrekten Eingabe
        while (!choice.equals("y") & !choice.equals("n")){
            System.out.println("Fehler: Keine Gueltige Auswahl getroffen!");
            System.out.println();
            System.out.println("Moechtest du die Daten im aktuellen Arbeitsverzeichnis ablegen? (y/n)");
            choice = scanner.nextLine();
        }
        
        //if-else Schleife zur Auswertung der Antwort
        if (choice.equals("y")){
            save();
        }
    }

    public static void save(){
        
        File file = new File ("myUserVariables.txt"); //define new file
        PrintWriter out = null; //define new PrintWriter
        
        //check if defined file exist. If not, create it
        try {
            if (file.exists()==false) {
                file.createNewFile();
            }
            out = new PrintWriter (new FileWriter(file, true)); //open file without overwriting
            
        } catch (IOException error) {
            error.printStackTrace();
        }
        
        //write the previously made inputs into the opened file
        out.println("Das sind deine persönlichen UserVariablen aus den gemachten Eingaben: \n");
        out.println("Name, Vorname: " + last_name + ", " + name);
        out.println("        Login: " + login);
        out.println("       E-Mail: " + login + "@hft-stuttgart.de");
        out.close(); //close file. Else the changes WILL NOT be saved
        
        System.out.println("Datei erfolgreich gespeichert. Auf Wiedersehen");
    }
}
