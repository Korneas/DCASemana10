package semana10;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logica {

	private PApplet app;
	private ArrayList<Caballo> cab;
	private ArrayList<Obstaculo> obs;
	private int posicion = 1;

	public Logica(PApplet app) {
		this.app = app;
		cab = new ArrayList<Caballo>();
		obs = new ArrayList<Obstaculo>();

		for (int i = 0; i < 10; i++) {
			cab.add(new Caballo(app, 20 + (i * 20)));
			cab.get(i).start();
		}

		for (int i = 0; i < 10; i++) {
			obs.add(new Obstaculo(app, 150, 20 + (i * 20)));
		}

		for (int i = 0; i < 10; i++) {
			int a = (int) app.random(250,500);
			obs.add(new Obstaculo(app, a, 20 + (i * 20)));
		}
	}

	public void ejecutar() {
		llegada();
		
		for (int i = 0; i < cab.size(); i++) {
			Caballo c = cab.get(i);
			c.pintar();
		}

		for (int i = 0; i < obs.size(); i++) {
			obs.get(i).pintar();
		}

		for (int i = 0; i < cab.size(); i++) {
			for (int j = 0; j < obs.size(); j++) {
				Caballo c = cab.get(i);
				Obstaculo o = obs.get(j);

				if (PApplet.dist(c.getX(), c.getY(), o.getX(), o.getY()) < 0.5) {
					c.interrupt();
				}
			}
		}
	}

	public void llegada() {
		for (int i = 0; i < cab.size(); i++) {
			Caballo c = cab.get(i);

			if (c.fin() && c.getPos() == 0) {
				c.posicion(posicion);
				posicion++;
			}
		}
	}

	public void click() {
		for (Caballo caballo : cab) {
			caballo.click();
		}

		System.out.println(cab.get(0).isMov());
	}
}
