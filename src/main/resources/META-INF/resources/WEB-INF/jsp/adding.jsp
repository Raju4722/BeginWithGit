
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="commons/head.jspf" %>
<%@include file="commons/nav.jspf" %>

<form:form method="post" modelAttribute="todos">
count:<form:input type="text" path="count" />
name:<form:input type="text" path="name"/>
description:<form:input type="text" path="description"/>
experience:<form:input type="text" path="experience"/>
date:<form:input type="text" path="localDate"/>
<input type="submit">
</form:form>
<script type="text/javascript">
		$('#localDate').datepicker({
			format : 'yyyy-mm-dd'
		})
	</script>
	<%@include file="commons/foot.jspf" %>

