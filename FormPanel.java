package gui;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormPanel extends JPanel
{
	private JLabel namelbl;
	private JLabel occupationlbl;
	private JTextField namefld;
	private JTextField occupationfld;
	private JButton okBtn;
	private StringListener listener;
	private JComboBox agelist;	
	private JLabel agelbl;
	private JLabel emplbl;
	private JComboBox empcombo;
	private JCheckBox ctzen;
	private JLabel taxlbl;
	private JTextField taxfld;
	private JLabel ctlbl;
	
	public FormPanel()
	{
		Dimension dim=new Dimension();
		dim.width=250;
		setPreferredSize(dim);
		
		namelbl=new JLabel("Name:");
		occupationlbl=new JLabel("Occupation:");
		agelbl=new JLabel("Age:");
		emplbl=new JLabel("Employment:");
		namefld=new JTextField(10);
		occupationfld=new JTextField(10);
		ctzen=new JCheckBox();
		ctlbl=new JLabel("Indian Citizen:");
		taxlbl=new JLabel("Tax:");
		taxfld=new JTextField(10);
		okBtn=new JButton("OK");
						
		setBorder(BorderFactory.createTitledBorder("Add Person"));
		
		setLayout(null);
		add(namelbl);
		namelbl.setBounds(20, 20, 100, 30);
		add(namefld);
		namefld.setBounds(100, 25, 80, 20);
		add(occupationlbl);
		occupationlbl.setBounds(20, 60, 100, 30);
		add(occupationfld);
		occupationfld.setBounds(100, 65, 80, 20);
		add(agelbl);
		agelbl.setBounds(20, 100, 80, 20);
		add(emplbl);
		emplbl.setBounds(20, 140, 80, 20);
		add(ctlbl);
		ctlbl.setBounds(20, 180, 80, 20);
		add(ctzen);
		ctzen.setBounds(100, 180, 80, 20);
		add(taxlbl);
		taxlbl.setBounds(20, 220, 80, 20);
		taxlbl.setEnabled(false);
		add(taxfld);
		taxfld.setBounds(100, 220, 80, 20);
		taxfld.setEnabled(false);
		add(okBtn);
		okBtn.setBounds(100, 265, 70, 20);
		
		String agelist_arr[]= {"Under 18","18 to 65","65 over"};
		agelist=new JComboBox(agelist_arr);
		agelist.setBounds(100, 100, 80, 20);
		add(agelist);
		
		String emplist_arr[]= {"Unemployed","Self-Employed","Employed"};
		empcombo=new JComboBox(emplist_arr);
		empcombo.setBounds(100, 140, 80, 20);
		add(empcombo);
		
		ctzen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				boolean isTicked=ctzen.isSelected();
				taxlbl.setEnabled(isTicked);
				taxfld.setEnabled(isTicked);
			}
			
		});
		
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getSource()==okBtn)
				{
					String name=namefld.getText();
					String occupation=occupationfld.getText();
					String age=(String) agelist.getSelectedItem();
					String emp=(String) empcombo.getSelectedItem();
					String tax=taxfld.getText();
										
					listener.textEmitted("Name:  "+name+"\nOccupation:  "+occupation+"\nAge:  "+age+"\nEmployment:  "+emp+"\nTax: "+tax+"\n");
				}
			}	
		});
	}
	
	public void setStringListener(StringListener listener)
	{
		this.listener=listener;
	}
}