/**
* IS 247 Game of Life Project
* Katarina Nitz & Nicholas Williar
* Model Code
*/

public class GameModel 
	implements GameModelInterface {
		private int height;
		private int width;
		private char liveCell;
		private char deadCell;
		private int generations;
		private int sleepTime;
		private char[][] gen1;
		private char[][] gen2;
		
		//Default constructor.
		public GameModel() {
			height = 10;
			width = 10;
			liveCell = "*";
			deadCell = " ";
			generations = "20";
			sleepTime = "250";
		}
		
		//Constructor with arguments.
		public GameModel(int h, int w, char l, char d, int g, int s) {
			setHeight(h);
			setWidth(w);
			setLiveCell(l);
			setDeadCell(d);
			setGenerations(g);
			setSleepTime(s)
		}
		
		//Setters.
		public void setHeight(int h) {
			this.height = h;
		}
		public void setWidth(int w) {
			this.width = w;
		}
		public void setLive(char l) {
			this.liveCell = l;
		}
		public void setDead(char d) {
			this.deadCell = d;
		}
		public void setGenerations(int g) {
			this.generations = g;
		}
		public void setSleepTime(int s) {
			this.sleepTime = s;
		}
		
		//Copy pattern into center of 2D array. HOW?
		
		//Executing game of life for specified number of generations.
		
		public char[][] gameGeneration() {
			//Create 2D arrays for current gen and next gen.
			gen1 = new char[height][width];
			gen2 = new char[height][width];
			
			//Executing game of life for specified number of generations.
			for(int k = 0; k < generations; k++) {
				//Iterating through 2D array (one generation for game of life)
				for(int i = 0; i < gen1.length; i++) {
					for(int j = 0; j < gen1[i].length; j++) {
						//Count live neighbors while checking for edges.
						int count = 0;
						int minRow;
						int maxRow;
						int minCol;
						int maxCol;
				
						//Checking for top edge.
						if(gen1[i] == 0) {
							minRow = gen1[i];
						} else {
							minRow = gen1[i] - 1;
						}
						//Checking for bottom edge.
						if(gen1[i] == gen1.length - 1) {
							maxRow = gen1[i];
						} else {
							maxRow = gen1[i] + 1;
						}
						//Checking for left edge.
						if(gen1[j] == 0) {
							minCol = gen1[j];
						} else {
							minCol = gen1[j] - 1;
						}
						//Checking for right edge.
						if(gen1[j] == gen1[i].length - 1) {
							maxCol = gen1[j];
						} else {
							maxCol = gen1[j] + 1;
						}
				
						//Counting live neighbors.
						for(m = minRow; m < maxRow + 1; m++) {
							for(n = minCol; n < maxCol + 1; n++) {
								if(gen1[i][j].equals(liveCell)) {
									count++;
								}
							}
						}
						
						//Account for adding self and inflating count.
						if(gen1[i][j].equals(liveCell)) {
							count--;
						}
				
						//Birth, survival, and overcrowding/loneliness rules executed.
						if(count == 3 && !gen1[i][j].equals(liveCell)) {
							gen2[i][j] = liveCell;
						} else if ((count == 2 || count == 3) && gen1[i][j].equals(liveCell)) {
							gen2[i][j] = liveCell;
						} else {
							gen2[i][j] = deadCell;
						}
					}
				}
				
				return gen2;
			}
			//Wipe gen1 and copy gen2 into gen1.
			gen1 = new char[height][width]
			for(int i = 0; i < gen2.length; i++) {
				for(int j = 0; j < gen2[i].length; j++) {
					gen1[i][j] = gen2[i][j];
				}
			}
			
			//Sleep program for designated time.
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}