
package br.recife.edu.ifpe.controller;

import br.recife.edu.ifpe.model.negocios.Livro;
import br.recife.edu.ifpe.model.repositorios.RepositorioLivro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Davidson Felix
 */
@WebServlet(name = "ApresentaLivrosServlet", urlPatterns = {"/ApresentaLivrosServlet"})
public class ApresentaLivrosServlet extends HttpServlet {

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
        
        List<Livro> livros = RepositorioLivro.lerTudo();
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Livros Cadastrados</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Livros Cadastrados</h1>");
            out.println("<a href=\"index.html\">home</a>");
            out.println("<table border='1'>");
            out.println("<tr><th>id</th><th>Titulo</th>"
                    + "<th>Autor</th><th>valor</th><th>desc</th></tr>");
            
            livros.forEach((c) -> {
                out.println("<tr><td>"+c.getId()+"</td><td>"+c.getTitulo()+"</td>"
                        + "<td>"+c.getAutor()+"</td><td>"+c.getValor()+"</td>"
                                + "<td><a href='VisualizaLivroServlet?id="+c.getId()+"'>visualizar</a>"
                                        + "<a href='ApresentaAlteracaoServlet?id="+c.getId()+"'> alterar</a>"
                                                + "<a href='DeletarLivroServlet?id="+c.getId()+"'> deletar</a></td></tr>");
            });
            
            out.println("</table>");
            
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
