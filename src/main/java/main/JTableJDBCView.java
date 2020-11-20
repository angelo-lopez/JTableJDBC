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
import java.awt.FlowLayout;

public class JTableJDBCView {
	private JFrame frame;
	private JPanel panelMain; 
	
	private JPanel panelTop; 
	
	private JPanel panelConnectionTop;
	private JPanel panelConnectionLeftCentre; 
	private JPanel panelConnectionLabel;
	private JPanel panelConnectionText;
	private JLabel labelConnectionTitle;
	private JLabel labelUrl;
	private JTextField textUrl;
	private JLabel labelSchema;
	private JTextField textSchema;
	private JLabel labelUserName;
	private JTextField textUserName;
	private JLabel labelPassWord;
	private JPasswordField pwdPassWord;
	private JButton buttonApplyConnection;
	
	private JPanel panelSql; 
	private JPanel panelButtonSql;
	private JLabel labelSql;
	private JScrollPane scrollPaneSql;
	private JTextArea textSql;
	private JButton buttonRunSql;
	
	private JPanel panelTable;
	private JPanel panelButtonTable;
	private JScrollPane scrollPaneTable;
	private JLabel labelResult;
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
		
		panelConnectionTop = new JPanel(new BorderLayout());
		panelConnectionTop.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelConnectionLeftCentre = new JPanel(new BorderLayout());
		panelConnectionLabel = new JPanel(new GridLayout(6, 1));
		panelConnectionText = new JPanel(new GridLayout(6, 1));
		
		labelConnectionTitle = new JLabel("Connection Properties");
		panelConnectionLabel.add(labelConnectionTitle);
		labelUrl = new JLabel("URL");
		panelConnectionLabel.add(labelUrl);
		labelSchema = new JLabel("Schema");
		panelConnectionLabel.add(labelSchema);
		labelUserName = new JLabel("Username");
		panelConnectionLabel.add(labelUserName);
		labelPassWord = new JLabel("Password");
		panelConnectionLabel.add(labelPassWord);
		buttonApplyConnection = new JButton("Apply");
		panelConnectionLabel.add(buttonApplyConnection);
		
		panelConnectionText.add(new JLabel(""));
		textUrl = new JTextField();
		panelConnectionText.add(textUrl);
		textSchema = new JTextField();
		panelConnectionText.add(textSchema);
		textUserName = new JTextField();
		panelConnectionText.add(textUserName);
		pwdPassWord = new JPasswordField();
		panelConnectionText.add(pwdPassWord);
		pwdPassWord.setEchoChar('*');
		
		panelConnectionLeftCentre.add(panelConnectionLabel, BorderLayout.LINE_START);
		panelConnectionLeftCentre.add(panelConnectionText, BorderLayout.CENTER);
		panelConnectionTop.add(panelConnectionLeftCentre, BorderLayout.PAGE_START);
		
		
		panelSql = new JPanel(new BorderLayout(10, 10));
		panelSql.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelButtonSql = new JPanel(new FlowLayout());
		labelSql = new JLabel("SQL Statement");
		textSql = new JTextArea();
		scrollPaneSql = new JScrollPane(textSql);
		buttonRunSql = new JButton("Run SQL");
		panelButtonSql.add(buttonRunSql);
		panelSql.add(labelSql, BorderLayout.PAGE_START);
		panelSql.add(scrollPaneSql, BorderLayout.CENTER);
		panelSql.add(panelButtonSql, BorderLayout.PAGE_END);
		
		panelTop = new JPanel(new GridLayout(0, 2));
		panelTop.add(panelSql);
		panelTop.add(panelConnectionTop);
		
		panelTable = new JPanel(new BorderLayout(10,10));
		panelTable.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelButtonTable = new JPanel(new FlowLayout());
		labelResult = new JLabel("Query Result");
		table = new JTable(new Object[][] {{""}}, new Object[] {"Empty"});
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setGridColor(Color.LIGHT_GRAY);
		table.setFillsViewportHeight(true);
		table.setCellSelectionEnabled(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setDefaultEditor(Object.class, null);
		scrollPaneTable = new JScrollPane(table);
		buttonClearTable = new JButton("Clear Result");
		panelButtonTable.add(buttonClearTable);
		panelTable.add(labelResult, BorderLayout.PAGE_START);
		panelTable.add(scrollPaneTable, BorderLayout.CENTER);
		panelTable.add(panelButtonTable, BorderLayout.PAGE_END);
		
		panelMain = new JPanel(new GridLayout(2, 0));
		panelMain.add(panelTop);
		panelMain.add(panelTable);
		
		frame.getContentPane().add(panelMain, BorderLayout.CENTER);
	}
	
	public void showGui() {
		frame.setVisible(true);
	}
}











































































































































































































































































































