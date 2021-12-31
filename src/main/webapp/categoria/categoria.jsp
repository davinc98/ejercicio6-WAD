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
    </head>
    <body>

        <div class="container">
            <center>

                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container-fluid">
                        <a class="navbar-brand" href="index.jsp">
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
                                    <a class="nav-link" href="listarProductos">Productos</a>
                                </li>

                                <li class="nav-item">
                                    <a class="nav-link" href="listarUsuarios">Usuarios</a>
                                </li>

                            </ul>
                        </div>
                    </div>
                </nav>

                <div class="col-sm-4">

                    <div class="mb-3">
                        <div class="card text-primary">
                            <div class="card-header text-center">
                                Categoria
                            </div>
                            <div class="card-body table-responsive">
                                <s:form action="almacenarCategoria">
                                    <s:hidden name="categoria.idCategoria"/>
                                    <div class="mb-3"></div>
                                    <div class="form-group row">
                                        <s:textfield name="categoria.nombreCategoria" 
                                                     key="categoria.nombreCategoria"
                                                     maxlength="50"
                                                     class="form-control"
                                                     requiredLabel="Campo Obligatorio"/>
                                    </div>
                                    <div class="form-group row">
                                        <s:textfield name="categoria.descripcionCategoria" 
                                                     key="categoria.descripcionCategoria"
                                                     maxlength="100"
                                                     class="form-control"
                                                     requiredLabel="Campo Obligatorio"/>
                                    </div>
                                    <s:submit key="categoria.boton.guardar" class="btn btn-outline-success"/>

                                </s:form>
                            </div>

                        </div>
                    </div>
                </div>
            </center>
        </div>
    </body>
</html>