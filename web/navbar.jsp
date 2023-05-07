<%@ page import="moduls.User" %>
<%
    User currentUser = (User) session.getAttribute("currentUser");
%>
<div class="mb-3">
    <div class="mb-3">
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark p-3">
            <div class="container-fluid">
                <a class="navbar-brand" href="/"><%=siteName%>
                </a>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                        <%
                            if (session.getAttribute("currentUser") != null
                                    && ((User) session.getAttribute("currentUser")).getRole_id() == 1) {
                        %>

                        <li class="nav-item me-3">
                            <a class="nav-link" href="/addNew">Add New</a>
                        </li>

                        <%
                            }
                        %>
                    </ul>
                    <ul class="nav navbar-nav ml-auto">
                        <%
                            if (session.getAttribute("currentUser") != null) {
                        %>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                               aria-expanded="false">
                                <%=currentUser.getFullName()%>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="/profile">Profile</a></li>

                            </ul>
                        </li>
                        <li class="nav-item me-3">
                            <a class="nav-link btn btn-danger text-light" href="/logout">Logout</a>
                        </li>
                        <%
                        } else {
                        %>
                        <li class="nav-item">
                            <a class="nav-link btn btn-success text-light" href="/login">Log In</a>
                        </li>
                        <%
                            }
                        %>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>
