<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%! int i =1;%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>各种头像查询~~~~</h2>
	<form action="SearchPageAction" method="POST">
		<s:radio list="#{'男':'男','女':'女'}" name="sex"  listValue="key" listKey="value"></s:radio>
		<input type="hidden" name="page" value="<%=i++%>">
		<s:submit value="下一页" labelposition="left"></s:submit>
	</form>
	
	<form action="Name" method="POST">
		<s:textfield name="student.name"/>
		<s:submit value="查询"></s:submit>
	</form>
	
	
	<s:iterator value="%{#session.students}" id="student">
		<s:property value="#student.name"/>
		<img alt="" src="<s:url value="\crawler%{#student.pic}"/>"/>
	</s:iterator>
</body>
</html>