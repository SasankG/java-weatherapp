package weather;

import org.json.JSONException;

import javax.swing.*;
import java.io.IOException;

/**
 * The main application
 */

public class App {

    public static void main(String[] args) throws Exception {

        JFrame app = new Frame();
        app.setTitle("Java-WeatherApp");
        app.setSize(900, 600);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setLocationRelativeTo(null);
        app.setVisible(true);
    }

}
