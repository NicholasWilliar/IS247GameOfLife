/**
* IS 247 Game of Life Project
* Katarina Nitz & Nicholas Williar
* View Code
*/

public class GameView implements GameViewInterface {
	String heightPrompt = "";
    	String widthPrompt = "";
    	String livePrompt = "";
    	String deadPrompt = "";
    	String delimiterPrompt = "";
    	String genPrompt = "";
    	String sleepPrompt = "";
    	String patternPrompt = "";

    	QueryListener queryListener = null;

    	// set prompts
    	public void setHeightPrompt(String h){
        	this.heightPrompt = h;
    	}

    	public void setWidthPrompt(String w){
        	this.widthPrompt = w;
    	}

    	public void setLivePrompt (String l){
        	this.livePrompt = l;
    	}

    	public void setDeadPrompt (String d){
        	this.deadPrompt = d;
    	}

    	public void setDelimiterPrompt (String del) {
        	this.delimiterPrompt = del;
    	}

    	public void setGenPrompt (String g) {
        	this.genPrompt = g;
    	}

    	public void setSleepPrompt (String s) {
        	this.sleepPrompt = s;
    	}

    	public void setPatternPrompt (String p) {
        	this.patternPrompt = p;
    	}

    	public void setListener(QueryListener ql){
        	this.queryListener = ql;
    	}

    	// show/display
    	public void show() {
        	// here is where we may need to use getters?
        	String input = "";
        	boolean exit = false;

        	while (!exit) {
            	// and here?
            		System.out.println("Play again? Y/N");
            		if (input.equalsIgnoreCase("y"));
                		exit = true;

        	} // while
    	} // show()
	/* the example mvc number problem uses getters here and the listener
	but i'm not sure that's necessary? */

    	public void displayGen(char[][] g) {
        	for(int row = 0; row < g.length; row++) {
            		for(int column = 0; column < g[row].length; column++) {
                		System.out.print(g[row][column] + " ");
            		} // columns
       		} // rows
    	} // displayGen
} // end	



		/*Reference
		
		//Printing current gen array.
		for(int row = 0; row < gen1.length; row++) {
			for(int column = 0; column < gen1[row].length; column++) {
				System.out.print(gen1[row][column] + " ");
			}
			System.out.println();
		}
		*/
