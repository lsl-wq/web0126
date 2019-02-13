package com.cqkj.dao.impl.oracle;

import java.lang.reflect.Field;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import com.cqkj.bean.PK;
import com.cqkj.bean.PageList;
import com.cqkj.bean.TbInfoName;
import com.cqkj.dao.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T>
{
    // �����������ݿ��ַ������û���������
    private static String url = null;
    private static String user = null;
    private static String pwd = null;

    // ���ݿ����Ӷ���
    private Connection con = null;

    // ִ��SQL�������
    private PreparedStatement st = null;

    // ִ�д洢����
    // private CallableStatement cs = null;

    // �����ѯ�����ʹ������ֱ�ӷ���
    protected ResultSet rs = null;

    static
    {
        try
        {
            Properties ps = new Properties();

            ps.load(BaseDaoImpl.class.getResourceAsStream("database.properties"));

            url = ps.getProperty("url");
            user = ps.getProperty("user");
            pwd = ps.getProperty("pwd");

            Class.forName(ps.getProperty("driver"));
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void initConnection()
    {
        try
        {
            con = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * ֧�����ɾ���޸�
     * 
     * @param sql
     * @param params
     * @return
     */
    public int executeUpdate(String sql, Object... params)
    {
        int rows = 0;

        try
        {
            initConnection();

            // ��ȡprepareStatement����
            st = con.prepareStatement(sql);

            // ����δ֪�ε�ֵ
            for (int i = 0; i < params.length; i++)
            {
                if (params[i].getClass().getTypeName().equals("java.util.Date"))
                {
                    st.setTimestamp(i + 1, new Timestamp(((Date) params[i]).getTime()));
                } else
                {
                    st.setObject(i + 1, params[i]);
                }

            }

            // ִ��Sql�����
            rows = st.executeUpdate();

        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            close();
        }

        return rows;
    }

    /**
     * ��ѯ����
     * 
     * @param sql
     * @param params
     * @return
     */
    public void executeQuery(String sql, Object... params) throws Exception
    {
        initConnection();

        // ��ȡprepareStatement����
        st = con.prepareStatement(sql);

        // ����δ֪�ε�ֵ
        for (int i = 0; i < params.length; i++)
        {
            if (params[i].getClass().getTypeName().equals("java.util.Date"))
            {
                st.setTimestamp(i + 1, new Timestamp(((Date) params[i]).getTime()));
            } else
            {
                st.setObject(i + 1, params[i]);
            }
        }

        // ִ��Sql�����
        rs = st.executeQuery();

    }

    /**
     * �ر������ͷ������Դ
     */
    protected void close()
    {
        if (rs != null)
        {
            try
            {
                rs.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }

            rs = null;
        }

        if (st != null)
        {
            try
            {
                st.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }

            st = null;
        }

        if (con != null)
        {
            try
            {
                con.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }

            con = null;
        }
    }

    /**
     * ��������뵽��Ӧ�����ݿ�
     * Լ��1�������Ӧ��������Ҫ���������һ�£������ִ�Сд��
     * Լ��2�������е����Ա�������е��ֶ���һ�£������ִ�Сд��
     * Լ��3�����е�������Ҫ������еı�"@PK"ע����ֶζ�Ӧ������ʹ�á�S_����.nextVal�������Զ����ɣ�
     * ������ע����������Ҫ�Ǹ��ݴ������Ķ��󣬻�ȡ��Ӧ��Class���Ͷ��󣬽�������ȡ���г�Ա��Ϣ��ƴ�ӳ�insert
     * Sql��䣬����������ݲ��뵽�����Ӧ����
     * 
     * @param t
     *            ����Ķ���
     * @return ���ز���ɹ�Ӱ�����
     * @throws Exception
     *             ���ñ�������Ҫ���д����쳣
     */
    /*
     public <T> int insert(T t) throws Exception
    {
        // ����Sql�ַ���
        StringBuilder sql = new StringBuilder();
        
        // ��ȡ�����Ӧ���ֽ������Ͷ���(Class����)
        Class<?> c = t.getClass();
        
        // ��ȡ��ǰ�����Ӧ������Ҳ�������ݿ��Ӧ�ı�����
        String tableName = c.getSimpleName();
        
        // ��ȡ���������е�����(Ҳ���ֶ�)��������
        Field[] fields = c.getDeclaredFields();
        
        // ƴ�Ӳ����Sql���
        sql.append("insert into " + tableName + " (");
        
        // ƴ�Ӳ������������Լ��������=�ֶ�����
        for (Field f : fields)
        {
            // �ֶ�Ϊ˽�У���Ҫ��������
            f.setAccessible(true);
            sql.append(f.getName() + ",");
        }
        
        // ȥ������������һ�� "," ��
        sql = sql.deleteCharAt(sql.length()-1);
        
        // ƴ�� Sql�ַ���
        sql.append( ") values (");
        
        // ƴ��δ֪����(Ҳ�б����������ʹ��?����)
        for(int i = 0; i< fields.length; i++)
        {
            // �������е����Ա�@PKע���ˣ�˵��������������Ҫ���ö�Ӧ������S_����.nextVal
            if(fields[i].isAnnotationPresent(PK.class))
            {
                sql.append("S_");
                sql.append(tableName);
                sql.append(".nextVal,");
            }
            else
            {
                // ���������������ʹ��?����
                sql.append("?,");
            }
        }
        
        // ȥ�����һ��,��
        sql = sql.deleteCharAt(sql.length()-1);
        
        // ƴ�Ӳ����������һ��).
        sql.append(")");
        
        
        //���ڲ����������ʹ�õ���PerperedStatement,SQL�еĲ���ʹ�õ���?����ֹSQLע�룩 
        //�����ǻ�ȡ�����е����ݣ���װ��һ�����󼯺ϣ����ݸ�ִ��SQL���ķ���executeUpdate(Sql,����)
        //��ʼ�������������飬����Ϊ���Ը���-1, ��Ϊ���������������ɡ�����������ʹ�ö����е�����
        Object[] objs = new Object[fields.length - 1]; 
        // i:����ѭ�������ݣ��м����ֶεľ�Ҫѭ�����Σ� j:���Ʋ���������±�
        for (int i = 0, j = 0; i < fields.length; i++)
        {
            //�ֶμ�������һ���������ֶΣ� ���������������Ҫ�ܣ���Ϊ����������
            if(fields[i].isAnnotationPresent(PK.class))
            {
                continue;
            }
            
            // ͨ���ֶζ��󣬻�ȡĳ�������и��ֶε�ֵ������ֵ��ֵ���������飨���±������ƶ�һλj++��
            objs[j++] = fields[i].get(t);
        }
        
        // ����ִ�����ɾ���޸ĵķ�����ִ�и�Sql��䣬�����������ݹ�ȥ
        return executeUpdate(sql.toString(),objs);
    
    }*/

    /**
     * ��������뵽��Ӧ�����ݿ�
     * Լ��1�������Ӧ��������Ҫ���������һ�£������ִ�Сд��
     * Լ��2�������е����Ա�������е��ֶ���һ�£������ִ�Сд��
     * Լ��3�����е�������Ҫ������еı�"@PK"ע����ֶζ�Ӧ������ʹ�á�S_����.nextVal�������Զ����ɣ�
     * ��չ1������������ֶ���������Ӧ���е����ƻ��������Ʋ�һ�µ����������ʹ��@TbInfoName(name="�ֶ���")ע�⣬ʹ���Ӧ��
     * ������ע����������Ҫ�Ǹ��ݴ������Ķ��󣬻�ȡ��Ӧ��Class���Ͷ��󣬽�������ȡ���г�Ա��Ϣ��ƴ�ӳ�insert
     * Sql��䣬����������ݲ��뵽�����Ӧ����
     * 
     * @param t
     *            ����Ķ���
     * @return ���ز���ɹ�Ӱ�����
     * @throws Exception
     *             ���ñ�������Ҫ���д����쳣
     */
    public int insert(T t) throws Exception
    {
        // ����Sql�ַ���
        StringBuilder sql = new StringBuilder();

        // ��ȡ�����Ӧ���ֽ������Ͷ���(Class����)
        Class<?> c = t.getClass();

        // ��ȡ����(���ʹ��@TbInfoName(name=����)������ע���е�name��Ϊ���������û��ע�⣬��ʹ�õ�ǰ������Ϊ����)
        String tableName = null;
        if (c.isAnnotationPresent(TbInfoName.class))
        {
            // ��ȡע���е�����
            tableName = c.getAnnotation(TbInfoName.class).name();
        } else
        {
            // ��ȡ����
            tableName = c.getSimpleName();
        }

        // ��ȡ���кţ����к�ΪS_������
        int seq = getSequenct("S_" + tableName);

        // ƴ�Ӳ����Sql���
        sql.append("insert into " + tableName + " (");

        // ��ȡ���������е�����(Ҳ���ֶ�)��������
        Field[] fields = c.getDeclaredFields();

        // ƴ�Ӳ������������Լ��������=�ֶ�����
        for (Field f : fields)
        {
            // �ֶ�Ϊ˽�У���Ҫ��������
            f.setAccessible(true);

            // (���ʹ��@TbInfoName(name=����)������ע���е�name��Ϊ���������û��ע�⣬��ʹ�õ�ǰ�ֶ�����Ϊ����)
            if (f.isAnnotationPresent(TbInfoName.class))
            {
                // ��ȡע���е�����
                sql.append(f.getAnnotation(TbInfoName.class).name());
            } else
            {
                // ��ȡ�ֶ���
                sql.append(f.getName());
                sql.append(",");
            }
        }

        // ȥ������������һ�� "," ��
        sql = sql.deleteCharAt(sql.length() - 1);

        // ƴ�� Sql�ַ���
        sql.append(") values (");

        // ƴ��δ֪����(Ҳ�б����������ʹ��?����)
        for (int i = 0; i < fields.length; i++)
        {
            /*// �������е����Ա�@PKע���ˣ�˵��������������Ҫ���ö�Ӧ������S_����.nextVal
            if(fields[i].isAnnotationPresent(PK.class))
            {
                sql.append("S_");
                sql.append(tableName);
                sql.append(".nextVal,");
            }
            else
            {
                // ���������������ʹ��?����
                sql.append("?,");
            }*/
            // ���������������ʹ��?����
            sql.append("?,");
        }

        // ȥ�����һ��,��
        sql = sql.deleteCharAt(sql.length() - 1);

        // ƴ�Ӳ����������һ��).
        sql.append(")");

        // ���ڲ����������ʹ�õ���PerperedStatement,SQL�еĲ���ʹ�õ���?����ֹSQLע�룩
        // �����ǻ�ȡ�����е����ݣ���װ��һ�����󼯺ϣ����ݸ�ִ��SQL���ķ���executeUpdate(Sql,����)
        // ��ʼ�������������飬����Ϊ���Ը���-1, ��Ϊ���������������ɡ�����������ʹ�ö����е�����
        Object[] objs = new Object[fields.length];
        // i:����ѭ�������ݣ��м����ֶεľ�Ҫѭ�����Σ� j:���Ʋ���������±�
        for (int i = 0; i < objs.length; i++)
        {
            // �ֶμ�������һ���������ֶΣ� ���������������Ҫ�ܣ���Ϊ����������
            if (fields[i].isAnnotationPresent(PK.class))
            {
                // ����������Ӧ�����к�
                objs[i] = seq;

                // �����󸳲����ID(�� ��) ���ڷ���
                fields[i].set(t, seq);
            }

            // ͨ���ֶζ��󣬻�ȡĳ�������и��ֶε�ֵ������ֵ��ֵ���������飨���±������ƶ�һλj++��
            objs[i] = fields[i].get(t);

        }

        // ����ִ�����ɾ���޸ĵķ�����ִ�и�Sql��䣬�����������ݹ�ȥ
        return executeUpdate(sql.toString(), objs);

    }

    /**
     * �����ݿ����ɾ�����ݵķ���
     * 
     * @param t
     *            ������Ķ���
     * @return ����������
     * @throws Exception
     *             �쳣����
     */
    public int delete(T t) throws Exception
    {
        // ����StringBuilder����sql
        StringBuilder sql = new StringBuilder();

        // ʹ��append��������ַ���
        sql.append("delete from ");

        // ��ȡt�����Class����
        Class<?> c = t.getClass();

        // ����һ�������洢����
        String tbName;

        // �жϱ����Ƿ�������һ��
        if (c.isAnnotationPresent(TbInfoName.class))
        {
            tbName = c.getAnnotation(TbInfoName.class).name();
        } else
        {
            tbName = c.getSimpleName();
        }

        // ��ȡ�����������ӵ�sql��
        sql.append(tbName);

        sql.append(" where ");

        // ��ȡt�����е������ֶΣ��浽Field������
        Field[] fields = c.getDeclaredFields();

        // ����һ�������洢������ֵ
        Object obj = new Object();

        for (int i = 0; i < fields.length; i++)
        {
            // ����ͨ��������ʷ���˽�б���
            fields[i].setAccessible(true);

            if (fields[i].isAnnotationPresent(PK.class))
            {
                // ��ȡ�ֶε����֣�����append�������sql��
                sql.append(fields[i].getName());

                // ��������ֵ����obj
                obj = fields[i].get(t);
                break;
            }
        }

        sql.append(" = ?");

        // ����executeUpdate��������return���������������
        return executeUpdate(sql.toString(), obj);
    }

    /**
     * �����ݿ�����޸����ݵķ���
     * 
     * @param t
     *            ������Ķ���
     * @return ����������
     * @throws Exception
     *             �쳣����
     */
    public int update(T t) throws Exception
    {
        // ����StringBuilder����sql
        StringBuilder sql = new StringBuilder();

        // ʹ��append��������ַ���
        sql.append("update ");

        // ��ȡt�����Class����
        Class<?> c = t.getClass();

        // ����һ�������洢����
        String tbName;

        // �жϱ����Ƿ�������һ��
        if (c.isAnnotationPresent(TbInfoName.class))
        {
            tbName = c.getAnnotation(TbInfoName.class).name();
        } else
        {
            tbName = c.getSimpleName();
        }

        // ��ȡ�����������ӵ�sql��
        sql.append(tbName);

        sql.append(" set ");

        // ��ȡt�����е������ֶΣ��浽Field������
        Field[] fields = c.getDeclaredFields();

        // ����һ������pkIndex�洢�����±�
        int pkIndex = -1;

        // ����һ��Object����
        Object[] obj = new Object[fields.length];

        // fields������ֶ����ӵڶ�����ʼ��ӵ�sql�����
        for (int i = 0, j = 0; i < fields.length; i++)
        {
            // ����ͨ��������ʷ���˽�б���
            fields[i].setAccessible(true);

            // �ж��������ڵ�λ��
            if (fields[i].isAnnotationPresent(PK.class))
            {
                // ��¼�������ڵ��±�
                pkIndex = i;

                // ��������Ӧ��ֵ���obj��������һ��λ��
                obj[obj.length - 1] = fields[i].get(t);
            } else
            {
                // ��ȡ�ֶε����֣�����append�������sql��
                sql.append(fields[i].getName());
                sql.append(" = ?,");

                // ��obj�����t�����ֶζ�Ӧ��ֵ
                obj[j++] = fields[i].get(t);
            }
        }

        // ɾ��sql���һ���ַ�
        sql.deleteCharAt(sql.length() - 1);

        sql.append(" where ");

        // ��fields�������������ӵ�sql�����
        fields[pkIndex].setAccessible(true);
        sql.append(fields[pkIndex].getName());

        sql.append(" = ?");

        // ����executeUpdate��������return���������������
        return executeUpdate(sql.toString(), obj);
    }

    /**
     * ��������ID ��ѯ��ǰT���Ͷ�Ӧ���е�һ������
     * 
     * @param c
     * @return T���Ͷ��� ��ʹ�õ�ʱ��ֻ��Ҫ��������ID��ֵ�Ϳ����ˣ�
     * @throws Exception
     */
    public T selectById(T t) throws Exception
    {
        // ��ȡT���Ͷ���
        Class<?> c = t.getClass();

        // ����
        String tableName = null;

        // ��ȡ����(���ʹ��@TbInfoName(name=����)������ע���е�name��Ϊ���������û��ע�⣬��ʹ�õ�ǰ������Ϊ����)
        if (c.isAnnotationPresent(TbInfoName.class))
        {
            tableName = c.getAnnotation(TbInfoName.class).name();
        } else
        {
            tableName = c.getSimpleName();
        }

        // �洢Sql�ַ���
        StringBuilder sql = new StringBuilder();

        sql.append("select ");

        // ƴ�Ӳ�ѯ������
        Field[] fields = c.getDeclaredFields();

        // ��������Field
        Field pkField = null;

        for (Field f : fields)
        {
            sql.append(f.getName()).append(",");

            // ��ȡ����
            if (f.isAnnotationPresent(PK.class))
            {
                pkField = f;
            }
        }

        // ���ñ�������
        pkField.setAccessible(true);

        // ɾ�����һ���ַ�
        sql.deleteCharAt(sql.length() - 1);

        sql.append(" from ").append(tableName).append(" where ");

        // where ��ѯ ���� Ϊ����
        sql.append(pkField.getName()).append(" = ?");

        // ���ñ����еĲ�ѯ�����������ؽ�����ڱ����е�ResultSet rs������
        executeQuery(sql.toString(), pkField.get(t));

        // ��ȡ��ѯ���
        while (rs.next())
        {
            // �������Ͷ��󣬴��������͵Ķ��󣨸����ͱ�������޲����Ĺ��췽����

            for (Field f : fields)
            {
                f.setAccessible(true);
                // ͨ���ֶζ��󣬸��ֶζ�Ӧ�Ķ���ֵֵ
                // ����������������ȡ���е�ֵ����ֵ�������е��ֶΣ���֤��������һ�£�
                setFieldValue(f, t);

            }

            break;
        }

        return t;
    }

    /**
     * �����ֶ����ͣ�ȡResultSet�ж�Ӧ�������͵�ֵ
     * 
     * @param f
     * @param t
     * @throws Exception
     */
    private void setFieldValue(Field f, Object t) throws Exception
    {
        if (f.getType().getName().equals(int.class.getName()))
        {
            f.set(t, rs.getInt(f.getName()));
        } else if (f.getType().getName().equals(String.class.getName()))
        {
            f.set(t, rs.getString(f.getName()));
        } else if (f.getType().getName().equals(double.class.getName()))
        {
            f.set(t, rs.getDouble(f.getName()));
        } else if (f.getType().getName().equals(Date.class.getName()))
        {
            // rs.getTimestamp(f.getName() ��ȡ����java.sql.Date����
            // .getTime()���ص���java.util.Date���͵�long����
            f.set(t, new Date(rs.getTimestamp(f.getName()).getTime()));
        }
        // ���������õ�����������
    }

    /**
     * ��ѯ��ǰT���Ͷ�Ӧ���е���������
     * 
     * @param c
     * @return T���Ͷ��󼯺�
     * @throws Exception
     */
    public List<T> selectAll(Class<T> c) throws Exception
    {
        // ����T���͵ļ���
        List<T> lst = new ArrayList<T>();

        // ����
        String tableName = null;

        // ��ȡ����(���ʹ��@TbInfoName(name=����)������ע���е�name��Ϊ���������û��ע�⣬��ʹ�õ�ǰ������Ϊ����)
        if (c.isAnnotationPresent(TbInfoName.class))
        {
            tableName = c.getAnnotation(TbInfoName.class).name();
        } else
        {
            tableName = c.getSimpleName();
        }

        // �洢Sql�ַ���
        StringBuilder sql = new StringBuilder();

        sql.append("select ");

        // ƴ�Ӳ�ѯ������
        Field[] fields = c.getDeclaredFields();
        for (Field f : fields)
        {
            sql.append(f.getName()).append(",");
        }

        // ɾ�����һ���ַ�
        sql.deleteCharAt(sql.length() - 1);

        sql.append(" from ").append(tableName);

        // ���ñ����еĲ�ѯ�����������ؽ�����ڱ����е�ResultSet rs������
        executeQuery(sql.toString());

        // ��ȡ��ѯ���
        while (rs.next())
        {
            // �������Ͷ��󣬴��������͵Ķ��󣨸����ͱ�������޲����Ĺ��췽����
            T obj = c.newInstance();

            for (Field f : fields)
            {
                f.setAccessible(true);
                // ͨ���ֶζ��󣬸��ֶζ�Ӧ�Ķ���ֵֵ
                // ����������������ȡ���е�ֵ����ֵ�������е��ֶΣ���֤��������һ�£�
                setFieldValue(f, obj);
            }

            lst.add(obj);
        }

        return lst;
    }

    /**
     * ��SQL����ѯ������T���Ͷ��󼯺�
     * 
     * @param c
     * @return T���Ͷ��󼯺�
     * @throws Exception
     */
    public List<T> selectAll(Class<T> c, String sql, Object... objs) throws Exception
    {
        // ����T���͵ļ���
        List<T> lst = new ArrayList<T>();

        // ƴ�Ӳ�ѯ������
        Field[] fields = c.getDeclaredFields();

        // ִ�в�ѯ
        executeQuery(sql, objs);

        // ��ȡ��ѯ���
        while (rs.next())
        {
            // �������Ͷ��󣬴��������͵Ķ��󣨸����ͱ�������޲����Ĺ��췽����
            T obj = c.newInstance();

            for (Field f : fields)
            {
                f.setAccessible(true);
                // ͨ���ֶζ��󣬸��ֶζ�Ӧ�Ķ���ֵֵ
                // ����������������ȡ���е�ֵ����ֵ�������е��ֶΣ���֤��������һ�£�
                setFieldValue(f, obj);
            }

            lst.add(obj);
        }

        return lst;
    }

    /**
     * ��ȡ��ҳ��ѯSQL
     * 
     * @param sql
     * @return
     */
    protected String getSqlPage(String sql, int pageSize, int pageIndex)
    {
        StringBuilder sb = new StringBuilder();

        sb.append("select * from (select rownum rn, s.* from ( ").append(sql).append(" ) s) t where t.rn between ")
                .append(pageSize * (pageIndex - 1) + 1).append(" and ").append(pageSize * pageIndex);

        return sb.toString();
    }

    /**
     * ��SQL����ҳ��ѯ,����T���Ͷ��󼯺�
     * 
     * @param c
     * @return T���Ͷ��󼯺�
     * @throws Exception
     */
    public void selectByPage(Class<T> c, String sql, PageList<T> pageList, Object... objs) throws Exception
    {
        // ����T���͵ļ���
        List<T> lst = new ArrayList<T>();

        // ƴ�Ӳ�ѯ������
        Field[] fields = c.getDeclaredFields();

        // ��ȡ������
        pageList.setCount(Integer.parseInt(executeQueryObj("select count(1) from (" + sql + ")", objs).toString()));

        // ���ñ����еĲ�ѯ�����������ؽ�����ڱ����е�ResultSet rs������
        executeQuery(getSqlPage(sql, pageList.getPageSize(), pageList.getPageIndex()), objs);

        // ��ȡ��ѯ���
        while (rs.next())
        {
            // �������Ͷ��󣬴��������͵Ķ��󣨸����ͱ�������޲����Ĺ��췽����
            T obj = c.newInstance();

            for (Field f : fields)
            {
                f.setAccessible(true);
                // ͨ���ֶζ��󣬸��ֶζ�Ӧ�Ķ���ֵֵ
                // ����������������ȡ���е�ֵ����ֵ�������е��ֶΣ���֤��������һ�£�
                setFieldValue(f, obj);
            }

            lst.add(obj);
        }

        pageList.setData(lst);
    }

    /**
     * ���ز�ѯ����еĵ�һ�У���һ�еĽ��
     * 
     * @param sql
     * @param params
     * @return �����Լ���ȡ��������֮�󣬸���ʵ���������ת����
     * @throws Exception
     */
    public Object executeQueryObj(String sql, Object... params) throws Exception
    {
        Object obj = null;

        try
        {
            this.executeQuery(sql, params);

            if (rs.next())
            {
                obj = rs.getObject(1);
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            close();
        }

        return obj;
    }

    /**
     * ��ȡ���к�
     * 
     * @param seqName
     * @return
     */
    public int getSequenct(String seqName)
    {
        int obj = 0;

        try
        {
            this.executeQuery("select " + seqName + ".nextVal from dual");

            if (rs.next())
            {
                obj = rs.getInt(1);
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            close();
        }

        return obj;
    }
}