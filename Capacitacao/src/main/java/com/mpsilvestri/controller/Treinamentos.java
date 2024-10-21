package com.mpsilvestri.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mpsilvestri.dao.Database;
import com.mpsilvestri.dao.Service;
import com.mpsilvestri.entity.DashTable;

@WebServlet("/dashboard")
public class Treinamentos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Treinamentos() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		new Database();
		
		Service database_service = new Service();
		
		List<DashTable> treinamentos = database_service.select_todos_treinamentos_dashboard();
		
		int total_empresas = database_service.total_empresas_dashboard();
		int total_convidados = database_service.total_convidados_dashboard();
		int total_treinamentos_concluidos = database_service.total_treinamentos_concluidos_dashboard();
		int empresa_mais_treinada_quantos = database_service.empresa_mais_treinada_quantos_dashboard();
		String qual_empresa_mais_treinada = database_service.qual_empresa_mais_treinada_dashboard();
		
		int quantos_janeiro_2019 = database_service.quantos_janeiro_2019_dashboard_grafico();
		int quantos_fevereiro_2019 = database_service.quantos_fevereiro_2019_dashboard_grafico();
		int quantos_marco_2019 = database_service.quantos_marco_2019_dashboard_grafico();
		int quantos_abril_2019 = database_service.quantos_abril_2019_dashboard_grafico();
		int quantos_maio_2019 = database_service.quantos_maio_2019_dashboard_grafico();
		int quantos_junho_2019 = database_service.quantos_junho_2019_dashboard_grafico();
		int quantos_julho_2019 = database_service.quantos_julho_2019_dashboard_grafico();
		int quantos_agosto_2019 = database_service.quantos_agosto_2019_dashboard_grafico();
		int quantos_setembro_2019 = database_service.quantos_setembro_2019_dashboard_grafico();
		int quantos_outubro_2019 = database_service.quantos_outubro_2019_dashboard_grafico();
		int quantos_novembro_2019 = database_service.quantos_novembro_2019_dashboard_grafico();
		int quantos_dezembro_2019 = database_service.quantos_dezembro_2019_dashboard_grafico();
		
		int quantos_janeiro_2020 = database_service.quantos_janeiro_2020_dashboard_grafico();
		int quantos_fevereiro_2020 = database_service.quantos_fevereiro_2020_dashboard_grafico();
		int quantos_marco_2020 = database_service.quantos_marco_2020_dashboard_grafico();
		int quantos_abril_2020 = database_service.quantos_abril_2020_dashboard_grafico();
		int quantos_maio_2020 = database_service.quantos_maio_2020_dashboard_grafico();
		int quantos_junho_2020 = database_service.quantos_junho_2020_dashboard_grafico();
		int quantos_julho_2020 = database_service.quantos_julho_2020_dashboard_grafico();
		int quantos_agosto_2020 = database_service.quantos_agosto_2020_dashboard_grafico();
		int quantos_setembro_2020 = database_service.quantos_setembro_2020_dashboard_grafico();
		int quantos_outubro_2020 = database_service.quantos_outubro_2020_dashboard_grafico();
		int quantos_novembro_2020 = database_service.quantos_novembro_2020_dashboard_grafico();
		int quantos_dezembro_2020 = database_service.quantos_dezembro_2020_dashboard_grafico();
		
		int quantos_janeiro_2021 = database_service.quantos_janeiro_2021_dashboard_grafico();
		int quantos_fevereiro_2021 = database_service.quantos_fevereiro_2021_dashboard_grafico();
		int quantos_marco_2021 = database_service.quantos_marco_2021_dashboard_grafico();
		int quantos_abril_2021 = database_service.quantos_abril_2021_dashboard_grafico();
		int quantos_maio_2021 = database_service.quantos_maio_2021_dashboard_grafico();
		int quantos_junho_2021 = database_service.quantos_junho_2021_dashboard_grafico();
		int quantos_julho_2021 = database_service.quantos_julho_2021_dashboard_grafico();
		int quantos_agosto_2021 = database_service.quantos_agosto_2021_dashboard_grafico();
		int quantos_setembro_2021 = database_service.quantos_setembro_2021_dashboard_grafico();
		int quantos_outubro_2021 = database_service.quantos_outubro_2021_dashboard_grafico();
		int quantos_novembro_2021 = database_service.quantos_novembro_2021_dashboard_grafico();
		int quantos_dezembro_2021 = database_service.quantos_dezembro_2021_dashboard_grafico();
		
		int quantos_janeiro_2022 = database_service.quantos_janeiro_2022_dashboard_grafico();
		int quantos_fevereiro_2022 = database_service.quantos_fevereiro_2022_dashboard_grafico();
		int quantos_marco_2022 = database_service.quantos_marco_2022_dashboard_grafico();
		int quantos_abril_2022 = database_service.quantos_abril_2022_dashboard_grafico();
		int quantos_maio_2022 = database_service.quantos_maio_2022_dashboard_grafico();
		int quantos_junho_2022 = database_service.quantos_junho_2022_dashboard_grafico();
		int quantos_julho_2022 = database_service.quantos_julho_2022_dashboard_grafico();
		int quantos_agosto_2022 = database_service.quantos_agosto_2022_dashboard_grafico();
		int quantos_setembro_2022 = database_service.quantos_setembro_2022_dashboard_grafico();
		int quantos_outubro_2022 = database_service.quantos_outubro_2022_dashboard_grafico();
		int quantos_novembro_2022 = database_service.quantos_novembro_2022_dashboard_grafico();
		int quantos_dezembro_2022 = database_service.quantos_dezembro_2022_dashboard_grafico();
		
		int quantos_janeiro_2023 = database_service.quantos_janeiro_2023_dashboard_grafico();
		int quantos_fevereiro_2023 = database_service.quantos_fevereiro_2023_dashboard_grafico();
		int quantos_marco_2023 = database_service.quantos_marco_2023_dashboard_grafico();
		int quantos_abril_2023 = database_service.quantos_abril_2023_dashboard_grafico();
		int quantos_maio_2023 = database_service.quantos_maio_2023_dashboard_grafico();
		int quantos_junho_2023 = database_service.quantos_junho_2023_dashboard_grafico();
		int quantos_julho_2023 = database_service.quantos_julho_2023_dashboard_grafico();
		int quantos_agosto_2023 = database_service.quantos_agosto_2023_dashboard_grafico();
		int quantos_setembro_2023 = database_service.quantos_setembro_2023_dashboard_grafico();
		int quantos_outubro_2023 = database_service.quantos_outubro_2023_dashboard_grafico();
		int quantos_novembro_2023 = database_service.quantos_novembro_2023_dashboard_grafico();
		int quantos_dezembro_2023 = database_service.quantos_dezembro_2023_dashboard_grafico();
		
		int quantos_janeiro_2024 = database_service.quantos_janeiro_2024_dashboard_grafico();
		int quantos_fevereiro_2024 = database_service.quantos_fevereiro_2024_dashboard_grafico();
		int quantos_marco_2024 = database_service.quantos_marco_2024_dashboard_grafico();
		int quantos_abril_2024 = database_service.quantos_abril_2024_dashboard_grafico();
		int quantos_maio_2024 = database_service.quantos_maio_2024_dashboard_grafico();
		int quantos_junho_2024 = database_service.quantos_junho_2024_dashboard_grafico();
		int quantos_julho_2024 = database_service.quantos_julho_2024_dashboard_grafico();
		int quantos_agosto_2024 = database_service.quantos_agosto_2024_dashboard_grafico();
		int quantos_setembro_2024 = database_service.quantos_setembro_2024_dashboard_grafico();
		int quantos_outubro_2024 = database_service.quantos_outubro_2024_dashboard_grafico();
		int quantos_novembro_2024 = database_service.quantos_novembro_2024_dashboard_grafico();
		int quantos_dezembro_2024 = database_service.quantos_dezembro_2024_dashboard_grafico();
		
		int quantos_2019 = database_service.quantos_2019_dashboard_grafico();
		int quantos_2020 = database_service.quantos_2020_dashboard_grafico();
		int quantos_2021 = database_service.quantos_2021_dashboard_grafico();
		int quantos_2022 = database_service.quantos_2022_dashboard_grafico();
		int quantos_2023 = database_service.quantos_2023_dashboard_grafico();
		int quantos_2024 = database_service.quantos_2024_dashboard_grafico();
		
		String mais_treinadas_1 = database_service.empresas_mais_treinadas_1();
		int mais_treinadas_1_qtd = database_service.empresas_mais_treinadas_1_qtd();
		String mais_treinadas_2 = database_service.empresas_mais_treinadas_2();
		int mais_treinadas_2_qtd = database_service.empresas_mais_treinadas_2_qtd();
		String mais_treinadas_3 = database_service.empresas_mais_treinadas_3();
		int mais_treinadas_3_qtd = database_service.empresas_mais_treinadas_3_qtd();
		String mais_treinadas_4 = database_service.empresas_mais_treinadas_4();
		int mais_treinadas_4_qtd = database_service.empresas_mais_treinadas_4_qtd();
		String mais_treinadas_5 = database_service.empresas_mais_treinadas_5();
		int mais_treinadas_5_qtd = database_service.empresas_mais_treinadas_5_qtd();
		String mais_treinadas_6 = database_service.empresas_mais_treinadas_6();
		int mais_treinadas_6_qtd = database_service.empresas_mais_treinadas_6_qtd();
		
		int treinamentos_concluidos = database_service.treinamentos_concluidos();
		int treinamentos_pendentes = database_service.treinamentos_pendentes();
		int treinamentos_adiados = database_service.treinamentos_adiados();
		int treinamentos_cancelados = database_service.treinamentos_cancelados();
		int treinamentos_abortados = database_service.treinamentos_abortados();
		int treinamentos_interrompidos = database_service.treinamentos_interrompidos();
		
		request.setAttribute("treinamentos", treinamentos);
		request.setAttribute("total_empresas", total_empresas);
		request.setAttribute("total_convidados", total_convidados);
		request.setAttribute("total_treinamentos_concluidos", total_treinamentos_concluidos);
		request.setAttribute("empresa_mais_treinada_quantos", empresa_mais_treinada_quantos);
		request.setAttribute("qual_empresa_mais_treinada", qual_empresa_mais_treinada);
		
		request.setAttribute("quantos_janeiro_2019", quantos_janeiro_2019);
		request.setAttribute("quantos_fevereiro_2019", quantos_fevereiro_2019);
		request.setAttribute("quantos_marco_2019", quantos_marco_2019);
		request.setAttribute("quantos_abril_2019", quantos_abril_2019);
		request.setAttribute("quantos_maio_2019", quantos_maio_2019);
		request.setAttribute("quantos_junho_2019", quantos_junho_2019);
		request.setAttribute("quantos_julho_2019", quantos_julho_2019);
		request.setAttribute("quantos_agosto_2019", quantos_agosto_2019);
		request.setAttribute("quantos_setembro_2019", quantos_setembro_2019);
		request.setAttribute("quantos_outubro_2019", quantos_outubro_2019);
		request.setAttribute("quantos_novembro_2019", quantos_novembro_2019);
		request.setAttribute("quantos_dezembro_2019", quantos_dezembro_2019);
		
		request.setAttribute("quantos_janeiro_2020", quantos_janeiro_2020);
		request.setAttribute("quantos_fevereiro_2020", quantos_fevereiro_2020);
		request.setAttribute("quantos_marco_2020", quantos_marco_2020);
		request.setAttribute("quantos_abril_2020", quantos_abril_2020);
		request.setAttribute("quantos_maio_2020", quantos_maio_2020);
		request.setAttribute("quantos_junho_2020", quantos_junho_2020);
		request.setAttribute("quantos_julho_2020", quantos_julho_2020);
		request.setAttribute("quantos_agosto_2020", quantos_agosto_2020);
		request.setAttribute("quantos_setembro_2020", quantos_setembro_2020);
		request.setAttribute("quantos_outubro_2020", quantos_outubro_2020);
		request.setAttribute("quantos_novembro_2020", quantos_novembro_2020);
		request.setAttribute("quantos_dezembro_2020", quantos_dezembro_2020);
		
		request.setAttribute("quantos_janeiro_2021", quantos_janeiro_2021);
		request.setAttribute("quantos_fevereiro_2021", quantos_fevereiro_2021);
		request.setAttribute("quantos_marco_2021", quantos_marco_2021);
		request.setAttribute("quantos_abril_2021", quantos_abril_2021);
		request.setAttribute("quantos_maio_2021", quantos_maio_2021);
		request.setAttribute("quantos_junho_2021", quantos_junho_2021);
		request.setAttribute("quantos_julho_2021", quantos_julho_2021);
		request.setAttribute("quantos_agosto_2021", quantos_agosto_2021);
		request.setAttribute("quantos_setembro_2021", quantos_setembro_2021);
		request.setAttribute("quantos_outubro_2021", quantos_outubro_2021);
		request.setAttribute("quantos_novembro_2021", quantos_novembro_2021);
		request.setAttribute("quantos_dezembro_2021", quantos_dezembro_2021);
		
		request.setAttribute("quantos_janeiro_2022", quantos_janeiro_2022);
		request.setAttribute("quantos_fevereiro_2022", quantos_fevereiro_2022);
		request.setAttribute("quantos_marco_2022", quantos_marco_2022);
		request.setAttribute("quantos_abril_2022", quantos_abril_2022);
		request.setAttribute("quantos_maio_2022", quantos_maio_2022);
		request.setAttribute("quantos_junho_2022", quantos_junho_2022);
		request.setAttribute("quantos_julho_2022", quantos_julho_2022);
		request.setAttribute("quantos_agosto_2022", quantos_agosto_2022);
		request.setAttribute("quantos_setembro_2022", quantos_setembro_2022);
		request.setAttribute("quantos_outubro_2022", quantos_outubro_2022);
		request.setAttribute("quantos_novembro_2022", quantos_novembro_2022);
		request.setAttribute("quantos_dezembro_2022", quantos_dezembro_2022);
		
		request.setAttribute("quantos_janeiro_2023", quantos_janeiro_2023);
		request.setAttribute("quantos_fevereiro_2023", quantos_fevereiro_2023);
		request.setAttribute("quantos_marco_2023", quantos_marco_2023);
		request.setAttribute("quantos_abril_2023", quantos_abril_2023);
		request.setAttribute("quantos_maio_2023", quantos_maio_2023);
		request.setAttribute("quantos_junho_2023", quantos_junho_2023);
		request.setAttribute("quantos_julho_2023", quantos_julho_2023);
		request.setAttribute("quantos_agosto_2023", quantos_agosto_2023);
		request.setAttribute("quantos_setembro_2023", quantos_setembro_2023);
		request.setAttribute("quantos_outubro_2023", quantos_outubro_2023);
		request.setAttribute("quantos_novembro_2023", quantos_novembro_2023);
		request.setAttribute("quantos_dezembro_2023", quantos_dezembro_2023);
		
		request.setAttribute("quantos_janeiro_2024", quantos_janeiro_2024);
		request.setAttribute("quantos_fevereiro_2024", quantos_fevereiro_2024);
		request.setAttribute("quantos_marco_2024", quantos_marco_2024);
		request.setAttribute("quantos_abril_2024", quantos_abril_2024);
		request.setAttribute("quantos_maio_2024", quantos_maio_2024);
		request.setAttribute("quantos_junho_2024", quantos_junho_2024);
		request.setAttribute("quantos_julho_2024", quantos_julho_2024);
		request.setAttribute("quantos_agosto_2024", quantos_agosto_2024);
		request.setAttribute("quantos_setembro_2024", quantos_setembro_2024);
		request.setAttribute("quantos_outubro_2024", quantos_outubro_2024);
		request.setAttribute("quantos_novembro_2024", quantos_novembro_2024);
		request.setAttribute("quantos_dezembro_2024", quantos_dezembro_2024);
		
		request.setAttribute("quantos_2019", quantos_2019);
		request.setAttribute("quantos_2020", quantos_2020);
		request.setAttribute("quantos_2021", quantos_2021);
		request.setAttribute("quantos_2022", quantos_2022);
		request.setAttribute("quantos_2023", quantos_2023);
		request.setAttribute("quantos_2024", quantos_2024);
		
		request.setAttribute("mais_treinadas_1", mais_treinadas_1);
		request.setAttribute("mais_treinadas_1_qtd", mais_treinadas_1_qtd);
		request.setAttribute("mais_treinadas_2", mais_treinadas_2);
		request.setAttribute("mais_treinadas_2_qtd", mais_treinadas_2_qtd);
		request.setAttribute("mais_treinadas_3", mais_treinadas_3);
		request.setAttribute("mais_treinadas_3_qtd", mais_treinadas_3_qtd);
		request.setAttribute("mais_treinadas_4", mais_treinadas_4);
		request.setAttribute("mais_treinadas_4_qtd", mais_treinadas_4_qtd);
		request.setAttribute("mais_treinadas_5", mais_treinadas_5);
		request.setAttribute("mais_treinadas_5_qtd", mais_treinadas_5_qtd);
		request.setAttribute("mais_treinadas_6", mais_treinadas_6);
		request.setAttribute("mais_treinadas_6_qtd", mais_treinadas_6_qtd);
		
		request.setAttribute("treinamentos_concluidos", treinamentos_concluidos);
		request.setAttribute("treinamentos_pendentes", treinamentos_pendentes);
		request.setAttribute("treinamentos_adiados", treinamentos_adiados);
		request.setAttribute("treinamentos_cancelados", treinamentos_cancelados);
		request.setAttribute("treinamentos_abortados", treinamentos_abortados);
		request.setAttribute("treinamentos_interrompidos", treinamentos_interrompidos);
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
