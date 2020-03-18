package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class CheckOrderDao {
	
	private Connect connect=new Connect();
	private Statement statement=null;
	
	public String checkOrder(String classnumber,String phonenumber,String ordertable) throws SQLException, Exception {
		statement=(Statement) connect.begin();
		String sqlString="select * from "+ordertable+" WHERE order_user_phone= "+"\'"+phonenumber+"\'"+" and order_class_number="+"\'"+classnumber+"\'";
		ResultSet rs=statement.executeQuery(sqlString);
		while (rs.next()) {
			if(rs.getString(6).trim().equals("Íê³É")) {
				return "no";
			}
			
		}
		
		return "yes";
	}
}
