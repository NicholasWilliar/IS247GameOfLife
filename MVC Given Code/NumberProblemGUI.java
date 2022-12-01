/**
 * file: NumberProblemGUI.java
 *
 * LISTING 8
 *
 * A GUI based view that works in this framework
 *
 * Like the text based view, this GUI view implements NumberProblemView
 * and "has a" NumberListener
 *
 * javac -classpath . NumberProblemGUI.java
 *
 */


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberProblemGUI extends Frame implements NumberProblemView,
        ActionListener  {
    Label inputPrompt = new Label();
    TextField numberField = new TextField(10);
    Button okButton = new Button();
    Button quitButton = new Button();
    Label outputDescription = new Label();
    TextField outputField = new TextField(10);
    NumberListener listener = null;
    NumberProblemGUI app = this;

    public void displayResult(Object obj) {
        outputField.setText("" + obj);
    }

    public void setInputPrompt(String prompt) {
        inputPrompt.setText(prompt);
    }

    public void setOutputDescription(String description) {
        outputDescription.setText(description);
    }

    public void setListener(NumberListener listener) {
        this.listener = listener;
    }

    public NumberProblemGUI()  {
        setSize(new Dimension(530, 96));
        okButton.setLabel("Perform");
        quitButton.setLabel("Quit");
        setLayout(new FlowLayout());
        add(inputPrompt, null);
        add(numberField, null);
        add(okButton, null);
        add(quitButton, null);
        add(outputDescription, null);
        add(outputField, null);
        okButton.addActionListener(this);
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                listener.quit();
                app.dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            // WAS
            //int number = (new Integer(numberField.getText())).valueOf();
            int number = Integer.parseInt(numberField.getText());
            listener.numberEntered(number);
        } catch (Exception e) {}
    }

    public void setProblemName(String name) {
        setTitle(name);
    }

}///:~


