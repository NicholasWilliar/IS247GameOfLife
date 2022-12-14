/**
 * IS 247 Game of Life Project
 * Katarina Nitz & Nicholas Williar
 * Model Code
 */
import java.util.*;
import java.io.*;

public class GameModel
        implements GameModelInterface {
    private int height;
    private int width;
    private char liveCell;
    private char deadCell;
    private int sleepTime;
    private String pattern;
    private char[][] gen1;
    private char[][] gen2;

    //Default constructor.
    public GameModel() {
        height = 10;
        width = 10;
        liveCell = '*';
        deadCell = ' ';
        sleepTime = 250;
        pattern = "Glider.pat";
    }

    //Constructor with arguments.
    public GameModel(int h, int w, char l, char d, int g, int s, String p) {
        setHeight(h);
        setWidth(w);
        setLive(l);
        setDead(d);
        setSleep(s);
        setPattern(p);
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
    public void setSleep(int s) {
        this.sleepTime = s;
    }
    public void setPattern(String p) {
        this.pattern = p;
    }

    //Create game board and copy pattern into center of 2D array.
    public char[][] createGrid() {
        String line;
        int count = 0;

        //Create 2D arrays for current gen and next gen.
        gen1 = new char[height][width];
        gen2 = new char[height][width];

        //Fill gen2 array with dead cells.
        for (char[] row: gen2) {
            Arrays.fill(row, deadCell);
        }

        //Create cursors to mark rough center of 2D array.
        int hCursor = 0;

        //Handle exception.
        try {
            //Create scanner to scan through pattern file.
            Scanner fileScan = new Scanner (new File(pattern));

            //Set pattern in rough center of 2D array line by line.
            while(fileScan.hasNext()) {
                line = fileScan.nextLine();
                int wCursor = 0;
                for(int i = 0; i < line.length(); i++) {
                    if(line.charAt(i) == '*') {
                        gen2[hCursor][wCursor] = liveCell;
                        wCursor++;
                    } else {
                        wCursor++;
                    }
                }
                hCursor++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gen2;
    }

    public char[][] gameGeneration() {
        //Wipe gen1 and copy gen2 into gen1.
        gen1 = new char[height][width];
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
                if(i == 0) {
                    minRow = i;
                } else {
                    minRow = i - 1;
                }
                //Checking for bottom edge.
                if(i == gen1.length - 1) {
                    maxRow = i;
                } else {
                    maxRow = i + 1;
                }
                //Checking for left edge.
                if(j == 0) {
                    minCol = j;
                } else {
                    minCol = j - 1;
                }
                //Checking for right edge.
                if(j == gen1[i].length - 1) {
                    maxCol = j;
                } else {
                    maxCol = j + 1;
                }

                //Counting live neighbors.
                for(int m = minRow; m <= maxRow; m++) {
                    for(int n = minCol; n <= maxCol; n++) {
                        if(gen1[m][n] == liveCell) {
                            count++;
                        }
                    }
                }

                //Account for adding self and inflating count.
                if(gen1[i][j] == liveCell) {
                    count--;
                }

                //Birth, survival, and overcrowding/loneliness rules executed.
                if(count == 3 && gen1[i][j] == deadCell) {
                    gen2[i][j] = liveCell;
                } else if ((count == 2 || count == 3) && gen1[i][j] == liveCell) {
                    gen2[i][j] = liveCell;
                } else {
                    gen2[i][j] = deadCell;
                }
            }
        }
        return gen2;
    }
}