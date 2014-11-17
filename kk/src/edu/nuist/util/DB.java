package edu.nuist.util;

import java.sql.*;

/**
 * project_name:java_demo
 * package_name:com.jdbc
 * user: youzipi
 * date: 2014/9/29
 * jdbc封装
 */
public class DB {
    static String url = "jdbc:mysql://localhost:3306/infotree";
    static String classname= "com.mysql.jdbc.Driver";
    static String username = "root";
    static String password = "123456";
    //static String charset = "utf8";

    static Statement stmt = null;
    static ResultSet rs = null;

    private Connection conn = null;

    public DB(){

    }
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            if(conn == null){
                conn = DriverManager.getConnection(url, username, password);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        //System.out.println("Connected...");
        return conn;
    }
    public Statement getStm(){
        try{
            conn=getConnection();
            stmt=conn.createStatement();
        }catch(Exception e){e.printStackTrace(System.err);}
        return stmt;
    }


    public Statement getStmed(){
        try{
            conn=getConnection();
            stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        }catch(Exception e){e.printStackTrace(System.err);}
        return stmt;
    }
    public ResultSet getrs(String sql){
        if(sql==null)sql="";
        try{
            stmt=getStm();
            rs=stmt.executeQuery(sql);
        }catch(SQLException e){e.printStackTrace();}
        return rs;
    }
    public ResultSet getRs(String sql){
        if(sql==null)sql="";
        try{
            stmt=getStmed();
            rs=stmt.executeQuery(sql);
        }catch(SQLException e){e.printStackTrace();}
        return rs;
    }
    public int update(String sql){
        int num=0;
        if(sql==null)sql="";
        try{
            stmt=getStmed();
            num=stmt.executeUpdate(sql);
        }catch(SQLException e){e.printStackTrace();num=0;}
        return num;
    }

    public boolean delete(String sql){
        boolean ok;
        if(sql==null)sql="";
        try{
            stmt=getStmed();
            ok=stmt.execute(sql);
            //System.out.println("okkkk="+ok);
            return true;
        }catch(SQLException e){e.printStackTrace();}
        return false;
    }

    public void closed(){
        try{
            if(rs!=null)rs.close();
        }catch(Exception e){e.printStackTrace();}
        try{
            if(stmt!=null)stmt.close();
        }catch(Exception e){e.printStackTrace();}
        try{
            if(conn!=null)conn.close();
        }catch(Exception e){e.printStackTrace();}
    }
}

