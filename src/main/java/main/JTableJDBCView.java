package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BorderFactory;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;

import util.MyTableModel;

public class JTableJDBCView {
	private JFrame frame;
	private JPanel panelMain; //Grid layout.
	
	private JPanel panelTop; //Gridbag layout.
	
	private JPanel panelConnection; //Grid layout, gbc - horizontal
	private JLabel labelUrl;
	private JTextField textUrl;
	private JLabel labelSchema;
	private JTextField textSchema;
	private JLabel labelUserName;
	private JTextField textUserName;
	private JLabel labelPassWord;
	private JPasswordField textPassWord;
	private JButton buttonApplyConnection;
	
	private JPanel panelSql; //Border layout, gbc - both
	private JLabel labelSql;
	private JButton buttonRunSql;
	
	private JScrollPane scrollPane;
	private JTable table;
	
	public JTableJDBCView() {
		
	}
	
	public void setUp() {
		
	}
}











































































































































































































































































































