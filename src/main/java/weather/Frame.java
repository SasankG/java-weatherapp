package weather;

/**
 * The GUI component housing the app
 */


import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
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


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(6, 4, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.setBackground(new Color(-16562043));
        mainPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(-15531896)), null));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("STIXIntegralsUp", Font.BOLD, 20, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setForeground(new Color(-3021830));
        label1.setText("Daily Weather - Markham");
        mainPanel.add(label1, new GridConstraints(0, 0, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        text = new JLabel();
        text.setText("Label");
        mainPanel.add(text, new GridConstraints(2, 0, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        category = new JLabel();
        category.setEnabled(false);
        Font categoryFont = this.$$$getFont$$$(null, -1, 16, category.getFont());
        if (categoryFont != null) category.setFont(categoryFont);
        category.setText("Label");
        mainPanel.add(category, new GridConstraints(1, 0, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        mainPanel.add(spacer1, new GridConstraints(3, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        mintemp = new JLabel();
        Font mintempFont = this.$$$getFont$$$(null, -1, 48, mintemp.getFont());
        if (mintempFont != null) mintemp.setFont(mintempFont);
        mintemp.setText("Label");
        mainPanel.add(mintemp, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        link = new JLabel();
        link.setText("Label");
        mainPanel.add(link, new GridConstraints(5, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        mainPanel.add(spacer2, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        maxtemp = new JLabel();
        Font maxtempFont = this.$$$getFont$$$(null, -1, 48, maxtemp.getFont());
        if (maxtempFont != null) maxtemp.setFont(maxtempFont);
        maxtemp.setText("Label");
        mainPanel.add(maxtemp, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$(null, -1, 16, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setText("Low");
        mainPanel.add(label2, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        Font label3Font = this.$$$getFont$$$(null, -1, 16, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setText("High");
        mainPanel.add(label3, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}
