<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>用户登录</title>
</head>
<script language="JavaScript">
    function validate(f) {
        if (!(/^\w{5,15}$/.test(f.userId.value))) {
            alert("用户名必须是5~15位！");
            f.userId.focus();
            return false;
        }
        if (!(/^\w{5,15}$/.test(f.password.value))) {
            alert("密码必须是5~15位！");
            f.password.focus();
            return false;
        }
        return true;
    }
</script>
<body>
<h2>用户登录程序</h2>
<%
    List<String> info = (List<String>) request.getAttribute("info");
    if (info != null) {
        for (String str : info) {
%>
            <h4><%=str%></h4>
<%
        }
    }
%>
<form action="LoginServlet" method="post" onsubmit="return validate(this)">
    用户名：<input type="text" name="userId"><br>
    密　码：<input type="password" name="password"><br>
    <input type="submit" value="登录">
    <input type="reset" value="重置">
</form>
</body>
</html>
