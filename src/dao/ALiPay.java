package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mysql.jdbc.Statement;

public class ALiPay {
	
	private Connect connect=new Connect();
	private Statement statement=null;
	
	public int insertOrder(String classnumberstring,String phonestring,String ordertable,
			Double price,Double discount) throws Exception {
		statement=(Statement)connect.begin();
    	String sqlString2="INSERT INTO "+ ordertable +"( order_user_phone, order_class_number,order_price,order_discount,order_time,order_appraise_number,order_appraise_text )"
    			+ "VALUES (\'"+phonestring+"\',\'"+classnumberstring+"\',\'"+price+"\',\'"+discount+"\',\'未完成 \',\' \',\' \' )";
    	statement.executeUpdate(sqlString2,Statement.RETURN_GENERATED_KEYS);
    	System.out.println(sqlString2);
    	
    	ResultSet rs = statement.getGeneratedKeys(); 
    	rs.next();
    	System.out.println("查到主键为:"+rs.getInt(1));
    	return rs.getInt(1);
	}
}
