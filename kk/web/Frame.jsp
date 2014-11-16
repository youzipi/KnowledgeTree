<%@ page contentType="text/html;charset=GB2312"%>

<html>
  <head>
	<style>
	*{
		margin: 0;
		padding: 0;
	}
	body{
		width: 100%;
		height: 100%;
		overflow:hidden;
		background: url("bgz.jpg") no-repeat left top;
	}
	.container{
		width: 966px;
		height: 560px;
		position: absolute;
		top: 50%;
		left: 50%;
		margin: -280px 0px 0px -480px;
	
	}
	
	.left{
		position: absolute;		
		width:240px;
		height:560px;
		border:1px solid black;
		
	}
	.right{
		position: absolute;
		width:700px;
		height:560px;
		right:0%;
		border:1px solid black;
	}
	.up{
		position: absolute;
		width: 640px;
		height: 50px;	
		margin:20px ;
		border:1px solid black;
		
	}
	.down{
		width: 640px;
		height: 400px;
		position: absolute;
		top:12%;
		margin:20px ;
		border:1px solid black;
	}
	.button1{
		width: 100px;
		height: 40px;
		position: absolute;
		border:1px solid black;
		margin:72% 0% 0% 70%;
		padding:2px;
	}
	.button2{
		width: 100px;
		height: 40px;
		position: absolute;
		border:1px solid black;
		margin:72% 0% 0% 78%;
		padding:2px;
	#id1{
	
	}
	#id2{
	}
	</style>

</head>
	<body>
	<div class="container">
		
		 <div class="left">
		 <!--Sidebar content-->
		 </div>
		<div class="right">
		  <!--Body content-->
		  <div class="up"> </div>
		  <div class="down"> </div>
		 <div class="button1">
		 <input id="id1" type="submit" value="删除" name="delete" onclick="del();"> </div>
			<div class="button2">
				<input id="id2" type="submit" value="取消" name="cancel" onclick="can();">

		
		 </div>

		 </div>
  </div>
			
			
		 
	
	<script>
	function del(){
	if(confirm("确认删除吗")){
	  alert("yes");
	 }
	 else{
	 alert("no")
	 return;
	 }
	}
	function can(){
	if(confirm("确认取消吗")){
	  alert("yes");
	 }
	 else{
	 alert("no")
	 return;
	 }
	}
	
	</script>
	</body>
</html>
