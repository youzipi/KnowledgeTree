package nuist.test;

import edu.nuist.knowledge.Knowledge;
import edu.nuist.util.DBConn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class Demo01{
	public static void main(String args[]) throws SQLException{
		DBConn dbconn = new DBConn();
		Statement stmt = dbconn.getConn().createStatement();
		String id="a1";
		String sql1="select * from knowledge_desc where id='"+id+"'";
		String sql2="select * from knowledge_relation where id_sub='"+id+"'";
		ResultSet rs1 = stmt.executeQuery(sql1);	
		LinkedList<String> lList = new LinkedList<String>();
		Knowledge know=null;
		while(rs1.next()){
			know=new Knowledge();
			know.setId(rs1.getString("id"));
			know.setName(rs1.getString("name"));
			know.setContent(rs1.getString("content"));
		}
		rs1.last();
		ResultSet rs2=stmt.executeQuery(sql2);
		while(rs2.next()){
			know.setFather_id(rs2.getString("father_id"));
			lList.add(rs2.getString("id_sub"));
		}
		rs2.last();
		if(know!=null){
		know.setlList(lList);	
		System.out.println(know.getId()+","+know.getName()+","+know.getFather_id());
		}
		else{
			System.out.println("no !");
		}
	}
}