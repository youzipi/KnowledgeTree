package edu.nuist.test;

import edu.nuist.knowledge.Knowledge;
import edu.nuist.knowledge.KnowledgeDBHelper;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class KnowledgeDBHelperTest {
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testGetKnowById() throws SQLException {
		String id="ad1e13af629c42a1b7c735fa5bb403ed";
		Knowledge know2=KnowledgeDBHelper.getKnowById(id);
		assertEquals(1,know2.getlList().size());
	}

	@Test
	public void testGetKnowByKeyword() throws SQLException {
		String[] test=new String[]{"hello"};
		LinkedList list=KnowledgeDBHelper.getKnowByKeyword(test);
		assertEquals(2,list.size());
	}

//	@Test
//	public void testSave() throws SQLException {
//		Knowledge know1=new Knowledge("java","hello world");
//		KnowledgeDBHelper.save(know1);
////		Knowledge know2=KnowledgeDBHelper.getKnowById(know1.getId());
////		assertEquals(know1.getId(),know2.getId());
//
//		Knowledge know2=new Knowledge(know1.getId(),"css","hello css");
//		KnowledgeDBHelper.save(know2);
//		assertEquals(know2.getFather_id(),know1.getId());
//	}

	@Test
	public void testDelete() throws SQLException {
		Knowledge know1=new Knowledge("java","hello world");
		//KnowledgeDBHelper.save(know1);
		KnowledgeDBHelper.delete(know1.getId());
	}

	@Test
	public void testMove() throws SQLException {
		Knowledge know1=new Knowledge("jquery","hello jquery");
		String id="91f90efb7e914dc9ad4b1e9a22825aaa";
		Knowledge know2=KnowledgeDBHelper.getKnowById(id);
		KnowledgeDBHelper.move(know1, know2);
//		System.out.println(know1.getId());
//		System.out.println(know2.getId());
//		System.out.println(know2.getFather_id());
//		assertEquals(know1.getId(),know2.getFather_id());
		
	}

}
