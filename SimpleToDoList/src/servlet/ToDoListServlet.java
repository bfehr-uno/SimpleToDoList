package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Task;
import util.UtilDB;

/**
 * Servlet implementation class ToDoListServlet
 */
@WebServlet("/ToDoListServlet")
public class ToDoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToDoListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String taskName = request.getParameter("TaskName");
		String dueDate = request.getParameter("DueDate");
		
		UtilDB.createTasks(taskName, dueDate);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
	            "transitional//en\">"; //
	    out.println(docType + //
	           "<html>" + //
	           "<style> .div1 { display: flex; height: 250px; justify-content: center; align-items: bottom; }" + //
	           ".div2 { display: flex; height: 250px; justify-content: center; align-items: bottom; } </style>");
	    out.println("<div class=\"div1\"> Task " + taskName + " was created.</div>");
	    out.println("<div class=\"div2\"><a href=\"ToDoList.jsp\">View the To-do List</a></div>");
	    out.println("</html>");
	    
	    List<Task> tasks = UtilDB.listTasks();
	    for (Task task : tasks) {
	    	System.out.println(task.getName());
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
