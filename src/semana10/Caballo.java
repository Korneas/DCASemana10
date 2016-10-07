package semana10;

import processing.core.PApplet;

public class Caballo extends Thread {

	private PApplet app;
	private float x, y;
	private float vel;
	private int r,pos;
	private long t;
	private boolean mov, choque;

	public Caballo(PApplet app, float y) {
		this.app = app;
		this.y = y;
		r = (int) app.random(2);
		x = 0;
		y = 0;
		vel = (float) 0.2;
		t = (long) app.random(2, 8);
	}

	public void pintar() {
		if (choque) {
			app.fill(0, 80, 80);
		} else {
			app.noFill();
		}
		app.stroke(t * 20, 80, 80);
		app.ellipse(x, y, 10, 10);
		
		if(fin()){
			app.text(pos, x-35, y);
		}
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
				if (choque == false && r == 0) {
					t += 2;
					choque = true;
				} else {
					r = (int) app.random(2);
				}
			}
		}
	}
	
	public boolean fin(){
		if(x>=app.width){
			return true;
		}
		return false;
	}
	
	public void posicion(int pos){
		this.pos=pos;
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

	public int getR() {
		return r;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	
}
