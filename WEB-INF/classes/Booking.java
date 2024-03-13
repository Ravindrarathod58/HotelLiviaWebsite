import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Booking extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
     {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String location = request.getParameter("location");
        String guests = request.getParameter("guests");
        String arrivals = request.getParameter("arrivals");
        String departure = request.getParameter("departure");
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/mydatabase","root","Ravindra@123");

        

        PreparedStatement ps=con.prepareStatement
                  ("insert into book_form(name, email, phone, address, location, guests, arrivals, departure) values ('" + name + "', '" + email + "', '" + phone + "', '" + address + "', '" + location + "', '" + guests + "', '" + arrivals + "', '" + departure + "')");

        int i=ps.executeUpdate();
        
          if(i>0)
          {
            out.println("You are sucessfully registered");
          }
        
        }
        catch(Exception se)
        {
            out.println(se);
        }
	
      }
  }