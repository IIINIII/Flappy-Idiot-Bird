package com.fib.gop;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bird {
	
	int x;
	public int y;
	public int ys;
	final int gr = 2;
	int width;
	int height;
	BufferedImage birdImg;
	int f;
	
	public Bird(int x,int y) {
		this.x=x;
		this.y=y;
		f=0;
		ys=0;
		width=150;
		height=150;
		try {
			birdImg = ImageIO.read(getClass().getResourceAsStream("/com/fib/images/bizimKus1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x+3, y+40, 135, 63);
	}
	
	public void move() {
		ys+=gr;
		if(ys>30)ys=30;
		y+=ys;
		// Collision test
	}
	
	public void paint(Graphics g, ImageObserver imgob) {
		g.drawImage(birdImg.getSubimage(f++*150, 0, 150, 150), x, y, imgob);
		f%=4;
	}
	
}
