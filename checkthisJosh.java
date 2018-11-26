import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class checkthisJosh {
    
    private JFrame WyvernFrame;
    
    // Title of Program
    private JLabel label = new JLabel ("Wyvern Branding");
    
    // Creates 3 blank spaces to be overridden when colours are picked
    private JLabel tag1 = new JLabel ("Pick a colour");
    private JLabel tag2 = new JLabel ("                   ");
    private JLabel tag3 = new JLabel ("                   ");
    
    // Six Buttons for the difference colours
    private JButton WRedButton = new JButton("Wyvern Red");
    private JButton WBlueButton = new JButton("Business Blue");
    private JButton WGreenButton = new JButton("Ergo Green");
    private JButton WPurpleButton = new JButton("DSA Purple");
    private JButton WYellowButton = new JButton("ATW Yellow");
    private JButton WGreyButton = new JButton("Repair Grey");
    
    //Defines the default values for RGB as White for the start-up
    int red = 255;
    int green = 255;
    int blue = 255;
    
    public static void main (String[] args) {
        checkthisJosh gui = new checkthisJosh();
        gui.go();
    }
    
    public void go() {
        WyvernFrame = new JFrame();
        WyvernFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container contentPane = WyvernFrame.getContentPane();
        
        // Creates a drawing panel ready
        MyDrawPanel drawPanel = new MyDrawPanel();
        
        //Adds the label to the top of the Program
        WyvernFrame.getContentPane().add(BorderLayout.NORTH,label);
        label.setHorizontalAlignment(JLabel.CENTER);
        
        /* Creates the dynamic section of the program.
        *  Split into a 2 smaller panels within one panel.
        *  @centrePanelA contains colour changing shape.
        *  @centrePanelB contains colour values.
        */
        JPanel centrePanel = new JPanel();
        JPanel centrePanelA = new JPanel();
        JPanel centrePanelB = new JPanel();
        contentPane.add(centrePanel,BorderLayout.CENTER);
        centrePanel.setLayout(new GridLayout(2,1));
        centrePanel.add(centrePanelA);
        centrePanelA.setLayout(new GridLayout(1,1));
        centrePanelA.add(drawPanel);
        centrePanel.add(centrePanelB);
        centrePanelB.setLayout(new GridLayout(3,1));
        centrePanelB.add(tag1); // Hex Colour
        tag1.setHorizontalAlignment(JLabel.CENTER);
        centrePanelB.add(tag2); // RGB Colour
        tag2.setHorizontalAlignment(JLabel.CENTER);
        centrePanelB.add(tag3); // CMYK Colour
        tag3.setHorizontalAlignment(JLabel.CENTER);
        
        // Creates Bottom Panel with 6 Buttons
        JPanel southPanel = new JPanel();
        contentPane.add(southPanel,BorderLayout.SOUTH);
        southPanel.setLayout(new GridLayout(2,3));
        southPanel.add(WRedButton);
        southPanel.add(WBlueButton);
        southPanel.add(WGreenButton);
        southPanel.add(WPurpleButton);
        southPanel.add(WYellowButton);
        southPanel.add(WGreyButton);
        
        // Button Listener Event Actions
        WRedButton.addActionListener(new redListener());
        WBlueButton.addActionListener(new blueListener());
        WGreenButton.addActionListener(new greenListener());
        WPurpleButton.addActionListener(new purpleListener());
        WYellowButton.addActionListener(new yellowListener());
        WGreyButton.addActionListener(new greyListener());
        
        // Builds GUI to size
        WyvernFrame.setSize(800,500);
        WyvernFrame.setVisible(true);
    }
    
    class redListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
            // Defines new RGB Colour for chosen colour.
            red = 189;
            green = 32;
            blue = 38;
            WyvernFrame.repaint();  // Causes box to re-draw
            tag1.setText("HEX #BD2026");
            tag2.setText("RGB " + red + ", " + green + ", " + blue); // RGB Colour fed by updated Ints
            tag3.setText("CMYK 0,83,80,26");
        }
    } // end of inner class
    
    class blueListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
            red = 4;
            green = 85;
            blue = 123;
            WyvernFrame.repaint();
            tag1.setText("HEX #04557B");
            tag2.setText("RGB " + red + ", " + green + ", " + blue);
            tag3.setText("CMYK 97,31,0,52");
        }
    } // end of inner class
    
    class greenListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
            red = 50;
            green = 117;
            blue = 113;
            WyvernFrame.repaint();
            tag1.setText("HEX #327571");
            tag2.setText("RGB " + red + ", " + green + ", " + blue);
            tag3.setText("CMYK 0,83,80,26");
        }
    } // end of inner class
    
    class purpleListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
            red = 74;
            green = 44;
            blue = 132;
            WyvernFrame.repaint();
            tag1.setText("HEX #4A2C84");
            tag2.setText("RGB " + red + ", " + green + ", " + blue);
            tag3.setText("CMYK 44,67,0,48");
        }
    } // end of inner class
    
    class yellowListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
            red = 244;
            green = 144;
            blue = 12;
            WyvernFrame.repaint();
            tag1.setText("HEX #F4900C");
            tag2.setText("RGB " + red + ", " + green + ", " + blue);
            tag3.setText("CMYK 0,41,95,4");
        }
    } // end of inner class
    
    class greyListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
            red = 63;
            green = 63;
            blue = 63;
            WyvernFrame.repaint();
            tag1.setText("HEX #3F3F3F");
            tag2.setText("RGB " + red + ", " + green + ", " + blue);
            tag3.setText("CMYK 0,0,0,75");
        }
    } // end of inner class
    
    public class MyDrawPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g){
            Graphics2D g2d = (Graphics2D) g;
            // Defines initial Box shape, colour and size
            Color myColor = new Color(red,green,blue);
            g.setColor(myColor);
            g.fillRect(0,0,this.getWidth(),this.getHeight());
        }
    }
}
