/**
 * file: NumberProblemController.java
 *
 * LISTING 7
 *
 * The controller class. This class decouples the models from the views.
 * The controller has the following interesting characteristics:
 *
 * 	controller "is a" NumberListener (all views "have a" NumberListener)
 * 	controller "has a" NumberProblemModel
 *  controller "has a" NumberProblemView
 * This allows the same controller to work with multiple views and
 * multiple problems
 *
 * The controller class contains a main to start up the application
 * This controller takes two command line arguments which specify
 * the view and the model to use. Note the use of Class.forName() to
 * create instances of classes based on the text args from the command
 * line
 *
 * Sample usage: java NumberProblemController NumberProblemTextUI MyPrimeTester
 *
 * Use GUI
 * java NumberProblemController NumberProblemGUI MyPrimeTester
 *
 * Update for deprecation
 * https://devdocs.io/openjdk~15/java.base/java/lang/class#newInstance()
 * newInstance deprecated
 * Use clazz.getDeclaredConstructor().newInstance()
 */


public class NumberProblemController implements NumberListener {

    // Controller has a model and a view member
    private NumberProblemView view;
    private NumberProblemModel model;

    public NumberProblemController(NumberProblemView view,
                                   NumberProblemModel model) {
        this.view = view;
        this.model = model;
        view.setInputPrompt("Enter number : ");
        view.setOutputDescription("Result : ");
        view.setListener(this);
        view.setProblemName(model.getProblemName());
        view.show();
    }


    /* NumberListener method */
    public void numberEntered(int number) {
        model.setNumber(number);
        view.displayResult(model.solve());
    }

    /* NumberListener method */
    public void quit() {
        view = null;
        model = null;
        System.exit(0);
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage : java NumberProblemController " +
                    "<ViewClassName> <ModelClassName>");
            return;
        }
        /// update for deprecation
        try {
            new NumberProblemController(
                    (NumberProblemView)Class.forName(args[0]).getDeclaredConstructor().newInstance(),
                    (NumberProblemModel)Class.forName(args[1]).getDeclaredConstructor().newInstance());
		/*
		WAS
		new NumberProblemController(
		(NumberProblemView)Class.forName(args[0]).newInstance(),
        (NumberProblemModel)Class.forName(args[1]).newInstance());
        */
        } catch (Exception e) {
            System.out.println("Invalid class name supplied");
            e.printStackTrace();
        }

    }//main

}///:~
