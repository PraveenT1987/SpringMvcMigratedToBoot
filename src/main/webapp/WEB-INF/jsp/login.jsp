<%--
  Created by IntelliJ IDEA.
  User: ravikiran_gorthi
  Date: 5/4/17
  Time: 7:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
    $(document).ready(function () {
        //----- OPEN
        $('[data-popup="error"]').fadeIn(350);

        //----- CLOSE
        $('[data-popup-close]').on('click', function(e)  {
            var targeted_popup_class = jQuery(this).attr('data-popup-close');
            $('[data-popup="error"]').fadeOut(350);

            e.preventDefault();
        });
    })
</script>
<br>
<h2>Login Test</h2>
<c:if test="${message != null}">
    <div class="popup" data-popup="error">
        <div class="popup-inner">
            <h2>Login Error !</h2>
            <br>
            <center><font color="red"><c:out value="${message}" /></font></center>
            <br>
            <a data-popup-close="error" href="#" class="action-button green">Close</a>
            <a class="popup-close" data-popup-close="error" href="#">x</a>
        </div>
    </div>
</c:if>
<form id="loginBean" name="loginBean" action="login" method="post">
    Enter Name : <input class="textbox" type="text" name="username" /> <br><br>
    Enter Password : <input class="password" type="text" name="password" /> <br><br>
    <input class="action-button shadow animate red" name="submit" type="submit" value="Login" />
</form>