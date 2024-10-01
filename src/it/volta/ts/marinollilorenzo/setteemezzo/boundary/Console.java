package it.volta.ts.marinollilorenzo.setteemezzo.boundary;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.volta.ts.marinollilorenzo.setteemezzo.carteDaGiocoApp.BlackJack;
import it.volta.ts.marinollilorenzo.setteemezzo.carteDaGiocoApp.Config;
import it.volta.ts.marinollilorenzo.setteemezzo.carteDaGiocoApp.GiocoDiCarteFactory;
import it.volta.ts.marinollilorenzo.setteemezzo.carteDaGiocoApp.SetteeMezzo;

public class Console {

	private Config c = Config.get();
	private ConsoleGUI gui;
	private JFrame frame;
	private JPanel panel;

	public void esegui() {

		frame = new JFrame("Scelta");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocation(430, 100);

		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		frame.add(panel);
		JLabel lbl = new JLabel("Scegli il gioco e clicca ok");
		lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(lbl);
		String[] choices = { "SCEGLI", "BLACKJACK", "SETTEEMEZZO", "SOLITARIO"};
		final JComboBox<String> cb = new JComboBox<String>(choices);

		cb.setMaximumSize(cb.getPreferredSize());
		cb.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(cb);
		JButton btn = new JButton("OK");
		btn.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(btn);
		frame.setVisible(true); 
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cb.setEnabled(false);
				btn.setEnabled(false);
				clickButton(cb.getSelectedIndex());

			}
		});

	}

	private void clickButton(int scelta) {
		switch(scelta) {
		case 0:
			break;
		case 1:
			c.setScope(scelta);
			gui = new ConsoleGUI(new GiocoDiCarteFactory().genera());
			break;
		case 2:
			c.setScope(scelta);
			gui = new ConsoleGUI(new GiocoDiCarteFactory().genera());
			break;
		case 3:
			c.setScope(scelta);
			JLabel sMazzo = new JLabel("Scegli il mazzo e clicca ok");
			sMazzo.setAlignmentX(Component.CENTER_ALIGNMENT);
			panel.add(sMazzo);
			String[] choices = { "SCEGLI", "FRANCESE", "TRIESTINO"};
			final JComboBox<String> cb = new JComboBox<String>(choices);

			cb.setMaximumSize(cb.getPreferredSize());
			cb.setAlignmentX(Component.CENTER_ALIGNMENT);
			panel.add(cb);
			JButton btn = new JButton("OK");
			btn.setAlignmentX(Component.CENTER_ALIGNMENT);
			panel.add(btn);
			frame.setVisible(true); 
			btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int scelta2 = cb.getSelectedIndex();
					switch (scelta2) {
					case 1:
						c.setTipoMazzo(scelta2);
						gui = new ConsoleGUI(new GiocoDiCarteFactory().genera());
						break;
					case 2:
						c.setTipoMazzo(scelta2);
						gui = new ConsoleGUI(new GiocoDiCarteFactory().genera());
						break;
					default: 
						System.out.println("\n### SCELTA NON VALIDA! ###");
					}

				}
			});
			break;
		default:
			System.out.println("\n### SCELTA NON VALIDA! ###");
		}	
	}
}
