package semana10;

import processing.core.PApplet;

public class Obstaculo {
	
	private float x,y;
	private PApplet app;

	public Obstaculo(PApplet app,float x,float y) {
		this.app=app;
		this.x=x;
		this.y=y;
	}
	
	public void pintar(){
		app.noStroke();
		app.fill(50,80,80);
		app.ellipse(x, y, 15, 15);
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	

}
