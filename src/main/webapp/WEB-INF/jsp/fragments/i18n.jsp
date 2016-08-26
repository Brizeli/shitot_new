<%@page contentType="text/javascript" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
var i18n = [];
<c:forEach var='key' items='<%=new String[]{
    "doctors.tel",
    "doctors.hometel",
    "doctors.address",
    "doctors.profession",
    "doctors.qualification",
    "doctors.buttons.select",
    "doctors.certificate",
    "doctors.profession",
    "doctors.qualification",
    "doctors.prefers",
    "doctors.lections",
    "doctors.target",
    "doctors.comments",
    "clinics.city",
    "clinics.address",
    "common.edit",
    "common.delete",
    "clinics.buttons.schedule",
    "clinics.buttons.add",
    "doctors.add",
    "doctors.edit",
    "app.deleted",
    "app.saved",
    "clinics.edit",
    "clinics.add",
    "patients.appointments"
}%>'>
i18n['${key}'] = '<spring:message code="${key}" javaScriptEscape="true"/>';
</c:forEach>