package com.niliv.server;

public class RegisterServlet implements Servletable{

	@Override
	public void service(Request req,Response res) {
		res.print("<html><body>注册成功 --- ");
		res.print(req.getParameter("uname"));
		res.print("</body></html>");
	}

}
