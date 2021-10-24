import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
/**
 * PigGUI is the graphical user interface for the
 * PIG OUT program.
 *
 * @author Mr. Page
 * @author Alexandra Michael modified for Checkstyle
 * @version June 7, 2018
 *
 */
public class PigGUI implements ActionListener
{
    private JFrame frame;
    private JButton rollButton;
    private JButton holdButton;
    private JTextField player1Score;
    private JTextField player2Score;
    private JLabel player1Label;
    private JLabel player2Label;
    private JTextField currentTurnScore;
    private JLabel turnLabel;
    private ImageIcon[] diceImages;

    private String currentActionCommand;
    private boolean buttonPushedFlag;
    // boolean flag for enabling the buttons
    // a disabled button does not set the buttonPushedFlag
    // this prevents the button from changing it's visual state
    // at the expense of handling button presses
    private boolean enabled;

    private static final String IMAGE_BASE_PATH = "images/";

    private static final int PIG_SIZE = 175;
    private static final int PIGOUT_FONT = 70;
    private static final int LABEL_FONT_SIZE = 24;
    private static final int DICE_SIZE = 100;
    private static final int COMPONENT_SPACING = 10;
    private static final int TEXT_FIELD_SIZE = 20;

    /**
     * constructor for the PigGUI
     * creates and shows the graphical user interface
     * DO NOT MODIFY
     * 
     * @author Mr. Page
     * @version 040910
     */
    public PigGUI()
    {
        enabled = true;
        currentActionCommand = "";
        buttonPushedFlag = false;
        // create an array to hold the dice images
        // ImageIcon[0] will hold the "roll" image        
        diceImages = new ImageIcon[7];
        String diceImage = "die";
        diceImages[0] = createIcon("roll.jpg", DICE_SIZE);
        for(int i = 1; i < 7; i++)
            diceImages[i]=createIcon(diceImage + i + ".jpg", DICE_SIZE);

        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.        
        SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                    createAndShowGUI();
                }
            });
        // wait until the display has been drawn
        try
        {
            while(frame == null || !frame.isVisible())
                Thread.sleep(1);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
            System.exit(1);
        }                 
    }

    /**
     * create the GUI and display it
     * DO NOT MODIFY
     * @author Mr. Page
     * @version 041010
     */
    private void createAndShowGUI()
    {
        frame = new JFrame("PIG OUT");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // create a JPanel with a box layout that will hold the GUI
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.LINE_AXIS));
        JLabel pig = new JLabel(createIcon("pig.png", PIG_SIZE));
        topPanel.add(pig);
        topPanel.add(Box.createHorizontalStrut(COMPONENT_SPACING));
        JLabel pigLabel = new JLabel("PIG OUT!");
        Font labelFont = new Font(Font.MONOSPACED, Font.BOLD,PIGOUT_FONT );
        pigLabel.setFont(labelFont);
        pigLabel.setForeground(Color.PINK);
        topPanel.add(pigLabel);
        // put in a glue element to take up the rest of the space
        topPanel.add(Box.createHorizontalGlue());
        mainPanel.add(topPanel);
        mainPanel.add(Box.createVerticalStrut(COMPONENT_SPACING));
        // add a bottom panel to hold the two buttons and turn indicator
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));
        // create the two buttons
        rollButton = new JButton(diceImages[0]);
        rollButton.addActionListener(this);
        rollButton.setActionCommand("roll");

        holdButton = new JButton(createIcon("hold.jpg", DICE_SIZE));
        holdButton.addActionListener(this);
        holdButton.setActionCommand("hold");

        bottomPanel.add(rollButton);
        bottomPanel.add(Box.createHorizontalStrut(COMPONENT_SPACING));
        bottomPanel.add(holdButton);
        bottomPanel.add(Box.createHorizontalStrut(5 * COMPONENT_SPACING));
        // add a panel to hold the scores
        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new BoxLayout(scorePanel, BoxLayout.PAGE_AXIS));
        player1Score = makeTextField(TEXT_FIELD_SIZE);
        player2Score = makeTextField(TEXT_FIELD_SIZE);
        currentTurnScore = makeTextField(TEXT_FIELD_SIZE);
        setScore(0,0);
        setScore(1,0);
        setScore(2,0);
        labelFont = new Font(Font.MONOSPACED, Font.BOLD, LABEL_FONT_SIZE);
        turnLabel = new JLabel("Player 1");
        turnLabel.setFont(labelFont);
        turnLabel.setForeground(Color.RED);

        scorePanel.add(turnLabel);
        scorePanel.add(Box.createVerticalStrut(COMPONENT_SPACING));
        scorePanel.add(currentTurnScore);
        scorePanel.add(new JLabel("current turn total"));
        scorePanel.add(Box.createVerticalStrut(COMPONENT_SPACING));
        scorePanel.add(player1Score);
        player1Label = new JLabel("Player 1 score");
        scorePanel.add(player1Label);
        scorePanel.add(Box.createVerticalStrut(COMPONENT_SPACING));
        scorePanel.add(player2Score);
        player2Label = new JLabel("Player 2 score");
        scorePanel.add(player2Label);
        scorePanel.add(Box.createVerticalStrut(COMPONENT_SPACING));

        bottomPanel.add(scorePanel);
        bottomPanel.add(Box.createHorizontalGlue());

        mainPanel.add(bottomPanel);
        mainPanel.add(Box.createHorizontalStrut(COMPONENT_SPACING));
        mainPanel.add(Box.createHorizontalGlue());

        //frame.setResizable(false);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setVisible(true);

    }

    /**
     * Action listener method for the buttons
     * DO NOT MODIFY
     * @param evt - the button event string
     * @author Mr. Page
     * @version 041010
     * 
     */
    public void actionPerformed(ActionEvent evt)
    {
        // if buttons are not enabled, do nothing
        if(enabled && !buttonPushedFlag)
        {
            currentActionCommand = evt.getActionCommand();
            buttonPushedFlag = true; 
        }
    }  

    /**
     * create a scaled ImageIcon from the given image
     *      1. create the URI
     *      2. create a buffered image by reading the file specified
     *         by the URI
     *      3. scale the buffered image and create an Image reference 
     *         (note that Image is an interface)
     *      4. create an ImageIcon containing the image
     *      5. return the ImageIcon
     * The Image is scaled to the given height, maintaining the
     * aspect ratio
     * An ImageIcon cannot be directly scaled
     * @param fileName - the file name of the image which must be in
     *                   the IMAGE_BASE_PATH directory
     * @param imageHeight - the scaled height in pixels
     * @author Mr. Page
     * @version 040910
     * 
     */
    private ImageIcon createIcon(String fileName, int imageHeight)
    {
        URI theURI = null;
        Image theImage = null;
        try
        {
            theURI = getClass().getResource(IMAGE_BASE_PATH + fileName).toURI();
            BufferedImage bImage = ImageIO.read(new File(theURI));
            // scale the image and maintain the aspect ratio
            theImage = bImage.getScaledInstance(imageHeight, -1,Image.SCALE_DEFAULT );
        }
        catch(IOException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        catch (URISyntaxException e)
        {
            throw new RuntimeException("malformed URI " + theURI);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        return new ImageIcon(theImage);        

    }

    /**
     * make a text field component of the specified width
     * 
     * @author Mr.Page
     * @version 041010
     * @param width the width of the text field in characters
     */
    private JTextField makeTextField(int width)
    {
        JTextField theField = new JTextField(width);
        theField.setEditable(false);
        theField.setBackground(Color.WHITE);
        theField.setOpaque(true);
        theField.setMaximumSize(theField.getPreferredSize());
        theField.setHorizontalAlignment(JTextField.RIGHT);
        return theField;
    }

    // USER CALLABLE METHODS
    // use the following methods to customize and update the GUI

    /**
     * set the score text area
     * @author Mr. Page
     * @version 041010
     * @param player identifies which player text field to change
     *          0 indicates the  current turn score filed
     *          1 indicates player1's score
     *          2 indicates player2's score
     * @param score  the new score
     * 
     * precondition: player must be an integer in [0,2]
     *               score must be greater than or equal to 0
     * postcondition: the corresponding text box is set              
     * 
     */
    public void setScore(int player, int score)
    {
        if(player == 0)currentTurnScore.setText("" + score);
        else if(player == 1) player1Score.setText("" + score);
        else if(player == 2) player2Score.setText("" + score);
        else throw new IllegalArgumentException("invalid player" + player);

    }

    /**
     * set the roll button image
     * @param imageNumber a number in the range [0,diceImages.length -1] which
     *          indicates which image in the diceImage array to show
     * @author Mr. Page
     * @version 041010
     */
    public void setDieImage(int imageNumber)
    {
        if(imageNumber < 0 || imageNumber >= diceImages.length) 
        // tell user and die
            throw new IllegalArgumentException("invalid image selected " + imageNumber);

        rollButton.setIcon(diceImages[imageNumber]);
    }

    /**
     * 
     * setDieImage overridden so that user can set their own ImageIcon
     * @param image the image to display.  The image is scaled to fit
     * @author Mr. Page
     * @version 041010
     * 
     */
    public void setDieImage(Image image)
    {
        ImageIcon theImage =
            new ImageIcon(image.getScaledInstance(DICE_SIZE, -1,Image.SCALE_DEFAULT ));
        rollButton.setIcon(theImage);
    }

    /**
     * change the turnLabel text
     * @param text is the new label text
     * @author Mr. Page
     * @version 041010
     */
    public void setTurnLabel(String text)
    {
        turnLabel.setText(text);
    }

    /**
     * enable or disable the buttons
     * @param enable set true to enable button presses false to disable
     * @author Mr. Page
     * @version 041010
     */
    public void enableButtons(boolean enable)
    {
        enabled = enable;
    }

    /**
     * wait for a button press, return the currentActionCommand
     * @return the action command for the button that was pressed
     *         "roll" for the roll button
     *         "hold" for the hold button
     * @author Mr. Page
     * @version 041010
     * precondition: buttons must be enabled (or it will wait forever)
     */
    public String waitForButtonPress()
    {
        try
        {
            while(!buttonPushedFlag)
            {
                Thread.sleep(100);
            }
        }
        catch (InterruptedException e)
        {
            // dump stack trace and die
            e.printStackTrace();
            System.exit(1);
        }
        buttonPushedFlag = false;
        return currentActionCommand;

    }

    /**
     * set the labels for the scores
     * @param player1 is a string that will be displayed with the player 1 score
     * @param player2 is a string that will be displayed with the player 2 score
     * @author Mr. Page
     * @version 041010
     */
    public void setPlayerNames(String player1, String player2) 
    {
        player1Label.setText(player1 + " score");
        player2Label.setText(player2 + " score");
    }

}
