<%-- 
    Document   : TemplateMain
    Created on : Oct 3, 2012, 11:18:45 PM
    Author     : kevingomes17
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            ${PageTitle}
        </title>
        <link rel="stylesheet" type="text/css" href="${BasePath}/css/style.css" />
        <link rel="stylesheet" type="text/css" href="${BasePath}/css/smoothness/jquery-ui.custom.min.css" />

        <script type="text/javascript" src="${BasePath}/scripts/jquery.min.js" ></script>
        <script type="text/javascript" src="${BasePath}/scripts/jquery-ui.min.js" ></script>
        <script type="text/javascript" src="${BasePath}/scripts/jquery.validate.js" ></script>
        <script type="text/javascript" src="${BasePath}/scripts/app.js" ></script>
    </head>
    <body> 
        <div class="outer-wrapper">
            <div class="width_980">
                <h1>Choose Your Adventure</h1>
            </div>
            <div class="main-wrapper">            
                <div id="header">
                    <c:if test="${Username != ''}">
                        <jsp:include page="PrimaryMenu.jsp"></jsp:include>
                    </c:if>
                </div>
                <div id="content">
                    <h2>${PageTitle}</h2>
                    <jsp:include page="Errors.jsp"></jsp:include>

                    <c:if test="${FatalError == 1}">
                        ${FatalErrorMessage}
                    </c:if>
                    <c:if test="${FatalError != 1}">
                        <jsp:include page="${Filename}"></jsp:include>                        
                    </c:if>

                </div>            
            </div>
            <div id="footer">
                ChooseYourAdventure.com &copy; 2012.                
            </div>
        </div>
        <div id="dialog-form" style="display: none;"></div>
    </body>
</html>
