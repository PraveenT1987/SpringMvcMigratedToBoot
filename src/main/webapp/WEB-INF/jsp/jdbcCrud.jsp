<%--
  Created by IntelliJ IDEA.
  User: ravikiran_gorthi
  Date: 5/4/17
  Time: 7:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script>
    $(document).ready(function () {
        //----- OPEN
        $('[data-popup="error"]').fadeIn(350);

        //----- CLOSE
        $('[data-popup-close]').on('click', function(e)  {
            var targeted_popup_class = jQuery(this).attr('data-popup-close');
            $('[data-popup="error"]').fadeOut(350);
        });
    });
</script>
 <h2>JDBC CRUD Operations Test</h2>

<c:if test="${jdbcCrudMessage != null}">
    <div class="popup" data-popup="error">
        <div class="popup-inner">
            <h2>Message to You !</h2>
            <br>
            <center><font color="red"><c:out value="${jdbcCrudMessage}" /></font></center>
            <br>
            <a data-popup-close="error" href="/jdbcCrudPage" class="action-button green">Close</a>
            <a style="text-decoration: none;" class="popup-close" data-popup-close="error" href="/jdbcCrudPage">x</a>
        </div>
    </div>
</c:if>
<c:if test="${customer != null}">
    <c:url var="postUrl" value="saveCustomer" />
    <form:form modelAttribute="customer" action="${postUrl}" method="post">
        <table align="center" id="customerTable">
            <form:hidden path="customerId"/>
            <tr>
                <th>First Name :</th>
                <td><form:input path="firstName" /><form:errors path="firstName" /></td>
            </tr>
            <tr>
                <th>Last Name :</th>
                <td><form:input path="lastName" /><form:errors path="lastName" /></td>
            </tr>
            <tr>
                <th>Email Id :</th>
                <td><form:input path="emailId" /><form:errors path="emailId" /></td>
            </tr>
            <tr>
                <th>Mobile No. :</th>
                <td><form:input path="mobileNo" /><form:errors path="mobileNo" /></td>
            </tr>
            <tr>
                <td align="center" colspan="2">
                    <c:if test="${!empty customer.firstName}">
                        <input class="button shadow animate blue" type="submit"
                                value="<spring:message text="Update Customer"/>" />
                    </c:if>
                    <c:if test="${empty customer.firstName}">
                        <input class="button shadow animate blue" type="submit"
                                value="<spring:message text="Add New Customer"/>" />
                    </c:if>
                </td>
            </tr>
        </table>
    </form:form>
</c:if>
<center><h3>Customers List</h3></center>
<c:choose>
    <c:when test="${listCustomer != null}">
        <table align="center" id="customerTable" border="1">
            <th style="width:5%">Sl.No</th>
            <th style="width:20%">First Name</th>
            <th style="width:20%">Last Name</th>
            <th style="width:20%">Email Id</th>
            <th style="width:20%">Mobile No.</th>
            <th style="width:15%">Action</th>

            <c:forEach var="customer" items="${listCustomer}" varStatus="count">
                <tr>
                    <td>${count.index + 1}</td>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.emailId}</td>
                    <td>${customer.mobileNo}</td>
                    <td>
                        <a class="push_button violet" href="editCustomer/${customer.customerId}">Edit</a>
                        <a class="push_button red" href="deleteCustomer/${customer.customerId}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <table align="center" id="customerTable">
            <tr>
                <td align="center" colspan="5"><h4>No Customers were found in the Database</h4></td>
            </tr>
        </table>
    </c:otherwise>
</c:choose>