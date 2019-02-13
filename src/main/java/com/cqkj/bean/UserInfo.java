package com.cqkj.bean;

import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * 用户信息实体，对应的表为UserInfo
 * 
 * @author lsl
 *
 */
@Component
public class UserInfo
{
    // 用户ID
    @PK
    private int userId;
    // 部门ID
    private int deptId;
    // 登录名
    private String loginName;
    // 登录密码
    private String loginPwd;
    // 用户姓名
    private String name;
    // 用户性别
    private String sex;
    // 用户年龄
    private int age;
    // 用户电话号码
    private String phone;
    // 用户身份证号
    private String idCard;
    // 用户微信号
    private String weChat;
    // 用户地址
    private String address;
    // 用户是否存在
    private int isDelete = 0;
    // 用户是否锁定
    private int isEnable = 1;
    // 创建日期
    @NotAdd
    private Date createDate;
    // 创建人的ID
    private int createUser;
    // 最后修改日期
    @NotAdd
    private Date lastUpdateDate;
    // 最后修改人ID
    private int lastUpdateUser;

    // 封装
    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public int getDeptId()
    {
        return deptId;
    }

    public void setDeptId(int deptId)
    {
        this.deptId = deptId;
    }

    public String getLoginName()
    {
        return loginName;
    }

    public void setLoginName(String loginName)
    {
        this.loginName = loginName;
    }

    public String getLoginPwd()
    {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd)
    {
        this.loginPwd = loginPwd;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getIdCard()
    {
        return idCard;
    }

    public void setIdCard(String idCard)
    {
        this.idCard = idCard;
    }

    public String getWeChat()
    {
        return weChat;
    }

    public void setWeChat(String weChat)
    {
        this.weChat = weChat;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public int getIsDelete()
    {
        return isDelete;
    }

    public void setIsDelete(int isDelete)
    {
        this.isDelete = isDelete;
    }

    public int getIsEnable()
    {
        return isEnable;
    }

    public void setIsEnable(int isEnable)
    {
        this.isEnable = isEnable;
    }

    public Date getCreateDate()
    {
        return createDate;
    }

    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }

    public int getCreateUser()
    {
        return createUser;
    }

    public void setCreateUser(int createUser)
    {
        this.createUser = createUser;
    }

    public Date getLastUpdateDate()
    {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate)
    {
        this.lastUpdateDate = lastUpdateDate;
    }

    public int getLastUpdateUser()
    {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(int lastUpdateUser)
    {
        this.lastUpdateUser = lastUpdateUser;
    }

    /**
     * 无参的构造方法
     */
    public UserInfo()
    {

    }

    /**
     * 带16个参数的构造方法
     * 
     * @param deptId
     * @param loginName
     * @param loginPwd
     * @param name
     * @param sex
     * @param age
     * @param phone
     * @param idCard
     * @param weChat
     * @param address
     * @param isDelete
     * @param isEnable
     * @param createDate
     * @param createUser
     * @param lastUpdateDate
     * @param lastUpdateUser
     */
    public UserInfo(int deptId, String loginName, String loginPwd, String name, String sex, int age, String phone,
            String idCard, String weChat, String address, int isDelete, int isEnable, Date createDate, int createUser,
            Date lastUpdateDate, int lastUpdateUser)
    {
        super();
        this.deptId = deptId;
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.idCard = idCard;
        this.weChat = weChat;
        this.address = address;
        this.isDelete = isDelete;
        this.isEnable = isEnable;
        this.createDate = createDate;
        this.createUser = createUser;
        this.lastUpdateDate = lastUpdateDate;
        this.lastUpdateUser = lastUpdateUser;
    }

    /**
     * 带17个参数的构造方法
     * 
     * @param userId
     * @param deptId
     * @param loginName
     * @param loginPwd
     * @param name
     * @param sex
     * @param age
     * @param phone
     * @param idCard
     * @param weChat
     * @param address
     * @param isDelete
     * @param isEnable
     * @param createDate
     * @param createUser
     * @param lastUpdateDate
     * @param lastUpdateUser
     */
    public UserInfo(int userId, int deptId, String loginName, String loginPwd, String name, String sex, int age,
            String phone, String idCard, String weChat, String address, int isDelete, int isEnable, Date createDate,
            int createUser, Date lastUpdateDate, int lastUpdateUser)
    {
        this.userId = userId;
        this.deptId = deptId;
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.idCard = idCard;
        this.weChat = weChat;
        this.address = address;
        this.isDelete = isDelete;
        this.isEnable = isEnable;
        this.createDate = createDate;
        this.createUser = createUser;
        this.lastUpdateDate = lastUpdateDate;
        this.lastUpdateUser = lastUpdateUser;
    }

}
