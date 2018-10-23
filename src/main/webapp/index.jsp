<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript"  src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		/* Act on the event */
		/*$.ajax({
			url: 'company/ajaxtest1.do',
			type: 'GET',
			dataType: 'text',
			data: {"haha":"baobei"},
		
		success:function(data){
			alert(data);
		},
		complete:function(){
			alert("after");
		},
		});*/

/*
			 $.ajax({
			url: 'company/ajaxtest2.do',
			type: 'POST',
			dataType: 'json',
			data: {"name":"asd","age":"19"},
		
		success:function(data){
			alert(data.name);
			alert(data.city);
		},
		complete:function(){
			alert("after");
		},
		}); */

		var json  = {"name":"陈佳乐","city":"上海"}
			 $.ajax({
			url: 'company/ajaxtest3.do',
			type: 'POST',
			contentType: "application/json;charset=utf-8",
			dataType: 'text',
			data:JSON.stringify(json) ,
		
		success:function(data){
			alert("成功");
		},
		complete:function(){
			alert("after");
		},
		
		}); 


		
	});

</script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="company/test.do">
<input  type="submit" value="成功"/>
</form>
</body>
</html>