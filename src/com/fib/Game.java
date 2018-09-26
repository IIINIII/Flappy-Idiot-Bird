package com.fib;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import com.fib.gop.GamePanel;

public class Game extends JFrame implements KeyListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3595975593411298553L;
	GamePanel gamePanel;

	public Game() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Game.class.getResource("/com/fib/images/Untitled.png")));
		setTitle("Flappy Idiot Bird");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setPreferredSize(new Dimension(1200, 600));
		
		gamePanel = new GamePanel();
		getContentPane().add(gamePanel, BorderLayout.CENTER);
		
		pack();
		setLocationRelativeTo(null);
		addKeyListener(this);
		/*addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				gamePanel.bird.y = e.getY();
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});*/
		setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==32) {
			gamePanel.bird.ys = -20;
		}
	}

}
