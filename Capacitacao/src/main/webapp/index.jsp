<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page errorPage = "error.jsp" %>
<!DOCTYPE html>
<html>
<head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Dashboard de Treinamentos</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="index.html">Treinamentos</a>
            <!-- Sidebar Toggle-->
            
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            
            <!-- Navbar Search-->
            <!--
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                    <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
                </div>
            </form>
            -->
            <!-- Navbar-->
            <!-- 
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#!">Settings</a></li>
                        <li><a class="dropdown-item" href="#!">Activity Log</a></li>
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="#!">Logout</a></li>
                    </ul>
                </li>
            </ul>
             -->
        </nav>
        <div id="layoutSidenav">
        	
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Core</div>
                            <a class="nav-link" href="#" onClick="window.location.reload()">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Dashboard
                            </a>
                            <div class="sb-sidenav-menu-heading">Treinamentos</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Sites
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="https://expertsender.mpsilvestri.com/" target="_blank">Português</a>
                                    <a class="nav-link" href="https://help.expertsender.com/" target="_blank">Inglês</a>
                                </nav>
                            </div>
                            
                            <div class="sb-sidenav-menu-heading">Documentações</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Sites
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="https://sites.google.com/expertsender.com/api-documentation-v2" target="_blank">API</a>
                                    <a class="nav-link" href="https://sites.google.com/expertsender.com/dynamic-content-documentation" target="_blank">Dynamic Content</a>
                                </nav>
                            </div>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Created by:</div>
                        Marcos Silvestri
                    </div>
                </nav>
            </div>
            
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Dashboard de treinamentos</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">Estatísticas</li>
                        </ol>
                        <div class="row">
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-primary text-white mb-4">
                                    <div class="card-body">Quantas empresas treinadas até hoje? <c:out value="${total_empresas}" /></div>
                                    <!-- 
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="#">View Details</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                     -->
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-warning text-white mb-4">
                                    <div class="card-body">Quantos convidados até hoje? <c:out value="${total_convidados}" /></div>
                                    <!-- 
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="#">View Details</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                     -->
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-success text-white mb-4">
                                    <div class="card-body">Quantos treinamentos até hoje? <c:out value="${total_treinamentos_concluidos}" /></div>
                                    <!-- 
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="#">View Details</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                     -->
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-danger text-white mb-4">
                                    <div class="card-body">Empresa mais treinada até hoje? <c:out value="${qual_empresa_mais_treinada}" /> (<c:out value="${empresa_mais_treinada_quantos}" />)</div>
                                    <!-- 
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="#">View Details</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                     -->
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <!-- 
                            <div class="col-xl-6">
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-area me-1"></i>
                                        Area Chart Example
                                    </div>
                                    <div class="card-body"><canvas id="myAreaChart" width="100%" height="40"></canvas></div>
                                </div>
                            </div>
                             -->
                            <div class="col-xl-12">
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-bar me-1"></i>
                                        Treinamentos de 2019 (<c:out value="${quantos_2019}" />)
                                    </div>
                                    <div class="card-body"><canvas id="2019_bar" width="100%" height="30"></canvas></div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                        	<div class="col-xl-12">
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-bar me-1"></i>
                                        Treinamentos de 2020 (<c:out value="${quantos_2020}" />)
                                    </div>
                                    <div class="card-body"><canvas id="2020_bar" width="100%" height="30"></canvas></div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                        	<div class="col-xl-12">
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-bar me-1"></i>
                                        Treinamentos de 2021 (<c:out value="${quantos_2021}" />)
                                    </div>
                                    <div class="card-body"><canvas id="2021_bar" width="100%" height="30"></canvas></div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                        	<div class="col-xl-12">
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-bar me-1"></i>
                                        Treinamentos de 2022 (<c:out value="${quantos_2022}" />)
                                    </div>
                                    <div class="card-body"><canvas id="2022_bar" width="100%" height="30"></canvas></div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                        	<div class="col-xl-12">
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-bar me-1"></i>
                                        Treinamentos de 2023 (<c:out value="${quantos_2023}" />)
                                    </div>
                                    <div class="card-body"><canvas id="2023_bar" width="100%" height="30"></canvas></div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                        	<div class="col-xl-12">
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-bar me-1"></i>
                                        Treinamentos de 2024 (<c:out value="${quantos_2024}" />)
                                    </div>
                                    <div class="card-body"><canvas id="2024_bar" width="100%" height="30"></canvas></div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                        	<div class="col-xl-6">
                        		<div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-bar me-1"></i>
                                        Status dos treinamentos
                                    </div>
                                    <div class="card-body"><canvas id="status_pie" width="100%" height="50"></canvas></div>
                                </div>
                        	</div>
                        	<div class="col-xl-6">
                        		<div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-bar me-1"></i>
                                        Empresas mais treinadas
                                    </div>
                                    <div class="card-body"><canvas id="empresas_horizontal_bar" width="100%" height="50"></canvas></div>
                                </div>
                        	</div>
                        </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                Treinamentos realizados (por pessoa)
                            </div>
                            <div class="card-body">
                                <table id="datatablesSimple">
                                    <thead>
                                        <tr>
                                            <th>Nome</th>
                                            <th>E-mail</th>
                                            <th>Empresa</th>
                                            <th>Curso</th>
                                            <th>Data</th>
                                            <th>Status</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Nome</th>
                                            <th>E-mail</th>
                                            <th>Empresa</th>
                                            <th>Curso</th>
                                            <th>Data</th>
                                            <th>Status</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <c:forEach var="treinamento" items="${treinamentos}">
                                        	<tr>
	                                        	<td><c:out value="${treinamento.nome}" /></td>
	                                        	<td><c:out value="${treinamento.email}" /></td>
	                                        	<td><c:out value="${treinamento.empresa}" /></td>
	                                        	<td><c:out value="${treinamento.curso}" /></td>
	                                        	<td><c:out value="${treinamento.data}" /></td>
	                                        	<td><c:out value="${treinamento.status}" /></td>
                                        	</tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; MPSilvestri 2023</div>
                            <div>
                                <a href="https://www.linkedin.com/in/marcos-silvestri-661bb216/" target="_blank">LinkedIn</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/chart-area-demo.js"></script>
        <!-- <script src="assets/demo/chart-bar-demo.js"></script> -->
        <!-- <script src="assets/demo/chart-pie-demo.js"></script> -->
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
        
        <script>
     
        Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
        Chart.defaults.global.defaultFontColor = '#292b2c';
        
        var ctx_2019 = document.getElementById("2019_bar");
        var myLineChart_2019 = new Chart(ctx_2019, {
          type: 'bar',
          data: {
            labels: ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"],
            datasets: [{
              label: "Treinamentos",
              backgroundColor: "rgba(2,117,216,1)",
              borderColor: "rgba(2,117,216,1)",
              data: [<c:out value="${quantos_janeiro_2019}" />, 
            	     <c:out value="${quantos_fevereiro_2019}" />, 
            	     <c:out value="${quantos_marco_2019}" />,
            	     <c:out value="${quantos_abril_2019}" />, 
            	     <c:out value="${quantos_maio_2019}" />, 
            	     <c:out value="${quantos_junho_2019}" />, 
            	     <c:out value="${quantos_julho_2019}" />, 
            	     <c:out value="${quantos_agosto_2019}" />, 
            	     <c:out value="${quantos_setembro_2019}" />, 
            	     <c:out value="${quantos_outubro_2019}" />, 
            	     <c:out value="${quantos_novembro_2019}" />, 
            	     <c:out value="${quantos_dezembro_2019}" />],
            }],
          },
          options: {
            scales: {
              xAxes: [{
                time: {
                  unit: 'meses'
                },
                gridLines: {
                  display: false
                },
                ticks: {
                  maxTicksLimit: 12
                }
              }],
              yAxes: [{
                ticks: {
                  min: 0,
                  max: 12,
                  maxTicksLimit: 5
                },
                gridLines: {
                  display: true
                }
              }],
            },
            legend: {
              display: false
            }
          }
        });
        
        var ctx_2020 = document.getElementById("2020_bar");
        var myLineChart_2020 = new Chart(ctx_2020, {
          type: 'bar',
          data: {
            labels: ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"],
            datasets: [{
              label: "Treinamentos",
              backgroundColor: "rgba(2,117,216,1)",
              borderColor: "rgba(2,117,216,1)",
              data: [<c:out value="${quantos_janeiro_2020}" />, 
            	     <c:out value="${quantos_fevereiro_2020}" />, 
            	     <c:out value="${quantos_marco_2020}" />,
            	     <c:out value="${quantos_abril_2020}" />, 
            	     <c:out value="${quantos_maio_2020}" />, 
            	     <c:out value="${quantos_junho_2020}" />, 
            	     <c:out value="${quantos_julho_2020}" />, 
            	     <c:out value="${quantos_agosto_2020}" />, 
            	     <c:out value="${quantos_setembro_2020}" />, 
            	     <c:out value="${quantos_outubro_2020}" />, 
            	     <c:out value="${quantos_novembro_2020}" />, 
            	     <c:out value="${quantos_dezembro_2020}" />],
            }],
          },
          options: {
            scales: {
              xAxes: [{
                time: {
                  unit: 'meses'
                },
                gridLines: {
                  display: false
                },
                ticks: {
                  maxTicksLimit: 12
                }
              }],
              yAxes: [{
                ticks: {
                  min: 0,
                  max: 12,
                  maxTicksLimit: 5
                },
                gridLines: {
                  display: true
                }
              }],
            },
            legend: {
              display: false
            }
          }
        });
        
        var ctx_2021 = document.getElementById("2021_bar");
        var myLineChart_2021 = new Chart(ctx_2021, {
          type: 'bar',
          data: {
            labels: ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"],
            datasets: [{
              label: "Treinamentos",
              backgroundColor: "rgba(2,117,216,1)",
              borderColor: "rgba(2,117,216,1)",
              data: [<c:out value="${quantos_janeiro_2021}" />, 
            	     <c:out value="${quantos_fevereiro_2021}" />, 
            	     <c:out value="${quantos_marco_2021}" />,
            	     <c:out value="${quantos_abril_2021}" />, 
            	     <c:out value="${quantos_maio_2021}" />, 
            	     <c:out value="${quantos_junho_2021}" />, 
            	     <c:out value="${quantos_julho_2021}" />, 
            	     <c:out value="${quantos_agosto_2021}" />, 
            	     <c:out value="${quantos_setembro_2021}" />, 
            	     <c:out value="${quantos_outubro_2021}" />, 
            	     <c:out value="${quantos_novembro_2021}" />, 
            	     <c:out value="${quantos_dezembro_2021}" />],
            }],
          },
          options: {
            scales: {
              xAxes: [{
                time: {
                  unit: 'meses'
                },
                gridLines: {
                  display: false
                },
                ticks: {
                  maxTicksLimit: 12
                }
              }],
              yAxes: [{
                ticks: {
                  min: 0,
                  max: 12,
                  maxTicksLimit: 5
                },
                gridLines: {
                  display: true
                }
              }],
            },
            legend: {
              display: false
            }
          }
        });
        
        var ctx_2022 = document.getElementById("2022_bar");
        var myLineChart_2022 = new Chart(ctx_2022, {
          type: 'bar',
          data: {
            labels: ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"],
            datasets: [{
              label: "Treinamentos",
              backgroundColor: "rgba(2,117,216,1)",
              borderColor: "rgba(2,117,216,1)",
              data: [<c:out value="${quantos_janeiro_2022}" />, 
            	     <c:out value="${quantos_fevereiro_2022}" />, 
            	     <c:out value="${quantos_marco_2022}" />,
            	     <c:out value="${quantos_abril_2022}" />, 
            	     <c:out value="${quantos_maio_2022}" />, 
            	     <c:out value="${quantos_junho_2022}" />, 
            	     <c:out value="${quantos_julho_2022}" />, 
            	     <c:out value="${quantos_agosto_2022}" />, 
            	     <c:out value="${quantos_setembro_2022}" />, 
            	     <c:out value="${quantos_outubro_2022}" />, 
            	     <c:out value="${quantos_novembro_2022}" />, 
            	     <c:out value="${quantos_dezembro_2022}" />],
            }],
          },
          options: {
            scales: {
              xAxes: [{
                time: {
                  unit: 'meses'
                },
                gridLines: {
                  display: false
                },
                ticks: {
                  maxTicksLimit: 12
                }
              }],
              yAxes: [{
                ticks: {
                  min: 0,
                  max: 12,
                  maxTicksLimit: 5
                },
                gridLines: {
                  display: true
                }
              }],
            },
            legend: {
              display: false
            }
          }
        });
        
        var ctx_2023 = document.getElementById("2023_bar");
        var myLineChart_2023 = new Chart(ctx_2023, {
          type: 'bar',
          data: {
            labels: ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"],
            datasets: [{
              label: "Treinamentos",
              backgroundColor: "rgba(2,117,216,1)",
              borderColor: "rgba(2,117,216,1)",
              data: [<c:out value="${quantos_janeiro_2023}" />, 
            	     <c:out value="${quantos_fevereiro_2023}" />, 
            	     <c:out value="${quantos_marco_2023}" />,
            	     <c:out value="${quantos_abril_2023}" />, 
            	     <c:out value="${quantos_maio_2023}" />, 
            	     <c:out value="${quantos_junho_2023}" />, 
            	     <c:out value="${quantos_julho_2023}" />, 
            	     <c:out value="${quantos_agosto_2023}" />, 
            	     <c:out value="${quantos_setembro_2023}" />, 
            	     <c:out value="${quantos_outubro_2023}" />, 
            	     <c:out value="${quantos_novembro_2023}" />, 
            	     <c:out value="${quantos_dezembro_2023}" />],
            }],
          },
          options: {
            scales: {
              xAxes: [{
                time: {
                  unit: 'meses'
                },
                gridLines: {
                  display: false
                },
                ticks: {
                  maxTicksLimit: 12
                }
              }],
              yAxes: [{
                ticks: {
                  min: 0,
                  max: 12,
                  maxTicksLimit: 5
                },
                gridLines: {
                  display: true
                }
              }],
            },
            legend: {
              display: false
            }
          }
        });
        
        var ctx_2024 = document.getElementById("2024_bar");
        var myLineChart_2024 = new Chart(ctx_2024, {
          type: 'bar',
          data: {
            labels: ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"],
            datasets: [{
              label: "Treinamentos",
              backgroundColor: "rgba(2,117,216,1)",
              borderColor: "rgba(2,117,216,1)",
              data: [<c:out value="${quantos_janeiro_2024}" />, 
            	     <c:out value="${quantos_fevereiro_2024}" />, 
            	     <c:out value="${quantos_marco_2024}" />,
            	     <c:out value="${quantos_abril_2024}" />, 
            	     <c:out value="${quantos_maio_2024}" />, 
            	     <c:out value="${quantos_junho_2024}" />, 
            	     <c:out value="${quantos_julho_2024}" />, 
            	     <c:out value="${quantos_agosto_2024}" />, 
            	     <c:out value="${quantos_setembro_2024}" />, 
            	     <c:out value="${quantos_outubro_2024}" />, 
            	     <c:out value="${quantos_novembro_2024}" />, 
            	     <c:out value="${quantos_dezembro_2024}" />],
            }],
          },
          options: {
            scales: {
              xAxes: [{
                time: {
                  unit: 'meses'
                },
                gridLines: {
                  display: false
                },
                ticks: {
                  maxTicksLimit: 12
                }
              }],
              yAxes: [{
                ticks: {
                  min: 0,
                  max: 12,
                  maxTicksLimit: 5
                },
                gridLines: {
                  display: true
                }
              }],
            },
            legend: {
              display: false
            }
          }
        });
        
        var empresas = document.getElementById("empresas_horizontal_bar");
        var empresas_mais_treinadas = new Chart(empresas, {
          type: "horizontalBar",
          data: {
          labels: ["<c:out value='${mais_treinadas_1}' />", "<c:out value='${mais_treinadas_2}' />", "<c:out value='${mais_treinadas_3}' />", "<c:out value='${mais_treinadas_4}' />", "<c:out value='${mais_treinadas_5}' />", "<c:out value='${mais_treinadas_6}' />"],
          datasets: [{
            backgroundColor: ["red", "green","blue","orange","brown", "pink"],
            data: [<c:out value='${mais_treinadas_1_qtd}' />, <c:out value='${mais_treinadas_2_qtd}' />, <c:out value='${mais_treinadas_3_qtd}' />, <c:out value='${mais_treinadas_4_qtd}' />, <c:out value='${mais_treinadas_5_qtd}' />, <c:out value='${mais_treinadas_6_qtd}' />]
          }]
        },
          options: {
            legend: {display: false},
            title: {
              display: true,
              text: "Empresas mais treinadas"
            },
            scales: {
              xAxes: [{ticks: {min: 5, max:20}}]
            }
          }
        });
        
        /*
        var status = document.getElementById("status_pie");
        var status_dos_treinamentos = new Chart(status, {
          type: "pie",
          data: {
            labels: ["Concluído", "Pendente", "Adiado", "Cancelado", "Abortado", "Interrompido"],
            datasets: [{
              backgroundColor: ["#b91d47", "#00aba9", "#2b5797", "#e8c3b9", "#1e7145", "#1e8254"],
              data: [<c:out value='${treinamentos_concluidos}' />, <c:out value='${treinamentos_pendentes}' />, <c:out value='${treinamentos_adiados}' />, <c:out value='${treinamentos_cancelados}' />, <c:out value='${treinamentos_abortados}' />, <c:out value='${treinamentos_interrompidos}' />],
            }]
          },
          options: {
            title: {
              display: true,
              text: "Status dos treinamentos"
            }
          }
        });
        */
        
        var ctx = document.getElementById("status_pie");
        var myPieChart = new Chart(ctx, {
          type: 'pie',
          data: {
            labels: ["Concluído", "Pendente", "Adiado", "Cancelado", "Abortado", "Interrompido"],
            datasets: [{
              data: [<c:out value='${treinamentos_concluidos}' />, <c:out value='${treinamentos_pendentes}' />, <c:out value='${treinamentos_adiados}' />, <c:out value='${treinamentos_cancelados}' />, <c:out value='${treinamentos_abortados}' />, <c:out value='${treinamentos_interrompidos}' />],
              backgroundColor: ['green', 'cyan', 'yellow', 'red', 'black', 'blue'],
            }],
          },
          options: {
              title: {
                display: false,
                text: "Status dos treinamentos"
              }
            }
        });

        </script>
    </body>
</html>