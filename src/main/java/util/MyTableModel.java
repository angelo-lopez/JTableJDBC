package util;

import javax.swing.table.DefaultTableModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyTableModel extends DefaultTableModel {
	private static final long serialVersionUID = 1L;
	
	public MyTableModel(Object[][] tableData, Object[] tableColumns) throws ArrayIndexOutOfBoundsException, NullPointerException {
		setDataVector(tableData, tableColumns);
	}
	
	public MyTableModel(ResultSet resultSet) throws SQLException, ArrayIndexOutOfBoundsException, NullPointerException {
		int columnCount = resultSet.getMetaData().getColumnCount();
		int rowCount = getResultSetRowCount(resultSet);
		
		Object[] tableColumns = new Object[columnCount];
		Object[][] tableData = new Object[rowCount][columnCount];
		
		for(int i = 1; i <= columnCount; i ++) {
			tableColumns[i - 1] = resultSet.getMetaData().getColumnName(i); 
		}
		
		while(resultSet.next()) {
			int i = 0;
			
			for(int j = 0; j < columnCount; j ++) {
				tableData[i][j] = resultSet.getString(j + 1);
			}
			
			i ++;
		}
		
		setDataVector(tableData, tableColumns);
	}
	
	private int getResultSetRowCount(ResultSet resultSet) {
		int i = 0;
		
		try {
			while(resultSet.next()) {
				i ++;
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return i;
	}
	
}
