package pl.biedzki.service;

import pl.biedzki.app.Main;
import pl.biedzki.model.Car;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;


public class BufferCleanerService implements Runnable {

    // implemented run method to be used in thread
    public void run() {
        TimerTask cleanBuffer = new TimerTask() {
            public void run() {
                //if buffer not empty than write to db and clean buffer
                if(Main.buffer.size()!=0) {
                        try (Connection conn = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/cars?useSSL=false&characterEncoding=utf8",
                                "root", "coderslab")) {

                            String sql = "insert into cars values(null, ?, ?, ?)";

                            for (Car car : Main.buffer) {
                            PreparedStatement preStmt = conn.prepareStatement(sql);
                            preStmt.setString(1, car.getProducer());
                            preStmt.setString(2, car.getModel());
                            preStmt.setDouble(3, car.getCapacity());
                            preStmt.executeUpdate();}

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    Main.buffer.clear();
                }
            }
        };

        Timer timer = new Timer("Timer");

    //timer parameters
        long delay = 30000L;
        long period = 30000L;
        timer.scheduleAtFixedRate(cleanBuffer, delay, period);
    }

}
