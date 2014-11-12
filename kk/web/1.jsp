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
    <link href="css/bootstrap.min.css" rel="stylesheet">
<style>
li {
	cursor: hand;}
</style>
<script src="js/jquery.js" type="text/javascript">
</script>
<script>
	$(function() {
        var i =1;

        $("ul li span").live('click',function(){
            if(typeof($(this).attr("clicked"))=="undefined") {   //未生成子节点
                var id = $(this).parent().attr("id");
                $.ajax({
                    url: "http://localhost:8080/Test",
                    type: "POST",
                    data: {'id': id},
                    dataType: 'json',
                    success: function (json) {
                        //$("#" + id).append("<ul class='nav nav-list tree'></ul>");
                        $("#" + id).append("<ul></ul>");
                        for (var i = 0; i < json.length; i++) {
                            $("#" + id + " ul").append("<li id=" + json[i].id + ">" + "</li>");
                            $("#" + json[i].id).append("<span>" + json[i].name + "</span>");
                        }
                    }
                });	//$.ajax 结束
                $(this).attr("clicked", "1");
                console.log("created");
            }
            else {
                {
                    console.log("first hide");
                    $(this).nextAll().hide();
                    console.log(i++);
                };
                //
                $(this).toggle(
                    function () {
                        //$(this).animate({"marginLeft": "+=53px"}, 500);
                        $(this).nextAll().show();
                        console.log(i++);
                     },
                    function () {
                        $(this).nextAll().hide();
                        console.log(i++);
                    });
            }

		});
	})
    function demo_create() {
        var ref = $('#jstree_demo').jstree(true),
                sel = ref.get_selected();
        if(!sel.length) { return false; }
        sel = sel[0];
        sel = ref.create_node(sel, {"type":"file"});
        if(sel) {
            ref.edit(sel);
        }
    };

</script>
</head>
<body>
<div class="col-md-4 col-sm-8 col-xs-8">
    <button type="button" class="btn btn-success btn-sm" onclick="demo_create();">Create</button>
    <button type="button" class="btn btn-warning btn-sm" onclick="demo_rename();">Rename</button>
    <button type="button" class="btn btn-danger btn-sm" onclick="demo_delete();">Delete</button>
</div>
<br/>
<br/>
<br/>
<br/>
<div>
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
</div>
</body>
</html>