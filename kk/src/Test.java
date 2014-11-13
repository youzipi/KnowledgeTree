
import edu.nuist.knowledge.Knowledge;
import edu.nuist.knowledge.KnowledgeDBHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.LinkedList;

public class Test extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		JSONObject jObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();   
		String id = request.getParameter("id");
		 PrintWriter out = response.getWriter();
		try {
			Knowledge know = KnowledgeDBHelper.getKnowById(id);
			LinkedList l=know.getlList();
			for(Object obj:l){
				String str=(String)obj;
				Knowledge know1=KnowledgeDBHelper.getKnowById(str);
				jObject.put("id", know1.getId());
				jObject.put("name", know1.getName());
				jObject.put("text", know1.getContent());
				jsonArray.add(jObject);
			}
			out.print(jsonArray);
			System.out.print(jsonArray);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
