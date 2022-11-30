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
			view.setHeightPrompt("Enter height: ");
			view.setWidthPrompt("Enter width: ");
			view.setLivePrompt("Enter live character: ");
			view.setDeadPrompt("Enter dead character: ");
			view.setDelimiterPrompt("Enter delimiter character: ");
			view.setGenPrompt("Enter number of generations: ");
			view.setSleepPrompt("Enter time between generations (ms): ");
			view.setListener(this);
			view.show();
		}
		
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
			model.setDelimiter(del);
		}
		public void genEntered(int g) {
			model.setGenerations(g);
		}
		public void sleepEntered(int s) {
			model.setSleepTime(s);
			view.displayGen(model.gameGeneration());
		}
		
		public static void main(String[] args) {
			if (args.length < 2) {
				System.out.println("Usage: java GameController <ViewClassName> <ModelClassName>");
				return;
			}
			try {
				new GameController(
				(GameViewInterface)Class.forName(args[0]).getDeclaredConstructor().newInstance(),
				(GameModelInterface)Class.forName(args[1]).getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				System.out.println("Invalid class name.");
				e.printStackTrace();
			}
		}
	}
