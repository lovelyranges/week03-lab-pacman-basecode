import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class PacmanPanel extends JPanel implements ActionListener {
	
	private Pacman ball;
	//declare new field
	private Pacman ball2;
	private Timer t; 
	private Dimension size;
	
	public PacmanPanel(Dimension initialSize) {
		super();
		
		size = initialSize;
		ball = new Pacman(initialSize.width/2, initialSize.height/2,
				Math.min(initialSize.width,initialSize.height)/10, 
				(int)Util.random(-10, 10), (int)Util.random(-10, 10), Util.randomColor());
		
		//instantiate new object for field in constructor
		ball2 = new Pacman(initialSize.width/3*2, initialSize.height/2,
				Math.min(initialSize.width,initialSize.height)/10, 
				(int)Util.random(-10, 10), (int)Util.random(-10, 10), Util.randomColor());

		
		t = new Timer(33, this);
		t.start();
	}
	
	@Override
	   public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.DARK_GRAY);
        Graphics2D g2 = (Graphics2D) g; //new
        ball.draw(g2); //editted
        ball2.draw(g2); //new
    
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ball.move();
		ball.checkCollision(size);
		
		repaint();
	}
	
}
