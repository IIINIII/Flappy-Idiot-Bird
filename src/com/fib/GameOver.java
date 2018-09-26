package com.fib;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class GameOver extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8367757358907923224L;
	
	public GameOver(int score) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GameOver.class.getResource("/com/fib/images/Untitled.png")));
		setTitle("Flappy Idiot Bird");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setPreferredSize(new Dimension(800, 400));
		getContentPane().setLayout(null);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JButton button = new JButton("New button");
		button.setBounds(200, -90000, 89, 23);
		getContentPane().add(button);
		btnExit.setBounds(200, 325, 196, 40);
		getContentPane().add(btnExit);
		
		JButton btnRetry = new JButton("Retry");
		btnRetry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameOver.this.dispose();
				new Game();
			}
		});
		btnRetry.setBounds(200, 274, 196, 40);
		getContentPane().add(btnRetry);
		
		JLabel lblScore = new JLabel("Your score: "+score);
		lblScore.setFont(new Font("Corbel", Font.PLAIN, 40));
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setBounds(100, 200, 396, 63);
		getContentPane().add(lblScore);
		
		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(GameOver.class.getResource("/com/fib/images/gameOverBg1.png")));
		lblBg.setBounds(0, 0, 800, 400);
		getContentPane().add(lblBg);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
