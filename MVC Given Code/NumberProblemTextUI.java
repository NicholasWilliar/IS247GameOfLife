/**
 * file: NumberProblemTextUI.java
 *
 * LISTING 6
 *
 * The text based concrete view class. All views in this framework
 * implement the NumberProblemView interface
 *
 * In this framework the MVC  controller "has a" NumberProblemView. The
 * controller can communicate with any NumberProblemView. Every view
 * "has a" NumberListener which is implemented by the controller. Notice
 * how the views and controllers communicate solely via interfaces.
 *
 * javac -classpath . NumberProblemTextUI.java
 */

import java.io.*;

public class NumberProblemTextUI implements NumberProblemView {

    String prompt = "", outputDescription= "", problemName = "";
    // the controller "is a" NumberListener
    NumberListener listener = null;

    public NumberProblemTextUI() {}

    protected String getPrompt() {
        return prompt;
    }

    public void show() {
        int number, answer;
        boolean completed = false;

        while (!completed) {
            System.out.println(getProblemName());
            System.out.print(getPrompt());
            number = readInt();
            listener.numberEntered(number);
            System.out.print("Want to solve another problem?  (1=yes      0=no) : ");
            answer = readInt();
            if (answer == 0) {
                completed = true;
                listener.quit();
            }
        }//while
    }//show

    public void displayResult(Object obj) {
        System.out.println("");
        System.out.print(getOutputDescription());
        System.out.println(obj);
    }

    public void setInputPrompt(String prompt) {
        this.prompt = prompt;
    }

    public void setOutputDescription(String description) {
        outputDescription = description;
    }

    public void setListener(NumberListener listener) {
        this.listener = listener;
    }

    public void setProblemName(String name) {
        problemName = name;
    }

    protected String getOutputDescription() {
        return outputDescription;
    }

    // this method saved from the original non OO solution
    protected static int readInt() {
        int ch;
        String inString = "";
        try {
            while (((ch = System.in.read()) >= 0) && (
                    ch != '\n'))
                inString = inString + (char) ch;
            return Integer.valueOf(inString.trim()).intValue();
        }
        catch(Exception e) {}
        return 0;
    }

    public String getProblemName() {
        return problemName;
    }

}///:~