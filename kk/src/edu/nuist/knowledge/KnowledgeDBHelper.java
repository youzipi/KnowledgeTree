package edu.nuist.knowledge;

import edu.nuist.util.DB;
import edu.nuist.util.DBConn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class KnowledgeDBHelper {
	@SuppressWarnings("null")

	public static Knowledge getKnowById(String id) throws SQLException{
        DB db = new DB();

		String sql1="select * from knowledge_desc where id='"+id+"'";
        String sql2="select * from knowledge_relation where father_id='"+id+"'";
        String sql3="select * from knowledge_relation where id_sub='"+id+"'";

        //System.out.println(sql1);
        //System.out.println(sql2);
        //System.out.println(sql3);

        ResultSet rs1 = db.getrs(sql1);


		LinkedList<String> lList = new LinkedList<String>();
		Knowledge know=null;
		while(rs1.next()){
			know=new Knowledge();
			know.setId(rs1.getString("id"));
			know.setName(rs1.getString("name"));
			know.setContent(rs1.getString("content"));
		}
		rs1.last();

        ResultSet rs2 = db.getrs(sql2);
        while(rs2.next()){
			lList.add(rs2.getString("id_sub"));
		}
		rs2.last();

        ResultSet rs3 = db.getrs(sql3);
        while(rs3.next()){
            if (know != null) {
                know.setFather_id(rs3.getString("father_id"));
            }
        }
        rs3.last();
        //db.closed();

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
    public static int update(Knowledge know)throws SQLException{
        DB db = new DB();
        String sql = "update knowledge_desc set name=\""+know.getName()+"\", content=\""+know.getContent()+"\" where id=\""+know.getId()+"\"";
        System.out.println(sql);
        int num = db.update(sql);
        db.closed();
        System.out.println(num);
        return num;
    }


    public static int insert(Knowledge know) throws SQLException {
        DB db = new DB();

        String sql1 = "insert into knowledge_desc (id,name) values(\""+know.getId()+"\", \""+know.getName()+"\");";
        String sql2 = "insert into knowledge_relation (father_id,id_sub) values(\""+know.getFather_id()+"\",\""+know.getId()+"\");";
        System.out.println(sql1);
        System.out.println(sql2);

        int num1 = db.update(sql1);
        int num2 = db.update(sql2);

        db.closed();
        System.out.println("num1="+num1);
        System.out.println("num2="+num2);
        return num1+num2;
	}

	public static boolean delete(String id) throws SQLException {
        DB db = new DB();

        boolean ok1;
        boolean ok2;
		Knowledge know = getKnowById(id);
		String sql1 = "delete from knowledge_desc where id='" + id + "'";
		String sql2 = "delete from knowledge_relation where id_sub='"
				+ id + "'";
        System.out.println(sql1);
        System.out.println(sql2);
        System.out.println(db.delete(sql1));
		ok1 = db.delete(sql1);
		ok2 = db.delete(sql2);
        System.out.println("ok1="+ok1);
        System.out.println("ok1="+ok2);
        System.out.println("ok1 && ok2="+(ok1 && ok2));
        return (ok1 && ok2);

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

        k.update(know);
    }




}
