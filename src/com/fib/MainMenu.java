package com.fib;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class MainMenu extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8971613378803136189L;

	public MainMenu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainMenu.class.getResource("/com/fib/images/Untitled.png")));
		setTitle("Flappy Idiot Bird");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setPreferredSize(new Dimension(574, 274));
		//getContentPane().setPreferredSize(new Dimension(1200, 600));
		getContentPane().setLayout(null);
		
		JButton btnNewGame = new JButton("Play");
		btnNewGame.setBounds(350, 72, 180, 48);
		btnNewGame.addActionListener(this);
		getContentPane().add(btnNewGame);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(350, 140, 180, 48);
		btnExit.addActionListener(this);
		getContentPane().add(btnExit);
		
		JLabel lblBg = new JLabel("bg");
		lblBg.setIcon(new ImageIcon(MainMenu.class.getResource("/com/fib/images/bg.png")));
		lblBg.setBounds(0, 0, 574, 274);
		getContentPane().add(lblBg);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		if(b.getText().equals("Exit")) {
			System.exit(0);
		} else if(b.getText().equals("Play")) {
			SwingUtilities.getRoot(b).setVisible(false);
			new Game();
		}
	}
}
