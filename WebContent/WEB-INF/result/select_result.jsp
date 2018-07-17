<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, jp.co.sss.sample.bean.Account"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>サーブレット＆JDBCサンプルコード</title>
</head>
<body>
	<h2>検索結果</h2>

	<table border="1">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>MONEY</th>
		</tr>
		<%
			List<Account> list = (List<Account>) request.getAttribute("list");
			for (int i = 0; i < list.size(); i++) {
				Account account = list.get(i);
		%>
		<tr>
			<td><%=account.getId()%></td>
			<td><%=account.getName()%></td>
			<td><%=account.getMoney()%></td>
		</tr>
		<%
			}
		%>
	</table>

	<p>
		<a href="<%= request.getContextPath() %>">トップ画面に戻る</a>
	</p>
</body>
</html>