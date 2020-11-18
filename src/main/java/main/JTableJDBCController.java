package main;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

import javax.swing.JOptionPane;

import util.DbUtil;
import util.MyTableModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JTableJDBCController {
	private JTableJDBCView view;
	private DbUtil dbUtil;
	
	public JTableJDBCController() {
		view = new JTableJDBCView("JTable - JDBC");
	}
	
	public JTableJDBCController(String title) {
		view = new JTableJDBCView(title);
	}
	
	public void run() {
		dbUtil = null;
		initListeners();
		view.showGui();
	}
	
	public void initListeners() {
		view.getFrame().addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				try {
					if(dbUtil != null) {
						if(dbUtil.getConnection() != null) {
							dbUtil.close();
							dbUtil = null;
							JOptionPane.showMessageDialog(null, "Disconnected from the database." ,"Connection Closed", JOptionPane.INFORMATION_MESSAGE );
						}
					}

					System.exit(0);
				}
				catch(SQLException ex) {
					displayExceptionMessage(ex.getMessage());
					ex.printStackTrace();
				}
				catch(Exception ex) {
					displayExceptionMessage(ex.getMessage());
					ex.printStackTrace();
				}
			}
		});
		
		view.getButtonApplyConnection().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				try {
					if(dbUtil != null) {
						if(dbUtil.getConnection() != null) {
							dbUtil.close();
							dbUtil = null;
						}
					}
					
					dbUtil = new DbUtil(view.getTextUrl().getText().trim(), 
							view.getTextSchema().getText().trim(), 
							view.getTextUserName().getText().trim(), 
							String.valueOf(view.getPwdPassWord().getPassword()));
					dbUtil.connect();
					JOptionPane.showMessageDialog(null, "Connected to " + dbUtil.getUrl() + "/" + dbUtil.getSchema(), 
							"Connection Successful", JOptionPane.INFORMATION_MESSAGE );
				}
				catch(SQLException ex) {
					displayExceptionMessage(ex.getMessage());
				}
				catch(Exception ex) {
					displayExceptionMessage(ex.getMessage());
				}
			}
		});
		
		view.getButtonRunSql().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				
			}
		});
		
		view.getButtonClearTable().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				
			}
		});
	}
	
	public void displayExceptionMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Exception Encountered", JOptionPane.ERROR_MESSAGE);
	}
}











































































































































































































































































