/**
 * IS 247 Game of Life Project
 * Katarina Nitz & Nicholas Williar
 * Query Listener
 */

public interface QueryListener {
    //Height has been entered.
    void heightEntered(int h);

    //Width has been entered.
    void widthEntered(int w);

    //Live cell character has been entered.
    void liveEntered(char l);

    //Dead cell character has been entered.
    void deadEntered(char d);

    //Generations has been entered.
    void genEntered(int g);

    //Time between generations has been entered.
    void sleepEntered(int s);

    //Pattern file name has been entered.
    void patternEntered(String p);
}