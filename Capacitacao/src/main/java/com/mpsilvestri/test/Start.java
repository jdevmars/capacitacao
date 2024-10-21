package com.mpsilvestri.test;

import com.mpsilvestri.dao.Database;
import com.mpsilvestri.dao.Service;

public class Start {

	public static void main(String[] args) {
		
		new Database();
		
		Service service = new Service();
		
		service.select_todos_treinamentos();
		service.select_todas_empresas();
		service.select_todos_cursos();
		service.select_todos_convidados();
		service.select_todos_treinamentos_dashboard();

	}

}
