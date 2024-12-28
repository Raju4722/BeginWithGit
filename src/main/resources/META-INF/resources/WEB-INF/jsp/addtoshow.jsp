<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="commons/head.jspf"%>
<%@include file="commons/nav.jspf"%>
<form:form method="post" modelAttribute="all">
    id <form:input type="text" path="id1"/>
     name<form:input type="text" path="name1"/>
     branch<form:input type="text" path="branch1"/>
   <input type="submit"/>

</form:form>


<%@include file="commons/foot.jspf" %>