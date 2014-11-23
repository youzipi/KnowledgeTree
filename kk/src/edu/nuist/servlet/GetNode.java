package edu.nuist.servlet;

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

/**
 * project_name:kk
 * package_name:PACKAGE_NAME
 * user: youzipi
 * date: 2014/11/16 17:57
 */
public class GetNode extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");


        //String method = request.getParameter("method");
        String id = request.getParameter("id");
        System.out.println("name"+request.getParameter("name"));
        System.out.println("id="+id);
        //JSONArray node;
        JSONObject node;
        //System.out.println("null".equals(id));
        //System.out.println(id == null);
        PrintWriter out = response.getWriter();
        //if(method.equals("read")) {

            System.out.println("get_node");
            node = getNodeInfo(id);
            out.print(node);

        //System.out.println(node);
        //out.print("node");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    public JSONObject getNodeInfo(String id) {
        JSONObject jObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        try {
            Knowledge know = KnowledgeDBHelper.getKnowById(id);
            jObject.put("id", know.getId());
            jObject.put("name", know.getName());
            jObject.put("content", know.getContent());

            jsonArray.add(jObject);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(jsonArray);
        //return jsonArray;
        return jObject;
    }

    public static void main(String[] args) {
        GetNode test = new GetNode();
        test.getNodeInfo("1");
    }
}
