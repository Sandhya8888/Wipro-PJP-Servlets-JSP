

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Assignment3
 */
public class Assignment3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Assignment3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		Date createTime = new Date(session.getCreationTime());
		 Date lastAccessTime = new Date(session.getLastAccessedTime());
		 String title = "Welcome Back to my website";
	      Integer visitCount = new Integer(0);
	      String visitCountKey = new String("visitCount");
	      String userIDKey = new String("userID");
	      String userID = new String("ABCD");
	      if (session.isNew()) {
	          title = "Welcome to my website";
	          session.setAttribute(userIDKey, userID);
	       } else {
	          visitCount = (Integer)session.getAttribute(visitCountKey);
	          visitCount = visitCount + 1;
	          userID = (String)session.getAttribute(userIDKey);
	       }
	       session.setAttribute(visitCountKey,  visitCount);
	       response.setContentType("text/html");
	       PrintWriter out = response.getWriter();

	       String docType =
	          "<!doctype html public \"-//w3c//dtd html 4.0 " +
	          "transitional//en\">\n";

	       out.println(docType +
	          "<html>\n" +
	             "<head><title>" + title + "</title></head>\n" +
	             
	             "<body bgcolor = \"#f0f0f0\">\n" +
	                "<h1 align = \"center\">" + title + "</h1>\n" +
	                "<h2 align = \"center\">Session Infomation</h2>\n" +
	                "<table border = \"1\" align = \"center\">\n" +
	                   
	                   "<tr bgcolor = \"#949494\">\n" +"  <th>Session info</th><th>value</th></tr>\n" +
	                      
	                   "<tr>\n" +
	                      "  <td>id</td>\n" +
	                      "  <td>" + session.getId() + "</td></tr>\n" +
	                   
	                   "<tr>\n" +
	                      "  <td>Creation Time</td>\n" +
	                      "  <td>" + createTime + "  </td></tr>\n" +
	                   
	                   "<tr>\n" +
	                      "  <td>Time of Last Access</td>\n" +
	                      "  <td>" + lastAccessTime + "  </td></tr>\n" +
	                   
	                   "<tr>\n" +
	                      "  <td>User ID</td>\n" +
	                      "  <td>" + userID + "  </td></tr>\n" +
	                   
	                   "<tr>\n" +
	                      "  <td>Number of visits</td>\n" +
	                      "  <td>" + visitCount + "</td></tr>\n" +
	                "</table>\n" +
	             "</body></html>"
	       );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
