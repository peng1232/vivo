<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../../css/xzfrom.css" />
</head>
	<body>
		<div class="from_xz">
			  <div class="form-container">
			         <h2 class="form-title">管理员登录</h2>
			         <form>
			             <div class="form-field">
			                 <label class="form-label" for="nickname">昵称:</label>
			                 <input class="form-input" type="text" id="nickname" name="nickname" required>
			             </div>
			             <div class="form-field">
			                 <label class="form-label" for="username">用户名:</label>
			                 <input class="form-input" type="text" id="username" name="username" required>
			             </div>
			             <div class="form-field">
			                 <label class="form-label" for="password">密码:</label>
			                 <input class="form-input" type="password" id="password" name="password" required>
			             </div>
			             <div class="form-field">
			                 <label class="form-label" for="phone">手机号码:</label>
			                 <input class="form-input" type="tel" id="phone" name="phone" required>
			             </div>
			             <div class="form-field">
			                 <input class="form-submit" type="submit" value="登录">
							<input type="reset" value="重置" class="form-submit">
			             </div>	
			         </form>
			     </div>
		</div>
	</body>
</html>