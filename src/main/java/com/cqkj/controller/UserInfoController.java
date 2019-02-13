package com.cqkj.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqkj.bean.DeptInfo;
import com.cqkj.bean.UserInfo;
import com.cqkj.service.DeptInfoService;
import com.cqkj.service.UserInfoService;

@Controller
public class UserInfoController
{
    @Resource
    UserInfoService userInfoService;

    @Resource
    DeptInfoService deptInfoService;

    @Resource
    UserInfo userInfo;

    @GetMapping("/userInfo")
    public String userInfo(Integer pageIndex, ModelMap map)
    {
        if (pageIndex != null)
        {
            map.put("pageIndex", pageIndex);
        }
        return "view/userInfo/userInfo";
    }

    @GetMapping("/addUser")
    public String addUser(Integer flag, Integer userId, ModelMap map)
    {
        if (userId != null)
        {
            map.put("userId", userId);
        }

        map.put("flag", flag);

        return "view/userInfo/addUser";
    }

    @GetMapping("/delete")
    public String deleteUserInfo(Integer userId) throws Exception
    {

        userInfoService.deleteUserInfo(userId);

        return "view/userInfo/userInfo";
    }

    @PostMapping("/add")
    public String addUserInfo(HttpServletRequest request, HttpSession session) throws Exception
    {
        userInfo.setDeptId(Integer.parseInt(request.getParameter("deptId")));
        userInfo.setLoginName(request.getParameter("loginName"));
        userInfo.setLoginPwd(request.getParameter("loginPwd"));
        userInfo.setName(request.getParameter("name"));
        userInfo.setSex(request.getParameter("sex"));
        userInfo.setAge(Integer.parseInt(request.getParameter("age")));
        userInfo.setPhone(request.getParameter("phone"));
        userInfo.setIdCard(request.getParameter("idCard"));
        userInfo.setWeChat(request.getParameter("weChat"));
        userInfo.setAddress(request.getParameter("address"));
        userInfo.setCreateUser(Integer.parseInt(session.getAttribute("userId").toString()));
        userInfo.setLastUpdateUser(Integer.parseInt(session.getAttribute("userId").toString()));
        userInfo.setCreateDate(new Date());
        userInfo.setLastUpdateDate(new Date());

        userInfoService.insertUserInfo(userInfo);

        return "view/userInfo/userInfo";
    }

    @PostMapping("/getDeptJson")
    @ResponseBody
    public List<DeptInfo> getDeptJson() throws Exception
    {
        return deptInfoService.selectAllDeptInfo();
    }

    @PostMapping("/update")
    public String updateUserInfo(HttpServletRequest request, HttpSession session) throws Exception
    {
        // �ı�ͻ������е����༭��ID
        userInfo.setLastUpdateUser(Integer.parseInt(session.getAttribute("userId").toString()));
        // �ı�ͻ������е����༭ʱ��
        userInfo.setLastUpdateDate(new Date());

        // �ı������ͻ���Ϣ
        userInfo.setUserId(Integer.parseInt(request.getParameter("userId")));
        userInfo.setDeptId(Integer.parseInt(request.getParameter("deptId")));
        userInfo.setLoginName(request.getParameter("loginName"));
        userInfo.setLoginPwd(request.getParameter("loginPwd"));
        userInfo.setName(request.getParameter("name"));
        userInfo.setSex(request.getParameter("sex"));
        userInfo.setAge(Integer.parseInt(request.getParameter("age")));
        userInfo.setPhone(request.getParameter("phone"));
        userInfo.setIdCard(request.getParameter("idCard"));
        userInfo.setWeChat(request.getParameter("weChat"));
        userInfo.setAddress(request.getParameter("address"));
        userInfo.setCreateUser(Integer.parseInt(request.getParameter("createUser")));
        userInfo.setCreateDate(new Date(Long.parseLong(request.getParameter("createDate"))));

        // ���ø��µķ���
        userInfoService.updateUserInfo(userInfo);

        return "view/userInfo/userInfo";
    }
    
    @PostMapping("/checkLoginName")
    @ResponseBody
    public String checkLoginName(String loginName,ModelMap map) throws Exception
    {
        String msg;
        //����Service�ķ����ж��û��Ƿ����
        if (userInfoService.userNameIsExist(loginName))
        {
            msg = "Y";
        } else
        {
            msg = "N";
        }
        
        return msg;
    }

}
