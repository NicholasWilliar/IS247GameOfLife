/**
* IS 247 Game of Life Project
* Katarina Nitz & Nicholas Williar
* Controller Code
*/

public class GameController
	implements QueryListener {
		private GameViewInterface view;
		private GameModelInterface model;
		
		public GameController(GameViewInterface view, GameModelInterface model) {
			this.view = view;
			this.model = model;
			
			view.setIntroduction("--------------------------------------------------------------------------------\n" +
                		"Welcome to the John Conway's Game of Life\n" +
                		"by Katarina Nitz and Nicholas Williar\n" +
                		"The Game of Life is a zero-player game in which a starting grid-based\n" +
                		"pattern evolves based on the following set of three rules:\n" +
                		"1) Birth: A dead cell with exactly three live neighbors becomes a live cell.\n" +
                		"2) Survival: A live cell with two or three live neighbors stays alive.\n" +
                		"3) Overcrowding/ Loneliness: In all other cases, a cell dies or remains dead.\n" +
                		"Follow the prompts to play.\n" +
               			"Enjoy!\n" +
                		"--------------------------------------------------------------------------------\n");
			
			view.setHeightPrompt("Enter height: ");
			view.setWidthPrompt("Enter width: ");
			view.setLivePrompt("Enter live character: ");
			view.setDeadPrompt("Enter dead character: ");
			view.setDelimiterPrompt("Enter delimiter character: ");
			view.setGenPrompt("Enter number of generations: ");
			view.setSleepPrompt("Enter time between generations (ms): ");
			view.setPatternPrompt("Enter a pattern name from the list below:\n" +
                		"Glider.pat\n" +
                		"GliderGun.pat\n" +
                		"Exploder.pat\n" +
                		"10CellRow.pat\n" +
                		"Spaceship.pat\n" +
                		"Tumbler.pat");
			view.setListener(this);
			
			view.setConclusion("Thank you for playing!");
			
			view.show();
		}
		
		int generations;
		int curGen = 1;
		
		//QueryListener methods
		public void heightEntered(int h) {
			model.setHeight(h);
		}
		public void widthEntered(int w) {
			model.setWidth(w);
		}
		public void liveEntered(char l) {
			model.setLive(l);
		}
		public void deadEntered(char d) {
			model.setDead(d);
		}
		public void delimiterEntered(char del) {
			view.setDelimiter(del);
		}
		public void genEntered(int g) {
			this.generations = g;
		}
		public void sleepEntered(int s) {
			model.setSleep(s);
		}
		public void patternEntered(String p) {
			model.setPattern(p);
			view.setCurGen(curGen);
			view.displayGen(model.createGrid());
			for(int i = 0; i < generations - 1; i++) {
				curGen++;
				view.setCurGen(curGen);
				view.displayGen(model.gameGeneration());
			}
		}

		public static void main(String[] args) {
			if (args.length < 2) {
				System.out.println("Usage: java GameController <ViewClassName> <ModelClassName>");
				return;
			}
			try {
				new GameController(
				(GameViewInterface)Class.forName(args[0]).getDeclaredConstructor().newInstance(),
				(GameModelInterface)Class.forName(args[1]).getDeclaredConstructor().newInstance());
			} catch (Exception e) {
				System.out.println("Invalid class name.");
				e.printStackTrace();
			}
		}
	}
