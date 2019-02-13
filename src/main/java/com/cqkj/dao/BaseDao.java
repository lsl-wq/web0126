package com.cqkj.dao;

import java.util.List;

import com.cqkj.bean.PageList;

public interface BaseDao<T>
{
    /**
     * ִ����ɾ��
     * @param sql
     * @param params
     * @return
     */
    int executeUpdate(String sql, Object... params) throws Exception;

    /**
     * ��ѯ����
     * @param sql
     * @param params
     * @return
     */
     void executeQuery(String sql, Object... params) throws Exception;
    
    /**
     * ��������뵽��Ӧ�����ݿ�
     * Լ��1�������Ӧ��������Ҫ���������һ�£������ִ�Сд��
     * Լ��2�������е����Ա�������е��ֶ���һ�£������ִ�Сд��
     * Լ��3�����е�������Ҫ������еı�"@PK"ע����ֶζ�Ӧ������ʹ�á�S_����.nextVal�������Զ����ɣ�
     * ��չ1������������ֶ���������Ӧ���е����ƻ��������Ʋ�һ�µ����������ʹ��@TbInfoName(name="�ֶ���")ע�⣬ʹ���Ӧ��
     * ������ע����������Ҫ�Ǹ��ݴ������Ķ��󣬻�ȡ��Ӧ��Class���Ͷ��󣬽�������ȡ���г�Ա��Ϣ��ƴ�ӳ�insert Sql��䣬����������ݲ��뵽�����Ӧ����
     * @param t ����Ķ���
     * @return ���ز���ɹ�Ӱ�����
     * @throws Exception ���ñ�������Ҫ���д����쳣
     */
    public int insert(T t) throws Exception;
    
    
    
    /**
     * �����ݿ����ɾ�����ݵķ���
     * 
     * @param t
     * ������Ķ���
     * @return ����������
     * @throws Exception
     *             �쳣����
     */
    public int delete(T t) throws Exception;

    /**
     * �����ݿ�����޸����ݵķ���
     * 
     * @param t ������Ķ���
     * @return ����������
     * @throws Exception
     *             �쳣����
     */
    public int update(T t) throws Exception; 

    /**
     * ��������ID ��ѯ��ǰT���Ͷ�Ӧ���е�һ������
     * @param c
     * @return T���Ͷ���  ��ʹ�õ�ʱ��ֻ��Ҫ��������ID��ֵ�Ϳ����ˣ�
     * @throws Exception
     */
    public T selectById(T t) throws Exception;
    
    
    /**
     * ��ѯ��ǰT���Ͷ�Ӧ���е���������
     * @param c
     * @return T���Ͷ��󼯺�
     * @throws Exception
     */
    public List<T> selectAll(Class<T> c) throws Exception;
    
    
    /**
     * ��SQL����ѯ������T���Ͷ��󼯺�
     * @param c
     * @return T���Ͷ��󼯺�
     * @throws Exception
     */
    public List<T> selectAll(Class<T> c, String sql, Object ... objs) throws Exception;
    
    
    /**
     * ��SQL����ҳ��ѯ,����T���Ͷ��󼯺�
     * @param c
     * @return T���Ͷ��󼯺�
     * @throws Exception
     */
    public void selectByPage(Class<T> c, String sql, PageList<T> pageList, Object ... objs) throws Exception;
    
    /**
     * ���ز�ѯ����еĵ�һ�У���һ�еĽ��
     * @param sql
     * @param params
     * @return �����Լ���ȡ��������֮�󣬸���ʵ���������ת����
     * @throws Exception
     */
    public Object executeQueryObj(String sql, Object... params) throws Exception; 
    
}


