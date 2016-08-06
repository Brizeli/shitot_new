<%@ page import="org.springframework.util.StringUtils" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>Add new doctor</h2>
<hr>
<jsp:useBean id="doctor" type="com.shitot.model.Doctor" scope="request"/>
<form action="doctors" method="post">
    <%--doctors?id=&name=Doctor1&
    login=doc1&
    password=1&
    email=doc1%40mail.com&
    telNumber=1683183&
    telAdditional=&
    specialty1=specialty1&
    specialty2=specialty2&
    target=CHILDREN&target=TEENS&
    preferential=&
    expert=expert1&
    certificate=certificate1&
    lections=&
    comments=comments--%>
    <input type="hidden" name="id" value="${doctor.id}">
    <dl>
        <dt>Enter doctor name:</dt>
        <dd>
            <input type="text" name="name" required value="${doctor.name}"/>
        </dd>
    </dl>
    <dl>
        <dt>Enter doctor login:</dt>
        <dd>
            <input type="text" name="login" required value="${doctor.login}"/>
        </dd>
    </dl>
    <dl>
        <dt>Enter doctor password:</dt>
        <dd>
            <input type="text" name="password" required value="${doctor.password}"/>
        </dd>
    </dl>
    <dl>
        <dt>Enter doctor email:</dt>
        <dd>
            <input type="email" name="email" value="${doctor.email}"/>
        </dd>
    </dl>
    <dl>
        <dt>Enter doctor tel number:</dt>
        <dd>
            <input type="text" name="telNumber" value="${doctor.telNumber}"/>
        </dd>
    </dl>
    <dl>
        <dt>Enter doctor additional tel:</dt>
        <dd>
            <input type="text" name="telAdditional" value="${doctor.telHome}"/>
        </dd>
    </dl>
    <dl>
        <dt>Enter doctor specialty:</dt>
        <dd>
            <input list="specialty1" value="${specialty1}" name="specialty1">
            <datalist id="specialty1">
                <c:forEach items="${specialtyList}" var="s">
                    <option>${s}</option>
                </c:forEach>
            </datalist>
        </dd>
    </dl>
    <dl>
        <dt>Enter doctor optional specialty:</dt>
        <dd>
            <input list="specialty2" value="${specialty2}" name="specialty2">
            <datalist id="specialty2">
                <c:forEach items="${specialtyList}" var="s">
                    <option>${s}</option>
                </c:forEach>
            </datalist>
        </dd>
    </dl>
    <dl>
        <dt>Select doctor target Audience:</dt>
        <dd>
            <fieldset>
                <c:forEach items="${targetAudienceList}" var="t">
                    <input type="checkbox" name="target" value="${t}"
                           <c:if test="${doctor.targetAudiences.contains(t)}">checked="checked"</c:if>>${t}
                </c:forEach>
            </fieldset>
        </dd>
    </dl>
    <dl>
        <dt>Enter doctor preferencies:</dt>
        <dd>
            <input type="text" name="preferential" value="${doctor.preferential}"/>
        </dd>
    </dl>
    <dl>
        <dt>Enter doctor experiences:</dt>
        <dd>
            <input type="text" name="expert" value="<%=StringUtils.collectionToCommaDelimitedString(doctor.getQualifications())%>"/>
        </dd>
    </dl>
    <dl>
        <dt>Enter doctor certification:</dt>
        <dd>
            <input list="certificate" value="${doctor.certificate}" name="certificate">
            <datalist id="certificate">
                <c:forEach items="${certificateList}" var="c">
                    <option>${c}</option>
                </c:forEach>
            </datalist>
        </dd>
    </dl>
    <dl>
        <dt>Enter doctor lections:</dt>
        <dd>
            <input type="text" name="lections" value="${doctor.lections}"/>
        </dd>
    </dl>
    <dl>
        <dt>Enter comments:</dt>
        <dd>
            <input type="text" name="comments" value="${doctor.comments}"/>
        </dd>
    </dl>
    <button type="submit">Save</button>
    <button onclick="window.history.back()">Cancel</button>
</form>

