package com.cqkj.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SessionInterceptor implements HandlerInterceptor
{

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception
    {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception
    {
        // ��ȡSession����
        HttpSession session = arg0.getSession();

        String loginName = (String) session.getAttribute("loginName");

        // ��֤session�Ƿ���ڣ����������򷵻ص�¼ҳ��
        if (loginName == null)
        {
            arg1.sendRedirect("login");
            return false;
        } else
        {
            return true;
        }

    }

}
