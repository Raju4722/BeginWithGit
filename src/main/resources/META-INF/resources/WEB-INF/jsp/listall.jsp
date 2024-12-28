<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="commons/head.jspf" %>
<%@include file="commons/nav.jspf" %>
<div><h2>welcome to the lists page</h2></div>
<div><h3>Your lists of todos are:</h3></div>
<div class="container">
 <table class="table">
 <thead>
 <tr>
 
   <th>count</th>
   <th>name</th>
   <th>Description</th>
   <th>Experience</th>
      <th>Date</th>
   <th></th>
   <th></th>
 </tr>
 </thead>
 <tbody>
 <c:forEach items="${todos}" var="todo">
 <tr>
 <td>${todo.count }</td>
 <td>${todo.name}</td>
 <td>${todo.description}</td>
 <td>${todo.experience}</td>
  <td>${todo.localDate}</td>
 <td><a href="delete?name=${todo.name} " class="btn btn-warning">delete</a></td>
  <td><a href="update?name=${todo.name}"  class="btn btn-success">update</a></td>
 </tr>
 </c:forEach>
 
 </tbody>
 
 </table>
 </div>
 <a href="addtodo" class="btn btn-success">add</a>
 <%@include file="commons/foot.jspf" %>