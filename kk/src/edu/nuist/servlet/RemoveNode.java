package edu.nuist.servlet;

import edu.nuist.knowledge.KnowledgeDBHelper;

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
 * date: 2014/11/17 16:27
 */
public class RemoveNode extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String id = request.getParameter("id");

        int num;
        PrintWriter out = response.getWriter();
        System.out.println("delete_node");
        num = deleteNode(id);
        System.out.println("num="+num);
        out.print(num);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    public int deleteNode(String id) {
        try {
            boolean ok = KnowledgeDBHelper.delete(id);
            if(ok)
                return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void main(String[] args) {
        RemoveNode test = new RemoveNode();
        test.deleteNode("id");
    }
}

