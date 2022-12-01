/**
 * file : MyPrimeTester.java
 *
 * LISTING 3
 *
 * A concrete model class. This model determines if
 * a number is prime.
 *
 * To fit into the framework we are designing in this example,
 * the model implements the NumberProblemModel interface.
 *
 * The solve() method returns type Object, which allows different
 * types of problems to return different types of results.
 *
 * The getProblemName() method allows the model to identify itself
 *
 */

public class MyPrimeTester implements NumberProblemModel {

    private int number;

    public MyPrimeTester() {
        number = 0;
    }

    public MyPrimeTester(int number) {
        setNumber(number);
    }

    public Object solve() {
        if (number <= 1)
            return Boolean.valueOf(false);
        if (number <= 3)
            return Boolean.valueOf(true);
        if (number % 2 == 0)
            return Boolean.valueOf(false);
        int j = 3;
        while ((j*j < number) && (number % j != 0))
            j += 2;
        if (j*j > number)
            return Boolean.valueOf(true);
        return Boolean.valueOf(false);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getProblemName() {
        return("Primality tester");
    }

}///:~