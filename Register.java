import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Register"})
public class Register extends HttpServlet
{
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
   {
       String uname=request.getParameter("uname");
       String pass=request.getParameter("pass"); 
       
        try
        {
        String url="jdbc:mysql://localhost:3306/university?useSSL=false";
        String uname1="root";
        String pass1="sigma@321";
        String query="insert into Login values(?,?)";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con=DriverManager.getConnection(url,uname1,pass1);
        PreparedStatement st=con.prepareStatement(query);
        st.setString(1,uname);
        st.setString(2,pass);
        
        PrintWriter out = response.getWriter();
       
        int count=st.executeUpdate();
         if(count>=1)
         {
              out.println("Successfully inserted.");
         }
         else
         {
              out.println("Couldn't insert.Try again!");
         }
        }
        catch(Exception e)
        {
            System.out.println("Exception occurreddddd");
        }
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
