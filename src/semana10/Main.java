package semana10;

import processing.core.PApplet;

public class Main extends PApplet {

	Logica app;

	static public void main(String[] args) {
		PApplet.main("semana10.Main");
	}

	@Override
	public void settings() {
		size(500, 300);
	}

	@Override
	public void setup() {
		app = new Logica(this);
		colorMode(HSB,360,100,100);
	}

	@Override
	public void draw() {
		background(0);
		app.ejecutar();
	}

	@Override
	public void mousePressed() {
		app.click();
	}
}
