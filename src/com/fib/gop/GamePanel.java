package com.fib.gop;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.util.LinkedList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.fib.GameOver;

public class GamePanel extends JComponent implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9068260370753242437L;
	public Bird bird;
	public LinkedList<Pipe> pipes;
	public int pipeTimer = 0;
	public int gameStatus = 0;
	public int score = 0;
	
	public GamePanel() {
		ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5);
		executor.scheduleAtFixedRate(this, 0, 32L, TimeUnit.MILLISECONDS);
		bird = new Bird(100, 100);
		pipes = new LinkedList<Pipe>();
	}

	@Override
	public void run() {
		if(gameStatus==0)
			this.repaint();
	}
	
	public void drawPipes(Graphics g) {
		for (Pipe p : pipes) {
			p.paint(g);
			if(!p.passed&&(gameStatus==0&&(bird.y+40<0||bird.y+93>600||p.getUpperBounds().intersects(bird.getBounds())||p.getLowerBounds().intersects(bird.getBounds())))) {
				/*System.out.println(p.getUpperBounds());
				System.out.println(p.getLowerBounds());
				System.out.println(bird.getBounds());*/
				gameStatus = 1;
				((JFrame)SwingUtilities.getRoot(this)).dispose();
				new GameOver(score);
			} else if (!p.passed&&p.x+p.width<bird.x) {
				score++;
				p.passed = true;
			}
			p.move();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		if(gameStatus!=0)
			return;
		g.setColor(Color.decode("#ffffff"));
		g.fillRect(0, 0, getWidth(), getHeight());
		pipeTimer--;
		if(pipeTimer<0) {
			pipeTimer = 50;
			pipes.add(new Pipe(1250));
			if(pipes.size()>10)
				pipes.removeFirst();
		}
		ImageObserver imgob = new ImageObserver() {
			
			@Override
			public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		bird.paint(g, imgob);
		bird.move();
		drawPipes(g);
		super.paint(g);
	}

}
