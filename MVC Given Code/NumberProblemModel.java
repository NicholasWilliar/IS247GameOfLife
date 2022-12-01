/**
 * file NumberProblemModel.java
 *
 * LISTING 2
 *
 * Develop the model classes as components that can be plugged
 * into a framework. Rather than developing the model class
 * in isolation develop an interface that all concrete
 * model classes must implement.
 *
 * For a model to plug into this framework ,
 * it must implement this NumberProblemModel interface. The
 * implementation details of each specific model are encapsulated
 * by that concrete class. The class that *uses* the model only needs
 * to know about this interface.
 *
 * Notice that the solve() method returns type Object
 *
 * javac MyPrimeTester.java
 *
 */

public interface NumberProblemModel {

    /** solve the problem and return the result as an Object */
    Object solve();

    /** set the number for the problem */
    void setNumber(int n);

    /** return the problem name */
    String getProblemName();
}