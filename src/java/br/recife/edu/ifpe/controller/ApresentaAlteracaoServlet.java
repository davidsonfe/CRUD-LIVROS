
package br.recife.edu.ifpe.controller;

import br.recife.edu.ifpe.model.negocios.Livro;
import br.recife.edu.ifpe.model.repositorios.RepositorioLivro;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Davidson Felix
 */
@WebServlet(name = "ApresentaAlteracaoServlet", urlPatterns = {"/ApresentaAlteracaoServlet"})
public class ApresentaAlteracaoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        Livro c = RepositorioLivro.ler(id);
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ApresentaAlteracaoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Altere o livro</h1>");
            out.println("<a href='ApresentaLivrosServlet'>livros</a><br>");
            out.println("<form method='post' action='AlteraLivroServlet'>");
            out.println("<input type='hidden' name='id' value='"+c.getId()+"'/>");
            out.println("Titulo: <input type=\"text\" name=\"titulo\" value='"+c.getTitulo()+"'><br>");
            out.println("Autor: <input type=\"text\" name=\"autor\" value='"+c.getAutor()+"'><br>");
            out.println("Categoria: <input type=\"text\" name=\"categoria\" value='"+c.getCategoria()+"'><br>");
            out.println("Valor: <input type=\"text\" name=\"valor\" value='"+c.getValor()+"'><br>");
            out.println("Desc: <input type=\"text\" name=\"desc\" value='"+c.getDesc()+"'><br>");
            out.println("<input type='submit' value='enviar'/>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
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
