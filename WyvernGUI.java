import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WyvernGUI extends JFrame {
    
    private JFrame wyvernFrame;
    
    // Title of Program
    private JLabel label = new JLabel ("Wyvern Branding");
    
    // Creates 3 blank spaces to be overridden when colours are picked
    private JLabel tag1 = new JLabel ("Pick a colour");
    private JLabel tag2 = new JLabel ("                   ");
    private JLabel tag3 = new JLabel ("                   ");
    
    // Six Buttons for the difference colours
    /**
     * @JoshComment
     * Try to use camelCase variable naming for variables
     */
    private JButton redButton = new JButton("Wyvern Red");
    private JButton blueButton = new JButton("Business Blue");
    private JButton greenButton = new JButton("Ergo Green");
    private JButton purpleButton = new JButton("DSA Purple");
    private JButton yellowButton = new JButton("ATW Yellow");
    private JButton greyButton = new JButton("Repair Grey");
    
    //Defines the default values for RGB as White for the start-up
    int red = 255;
    int green = 255;
    int blue = 255;
    
    public static void main (String[] args) {
        WyvernGUI gui = new WyvernGUI();
        UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
        gui.go();
    }
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        // Defines initial Box shape, colour and size
        Color myColor = new Color(red,green,blue);
        g.setColor(myColor);
        g.fillRect(0,0,this.getWidth(),this.getHeight());
    }
    
    public void go() {
        wyvernFrame = new JFrame(); // Use camel case
        wyvernFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container contentPane = wyvernFrame.getContentPane();
        
        // Creates a drawing panel ready
        WyvernGUI drawPanel = new WyvernGUI();
        
        //Adds the label to the top of the Program
        wyvernFrame.getContentPane().add(BorderLayout.NORTH,label);
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
        southPanel.add(redButton);
        southPanel.add(blueButton);
        southPanel.add(greenButton);
        southPanel.add(purpleButton);
        southPanel.add(yellowButton);
        southPanel.add(greyButton);
        
        // Button Listener Event Actions
        /**
         * @JoshComment
         * You could use an iterator and store the buttons in an array, then register action
         * listeners in a loop, I was too lazy so you can do that if you want
         */
        redButton.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent event){
                // Defines new RGB Colour for chosen colour.
                red = 189;
                green = 32;
                blue = 38;
                wyvernFrame.repaint();  // Causes box to re-draw
                tag1.setText("HEX #BD2026");
                tag2.setText("RGB " + red + ", " + green + ", " + blue); // RGB Colour fed by updated Ints
                tag3.setText("CMYK 0,83,80,26");
            }
        });
        
        blueButton.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent event){
                red = 4;
                green = 85;
                blue = 123;
                wyvernFrame.repaint();
                tag1.setText("HEX #04557B");
                tag2.setText("RGB " + red + ", " + green + ", " + blue);
                tag3.setText("CMYK 97,31,0,52");
            }
        });
        
        greenButton.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent event){
                red = 50;
                green = 117;
                blue = 113;
                wyvernFrame.repaint();
                tag1.setText("HEX #327571");
                tag2.setText("RGB " + red + ", " + green + ", " + blue);
                tag3.setText("CMYK 0,83,80,26");
            }
        });
        
        purpleButton.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent event){
                red = 74;
                green = 44;
                blue = 132;
                wyvernFrame.repaint();
                tag1.setText("HEX #4A2C84");
                tag2.setText("RGB " + red + ", " + green + ", " + blue);
                tag3.setText("CMYK 44,67,0,48");
            }
        });
        
        yellowButton.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent event){
                red = 244;
                green = 144;
                blue = 12;
                wyvernFrame.repaint();
                tag1.setText("HEX #F4900C");
                tag2.setText("RGB " + red + ", " + green + ", " + blue);
                tag3.setText("CMYK 0,41,95,4");
            }
        });
        
        greyButton.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent event){
                red = 63;
                green = 63;
                blue = 63;
                wyvernFrame.repaint();
                tag1.setText("HEX #3F3F3F");
                tag2.setText("RGB " + red + ", " + green + ", " + blue);
                tag3.setText("CMYK 0,0,0,75");
            }
        });
        
        // Builds GUI to size
        wyvernFrame.setSize(800,500);
        wyvernFrame.setVisible(true);
    }
    
}
