<%-- 
    Document   : categoria
    Created on : 29 nov. 2021, 11:09:13
    Author     : leoj_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <s:property value="titulo"/>
        </title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1>Categoria</h1>



        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">
                    <img src="/imagenes/bootstrap-logo.svg" alt="" width="30" height="24" class="d-inline-block align-text-top">
                    Proyecto V6
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavDropdown">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="index.jsp">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="listarCategorias">Categorias</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="ProductoServlet?accion=listaDeProductos">Productos</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="">Usuarios</a>
                        </li>

                    </ul>
                </div>
            </div>
        </nav>



        <div class="container">
            <div class="mb-3">
                <div class="card text-primary border-primary mb-3">
                    <div class="card-header text-center">
                        <s:property value="titulo"/>
                    </div>
                    <div class="card-body table-responsive">
                        <s:form action="almacenarCategoria">
                            <s:hidden name="categoria.idCategoria"/>
                            <div class="form-group row">
                                <s:textfield name="categoria.nombreCategoria" 
                                             key="categoria.nombreCategoria"
                                             maxLength="50"
                                             class="form-control"
                                             requiredLabel="Campo Obligatorio"/>
                            </div>
                            <div class="form-group row">
                                <s:textfield name="categoria.descripcionCategoria" 
                                             key="categoria.descripcionCategoria"
                                             maxLength="100"
                                             class="form-control"
                                             requiredLabel="Campo Obligatorio"/>
                            </div>
                            <div class="mb-3"></div>
                            <s:submit key="categoria.boton.guardar" class="btn btn-outline-success"/>

                        </s:form>
                    </div>

                </div>
            </div>
        </div>
    </body>
</html>