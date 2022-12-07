/**
 * IS 247 Game of Life Project
 * Katarina Nitz & Nicholas Williar
 * View Code
 */
import java.util.Scanner;

public class GameView implements GameViewInterface {
    String heightPrompt = "";
    String widthPrompt = "";
    String livePrompt = "";
    String deadPrompt = "";
    String delimiterPrompt = "";
    String genPrompt = "";
    String sleepPrompt = "";
    String patternPrompt = "";
	char delimiter;
	int generations;

    QueryListener queryListener = null;
	
	Scanner sc = new Scanner(System.in);
	
	public GameView() {}

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
	
	public void setDelimiter(char del) {
		this.delimiter = del;
	}

    public void setGenPrompt (String g) {
        this.genPrompt = g;
    }
	
	public void setGenerations(int gen) {
		this.generations = gen;
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
	
	//Get prompts.
	public String getHeightPrompt() {
		return heightPrompt;
	}
	
	public String getWidthPrompt() {
		return widthPrompt;
	}
	
	public String getLivePrompt() {
		return livePrompt;
	}
	
	public String getDeadPrompt() {
		return deadPrompt;
	}
	
	public String getDelimiterPrompt() {
		return delimiterPrompt;
	}
	
	public char getDelimiter() {
		return delimiter;
	}
	
	public String getGenPrompt() {
		return genPrompt;
	}
	
	public int getGenerations() {
		return generations;
	}
	
	public String getSleepPrompt() {
		return sleepPrompt;
	}
	
	public String getPatternPrompt() {
		return patternPrompt;
	}

    // show/display
    public void show() {
        int height;
		int width;
		char live;
		char dead;
		char delimiter;
		int gen;
		int sleep;
		String pattern;
        String input = "";
        boolean exit = false;

       // while (!exit) {
            System.out.println(getHeightPrompt());
			height = sc.nextInt();
			queryListener.heightEntered(height);
			
			System.out.println(getWidthPrompt());
			width = sc.nextInt();
			queryListener.widthEntered(width);
			
			System.out.println(getLivePrompt());
			live = sc.next().charAt(0);
			queryListener.liveEntered(live);
			
			System.out.println(getDeadPrompt());
			dead = sc.next().charAt(0);
			queryListener.deadEntered(dead);
			
			System.out.println(getDelimiterPrompt());
			delimiter = sc.next().charAt(0);
			
			System.out.println(getGenPrompt());
			gen = sc.nextInt();
			queryListener.genEntered(gen);
			
			System.out.println(getSleepPrompt());
			sleep = sc.nextInt();
			queryListener.sleepEntered(sleep);
			
			System.out.println(getPatternPrompt());
			pattern = sc.next();
			queryListener.patternEntered(pattern);
			
          /*  System.out.println("Play again? (Y/N)");
            if (input.equalsIgnoreCase("n")) {
				exit = true;
				queryListener.quit();
			} //if
        } // while*/
    } // show()
	/* the example mvc number problem uses getters here and the listener
	but i'm not sure that's necessary? */

    public void displayGen(char[][] g) {
		System.out.println("Game of Life - Generation: " + 2);
        for(int row = 0; row < g.length; row++) {
            for(int column = 0; column < g[row].length; column++) {
                System.out.print(g[row][column] + "  ");
            } // columns
			System.out.println();
        } // rows
	
	//display delimiter
	char[] delimiterArray = new char[g.length];
        for (char c:delimiterArray){
            delimiter[c] = delimiter;
            System.out.print(delimiter[c]);
        }
    } // displayGen
} // end	
