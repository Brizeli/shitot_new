<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <div class="row">
        <h1>
            <a href="${pageContext.request.contextPath}">SHITOT ORG</a>
            <img src="resources/images/logo4.png" align="right"/>
        </h1>
    </div>
    <%--<hr>--%>
    <div class="row">
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#"> Add <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="addPatientForm">Create new patient</a></li>
                            <li><a href="doctors/create">Create new doctor</a></li>
                            <li><a href="addSymptomForm">Create new symptom</a></li>
                            <li class="divider"></li>
                            <li><a href="addUserForm">Create new user</a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a class="dropdown-toggle"
                                            data-toggle="dropdown" href="#"> Get <span class="caret"></span>
                    </a>
                        <ul class="dropdown-menu">
                            <li><a href="getAllPatientsAction">Get all patients</a></li>
                            <li><a href="doctors">Get all doctors</a></li>
                            <li><a href="getDoctorsBySymptomsForm">Get doctors by symptoms</a></li>
                            <li><a href="#">Get doctors by clinic city</a></li>
                            <li><a href="#">Get doctors by specialization</a></li>
                        </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="navbar-text">${loggedUser}</li>
                    <li class=""><a href="logout">logout</a></li>
                </ul>
            </div>
        </nav>
    </div>
</header>