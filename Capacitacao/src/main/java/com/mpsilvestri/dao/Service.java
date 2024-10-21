package com.mpsilvestri.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mpsilvestri.entity.Convidado;
import com.mpsilvestri.entity.Curso;
import com.mpsilvestri.entity.DashTable;
import com.mpsilvestri.entity.Empresa;
import com.mpsilvestri.entity.Treinamento;

public class Service {
	
	public ResultSet select_todos_treinamentos() {
		
		String sql = "select * from treinamento";
		
		try (Statement statement = Database.connection.createStatement()){
		
			ResultSet result_set = statement.executeQuery(sql);
		
			List<Treinamento> treinamentos = new ArrayList<>();
						
			while(result_set.next()) {
			
				Treinamento treinamento = new Treinamento();
				
				treinamento.setId(result_set.getInt("id"));
				treinamento.setData(result_set.getDate("data"));
				treinamento.setStatus(result_set.getString("status"));
				treinamento.setObservacao(result_set.getString("observacao"));
				
				treinamentos.add(treinamento);
				
				System.out.println(treinamento);
				System.out.println();
				
			}
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return null;
		
	}
	
	public ResultSet select_todas_empresas() {
		
		String sql = "select * from empresa";
		
		try (Statement statement = Database.connection.createStatement()){
			
			ResultSet result_set = statement.executeQuery(sql);
			
			List<Empresa> empresas = new ArrayList<>();
			
			while(result_set.next()) {
				
				Empresa empresa = new Empresa();
				
				empresa.setId(result_set.getInt("id"));
				empresa.setNome(result_set.getString("nome"));
							
				empresas.add(empresa);
				
				System.out.println(empresa);
				System.out.println();
				
			}
			
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return null;
	}
	
	public ResultSet select_todos_cursos() {
		
		String sql = "select * from curso";
		
		try (Statement statement = Database.connection.createStatement()) {
			
			ResultSet result_set = statement.executeQuery(sql);
			
			List<Curso> cursos = new ArrayList<>();
			
			while(result_set.next()) {
				
				Curso curso = new Curso();
				
				curso.setId(result_set.getInt("id"));
				curso.setNome(result_set.getString("nome"));
				curso.setDescricao(result_set.getString("descricao"));
							
				cursos.add(curso);
				
				System.out.println(curso);
				System.out.println();
			
			}
				
			
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return null;
		
	}
	
	public ResultSet select_todos_convidados() {
			
			String sql = "select * from convidado";
			
			try (Statement statement = Database.connection.createStatement()) {
				
				ResultSet result_set = statement.executeQuery(sql);
				
				List<Convidado> convidados = new ArrayList<>();
				
				while(result_set.next()) {
					
					Convidado convidado = new Convidado();
					
					convidado.setEmail(result_set.getString("email"));
					convidado.setNome(result_set.getString("nome"));
					convidado.setObservacao(result_set.getString("observacao"));
								
					convidados.add(convidado);
					
					System.out.println(convidado);
					System.out.println();
				
				}
					
				
			} catch (SQLException sql_ex) {
				System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
			}
			
			return null;
			
		}
	
	public List<DashTable> select_todos_treinamentos_dashboard() {
		
		String sql = "select convidado.nome, convidado.email, empresa.nome, curso.nome, treinamento.data, treinamento.status "
				+ "from treinamento "
				+ "inner join curso on curso.id = treinamento.fk_curso_id "
				+ "inner join empresa_treinamento on empresa_treinamento.fk_treinamento_id = treinamento.id "
				+ "inner join empresa on empresa.id = empresa_treinamento.fk_empresa_id "
				+ "inner join treinamento_convidado on treinamento.id = treinamento_convidado.fk_treinamento_id "
				+ "inner join convidado on convidado.email = treinamento_convidado.fk_convidado_email "
				+ "order by data desc";
		
		ResultSet result_set = null;
		List<DashTable> treinamentos = null;
		try {
			
			Statement statement = Database.connection.createStatement();
		
			result_set = statement.executeQuery(sql);
		
			treinamentos = new ArrayList<>();
						
			while(result_set.next()) {
			
				DashTable treinamento = new DashTable();
				
				treinamento.setNome(result_set.getString("convidado.nome"));
				treinamento.setEmail(result_set.getString("convidado.email"));
				treinamento.setEmpresa(result_set.getString("empresa.nome"));
				treinamento.setCurso(result_set.getString("curso.nome"));
				treinamento.setData(result_set.getDate("treinamento.data"));
				treinamento.setStatus(result_set.getString("treinamento.status"));
				
				treinamentos.add(treinamento);
				
				// System.out.println(treinamento);
				System.out.println();
				
			}
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		
		return treinamentos;
		
	}
	
	public int total_empresas_dashboard() {
		
		String sql = "select count(*) from empresa";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.next();
			total = result_set.getInt(1);
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
	}
	
public int total_convidados_dashboard() {
		
		String sql = "select count(*) from convidado";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.next();
			total = result_set.getInt(1);
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
	}

	public int total_treinamentos_concluidos_dashboard() {
	
		String sql = "select distinct(data) from treinamento where status = 'Concluído'";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getRow();
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
	}
	
	public int empresa_mais_treinada_quantos_dashboard() {
		
		String sql = "select nome, count(nome) as quantos from treinamento "
				+ "inner join empresa_treinamento on empresa_treinamento.fk_treinamento_id = treinamento.id "
				+ "inner join empresa on empresa.id = empresa_treinamento.fk_empresa_id "
				+ "where status = 'Concluído' "
				+ "group by nome "
				+ "order by count(*) desc "
				+ "limit 1";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
	}
	
	public String qual_empresa_mais_treinada_dashboard() {
		
		String sql = "select nome, count(nome) as quantos from treinamento "
				+ "inner join empresa_treinamento on empresa_treinamento.fk_treinamento_id = treinamento.id "
				+ "inner join empresa on empresa.id = empresa_treinamento.fk_empresa_id "
				+ "where status = 'Concluído' "
				+ "group by nome "
				+ "order by count(*) desc "
				+ "limit 1";
		
		ResultSet result_set = null;
		
		String qual = "";
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			qual = result_set.getString("nome");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return qual;
	}
	
	public int quantos_janeiro_2019_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_janeiro from treinamento "
				+ "where status = 'Concluído' and (data between '2019-01-01' and '2019-01-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_janeiro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
	}

	public int quantos_fevereiro_2019_dashboard_grafico() {

		String sql = "select count(distinct(data)) as quantos_fevereiro from treinamento "
				+ "where status = 'Concluído' and (data between '2019-02-01' and '2019-02-28')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_fevereiro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
	}

	public int quantos_marco_2019_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_marco from treinamento "
				+ "where status = 'Concluído' and (data between '2019-03-01' and '2019-03-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_marco");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_abril_2019_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_abril from treinamento "
				+ "where status = 'Concluído' and (data between '2019-04-01' and '2019-04-30')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_abril");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_maio_2019_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_maio from treinamento "
				+ "where status = 'Concluído' and (data between '2019-05-01' and '2019-05-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_maio");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_junho_2019_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_junho from treinamento "
				+ "where status = 'Concluído' and (data between '2019-06-01' and '2019-06-30')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_junho");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_julho_2019_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_julho from treinamento "
				+ "where status = 'Concluído' and (data between '2019-07-01' and '2019-07-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_julho");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_agosto_2019_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_agosto from treinamento "
				+ "where status = 'Concluído' and (data between '2019-08-01' and '2019-08-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_agosto");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_setembro_2019_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_setembro from treinamento "
				+ "where status = 'Concluído' and (data between '2019-09-01' and '2019-09-30')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_setembro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_outubro_2019_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_outubro from treinamento "
				+ "where status = 'Concluído' and (data between '2019-10-01' and '2019-10-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_outubro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_novembro_2019_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_novembro from treinamento "
				+ "where status = 'Concluído' and (data between '2019-11-01' and '2019-11-30')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_novembro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_dezembro_2019_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_dezembro from treinamento "
				+ "where status = 'Concluído' and (data between '2019-12-01' and '2019-12-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_dezembro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}
	
	public int quantos_janeiro_2020_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_janeiro from treinamento "
				+ "where status = 'Concluído' and (data between '2020-01-01' and '2020-01-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_janeiro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
	}

	public int quantos_fevereiro_2020_dashboard_grafico() {

		String sql = "select count(distinct(data)) as quantos_fevereiro from treinamento "
				+ "where status = 'Concluído' and (data between '2020-02-01' and '2020-02-29')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_fevereiro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
	}

	public int quantos_marco_2020_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_marco from treinamento "
				+ "where status = 'Concluído' and (data between '2020-03-01' and '2020-03-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_marco");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_abril_2020_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_abril from treinamento "
				+ "where status = 'Concluído' and (data between '2020-04-01' and '2020-04-30')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_abril");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_maio_2020_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_maio from treinamento "
				+ "where status = 'Concluído' and (data between '2020-05-01' and '2020-05-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_maio");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_junho_2020_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_junho from treinamento "
				+ "where status = 'Concluído' and (data between '2020-06-01' and '2020-06-30')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_junho");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_julho_2020_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_julho from treinamento "
				+ "where status = 'Concluído' and (data between '2020-07-01' and '2020-07-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_julho");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_agosto_2020_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_agosto from treinamento "
				+ "where status = 'Concluído' and (data between '2020-08-01' and '2020-08-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_agosto");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_setembro_2020_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_setembro from treinamento "
				+ "where status = 'Concluído' and (data between '2020-09-01' and '2020-09-30')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_setembro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_outubro_2020_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_outubro from treinamento "
				+ "where status = 'Concluído' and (data between '2020-10-01' and '2020-10-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_outubro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_novembro_2020_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_novembro from treinamento "
				+ "where status = 'Concluído' and (data between '2020-11-01' and '2020-11-30')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_novembro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_dezembro_2020_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_dezembro from treinamento "
				+ "where status = 'Concluído' and (data between '2020-12-01' and '2020-12-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_dezembro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_janeiro_2021_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_janeiro from treinamento "
				+ "where status = 'Concluído' and (data between '2021-01-01' and '2021-01-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_janeiro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_fevereiro_2021_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_fevereiro from treinamento "
				+ "where status = 'Concluído' and (data between '2021-02-01' and '2021-02-28')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_fevereiro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_marco_2021_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_marco from treinamento "
				+ "where status = 'Concluído' and (data between '2021-03-01' and '2021-03-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_marco");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_abril_2021_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_abril from treinamento "
				+ "where status = 'Concluído' and (data between '2021-04-01' and '2021-04-30')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_abril");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_maio_2021_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_maio from treinamento "
				+ "where status = 'Concluído' and (data between '2021-05-01' and '2021-05-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_maio");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_junho_2021_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_junho from treinamento "
				+ "where status = 'Concluído' and (data between '2021-06-01' and '2021-06-30')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_junho");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_julho_2021_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_julho from treinamento "
				+ "where status = 'Concluído' and (data between '2021-07-01' and '2021-07-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_julho");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_agosto_2021_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_agosto from treinamento "
				+ "where status = 'Concluído' and (data between '2021-08-01' and '2021-08-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_agosto");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_setembro_2021_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_setembro from treinamento "
				+ "where status = 'Concluído' and (data between '2021-09-01' and '2021-09-30')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_setembro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_outubro_2021_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_outubro from treinamento "
				+ "where status = 'Concluído' and (data between '2021-10-01' and '2021-10-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_outubro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_novembro_2021_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_novembro from treinamento "
				+ "where status = 'Concluído' and (data between '2021-11-01' and '2021-11-30')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_novembro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_dezembro_2021_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_dezembro from treinamento "
				+ "where status = 'Concluído' and (data between '2021-12-01' and '2021-12-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_dezembro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_janeiro_2022_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_janeiro from treinamento "
				+ "where status = 'Concluído' and (data between '2022-01-01' and '2022-01-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_janeiro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_fevereiro_2022_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_fevereiro from treinamento "
				+ "where status = 'Concluído' and (data between '2022-02-01' and '2022-02-28')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_fevereiro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_marco_2022_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_marco from treinamento "
				+ "where status = 'Concluído' and (data between '2022-03-01' and '2022-03-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_marco");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_abril_2022_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_abril from treinamento "
				+ "where status = 'Concluído' and (data between '2022-04-01' and '2022-04-30')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_abril");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_maio_2022_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_maio from treinamento "
				+ "where status = 'Concluído' and (data between '2022-05-01' and '2022-05-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_maio");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_junho_2022_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_junho from treinamento "
				+ "where status = 'Concluído' and (data between '2022-06-01' and '2022-06-30')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_junho");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_julho_2022_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_julho from treinamento "
				+ "where status = 'Concluído' and (data between '2022-07-01' and '2022-07-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_julho");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_agosto_2022_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_agosto from treinamento "
				+ "where status = 'Concluído' and (data between '2022-08-01' and '2022-08-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_agosto");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_setembro_2022_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_setembro from treinamento "
				+ "where status = 'Concluído' and (data between '2022-09-01' and '2022-09-30')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_setembro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_outubro_2022_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_outubro from treinamento "
				+ "where status = 'Concluído' and (data between '2022-10-01' and '2022-10-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_outubro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_novembro_2022_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_novembro from treinamento "
				+ "where status = 'Concluído' and (data between '2022-11-01' and '2022-11-30')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_novembro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_dezembro_2022_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_dezembro from treinamento "
				+ "where status = 'Concluído' and (data between '2022-12-01' and '2022-12-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_dezembro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}
	
