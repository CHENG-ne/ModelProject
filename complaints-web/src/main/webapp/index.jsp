<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.0.0.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/vue.min.js"></script>

<title>首页</title>
</head>
<body>
	<input type="hidden" id="item" value="<%=request.getContextPath() %>"></input>
	hello,世界!<%=request.getContextPath() %>
	<div id="app">
            <h1>Hello, Vue.js!</h1>
            <h1 v-if="yes">Yes!</h1>
            <h1 v-if="no">No!</h1>
            <h1 v-if="age >= 25">Age: {{ age }}</h1>
            <h1 v-if="name.indexOf('jack') >= 0">Name: {{ name }}</h1>
    </div>
<script>
    var vm = new Vue({
        el: '#app',
        data: {
            yes: true,
            no: false,
            age: 28,
            name: 'keepfool'
        }
    })
</script>
</body>
</html>