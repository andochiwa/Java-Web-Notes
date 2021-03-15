<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>尚硅谷会员注册页面</title>

	<%--静态包含base标签，css样式，JQuery--%>
	<%@include file="/pages/common/head.jsp"%>

	<style type="text/css">
		.login_form {
			height: 420px;
			margin-top: 25px;
		}
	</style>
	<script>
		$(function () {
			// 给验证码绑定单击事件
			$("#code_img").click(function() {
				this.src = this.src + "?d=" + new Date();
			});

			$("#username").blur(function() {
				var username = this.value;

				$.getJSON("userServlet", "action=ajaxExistUsername&username=" + username, function(data) {
					if(data.existsUserName) {
						$("span.errorMsg").text("用户名已存在");
					} else {
						$("span.errorMsg").text("用户名可用");
					}
				});
			});

			// 给注册绑定单击事件
			$("#sub_btn").click(function() {
				// 验证用户名：由字母，数字，下划线组成的5-12位长度
				var usernameText = $("#username").val();
				var usernamePatt = /^\w{5,12}$/;
				if(!usernamePatt.test(usernameText)) {
					$("span.errorMsg").text("用户名不合法");
					return false;
				}
				$("span.errorMsg").text("");

				// 验证密码：由字母，数字，下划线组成的5-12位长度
				var passwordText = $("#password").val();
				var passwordPatt = /^\w{5,12}$/;
				if(!passwordPatt.test(passwordText)) {
					$("span.errorMsg").text("密码不合法");
					return false;
				}
				$("span.errorMsg").text("");

				// 验证确认密码：和密码相同
				var repwdText = $("#repwd").val();
				if(repwdText != passwordText) {
					$("span.errorMsg").text("密码与确认密码不一致");
					return false;
				}
				$("span.errorMsg").text("");

				// 邮箱验证：xxx@xxx.com的格式
				var emailText = $("#email").val();
				var emailPatt = /^\w+@\w+.com$/
				if(!emailPatt.test(emailText)) {
					$("span.errorMsg").text("邮箱不合法");
					return false;
				}
				$("span.errorMsg").text("");

				// 验证码
				var codeText = $trim($("#code").val());
				if(codeText == null || codeText == "") {
					$("span.errorMsg").text("验证码不能为空");
				}
			});
		});
	</script>
</head>

<body>
	<div id="login_header">
		<img class="logo_img" alt="" src="static/img/logo.gif">
	</div>

	<div class="login_banner">

		<div id="l_content">
			<span class="login_word">欢迎注册</span>
		</div>

		<div id="content">
			<div class="login_form">
				<div class="login_box">
					<div class="tit">
						<h1>注册尚硅谷会员</h1>
						<span class="errorMsg">
							${empty requestScope.msg ? "请输入注册信息" : requestScope.msg}
						</span>
					</div>
					<div class="form">
						<form action="userServlet" method="post">
							<input type="hidden" name="action" value="regist">
							<label>用户名称：</label>
							<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1"
								name="username" id="username"
								value="${requestScope.username}"/>
							<br />
							<br />
							<label>用户密码：</label>
							<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
								name="password" id="password" />
							<br />
							<br />
							<label>确认密码：</label>
							<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1"
								name="repwd" id="repwd" />
							<br />
							<br />
							<label>电子邮件：</label>
							<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1"
								name="email" id="email"
								value="${requestScope.email}"/>
							<br />
							<br />
							<label>验证码：</label>
							<input class="itxt" type="text" style="width: 125px;" id="code" name="code" />
							<img id="code_img" alt="" src="kaptcha.jpg" style="float: right; margin-right: 40px; width: 100px; height: 40px">
							<br />
							<br />
							<input type="submit" value="注册" id="sub_btn" />

						</form>
					</div>

				</div>
			</div>
		</div>
	</div>
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>

</html>