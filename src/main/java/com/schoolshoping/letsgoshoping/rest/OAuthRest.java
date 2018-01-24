package com.schoolshoping.letsgoshoping.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.schoolshoping.letsgoshoping.base.Result;



@RestController
@RequestMapping("/schoolshoping")
public class OAuthRest {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
	@RequestMapping(value = "/oauth/info",method = RequestMethod.GET)
	public Result login(String state,@RequestParam String code) {
		String openid = null;
		String employeeNumber=request.getParameter("employeeNumber");
		try {
			//openid = WxHttpClient.getOpenId(request, code);
			HttpSession session = request.getSession();
			session.setAttribute("openId", openid);
			if("CARINSURANCE".equals(state)) {//车险页面
				if(employeeNumber!=null){
					response.sendRedirect("/ui/login?fromdata=CCBCreditCardCarInsurance&openid="+openid+"&employeeNumber="+employeeNumber+"&url=car/ccdstages.html");
				}else{
					response.sendRedirect("/ui/login?fromdata=CCBCreditCardCarInsurance&openid="+openid+"&employeeNumber="+"&url=car/ccdstages.html");
				}
            }else if("CARPOLICY".equals(state)){//我的保单
				response.sendRedirect("/ui/login?openid="+openid+"&url=car/paymentpolicy.html");

            }
		} catch (Exception e) {
			return new Result(-1, e.getMessage());
		}
		return null;
	}
}
