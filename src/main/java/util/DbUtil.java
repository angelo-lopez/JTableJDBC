package util;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.SQLException;

public class DbUtil {
	private Connection connection;
	private String url;
	private String schema;
	private String userName;
	private String passWord;
	
	public DbUtil() {
		url = null;
		schema = null;
		userName = null;
		passWord = null;
	}
	
	public DbUtil(String url, String schema, String userName, String passWord) {
		this.url = url;
		this.schema = schema;
		this.userName = userName;
		this.passWord = passWord;
	}

	public Connection getConnection() {
		return connection;
	}
	
	public String getUrl() {
		return url;
	}

	public String getSchema() {
		return schema;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassWord() {
		return passWord;
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public void connect() throws SQLException {
		connection = DriverManager.getConnection(url + "/" + schema, userName, passWord);
	}
	
	public void connect(String url, String schema, String userName, String passWord) throws SQLException {
		connection = DriverManager.getConnection(url + "/" + schema, userName, passWord);
	}
	
	public void close() throws SQLException {
		connection.close();
	}
	
	public String[] getColumnNames(ResultSet resultSet) throws SQLException {
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		String[] columnNames = new String[resultSetMetaData.getColumnCount()];
		
		for(int i = 1; i <= resultSetMetaData.getColumnCount(); i ++) {
			columnNames[i - 1] = resultSetMetaData.getColumnName(i);
		}
		
		return columnNames;
	}
	
	public ResultSet getResultSet(String sql) throws SQLException {
		Statement statement = connection.createStatement();
		
		return statement.executeQuery(sql);
	}
}






































































































































































































































