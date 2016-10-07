package semana10;

import processing.core.PApplet;

public class Caballo extends Thread {

	private PApplet app;
	private float x, y;
	private float vel;
	private long t;
	private boolean mov, choque;

	public Caballo(PApplet app, float y) {
		this.app = app;
		this.y = y;
		x = 0;
		y = 0;
		vel = (float) 0.2;
		t = (long) app.random(3, 10);
	}

	public void pintar() {
		if (choque) {
			app.fill(0, 80, 80);
		} else {
			app.noFill();
		}
		app.stroke(t * 20, 80, 80);
		app.ellipse(x, y, 10, 10);
	}

	public void click() {
		mov = true;
	}

	@Override
	public void run() {
		while (true) {
			if (mov && x < app.width) {
				x += vel;
			}
			try {
				Thread.sleep(t);
			} catch (InterruptedException e) {
				System.out.println("Caballo choco");
				if(choque==false){
				t+=2;
				choque=true;
				}
			}
		}
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

	public boolean isMov() {
		return mov;
	}

	public void setMov(boolean mov) {
		this.mov = mov;
	}

}
