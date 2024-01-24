<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sistema de Empleados</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <nav class="navbar navbar-expand-lg  bg-primary" data-bs-theme="dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="/">Sistema de empleados</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarText">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="/">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/agregar">Agregar Empleado</a>
                        </li>

                    </ul>
                    <span class="navbar-text">
          </span>
                </div>
            </div>
        </nav>
    </div>
    <div class="container">
        <div class="text-center" style="margin: 30px">
            <h3>Editar empleado "${empleado.nombre}"</h3>
        </div>
        <div>
            <form action="/editar" modelAttribute="empleadoForm" method="POST">

                <input type="hidden" name="_method" value="PUT">
                <input type="hidden" name="idEmpleado" value="${empleado.idEmpleado}">


                <div class="mb-3">
                    <label for="nombre" class="form-label">Nombre</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" required="true" value="${empleado.nombre}">
                    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                </div>
                <div class="mb-3">
                    <label for="departamento" class="form-label">Departamento</label>
                    <input type="text" class="form-control" id="departamento" name="departamento"
                    value="${empleado.departamento}">
                </div>
                <div class="mb-3">
                    <label for="sueldo" class="form-label">Sueldo</label>
                    <input type="number" step="any" class="form-control" id="sueldo" name="sueldo"
                    value="${empleado.sueldo}">
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-success me-3">Editar</button>
                    <a href="/" class="btn btn-primary btn-sm">Regresar</a>
                </div>


            </form>
        </div>
    </div>
</body>
</html>