package pl.biedzki.service;

import pl.biedzki.app.Main;
import pl.biedzki.model.Car;
import java.sql.*;
import java.util.Scanner;

public class ConsoleService implements Runnable {


    // implemented run method to be used in thread
    public void run() {

        //get console input and check which option to choose
        int option = chooseOption();
        while(option < 1 || option > 3) {
            option = chooseOption();
        }

        //execute selected action by calling method
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

        //make sure that int has been input by user
        while (!scanner.hasNextInt()) {
            displayHeader();
            scanner = new Scanner(System.in);
        }
        return scanner.nextInt();

    }

    public void displayCarList() {
       //connection to db with preapred statement
        String query = "select * from cars;";

        try (Connection conn = DriverManager.getConnection(
                Main.mySqlUrl, Main.mySqlUser, Main.mySqlPassword)) {

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String producer = resultSet.getString(2);
                String model = resultSet.getString(3);
                double capacity = resultSet.getDouble(4);
                System.out.println(producer + " " + model + " " + capacity);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        //after displaying list run again console menu
        run();
    }

    public void addCar() {

        //get and validate producer
        System.out.println("podaj producenta (Z dużej litery, bez spacji) : ");
        String producerToBeAdded = getLine();
        while (!producerToBeAdded.matches("^[A-Z]\\S*$")) {
            System.out.println("podaj producenta (Z dużej litery, bez spacji) : ");
            producerToBeAdded = getLine();
        }

        //get and validate model
        System.out.println("podaj model (przynajmniej jedna cyfra lub litera) : ");
        String modelToBeAdded = getLine();
        while (!modelToBeAdded.matches("^[A-Za-z0-9]+")) {
            System.out.println("podaj model (przynajmniej jedna cyfra lub litera) : ");
            modelToBeAdded = getLine();
        }

        //get and validate capacity
        System.out.println("podaj pojemność silnika (cyfry . cyfry) : ");
        String capacityToBeAdded = getLine();
        while (!capacityToBeAdded.matches("^\\d+\\.{1}\\d+\\S*$")) {
            System.out.println("podaj pojemność silnika (cyfry . cyfry) : ");
            capacityToBeAdded = getLine();
        }

        //create new car object
        Car carToBeAdded = new Car();
        carToBeAdded.setId(null);
        carToBeAdded.setProducer(producerToBeAdded);
        carToBeAdded.setModel(modelToBeAdded);
        carToBeAdded.setCapacity(Double.parseDouble(capacityToBeAdded));

        //add new car to buffer
        Main.buffer.add(carToBeAdded);

        //after adding car to buffer run again console menu
        run();
    }

    public void quitApp() {

        //wait for tomer to write to db and clear buffer
        System.out.println("Czekam na zapis do bazy danych ... ");
        while (Main.buffer.size()!=0) {

        }
        System.out.println("Aplikacja zakończona przez użytkownika");
        //quit app killing all threads
        System.exit(0);


    }

    public String getLine() {
        //collect console input
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextLine()) {
            scanner = new Scanner(System.in);
        }
        return scanner.nextLine();

    }
}

