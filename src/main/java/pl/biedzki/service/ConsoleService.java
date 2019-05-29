package pl.biedzki.service;

public class ConsoleService implements Runnable {

    // implemented run method to be used in thread
    public void run() {
        displayHeader();
    }


    public void displayHeader() {
        String header = "Podaj operacje (1 - lista, 2 - dodawanie, 3 – wyjście):";
        System.out.println(header);
    }
}

