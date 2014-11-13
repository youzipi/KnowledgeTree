/**
 * project_name:kk
 * package_name:edu.nuist
 * user: youzipi
 * date: 2014/11/12 19:02
 */

import edu.nuist.knowledge.Knowledge;
import edu.nuist.knowledge.KnowledgeDBHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

public class InitTree extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        //String id = request.getParameter("id");
        //PrintWriter out = response.getWriter();
//        LinkedList l = knowhelper.getKnowledge();
//        int i;
//        for (i = 0; i < l.size(); i++) {
//            String id = (String) l.get(i);
//            know = knowhelper.getKnowById(id);
//            %>
//            <li id="<%=know.getId()%>"><span><%=know.getName()%></span>


    }

    public JSONArray getJSONArray(){
        JSONObject jObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        try {
            LinkedList l = KnowledgeDBHelper.getKnowledge();
            System.out.println(l);
            //System.out.println(l.getClass());
            int i;
            for (i = 0; i < l.size(); i++) {
                String id = (String) l.get(i);
                Knowledge know = KnowledgeDBHelper.getKnowById(id);
                jObject.put("id", know.getId());
                //System.out.println("father_id:" + know.getFather_id());
                jObject.put("pId", know.getFather_id());
                jObject.put("name", know.getName());
                jsonArray.add(jObject);
            }
            System.out.print(jsonArray);
        }catch(SQLException e){
            e.printStackTrace();
        }
        //System.out.println(jsonArray);
        return jsonArray;
    }

    public static void main(String[] args) {
        InitTree test = new InitTree();
        test.getJSONArray();

    }
}
