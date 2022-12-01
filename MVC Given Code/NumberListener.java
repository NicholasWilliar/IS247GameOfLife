/**
 * file: NumberListener.java
 *
 * LISTING 4
 *
 * NumberListener is implemented by the MVC controller
 *
 * Any class that wants to use a view in the framework implements
 * NumberListener. This allows the view to be plug and play with
 * other classes.
 *
 * The actual view, whether text based or GUI based, will contain
 * an object that implements NumberListener. In the MVC architecture,
 * the model and view do not communicate directly. Therefore, the
 * controller that wants to use a view, must implement
 * NumberListener.
 *
 * This architecture allows the instance in the view class
 * to be based on an interface rather than a specific class
 */

public interface NumberListener {
    /** number has been entered */
    void numberEntered(int n);

    /** user wants to quit */
    void quit();
}
