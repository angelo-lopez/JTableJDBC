package util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DbUtilFunctionalTest {
	
	private DbUtil dbUtil = null;
	private Properties properties = null;
	
	@BeforeEach
	public void setUp() throws SQLException, FileNotFoundException, IOException {
		if(dbUtil == null) {
			properties = new Properties();
			InputStream inputStream = new FileInputStream(new File("./config/testconnection.properties"));
			properties.load(inputStream);
			dbUtil = new DbUtil(properties.getProperty("mysqllocal.url"), properties.getProperty("mysqllocal.schema"),
					properties.getProperty("mysqllocal.username"), properties.getProperty("mysqllocal.password"));
		}
	}
	
	@Test
	public void testMain() {
		try {
			System.out.println("Functional test started for -> " + dbUtil.getClass().getName());
			System.out.println("Data Source -> " + properties.getProperty("mysqllocal.url") + "/" + properties.getProperty("mysqllocal.schema"));
			System.out.println("Run Date and Time -> " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + 
					" " + LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")));
			
			System.out.println("--------------------------------------------------------------------------------------------");
			System.out.println("Method under test -> public void connect()");
			System.out.println("Query String: None");
			System.out.println("Commments: Connects to the MySQL local database.");
			System.out.println("Result:\n");
			dbUtil.connect();
			System.out.println("successful.");
			System.out.println("--------------------------------------------------------------------------------------------");
			System.out.println("Method under test -> public ResultSet getData(String sql)");
			System.out.println("Query String: Select * From employees Limit 100");
			System.out.println("Comments: Retrieves the total number of records in the employees table.");
			System.out.println("Result:\n");
			displayResultSet(getResultSet("Select * From employees Limit 100"));
			System.out.println("Test successful.");
			System.out.println("--------------------------------------------------------------------------------------------");
			System.out.println("Method under test -> public void close()");
			System.out.println("Query String: None");
			System.out.println("Comments: Closes the connection to the MySQL local database.");
			System.out.println("Result:\n");
			dbUtil.close();
			System.out.println("Test successful.");
			
			System.out.println("--------------------------------------------------------------------------------------------");
			System.out.println("End of test.");
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			fail(ex.toString());
		}
		catch(Exception ex) {
			ex.printStackTrace();
			fail(ex.toString());
		}
	}
	
	public ResultSet getResultSet(String sql) throws SQLException, Exception {
		return dbUtil.getResultSet(sql);
	}
	
	public void displayResultSet(ResultSet resultSet) throws SQLException, Exception {
		String[] columnNames;
		
		if(resultSet != null & resultSet.isBeforeFirst()) {
			columnNames = dbUtil.getColumnNames(resultSet);
			
			for(int i =0; i < columnNames.length; i ++) {
				System.out.printf("%-35s", columnNames[i]);
			}
			
			System.out.print("\n");
			
			while(resultSet.next()) {
				for(int i = 0; i < columnNames.length; i ++) {
					System.out.printf("%-35s", resultSet.getString(i + 1));
				}
				System.out.print("\n");
			}
		}
		else {
			System.out.println("0 number of records retrieved.");
		}
	}
}





























































































































































































































