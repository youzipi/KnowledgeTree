
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
 * date: 2014/11/17 15:23
 */
public class addNode extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String name = request.getParameter("name");
        String pId = request.getParameter("pId");

        int num;
        PrintWriter out = response.getWriter();
        System.out.println("add_node");
        num = createNode(name, pId);
        System.out.println("num="+num);
        out.print(num);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    public int createNode(String name,String pId) {
        JSONObject jObject = new JSONObject();
        try {
            Knowledge know = new Knowledge(pId,name,"");
            System.out.println("newNode.id="+know.getId());
            int num = KnowledgeDBHelper.insert(know);
            return num;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void main(String[] args) {
        addNode test = new addNode();
        test.createNode("name","pId");
    }
}