public int quantos_janeiro_2023_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_janeiro from treinamento "
				+ "where status = 'Concluído' and (data between '2023-01-01' and '2023-01-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_janeiro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_fevereiro_2023_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_fevereiro from treinamento "
				+ "where status = 'Concluído' and (data between '2023-02-01' and '2023-02-28')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_fevereiro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_marco_2023_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_marco from treinamento "
				+ "where status = 'Concluído' and (data between '2023-03-01' and '2023-03-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_marco");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_abril_2023_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_abril from treinamento "
				+ "where status = 'Concluído' and (data between '2023-04-01' and '2023-04-30')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_abril");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_maio_2023_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_maio from treinamento "
				+ "where status = 'Concluído' and (data between '2023-05-01' and '2023-05-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_maio");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_junho_2023_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_junho from treinamento "
				+ "where status = 'Concluído' and (data between '2023-06-01' and '2023-06-30')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_junho");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_julho_2023_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_julho from treinamento "
				+ "where status = 'Concluído' and (data between '2023-07-01' and '2023-07-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_julho");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_agosto_2023_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_agosto from treinamento "
				+ "where status = 'Concluído' and (data between '2023-08-01' and '2023-08-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_agosto");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_setembro_2023_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_setembro from treinamento "
				+ "where status = 'Concluído' and (data between '2023-09-01' and '2023-09-30')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_setembro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_outubro_2023_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_outubro from treinamento "
				+ "where status = 'Concluído' and (data between '2023-10-01' and '2023-10-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_outubro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_novembro_2023_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_novembro from treinamento "
				+ "where status = 'Concluído' and (data between '2023-11-01' and '2023-11-30')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_novembro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public int quantos_dezembro_2023_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_dezembro from treinamento "
				+ "where status = 'Concluído' and (data between '2023-12-01' and '2023-12-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_dezembro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}
	
	public int quantos_janeiro_2024_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_janeiro from treinamento "
				+ "where status = 'Concluído' and (data between '2024-01-01' and '2024-01-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_janeiro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}
	
	public int quantos_fevereiro_2024_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_fevereiro from treinamento "
				+ "where status = 'Concluído' and (data between '2024-02-01' and '2024-02-28')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_fevereiro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}
	
	public int quantos_marco_2024_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_marco from treinamento "
				+ "where status = 'Concluído' and (data between '2024-03-01' and '2024-03-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_marco");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}
	
	public int quantos_abril_2024_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_abril from treinamento "
				+ "where status = 'Concluído' and (data between '2024-04-01' and '2024-04-30')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_abril");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}
	
	public int quantos_maio_2024_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_maio from treinamento "
				+ "where status = 'Concluído' and (data between '2024-05-01' and '2024-05-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_maio");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}
	
	public int quantos_junho_2024_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_junho from treinamento "
				+ "where status = 'Concluído' and (data between '2024-06-01' and '2024-06-30')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_junho");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}
	
	public int quantos_julho_2024_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_julho from treinamento "
				+ "where status = 'Concluído' and (data between '2024-07-01' and '2024-07-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_julho");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}
	
	public int quantos_agosto_2024_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_agosto from treinamento "
				+ "where status = 'Concluído' and (data between '2024-08-01' and '2024-08-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_agosto");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}
	
	public int quantos_setembro_2024_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_setembro from treinamento "
				+ "where status = 'Concluído' and (data between '2024-09-01' and '2024-09-30')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_setembro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}
	
	public int quantos_outubro_2024_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_outubro from treinamento "
				+ "where status = 'Concluído' and (data between '2024-10-01' and '2024-10-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_outubro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}
	
	public int quantos_novembro_2024_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_novembro from treinamento "
				+ "where status = 'Concluído' and (data between '2024-11-01' and '2024-11-30')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_novembro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}
	
	public int quantos_dezembro_2024_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_dezembro from treinamento "
				+ "where status = 'Concluído' and (data between '2024-12-01' and '2024-12-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_dezembro");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}
	
	public int quantos_2019_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_2019 from treinamento "
				+ "where status = 'Concluído' and (data between '2019-01-01' and '2019-12-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_2019");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}
	
	public int quantos_2020_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_2020 from treinamento "
				+ "where status = 'Concluído' and (data between '2020-01-01' and '2020-12-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_2020");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}
	
	public int quantos_2021_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_2021 from treinamento "
				+ "where status = 'Concluído' and (data between '2021-01-01' and '2021-12-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_2021");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}
	
	public int quantos_2022_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_2022 from treinamento "
				+ "where status = 'Concluído' and (data between '2022-01-01' and '2022-12-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_2022");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}
	
	public int quantos_2023_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_2023 from treinamento "
				+ "where status = 'Concluído' and (data between '2023-01-01' and '2023-12-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_2023");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}
	
	public int quantos_2024_dashboard_grafico() {
		
		String sql = "select count(distinct(data)) as quantos_2024 from treinamento "
				+ "where status = 'Concluído' and (data between '2024-01-01' and '2024-12-31')";
		
		ResultSet result_set = null;
		
		int total = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			total = result_set.getInt("quantos_2024");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return total;
		
	}

	public String empresas_mais_treinadas_1() {
		
		String sql = "select nome, count(nome) as quantos from treinamento "
				+ "inner join empresa_treinamento on empresa_treinamento.fk_treinamento_id = treinamento.id "
				+ "inner join empresa on empresa.id = empresa_treinamento.fk_empresa_id "
				+ "where status = 'Concluído' "
				+ "group by nome "
				+ "order by count(*) desc "
				+ "limit 6";
		
		ResultSet result_set = null;
		
		String empresa = "";
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.next();
			empresa = result_set.getString("nome");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return empresa;
		
	}

	public int empresas_mais_treinadas_1_qtd() {
		
		String sql = "select nome, count(nome) as quantos from treinamento "
				+ "inner join empresa_treinamento on empresa_treinamento.fk_treinamento_id = treinamento.id "
				+ "inner join empresa on empresa.id = empresa_treinamento.fk_empresa_id "
				+ "where status = 'Concluído' "
				+ "group by nome "
				+ "order by count(*) desc "
				+ "limit 6";
		
		ResultSet result_set = null;
		
		int quantos = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.next();
			quantos = result_set.getInt("quantos");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return quantos;
		
	}

	public String empresas_mais_treinadas_2() {
		
		String sql = "select nome, count(nome) as quantos from treinamento "
				+ "inner join empresa_treinamento on empresa_treinamento.fk_treinamento_id = treinamento.id "
				+ "inner join empresa on empresa.id = empresa_treinamento.fk_empresa_id "
				+ "where status = 'Concluído' "
				+ "group by nome "
				+ "order by count(*) desc "
				+ "limit 6";
		
		ResultSet result_set = null;
		
		String empresa = "";
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.next();
			result_set.next();
			empresa = result_set.getString("nome");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return empresa;
		
	}

	public int empresas_mais_treinadas_2_qtd() {
		
		String sql = "select nome, count(nome) as quantos from treinamento "
				+ "inner join empresa_treinamento on empresa_treinamento.fk_treinamento_id = treinamento.id "
				+ "inner join empresa on empresa.id = empresa_treinamento.fk_empresa_id "
				+ "where status = 'Concluído' "
				+ "group by nome "
				+ "order by count(*) desc "
				+ "limit 6";
		
		ResultSet result_set = null;
		
		int quantos = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.next();
			result_set.next();
			quantos = result_set.getInt("quantos");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return quantos;
		
	}

	public String empresas_mais_treinadas_3() {
		
		String sql = "select nome, count(nome) as quantos from treinamento "
				+ "inner join empresa_treinamento on empresa_treinamento.fk_treinamento_id = treinamento.id "
				+ "inner join empresa on empresa.id = empresa_treinamento.fk_empresa_id "
				+ "where status = 'Concluído' "
				+ "group by nome "
				+ "order by count(*) desc "
				+ "limit 6";
		
		ResultSet result_set = null;
		
		String empresa = "";
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.next();
			result_set.next();
			result_set.next();
			empresa = result_set.getString("nome");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return empresa;
		
	}

	public int empresas_mais_treinadas_3_qtd() {
		
		String sql = "select nome, count(nome) as quantos from treinamento "
				+ "inner join empresa_treinamento on empresa_treinamento.fk_treinamento_id = treinamento.id "
				+ "inner join empresa on empresa.id = empresa_treinamento.fk_empresa_id "
				+ "where status = 'Concluído' "
				+ "group by nome "
				+ "order by count(*) desc "
				+ "limit 6";
		
		ResultSet result_set = null;
		
		int quantos = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.next();
			result_set.next();
			result_set.next();
			quantos = result_set.getInt("quantos");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return quantos;
		
	}

	public String empresas_mais_treinadas_4() {
		
		String sql = "select nome, count(nome) as quantos from treinamento "
				+ "inner join empresa_treinamento on empresa_treinamento.fk_treinamento_id = treinamento.id "
				+ "inner join empresa on empresa.id = empresa_treinamento.fk_empresa_id "
				+ "where status = 'Concluído' "
				+ "group by nome "
				+ "order by count(*) desc "
				+ "limit 6";
		
		ResultSet result_set = null;
		
		String empresa = "";
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.next();
			result_set.next();
			result_set.next();
			result_set.next();
			empresa = result_set.getString("nome");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return empresa;
		
	}

	public int empresas_mais_treinadas_4_qtd() {
		
		String sql = "select nome, count(nome) as quantos from treinamento "
				+ "inner join empresa_treinamento on empresa_treinamento.fk_treinamento_id = treinamento.id "
				+ "inner join empresa on empresa.id = empresa_treinamento.fk_empresa_id "
				+ "where status = 'Concluído' "
				+ "group by nome "
				+ "order by count(*) desc "
				+ "limit 6";
		
		ResultSet result_set = null;
		
		int quantos = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.next();
			result_set.next();
			result_set.next();
			result_set.next();
			quantos = result_set.getInt("quantos");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return quantos;
		
	}

	public String empresas_mais_treinadas_5() {
		
		String sql = "select nome, count(nome) as quantos from treinamento "
				+ "inner join empresa_treinamento on empresa_treinamento.fk_treinamento_id = treinamento.id "
				+ "inner join empresa on empresa.id = empresa_treinamento.fk_empresa_id "
				+ "where status = 'Concluído' "
				+ "group by nome "
				+ "order by count(*) desc "
				+ "limit 6";
		
		ResultSet result_set = null;
		
		String empresa = "";
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.next();
			result_set.next();
			result_set.next();
			result_set.next();
			result_set.next();
			empresa = result_set.getString("nome");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return empresa;
		
	}

	public int empresas_mais_treinadas_5_qtd() {
		
		String sql = "select nome, count(nome) as quantos from treinamento "
				+ "inner join empresa_treinamento on empresa_treinamento.fk_treinamento_id = treinamento.id "
				+ "inner join empresa on empresa.id = empresa_treinamento.fk_empresa_id "
				+ "where status = 'Concluído' "
				+ "group by nome "
				+ "order by count(*) desc "
				+ "limit 6";
		
		ResultSet result_set = null;
		
		int quantos = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.next();
			result_set.next();
			result_set.next();
			result_set.next();
			result_set.next();
			quantos = result_set.getInt("quantos");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return quantos;
		
	}
	
	public String empresas_mais_treinadas_6() {
		
		String sql = "select nome, count(nome) as quantos from treinamento "
				+ "inner join empresa_treinamento on empresa_treinamento.fk_treinamento_id = treinamento.id "
				+ "inner join empresa on empresa.id = empresa_treinamento.fk_empresa_id "
				+ "where status = 'Concluído' "
				+ "group by nome "
				+ "order by count(*) desc "
				+ "limit 6";
		
		// Tentativa de unificar resultados de Manole (funciona dentro do banco, mas não aqui)
		String sql2 = "select "
				+ "	CASE "
				+ "     WHEN nome LIKE 'Manole%' THEN 'Manole / Raccoon / Pusco' "
				+ "        ELSE nome "
				+ " END AS unified_nome, "
				+ "count(nome) as quantos from treinamento "
				+ "inner join empresa_treinamento on empresa_treinamento.fk_treinamento_id = treinamento.id "
				+ "inner join empresa on empresa.id = empresa_treinamento.fk_empresa_id "
				+ "where status = 'Concluído' "
				+ "group by "
				+ "	CASE "
				+ "     WHEN nome LIKE 'Manole%' THEN 'Manole / Raccoon / Pusco' "
				+ "        ELSE nome "
				+ " END "
				+ "order by count(*) desc "
				+ "limit 6";
		
		ResultSet result_set = null;
		
		String empresa = "";
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.next();
			result_set.next();
			result_set.next();
			result_set.next();
			result_set.next();
			result_set.next();
			empresa = result_set.getString("nome");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return empresa;
		
	}

	public int empresas_mais_treinadas_6_qtd() {
		
		String sql = "select nome, count(nome) as quantos from treinamento "
				+ "inner join empresa_treinamento on empresa_treinamento.fk_treinamento_id = treinamento.id "
				+ "inner join empresa on empresa.id = empresa_treinamento.fk_empresa_id "
				+ "where status = 'Concluído' "
				+ "group by nome "
				+ "order by count(*) desc "
				+ "limit 6";
		
		// Tentativa de unificar resultados de Manole (funciona dentro do banco, mas não aqui)
		String sql2 = "select "
				+ "	CASE "
				+ "     WHEN nome LIKE 'Manole%' THEN 'Manole / Raccoon / Pusco' "
				+ "        ELSE nome "
				+ " END AS unified_nome, "
				+ "count(nome) as quantos from treinamento "
				+ "inner join empresa_treinamento on empresa_treinamento.fk_treinamento_id = treinamento.id "
				+ "inner join empresa on empresa.id = empresa_treinamento.fk_empresa_id "
				+ "where status = 'Concluído' "
				+ "group by "
				+ "	CASE "
				+ "     WHEN nome LIKE 'Manole%' THEN 'Manole / Raccoon / Pusco' "
				+ "        ELSE nome "
				+ " END "
				+ "order by count(*) desc "
				+ "limit 6";
		
		ResultSet result_set = null;
		
		int quantos = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.next();
			result_set.next();
			result_set.next();
			result_set.next();
			result_set.next();
			result_set.next();
			quantos = result_set.getInt("quantos");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return quantos;
		
	}

	public int treinamentos_concluidos() {
		
		String sql = "select count(*) as contagem from treinamento where status = 'Concluído'";
		
		ResultSet result_set = null;
		
		int quantos = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			quantos = result_set.getInt("contagem");
					
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return quantos;
		
	}

	public int treinamentos_pendentes() {
		
		String sql = "select count(*) as contagem from treinamento where status = 'Pendente'";
		
		ResultSet result_set = null;
		
		int quantos = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			quantos = result_set.getInt("contagem");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return quantos;
		
	}

	public int treinamentos_adiados() {
		
		String sql = "select count(*) as contagem from treinamento where status = 'Adiado'";
		
		ResultSet result_set = null;
		
		int quantos = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			quantos = result_set.getInt("contagem");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return quantos;
		
	}

	public int treinamentos_cancelados() {
		
		String sql = "select count(*) as contagem from treinamento where status = 'Cancelado'";
		
		ResultSet result_set = null;
		
		int quantos = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			quantos = result_set.getInt("contagem");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return quantos;
		
	}

	public int treinamentos_abortados() {
		
		String sql = "select count(*) as contagem from treinamento where status = 'Abortado'";
		
		ResultSet result_set = null;
		
		int quantos = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			quantos = result_set.getInt("contagem");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return quantos;
		
	}

	public int treinamentos_interrompidos() {
		
		String sql = "select count(*) as contagem from treinamento where status = 'Interrompido'";
		
		ResultSet result_set = null;
		
		int quantos = 0;
		try {
			
			Statement statement = Database.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
			result_set = statement.executeQuery(sql);
						
			result_set.last();
			quantos = result_set.getInt("contagem");
		
		} catch (SQLException sql_ex) {
			System.out.println("Error: " + sql_ex.getMessage() + "|" + sql_ex.getStackTrace());
		}
		
		return quantos;
		
	}

	

}
