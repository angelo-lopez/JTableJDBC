package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.BorderFactory;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;

import util.MyTableModel;

public class JTableJDBCView {
	private JFrame frame;
	private JPanel mainPanel;
	
	private JPanel panelConnection;
	private JTextField textUrl;
	private JTextField textSchema;
	private JTextField textUserName;
	private JPasswordField textPassWord;
	private JButton buttonApplyConnection;
	
	public JTableJDBCView() {
	}
}
