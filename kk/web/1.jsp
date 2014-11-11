<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="edu.nuist.knowledge.*"%>
<%@ page import="edu.nuist.util.*"%>
<jsp:useBean id="know" scope="page"

	class="edu.nuist.knowledge.Knowledge" />
<jsp:useBean id="know1" scope="page"
	class="edu.nuist.knowledge.Knowledge" />
<jsp:useBean id="knowhelper" scope="page"
	class="edu.nuist.knowledge.KnowledgeDBHelper" />
<jsp:useBean id="knowhelper1" scope="page"
	class="edu.nuist.knowledge.KnowledgeDBHelper" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Knowledge tree</title>
<style>
li {
	cursor: hand;}
</style>
<script src="js/jquery.js" type="text/javascript">
</script>
<script>
	$(function() {		
		$("ul li span").click(function(){
				alert("why");
				var id=$(this).parent().attr("id");				
				$.ajax({
					url:"http://localhost:8080/Kledge/Test",
					type:"POST",
					data:{'id':id},
					dataType:'json',
					success:function(json){
						$("#"+id).append("<ul></ul>");
						for(var i=0;i<json.length;i++)
						{
						$("#"+id+" ul").append("<li id="+json[i].id+ ">"+"</li>");
						$("#"+json[i].id).append("<span>"+json[i].name+"</span>");
						}
					}
				});	//$.ajax 结束
				
		});
	})
</script>
</head>
<body>
	<ul>
		<%
			LinkedList l = knowhelper.getKnowledge();
			int i;
			for (i = 0; i < l.size(); i++) {
				String id = (String) l.get(i);
				know = knowhelper.getKnowById(id);
		%>
		<li id="<%=know.getId()%>"><span><%=know.getName()%></span>
		</li>
		<%
			}
		%>
	</ul>
</body>
</html>