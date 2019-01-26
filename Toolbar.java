package gui;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener
{
	private JButton hbtn;
	private JButton gbtn;
	private StringListener textListener;
	
	public Toolbar()
	{
		setBorder(BorderFactory.createEtchedBorder());
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		hbtn=new JButton("Hello");
		gbtn=new JButton("Goodbye");
		
		add(hbtn);
		add(gbtn);
		
		hbtn.addActionListener(this);
		gbtn.addActionListener(this);
	}
	
	public void setStringListener(StringListener textListener)
	{
		this.textListener=textListener;
	}
	
	
	public void actionPerformed(ActionEvent e) 
	{
		if(textListener!=null)
		{
			if(e.getSource()==hbtn)
			{
				textListener.textEmitted("Hello\n");
			}
			else if(e.getSource()==gbtn)
			{
				textListener.textEmitted("Goodbye\n");
			}
		}
	}
}
