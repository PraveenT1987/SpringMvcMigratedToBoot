<%--
  Created by IntelliJ IDEA.
  User: ravikiran_gorthi
  Date: 5/4/17
  Time: 7:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<br><br>
<c:choose>
    <c:when test="${jdbcTestResult == 'success'}" >
        <h2><font color="#00008b"><c:out value="JDBC Test was 'Successful' !" /></font></h2>
    </c:when>
    <c:when test="${jdbcTestResult == 'failed'}" >
        <h2><font color="red"><c:out value="JDBC Test 'Failed' !" /></font></h2>
    </c:when>
    <c:otherwise>

    </c:otherwise>
</c:choose>
