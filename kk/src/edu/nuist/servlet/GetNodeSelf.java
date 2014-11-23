package edu.nuist.servlet; /**
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
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.LinkedList;

public class GetNodeSelf extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String id = request.getParameter("id");
        System.out.println("getnodeself");
        System.out.println("id="+id);
        JSONArray nodes;
        //System.out.println("null".equals(id));
        //System.out.println(id == null);
            nodes = getNode(id);

        PrintWriter out = response.getWriter();
        out.print(nodes);

    }

    public JSONArray getNode(String id){
        JSONObject jObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        try {
            Knowledge know = KnowledgeDBHelper.getKnowById(id);
            LinkedList l=know.getlList();
            for(Object obj:l){
                String str=(String)obj;
                Knowledge know1=KnowledgeDBHelper.getKnowById(str);
                jObject.put("id", know1.getId());
                jObject.put("pId", know1.getFather_id());
                jObject.put("name", know1.getName());
                jObject.put("isParent", (know1.getlList().isEmpty()?0:1));
                jsonArray.add(jObject);
            }
            //System.out.print(jsonArray);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(jsonArray);
        return jsonArray;
    }

    public static void main(String[] args) {
        InitTree test = new InitTree();

        System.out.println("roots=" + test.getRoots());
        System.out.println("roots="+test.getNodes("1"));


    }
}
