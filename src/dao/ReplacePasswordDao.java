package dao;

import com.mysql.jdbc.Statement;

public class ReplacePasswordDao {
	private Connect connect=new Connect();
	private Statement statement=null;
	
	public int upthisdata(String phonenumberstring,String passWordstring) throws Exception, Exception {
		String table="user_info_"+phonenumberstring.substring(phonenumberstring.length()-1);
		statement=(Statement) connect.begin();
		String sqlString="UPDATE "+table+" set user_password=\'"+passWordstring+"\' WHERE user_phonenumber=\'"+phonenumberstring+"\'";
		System.out.print(sqlString);
		statement.executeUpdate(sqlString);
		return 1;
	}
}
