package pl.biedzki.app;


import pl.biedzki.service.ConsoleService;
import pl.biedzki.service.BufferCleanerService;
import pl.biedzki.model.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {

    //buffer to be entered with user data and then written to database
    public static List<Car> buffer = Collections.synchronizedList(new ArrayList<>());

    //mySQL connector parameters
    public static String mySqlUrl = "jdbc:mysql://localhost:3306/cars?" +
            "allowPublicKeyRetrieval=true&useSSL=false&characterEncoding=utf8";
    public static String mySqlUser = "root";
    public static String mySqlPassword = "coderslab";


    public static void main(String[] args) {

        //open timer buffer cleaner thread
        Thread threadOfBufferCleaner = new Thread(new BufferCleanerService());
        threadOfBufferCleaner.start();

        //open console service thread
        Thread threadOfConsoleService = new Thread(new ConsoleService());
        threadOfConsoleService.start();

    }


}
