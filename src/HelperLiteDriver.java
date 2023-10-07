import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HelperLiteDriver extends JFrame implements ActionListener {

    // Creates instances of each class
    BasicCalculator bCalc = new BasicCalculator();
    BasicConversation bConvo = new BasicConversation();
    DateAndTime dateATime = new DateAndTime();
    ToDoList tdList = new ToDoList();

    // creates new panel for GUI
    JPanel mainHub = new JPanel();

    // Creates buttons for main functions
    JButton calc = new JButton("Calculate");
    JButton convo = new JButton("Converse");
    JButton dateTime = new JButton("Date/Time");
    JButton toDo = new JButton("To Do List");

    // Creates Color object for background color
    Color backgColor = new Color(135,206,235);

    // Creates a text are for text to appear in
    JTextArea instructions = new JTextArea("  Help will show up here.  ");

    // Multipurpose user input text field
    JTextField userInput = new JTextField(20);

    // Mulitpurpose text area for all results + scroll pane for overflow
    JTextArea resultsArea = new JTextArea(8, 50);
    JScrollPane pane = new JScrollPane(resultsArea);

    // Submit buttons to link to userInput; need to add ActionListeners to each one in constructor
    JButton calcSubmitInput = new JButton("  Submit  ");
    JButton convoSubmitInput = new JButton("  Submit  ");
    JButton datSubmitInput = new JButton("  Submit  ");
    JButton toDoSubmitInput = new JButton("  Submit  ");
    JButton toDoRemoveInput = new JButton("  Remove  ");

    // Stores user input for each class
    String calcStore;
    String responseStore;
    String datStore;
    String toDoStore;

    // Constructor to set up GUI (all the details go in here; it's like the main method for the GUI)
    public HelperLiteDriver() {
        // sets title, window size, exit functionality, and visibility
        super("HelperLite");
        setSize(520, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(mainHub);
        setVisible(true);

        // changes background color of mainhub
        mainHub.setBackground(backgColor);

        // Gives all buttons functionality
        calc.addActionListener(this);
        convo.addActionListener(this);
        dateTime.addActionListener(this);
        toDo.addActionListener(this);
        calcSubmitInput.addActionListener(this);
        convoSubmitInput.addActionListener(this);
        datSubmitInput.addActionListener(this);
        toDoSubmitInput.addActionListener(this);
        toDoRemoveInput.addActionListener(this);

        // adds main buttons to mainhub
        mainHub.add(calc);
        mainHub.add(convo);
        mainHub.add(dateTime);
        mainHub.add(toDo);

        // adds text field for event listener to respond to later
        mainHub.add(instructions);

        // adds main text area
        mainHub.add(pane);        
    }

    // Sets up actions for various button clicks
    public void actionPerformed(ActionEvent e) {
        // actions for calc click
        if (e.getSource() == calc) {
            instructions.setText("  Enter the problem in the text field next to the submit button.  \n  A result of -1 may mean you entered an invalid character.");

            //removes all previously created submit/remove buttons first
            mainHub.remove(calcSubmitInput);
            mainHub.remove(convoSubmitInput);
            mainHub.remove(datSubmitInput);
            mainHub.remove(toDoSubmitInput);
            mainHub.remove(toDoRemoveInput);
            mainHub.revalidate();
            mainHub.repaint();
            
            // sets up text field to take in string, then a submit button
            mainHub.add(userInput);

            // submit button
            mainHub.add(calcSubmitInput);

            // to reset text in text area
            resultsArea.setText("  Answers:\n");
        }

        // submit button functionality for calculator
        if (e.getSource() == calcSubmitInput) {
            calcStore = userInput.getText();
            calcStore =  Double.toString(bCalc.solve(calcStore));
            resultsArea.append("  " + calcStore + "\n");
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // actions for conversation click
        if (e.getSource() == convo) {
            instructions.setText("  Enter your response in the text field next to the submit button.  ");

            //removes all previously created submit/remove buttons first
            mainHub.remove(calcSubmitInput);
            mainHub.remove(convoSubmitInput);
            mainHub.remove(datSubmitInput);
            mainHub.remove(toDoSubmitInput);
            mainHub.remove(toDoRemoveInput);
            mainHub.revalidate();
            mainHub.repaint();
            
            // sets up text field to take in string, then a submit button
            mainHub.add(userInput);

            // submit button
            mainHub.add(convoSubmitInput);

            // to reset text in text area and begin conversation
            resultsArea.setText("  " + bConvo.initialStatement() + "\n\n");
        }

        // submit button functionality for basic conversation
        if (e.getSource() == convoSubmitInput) {
            responseStore = userInput.getText();
            responseStore =bConvo.evaluateResponseAndReply(responseStore);
            resultsArea.append("  " + responseStore + "\n\n");
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        // actions for date and time click
        if (e.getSource() == dateTime) {
            instructions.setText("  Enter \"date\" and/or \"time\" in the text field next to the submit button.  ");

            //removes all previously created submit/remove buttons first
            mainHub.remove(calcSubmitInput);
            mainHub.remove(convoSubmitInput);
            mainHub.remove(datSubmitInput);
            mainHub.remove(toDoSubmitInput);
            mainHub.remove(toDoRemoveInput);
            mainHub.revalidate();
            mainHub.repaint();
            
            // sets up text field to take in string, then a submit button
            mainHub.add(userInput);

            // submit button
            mainHub.add(datSubmitInput);

            // to reset text in text area
            resultsArea.setText("");
        }

        // submit button functionality for date and time
        if (e.getSource() == datSubmitInput) {
            datStore = userInput.getText();
            datStore = dateATime.determineDateTime(datStore);
            resultsArea.append(datStore + "\n\n");
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // actions for to do list click
        if (e.getSource() == toDo) {
            instructions.setText("  To add an item to the To Do List, enter the item and press submit.  ");

            //removes all previously created submit/remove buttons first
            mainHub.remove(calcSubmitInput);
            mainHub.remove(convoSubmitInput);
            mainHub.remove(datSubmitInput);
            mainHub.remove(toDoSubmitInput);
            mainHub.remove(toDoRemoveInput);
            mainHub.revalidate();
            mainHub.repaint();
            
            // sets up text field to take in string, then a submit button
            mainHub.add(userInput);

            // submit button and remove button
            mainHub.add(toDoSubmitInput);
            mainHub.add(toDoRemoveInput);

            // to reset text in text area
            resultsArea.setText("  To Do:\n");
        }

        // submit button functionality for adding an item
        if (e.getSource() == toDoSubmitInput) {
            toDoStore = userInput.getText();
            tdList.addItem(toDoStore);

            // prints the list to text area, but resets it first to remove dupicate items
            resultsArea.setText("  To Do:\n");
            for (int i=0; i < tdList.getList().size(); i++) {
                resultsArea.append("  " + tdList.getList().get(i) + "\n");
            }
        }

        // remove button functionality for removing an item
        if (e.getSource() == toDoRemoveInput) {
            toDoStore = userInput.getText();
            tdList.removeItem(toDoStore);
            // prints the list to text area, but resets it first to remove dupicate items
            resultsArea.setText("  To Do:\n");
            for (int i=0; i < tdList.getList().size(); i++) {
                resultsArea.append("  " + tdList.getList().get(i) + "\n");
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        // (Functionally) tells the window to load up when running the project
        HelperLiteDriver gui = new HelperLiteDriver();
    }
}