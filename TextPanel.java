package gui;
import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextPanel extends JPanel
{
	private JTextArea ta;
	public TextPanel()
	{
		setLayout(new BorderLayout());
		ta=new JTextArea();
		add(new JScrollPane(ta),BorderLayout.CENTER);
	}
		
	public void appendText(String str)
	{
		ta.append(str);
	}
}