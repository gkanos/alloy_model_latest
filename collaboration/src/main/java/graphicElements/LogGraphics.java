package graphicElements;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LogGraphics {
	private static LogGraphics instance = null;
	private static int x;
	private static int y;
	private static HashMap<Integer,Object> graphicsLog;
	private static List<Object> graphElements = new LinkedList<>();
	private static int numOfElement;
	
	
	public LogGraphics() {
		x = 0;
		y = 0;
		graphicsLog = new HashMap<Integer,Object>();
		numOfElement = 0;
	}
	
	public static LogGraphics getInstance() 
	{
		if(instance == null) 
		{
			instance = new LogGraphics();
		}
		return instance;
	}
	
	public static void addLifeline() 
	{
		
	}	

	//Getters and setters
	public static int getX() {
		return x;
	}

	public static void setX(int x) {
		LogGraphics.x = x;
	}

	public static int getY() {
		return y;
	}

	public static void setY(int y) {
		LogGraphics.y = y;
	}

	public static HashMap<Integer, Object> getGraphicsLog() {
		return graphicsLog;
	}

	public static void setGraphicsLog(HashMap<Integer, Object> graphicsLog) {
		LogGraphics.graphicsLog = graphicsLog;
	}

	public static int getNumOfElement() {
		return numOfElement;
	}

	public static void setNumOfElement(int numOfElement) {
		LogGraphics.numOfElement = numOfElement;
	}

	public static List<Object> getGraphElements() {
		return graphElements;
	}

	public static void setGraphElements(List<Object> graphElements) {
		LogGraphics.graphElements = graphElements;
	}

}
