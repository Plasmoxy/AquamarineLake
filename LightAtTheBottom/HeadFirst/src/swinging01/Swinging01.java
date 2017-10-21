package swinging01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Swinging01
implements ActionListener
{
	
	private JButton button;
	
	public Swinging01()
	{
		MaterialLookAndFeel ui = new MaterialLookAndFeel (GUITheme.LIGHT_THEME);
	    
	    try {
	     UIManager.setLookAndFeel (ui.getName ());
	     }
	     catch (UnsupportedLookAndFeelException e) {}
	     catch (ClassNotFoundException e) {}
	     catch (InstantiationException e) {}
	     catch (IllegalAccessException e) {}
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		button = new JButton("Click me");
		button.addActionListener(this);
		frame.getContentPane().add(button);
		
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		Swinging01 sw = new Swinging01();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		button.setText("XD");
	}
}
