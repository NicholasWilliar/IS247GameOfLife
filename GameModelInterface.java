/**
 * IS 247 Game of Life Project
 * Katarina Nitz & Nicholas Williar
 * Model Interface
 */

public interface GameModelInterface {
    //Sets height of 2D array.
    void setHeight(int h);

    //Sets width of 2D array.
    void setWidth(int w);

    //Sets character of live cells.
    void setLive(char l);

    //Sets character of dead cells.
    void setDead(char d);

    //Sets sleep time between generations.
    void setSleep(int s);

    //Sets pattern.
    void setPattern(String p);

    //Creates grid and copies pattern into rough center.
    char[][] createGrid();

    //Executes game of life generation.
    char[][] gameGeneration();
}