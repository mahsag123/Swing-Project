package gui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class MainFrame extends JFrame
{
	private Toolbar tb;
	private TextPanel tp;
	private FormPanel fp;
	private JFileChooser fc;
	
	
	public MainFrame()
	{
		super("Hello World");
		setLayout(new BorderLayout());
		
		setJMenuBar(createMenuBar());
		
		fc=new JFileChooser();
		
		fp=new FormPanel();
		add(fp,BorderLayout.WEST);
		
		tb=new Toolbar();
		add(tb,BorderLayout.NORTH);
		
		tp=new TextPanel();
		add(tp,BorderLayout.CENTER);
		
		fp.setStringListener(new StringListener() {
			public void textEmitted(String text) 
			{
				tp.appendText(text);
			}
		});
		
		tb.setStringListener(new StringListener() {
			public void textEmitted(String text) 
			{
				tp.appendText(text);
			}
		});
						
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 700, 500);
	}
	
	JMenuBar createMenuBar()
	{
		JMenuBar menuBar=new JMenuBar();
		
		JMenu file=new JMenu("File");
		JMenuItem exportdata=new JMenuItem("Export");
		JMenuItem importdata=new JMenuItem("Import");
		JMenuItem exit=new JMenuItem("Exit");
		
		file.add(exportdata);
		file.add(importdata);
		file.addSeparator();
		file.add(exit);
		
		JMenu window=new JMenu("Window");
		JMenu show=new JMenu("Show");
		JCheckBoxMenuItem showForm=new JCheckBoxMenuItem("Person Form");
		showForm.setSelected(true);
		
		show.add(showForm);
		window.add(show);
		
		exportdata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(fc.showSaveDialog(MainFrame.this)==fc.APPROVE_OPTION)
				{
					System.out.println(fc.getSelectedFile());
				}
			}		
		});
		
		importdata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(fc.showOpenDialog(MainFrame.this)==fc.APPROVE_OPTION)
				{
					System.out.println(fc.getSelectedFile());
				}
			}		
		});
		
		showForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				fp.setVisible(showForm.isSelected());
			}		
		});
			
		menuBar.add(file);
		menuBar.add(window);
		
		file.setMnemonic(KeyEvent.VK_F);
		exit.setMnemonic(KeyEvent.VK_X);
		
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String text=JOptionPane.showInputDialog(MainFrame.this, "Enter your  username", "Enter UserName", JOptionPane.OK_OPTION);
				tp.appendText(text);
				
				int action=JOptionPane.showConfirmDialog(MainFrame.this, "Do you really want to exit the application", "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
				if(action==JOptionPane.OK_OPTION)
				System.exit(0);
			}		
		});
		
		return menuBar;
	}
}
