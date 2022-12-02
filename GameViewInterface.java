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
	
	//Set live character.
	void setLivePrompt(String l);
	
	//Set dead character.
	void setDeadPrompt(String d);
	
	//Set delimiter character.
	void setDelimiterPrompt(String del);
	
	//Set generation prompt.
	void setGenPrompt(String g);
	
	//Set sleep prompt.
	void setSleep(String s);
	
	//Set pattern prompt.
	void setPattern(String p);
}
