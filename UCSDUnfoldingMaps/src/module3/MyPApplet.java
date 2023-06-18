package module3;

import processing.core.*;

public class MyPApplet extends PApplet
{
	private String URL = "https://media.istockphoto.com/vectors/happy-mothers-day-greeting-card-with-modern-doodle-flowers-background-vector-id1211974292";
	private PImage backgroundImg;
	
	public void setup()
	{
		size(200,200);
		backgroundImg = loadImage(URL, "jpg");
		backgroundImg.resize(width,0);
		image(backgroundImg, 0, 0);

	}
	
	public void draw()
	{
		int[] color = sunColorSec(second());
		fill(color[0],color[1],color[2]);
		ellipse(width/4, height/5, width/5, height/5);
	}
	
	public int[] sunColorSec(float seconds)
	{
		int[] rgb = new int[3];
		
		float ratio = Math.abs(seconds-30)/30;
		
		rgb[0]=(int)(255*ratio);
		rgb[1]=(int)(255*ratio);
		rgb[2]=0;
		
		return rgb;
	}
		
}