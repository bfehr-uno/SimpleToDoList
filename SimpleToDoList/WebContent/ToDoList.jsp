<%@page import="java.util.List"%>
<%@page import="util.UtilDB"%>
<%@page import="datamodel.Task"%>
<table>
	<thead>
		<tr>
			<th><a href="AddTask.html"><button type="button">Add Task</button></a></th>
			<th></th>
			<th>Due Date</th>
		</tr>
	</thead>
	<tbody>
		<%
			List<Task> tasks = UtilDB.listTasks();
			for (Task task : tasks) {
		%> 
			<tr> 
				<td><a href="removeTask.jsp?id=<%=task.getID()%>"><button type="button">Remove</button></a></td>
				<td><%=task.getName()%></td>
				<td><%=task.getDueDate()%></td>
			</tr>
		<%
			}
		%>
	</tbody>
</table>