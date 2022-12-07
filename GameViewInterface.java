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
	int curGen;

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
	
	public void setCurGen(int gen) {
		this.curGen = gen;
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
	protected String getHeightPrompt() {
		return heightPrompt;
	}
	
	protected String getWidthPrompt() {
		return widthPrompt;
	}
	
	protected String getLivePrompt() {
		return livePrompt;
	}
	
	protected String getDeadPrompt() {
		return deadPrompt;
	}
	
	protected String getDelimiterPrompt() {
		return delimiterPrompt;
	}
	
	protected char getDelimiter() {
		return delimiter;
	}
	
	protected String getGenPrompt() {
		return genPrompt;
	}
	
	protected int getCurGen() {
		return curGen;
	}
	
	protected String getSleepPrompt() {
		return sleepPrompt;
	}
	
	protected String getPatternPrompt() {
		return patternPrompt;
	}

    // show/display
    public void show() {
        int height;
		int width;
		char live;
		char dead;
		int gen;
		int sleep;
		String pattern;
        String input = "";
        boolean exit = false;

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
    } // show()
	
    public void displayGen(char[][] g) {
		System.out.println("Game of Life - Generation: " + getCurGen());
        for(int row = 0; row < g.length; row++) {
            for(int column = 0; column < g[row].length; column++) {
                System.out.print(g[row][column] + "  ");
            } // columns
			System.out.println();
        } // rows
		//Print delimiter.
		for(int i = 0; i < (g.length * 3); i++) {
			System.out.print(getDelimiter());
		}
		System.out.println();
    } // displayGen
} // end	
