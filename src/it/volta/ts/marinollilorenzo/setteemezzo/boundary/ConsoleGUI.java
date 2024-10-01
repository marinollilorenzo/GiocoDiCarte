package it.volta.ts.marinollilorenzo.setteemezzo.boundary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import it.volta.ts.marinollilorenzo.setteemezzo.bean.Carta;
import it.volta.ts.marinollilorenzo.setteemezzo.carteDaGiocoApp.Config;
import it.volta.ts.marinollilorenzo.setteemezzo.carteDaGiocoApp.GiocoDiCarte;
import it.volta.ts.marinollilorenzo.setteemezzo.carteDaGiocoApp.SetteeMezzo;


public class ConsoleGUI extends JFrame{

	private JPanel panel;
	private List<Image> immagini;
	private JLabel imageLabel;
	private JButton stoButton;
	private JButton restartButton;
	private GiocoDiCarte gioco;
	private JLabel scoreLabel;
	private JLabel punteggioLabel;
	private boolean primaCarta;


	private JButton pescaButton;

	public ConsoleGUI(GiocoDiCarte gioco) {
		super("App Carte da Gioco");
		this.gioco = gioco;
		imageLabel = new JLabel(new ImageIcon(gioco.getRetro()));
		scoreLabel = new JLabel();
		scoreLabel.setForeground(Color.gray);
		punteggioLabel = new JLabel();
		punteggioLabel.setForeground(Color.BLACK);
		pescaButton = new JButton("Pesca");
		pescaButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				pescaCarta(gioco);
			}
		});
		stoButton = new JButton("Sto");
		stoButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sto(gioco);

			}
		});
		restartButton = new JButton("Restart");
		restartButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				restart(gioco);
			}
		});
		panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.add(pescaButton);
		if(!Config.get().isSolitario())
			panel.add(stoButton);
		panel.add(restartButton);
		panel.add(scoreLabel);
		panel.add(punteggioLabel);
		panel.add(imageLabel);
		Dimension d = new Dimension(1800, 1000);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		getContentPane().add(panel);
		setSize(d);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	private void pescaCarta(GiocoDiCarte gioco) {

		Image cartaPescata = gioco.daiCarta();
		if(primaCarta) {
			primaCarta = !primaCarta;
			imageLabel.setIcon(new ImageIcon(cartaPescata));
		}else {
			imageLabel = new JLabel(new ImageIcon(cartaPescata));
			panel.add(imageLabel);
			panel.revalidate();
			panel.repaint();
		}

		scoreLabel.setText(gioco.daiDescrizione());

		punteggioLabel.setText(gioco.getPunteggio());
		if(gioco.checkLose())
			sto(gioco);
	}

	private void sto(GiocoDiCarte gioco) {
		JLabel win;
		pescaButton.setEnabled(false);
		if(!Config.get().isSolitario())
			stoButton.setEnabled(false);
		scoreLabel.setText("");
		if(gioco.checkLose())
			punteggioLabel.setForeground(Color.red);
		if(gioco.checkWin())
			punteggioLabel.setForeground(Color.green);
	}


	protected void restart(GiocoDiCarte gioco) {
		gioco.nuovaMano();
		panel.removeAll();
		designGui(gioco);
		panel.revalidate();
		panel.repaint();
	}
	private void designGui(GiocoDiCarte gioco) {
		gioco.setPunteggio();
		imageLabel.setIcon(new ImageIcon(gioco.getRetro()));
		pescaButton.setEnabled(true);
		if(!Config.get().isSolitario())
			stoButton.setEnabled(true);
		punteggioLabel.setForeground(Color.BLACK);
		scoreLabel.setText("");
		punteggioLabel.setText(gioco.getPunteggio());
		panel.add(pescaButton);
		if(!Config.get().isSolitario())
			panel.add(stoButton);
		panel.add(restartButton);
		panel.add(scoreLabel);
		panel.add(punteggioLabel);
		panel.add(imageLabel);
		setVisible(true);

	}

}
