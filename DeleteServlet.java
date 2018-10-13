

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/DeleteServlet"})
public class DeleteServlet extends HttpServlet
{

    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
       String uname=request.getParameter("uname"); 
       
        try
        {
         String url="jdbc:mysql://localhost:3306/university?useSSL=false";
         String uname1="root";
         String pass1="sigma@321";
         String query="delete from Login where Username=?";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con=DriverManager.getConnection(url,uname1,pass1);
        PreparedStatement st=con.prepareStatement(query);
        
        st.setString(1,uname);
        
        PrintWriter out = response.getWriter();
       
        int count=st.executeUpdate();
         if(count>=1)
         {
              out.println("Successfully deleted.");
         }
         else
         {
              out.println("Couldn't delete.Try again!");
         }
        }
        catch(Exception e)
        {
            System.out.println("Exception occurreddddd");
        }
     }
    
}
