package edu.nuist.test;

import java.sql.SQLException;

import edu.nuist.knowledge.Knowledge;
import edu.nuist.knowledge.KnowledgeDBHelper;

public class Demo02 {
	public static void main(String args[]) throws SQLException{
		Knowledge know=KnowledgeDBHelper.getKnowById("1");
		for(int i=0;i<know.getlList().size();i++)
		{	
			System.out.println(know.getlList().get(i));
			Knowledge know1=KnowledgeDBHelper.getKnowById(know.getlList().get(i));
			System.out.println(know.getId()+","+know1.getName());
		}
	}
}
