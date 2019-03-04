package weather;

/**
 * The GUI component housing the app
 */


import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;


public class Frame extends JFrame {

    // Get the API
    private API api = new API();

    // Form elements
    public JPanel mainPanel;
    public JLabel text;
    public JLabel category;
    public JLabel mintemp;
    public JLabel maxtemp;
    public JLabel link;

    /**
     * Construct the frame
     */
    public Frame() throws Exception, JSONException {

        initFrame();

    }

    public void initFrame() throws Exception, JSONException {

        // Get API response
        JSONObject wjson = api.connection();

        // Filter response and get data
        String[] data = api.respFilter(wjson);


        // Swing components
        mainPanel = new JPanel(new BorderLayout());
        text = new JLabel();
        category = new JLabel();
        mintemp = new JLabel();
        maxtemp = new JLabel();
        link = new JLabel();


        // Add to the frame
        add(mainPanel);
        add(text);
        add(category);
        add(mintemp);
        add(maxtemp);


        text.setText(data[0]);
        category.setText(data[1]);
        mintemp.setText(data[3]);
        maxtemp.setText(data[4]);


    }


}
