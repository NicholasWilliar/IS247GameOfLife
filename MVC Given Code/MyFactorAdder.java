/**
 * file: MyFactorAdder.java
 *
 * LISTING 9
 *
 * A model that plugs into the framework. Like the prime
 * number model, this model implements the NumberProblemModel
 * interface
 * Computes the sum of all the divisors of a given number
 *
 */

public class MyFactorAdder implements NumberProblemModel {
    int number;

    public MyFactorAdder() {
        number = 0;
    }

    public Object solve() {
        int sum;
        if (number < 1)
            sum = 0;
        else if (number == 1)
            sum = 1;
        else {
            sum = number + 1;
            int f, d;
            for (d = 2; (d * d < number); d++)
                if (number % d == 0)
                    sum += (d + number/d);
            if (d * d == number) sum += d;
        }
        return Integer.valueOf(sum);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getProblemName() {
        return "Factor adder";
    }

}///:~