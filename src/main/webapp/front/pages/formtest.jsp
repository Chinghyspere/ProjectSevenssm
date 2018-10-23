<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript"  src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">



</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>/company/formtest2.do" onsubmit="return test()">


<table style="margin-left:350px;width:400px;height:500px;border: 2px solid black;box-shadow: 3px 3px 3px grey; ">
<tr>
<td>公司编号</td><td><input type="text" name="id" id="id"></td><td><p style="color:red">*</p></td>
</tr>
<tr>
<td>公司名称</td><td><input type="text" name="name" id="name"></td><td><p style="color:red">*</p></td>
</tr>
<tr>
<td>所在城市</td><td><input type="text" name="city"></td><td><p style="color:red"></p></td>
</tr>
<tr>
<td>联系电话</td><td><input type="text" name="phone"></td><td><p style="color:red"></p></td>
</tr>
<tr>
<td>传真</td><td><input type="text" name="fax"></td><td><p style="color:red"></p></td>
</tr>
<tr>
<td>地址</td><td><input type="text" name="address"></td><td><p style="color:red"></p></td>
</tr>
<tr>
<td>备注</td><td><input type="text" name="remark"></td><td><p style="color:red"></p></td>
</tr>
<tr>
<td><input type="submit" value="提交" style="width:80px"></td><td><input type="reset" value="重置" style="margin-left:-70px;width:80px"></td><td></td>
</tr>
</table>
</form>
</body>
</html>