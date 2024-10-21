package com.mpsilvestri.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

@WebServlet("/CapacitacaoTeste")
public class CapacitacaoTeste extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CapacitacaoTeste() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String URL = "jdbc:mysql://localhost:3306/capacitacao";
		String USER = "root";
		String PASS = "admin@123456";
		Statement stmt = null;
		
		Date data;
		String status;
		String nome;
		
		
		
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			
			String sql = "select data, nome, status from treinamento "
					+ "inner join empresa_treinamento on treinamento.id = empresa_treinamento.fk_treinamento_id "
					+ "inner join empresa on empresa.id = empresa_treinamento.fk_empresa_id "
					+ "order by data asc";
			
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.println("<h2>Dados de Treinamento</h2>");
			out.println("<table border='1'>");
			
			int i = 1;
			while(rs.next()) {
				out.println("<tr>");
				
				data = rs.getDate("data");
				status = rs.getString("status");
				nome = rs.getString("nome");
				
				out.println("<td>");
				out.println(i);
				out.println("</td>");
				out.println("<td>");
				out.println(data);
				out.println("</td>");
				out.println("<td>");
				out.println(status);
				out.println("</td>");
				out.println("<td>");
				out.println(nome);
				out.println("</td>");
				
				out.println("</tr>");
				// System.out.println("Data de treinamento: " + data + " | Empresa: " + nome + " | Status: " + status);
				i++;
			}
			
			
			out.println("</table>");
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				stmt.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
