package main;

public class JTableJDBCController {
	JTableJDBCView view;
	
	public JTableJDBCController() {
		view = new JTableJDBCView("JTable - JDBC");
		run();
	}
	
	public void run() {
		view.showGui();
	}
}
