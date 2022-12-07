/**
* IS 247 Game of Life Project
* Katarina Nitz & Nicholas Williar
* View Interface
*/

public interface GameViewInterface {
	//Show the UI.
	void show();
	
	//Set listener.
	void setListener(QueryListener ql);
	
	//Show generation.
	void displayGen(char[][] g);
	
	//Set height prompt.
	void setHeightPrompt(String h);
	
	//Set width prompt.
	void setWidthPrompt(String w);
	
	//Set live character prompt.
	void setLivePrompt(String l);
	
	//Set dead character prompt.
	void setDeadPrompt(String d);
	
	//Set delimiter character prompt.
	void setDelimiterPrompt(String del);
	
	//Set delimiter.
	void setDelimiter(char delim);
	
	//Set generation prompt.
	void setGenPrompt(String g);
	
	//Set current generation.
	void setCurGen(int gen);
	
	//Set sleep prompt.
	void setSleepPrompt(String s);
	
	//Set pattern prompt.
	void setPatternPrompt(String p);
}
