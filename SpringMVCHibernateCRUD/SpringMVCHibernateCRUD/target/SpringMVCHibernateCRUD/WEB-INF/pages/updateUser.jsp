
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.jwt.model.Users" %>
<%@ page import="com.jwt.model.Role" %>
<%--
  Created by IntelliJ IDEA.
  User: zylihard
  Date: 19/01/2022
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% if(session!=null){  %>
<%  Users user = (Users)request.getAttribute("user"); %>

<html>
<head>
    <title>Add User</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<buttton style="float:right" class="btn btn-default mb-5"><a href="${pageContext.servletContext.contextPath}/home">Back</a></buttton>
<section id="cover" class="min-vh-100">
    <div id="cover-caption">
        <div >
            <div class="row text-white">
                <div class="col-xl-5 col-lg-6 col-md-8 col-sm-10 mx-auto text-center form p-4">
                    <h1 class="py-2 text-primary">Add User</h1>
                    <div class="px-2">
                        <form class="justify-content-center" action="${pageContext.servletContext.contextPath}/admin/update" method="post">

                            <div class="form-group">
                                <input class="form-control" value="<%= user.getUserId() %>" type="text" name="idUser"  id="idUser" hidden>
                                <label for="email">Email:</label>
                                <input class="form-control"  value="<%= user.getEmail() %>" type="email" name="email" placeholder="Email" id="email" required/>
                            </div>
                            <div class="form-group ">
                                <label for="first_name">First name:</label>
                                <input class="form-control" value="<%= user.getFirst_name() %>"  type="text" name="first_name" placeholder="First name" id="first_name" required/>
                            </div>
                            <div class="form-group ">
                                <label for="last_name">Last name:</label>
                                <input class="form-control" type="text" value="<%= user.getLast_name() %>"  name="last_name" placeholder="Last name" id="last_name" required/>
                            </div>

                            <div class="form-group">
                                <label for="role">Role:</label>
                                <select class="custom-select" id="role" name="role" required>

                                    <%
                                        ArrayList<Role> roleList = (ArrayList<Role>) request.getAttribute("roles");
                                        for(Role roles : roleList) {%>
                                    <option <% if(user.getRole().getId_role() == roles.getId_role() ){ %> <%= "selected"%> <% }%> value="<%=roles.getId_role()%>">
                                        <%=roles.getName()%>
                                    </option>
                                    <%}%>
                                </select>

                            </div>


                            <div class="form-group">
                                <label for="password">Password:</label>
                                <input class="form-control" value="<%= user.getPassword() %>" type="password" name="password" placeholder="Password" id="password" required/>
                            </div>

                            <div class="form-group">
                                <input class="form-control" value="<%= user.getAddress().getIdAddress() %>" type="text" name="idAddress"  id="idAddress" hidden>
                                <label for="country">Country:</label>
                                <input class="form-control" value="<%= user.getAddress().getCountry() %>" type="text" name="country" placeholder="Country" id="country" required/>
                            </div>
                            <div class="form-group">
                                <label for="city">City:</label>
                                <input class="form-control" value="<%= user.getAddress().getCity() %>" type="text" name="city" placeholder="City" id="city" required/>
                            </div>
                            <div class="form-group">
                                <label for="street">Street:</label>
                                <input class="form-control"  value="<%= user.getAddress().getStreet() %>" type="text" name="street" placeholder="Street" id="street" required/>
                            </div>


                            <div class="row">
                                <div class="form-group">
                                    <button class="btn btn-lg btn-primary">Update</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>




</body>
</html>
<% }else {
    request.getRequestDispatcher("login.jsp");
}  %>