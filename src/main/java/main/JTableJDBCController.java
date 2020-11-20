package main;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

import java.util.Properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

import util.DbUtil;
import util.MyTableModel;

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
		
		try {
			InputStream inputStream = new FileInputStream(new File("./config/mainconnection.properties"));
			Properties properties = new Properties();
			properties.load(inputStream);
			
			view.getTextUrl().setText(properties.getProperty("url"));
			view.getTextSchema().setText(properties.getProperty("schema"));
			view.getTextUserName().setText(properties.getProperty("username"));
		}
		catch(FileNotFoundException ex) {
			displayExceptionMessage(ex.getMessage());
			ex.printStackTrace();
		}
		catch(IOException ex) {
			displayExceptionMessage(ex.getMessage());
			ex.printStackTrace();
		}
		catch(Exception ex) {
			displayExceptionMessage(ex.getMessage());
			ex.printStackTrace();
		}
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
					
					OutputStream outputStream = new FileOutputStream(new File("./config/mainconnection.properties"));
					Properties properties = new Properties();
					properties.setProperty("url", view.getTextUrl().getText());
					properties.setProperty("schema", view.getTextSchema().getText());
					properties.setProperty("username", view.getTextUserName().getText());
					properties.store(outputStream, null);
					
					JOptionPane.showMessageDialog(null, "Connected to " + dbUtil.getUrl() + "/" + dbUtil.getSchema(), 
							"Connection Successful", JOptionPane.INFORMATION_MESSAGE );
				}
				catch(SQLException ex) {
					displayExceptionMessage(ex.getMessage());
					ex.printStackTrace();
				}
				catch(FileNotFoundException ex) {
					displayExceptionMessage(ex.getMessage());
					ex.printStackTrace();
				}
				catch(IOException ex) {
					displayExceptionMessage(ex.getMessage());
					ex.printStackTrace();
				}
				catch(Exception ex) {
					displayExceptionMessage(ex.getMessage());
					ex.printStackTrace();
				}
			}
		});
		
		view.getButtonRunSql().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				try {
					MyTableModel myTableModel = new MyTableModel(dbUtil.getResultSet(view.getTextSql().getText()));
					view.getTable().setModel(myTableModel);
				}
				catch(SQLException ex) {
					displayExceptionMessage(ex.getMessage());
					ex.printStackTrace();
				}
				catch(NullPointerException ex) {
					displayExceptionMessage(ex.getMessage());
					ex.printStackTrace();
				}
				catch(ArrayIndexOutOfBoundsException ex) {
					displayExceptionMessage(ex.getMessage());
					ex.printStackTrace();
				}
				catch(Exception ex) {
					displayExceptionMessage(ex.getMessage());
					ex.printStackTrace();
				}
			}
		});
		
		view.getButtonClearTable().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				try {
				MyTableModel myTableModel = new MyTableModel(new Object[][] {{""}}, new Object[] {"Empty"});
				view.getTable().setModel(myTableModel);
				}
				catch(Exception ex) {
					displayExceptionMessage(ex.getMessage());
					ex.printStackTrace();
				}
			}
		});
	}
	
	public void displayExceptionMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Exception Encountered", JOptionPane.ERROR_MESSAGE);
	}
	
}











































































































































































































































































