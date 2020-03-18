package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class UpdataorderDao {
	private Connect connect=new Connect();
	private Statement statement=null;
	private Connect connect2=new Connect();
	private Statement statement2=null;
	private String[] orders=new String[] {"u_order_high_1_1","u_order_junior_1_1","u_order_primary_1_1",};
	private String[] classes=new String[] {"high_grade_1","junior_grade_1","primary_grade_1"};
	public JSONArray Updataorder(String numberstring) throws Exception {
		statement=(Statement) connect.begin();
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<3;i++) {
			String sqlString ="select * from "+orders[i]+" where order_user_phone =\'"+numberstring+"\'";
			ResultSet rs=statement.executeQuery(sqlString);
			while (rs.next()) {
				String classnumber=rs.getString("order_class_number");
				System.out.println("¿Î³ÌºÅ"+classnumber);
				statement2=(Statement) connect2.begin();
				String sqlString2 ="select * from "+classes[i]+" where class_number =\'"+classnumber+"\'";
				ResultSet rs2=statement2.executeQuery(sqlString2);
				while (rs2.next()) {
				JSONObject jsonObject=new JSONObject();
				jsonObject.put( "class_number", rs2.getString("class_number"));
				jsonObject.put( "class_big_title", rs2.getString("class_big_title"));
				jsonObject.put( "class_title",  rs2.getString("class_title"));
				jsonObject.put( "class_time",  rs2.getString("class_time"));
				jsonObject.put( "class_time_length", rs2.getString("class_time_length"));
				jsonObject.put( "class_teacher_one",rs2.getString("class_teacher_one"));
				jsonObject.put( "class_teacher_two", rs2.getString("class_teacher_two"));
				jsonObject.put( "class_howmanytimes", rs2.getString("class_howmanytimes"));
				jsonObject.put( "class_classification",rs2.getString("class_classification"));
				jsonObject.put( "class_grade",  rs2.getString("class_grade"));
				jsonObject.put( "class_price", rs2.getString("class_price"));
				jsonObject.put( "class_discount", rs2.getString("class_discount"));
				jsonObject.put( "class_state", rs2.getString("class_state"));
				jsonArray.add(jsonObject);
					
				}
				
				
			}
			
		}
		return jsonArray;
		
	}
}





