<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>サーブレット＆JDBCサンプルコード</title>
</head>
<body>
  <h2>登録内容の入力</h2>

  <form action="/servlet_jdbc/insert">
    ID：<input type="text" name="id" />※登録済みのIDは入力しないでください。<br /> 名前：<input
      type="text" name="name" /><br /> 金額：<input type="text" name="money" /><br />
    <input type="submit" value="登録" />
  </form>

  <p>
    <a href="/servlet_jdbc/">トップ画面に戻る</a>
  </p>
</body>
</html>