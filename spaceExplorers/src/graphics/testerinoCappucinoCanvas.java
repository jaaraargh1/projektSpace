package graphics;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import logics.Buttons;

public class testerinoCappucinoCanvas extends JFrame {
//	private Buttons clearButtons;
	private Game game;

	public testerinoCappucinoCanvas(Game game) {
		super("Välkommen till ritprogrammet!");
		this.game = game;
		setLayout(new BorderLayout());

		Game rityta = new Game();
		JPanel eastPanel = new JPanel();
		JPanel northPanel = new JPanel();
		JPanel westPanel = new JPanel();
		Buttons clearButtons = new Buttons(game);
		// Colours colourButtons = new Colours();
		// shapeButtons = new ShapePanel();
		// clearButtons.setSize(80, 90);
		// northPanel.add(null);
		// westPanel.add(null, BorderLayout.WEST);
		getContentPane().add(rityta);
		/// temp holder
		// this.add(colourButtons, BorderLayout.EAST);
		this.add(northPanel, BorderLayout.NORTH);
		this.add(rityta, BorderLayout.CENTER);
		this.add(westPanel, BorderLayout.SOUTH);

		this.setLocationRelativeTo(null);

		this.setSize(800, 600);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		revalidate();

	}

	
}