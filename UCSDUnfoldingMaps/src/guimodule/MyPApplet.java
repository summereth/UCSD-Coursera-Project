package guimodule;

import processing.core.*;

public class MyPApplet extends PApplet {

	private String URL = "https://media.istockphoto.com/vectors/happy-mothers-day-greeting-card-with-modern-doodle-flowers-background-vector-id1211974292";
	private PImage backgroundImg;

	public void setup()
	{
		backgroundImg = loadImage(URL, "jpg");
		background(backgroundImg);
	}
	
	public void draw()
	{


	}
	
}
