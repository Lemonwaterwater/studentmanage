
<%@ page language="java" import="lala.util.*,com.pbh.haha.User,com.pbh.dao,Daola" pageEncoding="GBK"%>  
  
  
    <%!  
    public static String codestring(String s){  
    String str=s;  
    try{  
    byte[] b=str.getBytes("iso-8859-1");  
    str=new String(b,"utf-8");  
    return str;  
    }catch(Exception e)  
    {  
    return str;  
    }  
    }  
     %>  
     <%  
     //取得用户名  
     String name=codestring(request.getParameter("name"));  
     String password=codestring(request.getParameter("password"));  
     Daola md=new Daola();  
     User m=new User(); 
     //封装  
     m.setName(name);  
     m.setPassword(password);  
     //调用方法，保存对象  
     md.save(m);  
     //从数据库中加载类对象  
     out.print("注册成功<br>");  
     List l=null;  
     l=md.findByProperty("name",name);  
     Iterator i=l.iterator();  
     out.print("从数据库中加载类对象<br>");  
     if(i.hasNext()){  
      m=(Member)i.next();  
      out.print("用户名："+m.getName()+"<br>");  
      out.print("密码："+m.getPassword()+"<br>");  
     }else{  
      out.print("数据库中不存在该对象");   
     }  
      %>  
