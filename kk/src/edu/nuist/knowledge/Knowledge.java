package edu.nuist.knowledge;
import edu.nuist.util.UUIDGenerator;

import java.util.LinkedList;

public  class Knowledge {
	private String father_id;
	//private String father_id;
	private String id;
	private String name;
	private String content;	
	//public static LinkedList<String> lList=new <String>LinkedList();
	public static LinkedList<String> lList=new LinkedList();

	public Knowledge(String father_id,String name,String content){
		this.father_id=father_id;
		this.id = new UUIDGenerator().getUUID();
		this.name = name;
		this.content = content;
	}
	public Knowledge(String name, String content) {
		this.id = new UUIDGenerator().getUUID();
		this.name = name;
		this.content = content;
	}
	public Knowledge() {

	}
	public String getFather_id() {
		return father_id;
	}
	public void setFather_id(String father_id) {
		this.father_id = father_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public static LinkedList<String> getlList() {
		return lList;
	}
	public static void setlList(LinkedList<String> lList) {
		Knowledge.lList = lList;
	}
}
