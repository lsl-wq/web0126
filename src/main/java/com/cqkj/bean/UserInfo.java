package com.cqkj.bean;

import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * �û���Ϣʵ�壬��Ӧ�ı�ΪUserInfo
 * 
 * @author lsl
 *
 */
@Component
public class UserInfo
{
    // �û�ID
    @PK
    private int userId;
    // ����ID
    private int deptId;
    // ��¼��
    private String loginName;
    // ��¼����
    private String loginPwd;
    // �û�����
    private String name;
    // �û��Ա�
    private String sex;
    // �û�����
    private int age;
    // �û��绰����
    private String phone;
    // �û����֤��
    private String idCard;
    // �û�΢�ź�
    private String weChat;
    // �û���ַ
    private String address;
    // �û��Ƿ����
    private int isDelete = 0;
    // �û��Ƿ�����
    private int isEnable = 1;
    // ��������
    @NotAdd
    private Date createDate;
    // �����˵�ID
    private int createUser;
    // ����޸�����
    @NotAdd
    private Date lastUpdateDate;
    // ����޸���ID
    private int lastUpdateUser;

    // ��װ
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
     * �޲εĹ��췽��
     */
    public UserInfo()
    {

    }

    /**
     * ��16�������Ĺ��췽��
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
     * ��17�������Ĺ��췽��
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
