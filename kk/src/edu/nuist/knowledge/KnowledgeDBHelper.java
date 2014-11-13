package edu.nuist.knowledge;

import edu.nuist.util.DB;
import edu.nuist.util.DBConn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class KnowledgeDBHelper {
	@SuppressWarnings("null")
//	public static Knowledge getKnowById(String id) throws SQLException {
//		DBConn dbconn = new DBConn();
//		Statement stmt = dbconn.getConn().createStatement();
//		String sql = "select father_id,id,name,content,id_sub from knowledge_desc,knowledge_relation "
//				+ "where knowledge_desc.id= '" + id + "'";
//		ResultSet rs = stmt.executeQuery(sql);
//		LinkedList<String> lList = new LinkedList<String>();
//		Knowledge know  = null;
//		int i = 1;
//		while (rs.next()) {	
//			if (i == 1) {
//				know =new Knowledge();
//				know.setFather_id(rs.getString("father_id"));
//				know.setId(rs.getString("id"));
//				know.setName(rs.getString("name"));
//				know.setContent(rs.getString("content"));
//				i--;
//				lList.add(rs.getString("id_sub"));
//			
//			} else
//				lList.add(rs.getString("id_sub"));
//		}		
//		if (know != null)
//			know.setlList(lList);
//		return know;
//	}
	public static Knowledge getKnowById(String id) throws SQLException{
		//DBConn dbconn = new DBConn();
		//Statement stmt = dbconn.getConn().createStatement();
        DB db = new DB();

		String sql1="select * from knowledge_desc where id='"+id+"'";
        //String sql2="select * from knowledge_relation where father_id='"+id+"'";
        String sql2="select * from knowledge_relation where father_id='"+id+"'";
        String sql3="select * from knowledge_relation where id_sub='"+id+"'";

        //System.out.println(sql1);
        //System.out.println(sql2);
        //System.out.println(sql3);

        ResultSet rs1 = db.getrs(sql1);
        ResultSet rs2 = db.getrs(sql2);
        ResultSet rs3 = db.getrs(sql3);


		LinkedList<String> lList = new LinkedList<String>();
		Knowledge know=null;
		while(rs1.next()){
			know=new Knowledge();
			know.setId(rs1.getString("id"));
			know.setName(rs1.getString("name"));
			know.setContent(rs1.getString("content"));
		}
		rs1.last();
		//ResultSet rs2=stmt.executeQuery(sql2);
        while(rs2.next()){
            //String father_id = rs2.getString("father_id");
			//know.setFather_id(father_id);
			lList.add(rs2.getString("id_sub"));
		}
		rs2.last();
        while(rs3.next()){
            //System.out.println("father_id="+rs3.getString("father_id"));
            know.setFather_id(rs3.getString("father_id"));
        }
        rs3.last();
        db.closed();

		if(know!=null){
		know.setlList(lList);
		return know;
		}
		return null;
	}
	public static LinkedList getKnowByKeyword(String[] keyword)
			throws SQLException {
		DBConn dbconn = new DBConn();
		Statement stmt = dbconn.getConn().createStatement();
		String sql = "select * from knowledge_desc where ";
		for (int i = 0; i < keyword.length - 1; i++) {
			sql += "content like '%" + keyword[i] + "%' or" + " ";
		}
		sql += "content like '%" + keyword[keyword.length - 1] + "%'";
		ResultSet rs = stmt.executeQuery(sql);
		LinkedList lList = new LinkedList();
		while (rs.next()) {
			lList.add(getKnowById(rs.getString("id")));
		}
		return lList;
	}

	public static void save(Knowledge know) throws SQLException {
		DBConn dbconn = new DBConn();
		Statement stmt = dbconn.getConn().createStatement();
		String insertquery1 = "insert into knowledge_desc values('"
				+ know.getId() + "','" + know.getName() + "','"
				+ know.getContent() + "')";
		stmt.executeUpdate(insertquery1);
		String insertquery2 = "insert into knowledge_relation values('"
				+ know.getFather_id() + "','" + know.getId() + "')";
		stmt.executeUpdate(insertquery2);
	}

	public static void delete(String id) throws SQLException {
		DBConn dbconn = new DBConn();
		Statement stmt = dbconn.getConn().createStatement();
		Knowledge know = getKnowById(id);
		String deletesql1 = "delete from knowledge_desc where id='" + id + "'";
		String deletesql2 = "delete from knowledge_relation where father_id='"
				+ id + "'";
		stmt.executeUpdate(deletesql1);
		stmt.executeUpdate(deletesql2);
	}
	public static void move(Knowledge know_new,Knowledge know_old)throws SQLException{
		DBConn dbconn = new DBConn();
		Statement stmt = dbconn.getConn().createStatement();
		
		String updatesql="update knowledge_relation set father_id='"+know_new.getId()+"'"
				+"where father_id='"+know_old.getFather_id()+"'";
		stmt.executeUpdate(updatesql);
	}
    //最顶层
	public static LinkedList getKnowledge() throws SQLException{
		DBConn dbconn = new DBConn();
		Statement stmt = dbconn.getConn().createStatement();

		String sql="select * from knowledge_relation where father_id='null'";
		ResultSet rs=stmt.executeQuery(sql);
		LinkedList l=new LinkedList();
		while(rs.next()){
			l.add(rs.getString("id_sub"));
		}
		return l;
	}

    public static void main(String[] args) throws SQLException {
        KnowledgeDBHelper k = new KnowledgeDBHelper();
        System.out.println("root_id="+k.getKnowledge());
        Knowledge know = k.getKnowById("1");
        System.out.println("father_id="+know.getFather_id());
        System.out.println("id="+know.getId());
        System.out.println("name="+know.getName());
        System.out.println("sub_id="+know.getlList());
    }
}
