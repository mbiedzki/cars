package pl.biedzki.app;


import pl.biedzki.service.ConsoleService;
import pl.biedzki.service.BufferCleanerService;
import pl.biedzki.model.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        //buffer to be entered with user data and then written to database
        List<Car> buffer = Collections.synchronizedList(new ArrayList<Car>());

        //open timer buffer cleaner thread
        Thread threadOfBufferCleaner = new Thread(new BufferCleanerService());
        threadOfBufferCleaner.start();

        Thread threadOfConsoleService = new Thread(new ConsoleService());
        threadOfConsoleService.start();

    }
}
