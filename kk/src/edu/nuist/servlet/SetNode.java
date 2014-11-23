package edu.nuist.servlet;

import edu.nuist.knowledge.Knowledge;
import edu.nuist.knowledge.KnowledgeDBHelper;
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
public class SetNode extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String content = request.getParameter("content");

        int num;
        PrintWriter out = response.getWriter();
        System.out.println("set_node");
        num = setNodeInfo(id, name, content);
        System.out.println("num="+num);
        out.print(num);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    public int setNodeInfo(String id,String name,String content) {
        JSONObject jObject = new JSONObject();
        try {
            Knowledge know = new Knowledge();
            know.setId(id);
            know.setName(name);
            know.setContent(content);
            int num = KnowledgeDBHelper.update(know);
            return num;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void main(String[] args) {
        SetNode test = new SetNode();
        //test.setNodeInfo("1");
    }
}
