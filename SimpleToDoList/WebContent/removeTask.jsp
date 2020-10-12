<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>
<%
String id=request.getParameter("id");
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://ec2-3-86-40-249.compute-1.amazonaws.com:3306/ToDoListDB", "bfehr", "Sti4#2Inn!");
Statement st=conn.createStatement();
int i=st.executeUpdate("DELETE FROM task WHERE id="+id);
out.println("Task Removed Successfully!");
out.println("<a href=\"ToDoList.jsp\"><button type=\"button\">Go Back</button></a>");
}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}
%>