/**
 * file: NumberProblemView.java
 *
 * LISTING 5
 *
 * All views implement the NumberProblemView interface
 * Just as all views "have a" instance of NumberListener
 * all controller classes will "have a" instance of NumberProblemView
 *
 * javac -classpath . NumberProblemView.java
 */

public interface NumberProblemView{
    /** present the UI */
    void show();

    void displayResult(Object obj);

    /** set the prompt the UI presents */
    void setInputPrompt(String p);

    /** set the text describing the output */
    void setOutputDescription(String s);

    /* set the listener to be notified
       of events. The Listener is the
       MVC controller */
    void setListener(NumberListener nl);

    void setProblemName(String s);
}