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
import javax.swing.ListSelectionModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
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
	private JPasswordField pwdPassWord;
	private JButton buttonApplyConnection;
	
	private JPanel panelSql; //Border layout, gbc - both
	private JLabel labelSql;
	private JScrollPane scrollPaneSql;
	private JTextArea textSql;
	private JButton buttonRunSql;
	
	private JPanel panelTable;
	private JScrollPane scrollPaneTable;
	private JTable table;
	private JButton buttonClearTable;
	
	String frameTitle;
	
	public JTableJDBCView() {
		frameTitle = "JTable JDBC Demo.";
		setUp();
	}
	
	public JTableJDBCView(String title) {
		frameTitle = title;
		setUp();
	}
		
	public JFrame getFrame() {
		return frame;
	}

	public JTextField getTextUrl() {
		return textUrl;
	}

	public JTextField getTextSchema() {
		return textSchema;
	}

	public JTextField getTextUserName() {
		return textUserName;
	}

	public JPasswordField getPwdPassWord() {
		return pwdPassWord;
	}

	public JButton getButtonApplyConnection() {
		return buttonApplyConnection;
	}

	public JTextArea getTextSql() {
		return textSql;
	}

	public JButton getButtonRunSql() {
		return buttonRunSql;
	}

	public JTable getTable() {
		return table;
	}

	public JButton getButtonClearTable() {
		return buttonClearTable;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public void setTextUrl(JTextField textUrl) {
		this.textUrl = textUrl;
	}

	public void setTextSchema(JTextField textSchema) {
		this.textSchema = textSchema;
	}

	public void setTextUserName(JTextField textUserName) {
		this.textUserName = textUserName;
	}

	public void setPwdPassWord(JPasswordField pwdPassWord) {
		this.pwdPassWord = pwdPassWord;
	}

	public void setTextSql(JTextArea textSql) {
		this.textSql = textSql;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public void setUp() {
		frame = new JFrame(frameTitle);
		frame.setLayout(new BorderLayout(10, 10));
		frame.setSize(800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		panelConnection = new JPanel(new GridLayout(5, 2));
		labelUrl = new JLabel("URL");
		labelSchema = new JLabel("Schema");
		labelUserName = new JLabel("Username");
		labelPassWord = new JLabel("Password");
		textUrl = new JTextField();
		textSchema = new JTextField();
		textUserName = new JTextField();
		pwdPassWord = new JPasswordField();
		pwdPassWord.setEchoChar('*');
		buttonApplyConnection = new JButton("Apply");
		panelConnection.add(labelUrl);
		panelConnection.add(textUrl);
		panelConnection.add(labelSchema);
		panelConnection.add(textSchema);
		panelConnection.add(labelUserName);
		panelConnection.add(textUserName);
		panelConnection.add(labelPassWord);
		panelConnection.add(pwdPassWord);
		panelConnection.add(buttonApplyConnection);
		
		panelSql = new JPanel(new BorderLayout(10, 10));
		labelSql = new JLabel("SQL Statement");
		textSql = new JTextArea();
		scrollPaneSql = new JScrollPane(textSql);
		buttonRunSql = new JButton("Run SQL");
		panelSql.add(labelSql, BorderLayout.PAGE_START);
		panelSql.add(scrollPaneSql, BorderLayout.CENTER);
		panelSql.add(buttonRunSql, BorderLayout.PAGE_END);
		
		panelTop = new JPanel(new GridBagLayout());
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 0;
		panelTop.add(panelSql, gridBagConstraints);
		
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 0;
		panelTop.add(panelConnection, gridBagConstraints);
		
		panelTable = new JPanel(new BorderLayout(10,10));
		table = new JTable(new Object[][] {{""}}, new Object[] {"Empty"});
		table.setGridColor(Color.LIGHT_GRAY);
		table.setFillsViewportHeight(true);
		table.setCellSelectionEnabled(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setDefaultEditor(Object.class, null);
		scrollPaneTable = new JScrollPane(table);
		buttonClearTable = new JButton("Clear Results");
		panelTable.add(scrollPaneTable, BorderLayout.CENTER);
		panelTable.add(buttonClearTable, BorderLayout.PAGE_END);
		
		panelMain = new JPanel(new GridLayout(2, 0));
		panelMain.add(panelTop);
		panelMain.add(panelTable);
		
		frame.getContentPane().add(panelMain, BorderLayout.CENTER);
	}
	
	public void showGui() {
		frame.setVisible(true);
	}
}











































































































































































































































































































