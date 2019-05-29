package pl.biedzki.service;

import pl.biedzki.app.Main;
import pl.biedzki.model.Car;

import java.util.Scanner;

public class ConsoleService implements Runnable {

    // implemented run method to be used in thread
    public void run() {

        //get console input and check which option to choose
        int option = chooseOption();
        while(option < 1 || option > 3) {
            option = chooseOption();
        }

        switch (option) {

            case 1 : {
                displayCarList();
                break;
            }

            case 2 : {
                addCar();
                break;
            }

            case 3 : {
               quitApp();
                break;
            }

        }

    }


    public void displayHeader() {
        String header = "Podaj operacje (1 - lista, 2 - dodawanie, 3 – wyjście):";
        System.out.println(header);
    }

    public int chooseOption () {
        //new console scanner
        Scanner scanner = new Scanner(System.in);
        displayHeader();

        //make sure that int has been input
        while (!scanner.hasNextInt()) {
            displayHeader();
            scanner = new Scanner(System.in);
        }
        return scanner.nextInt();

    }

    public void displayCarList() {
        System.out.println("Car list");
        run();
    }

    public void addCar() {

        System.out.println("podaj producenta (Z dużej litery, bez spacji) : ");
        String producerToBeAdded = getLine();
        while (!producerToBeAdded.matches("^[A-Z]\\S*$")) {
            System.out.println("podaj producenta (Z dużej litery, bez spacji) : ");
            producerToBeAdded = getLine();
        }
        System.out.println(producerToBeAdded);

        System.out.println("podaj model (przynajmniej jedna cyfra lub litera) : ");
        String modelToBeAdded = getLine();
        while (!modelToBeAdded.matches("^[A-Za-z0-9]+")) {
            System.out.println("podaj model (przynajmniej jedna cyfra lub litera) : ");
            modelToBeAdded = getLine();
        }
        System.out.println(modelToBeAdded);

        System.out.println("podaj pojemność silnika (cyfry . cyfry) : ");
        String capacityToBeAdded = getLine();
        while (!capacityToBeAdded.matches("^\\d+\\.{1}\\d+\\S*$")) {
            System.out.println("podaj pojemność silnika (cyfry . cyfry) : ");
            capacityToBeAdded = getLine();
        }
        System.out.println(capacityToBeAdded);

        //run();
    }

    public void quitApp() {
        System.out.println("App terminated by user");
        System.exit(0);

    }

    public String getLine() {
        //collect producer input
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextLine()) {
            scanner = new Scanner(System.in);
        }
        return scanner.nextLine();

    }
}

