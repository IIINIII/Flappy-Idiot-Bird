package com.fib.gop;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pipe {
	
	int x,y,width,height;
	final int xs = 8;
	public boolean passed;
	
	public Pipe(int x) {
		this.x = x;
		this.y = (int) (50 + Math.floor(Math.random()*261));
		this.height = 250;
		this.width = 120;
		passed = false;
	}
	
	public void move() {
		x-=xs;
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.decode("#333333"));
		g.fillRect(x+10, 0, width-20, y);
		g.fillRect(x+10, y+height, width-20, 620-y-height);
		g.setColor(Color.decode("#2196f3"));
		g.fillRect(x, y-10, width, 10);
		g.fillRect(x, y+height, width, 10);
	}
	
	public Rectangle getUpperBounds() {
		return new Rectangle(x, 0, width, y);
	}
	
	public Rectangle getLowerBounds() {
		return new Rectangle(x, y+height, width, 620-y-height);
	}
	
}
