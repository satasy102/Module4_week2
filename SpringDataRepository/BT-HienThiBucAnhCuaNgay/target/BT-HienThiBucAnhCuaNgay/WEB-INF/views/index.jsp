<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Image of Date</h2>
<img id="img-of-the-day" alt="" src="">
<form:form method="post" action="/" modelAttribute="comment">
    <form:select path="rating">
        <form:option value="1"/>
        <form:option value="2"/>
        <form:option value="3"/>
        <form:option value="4"/>
        <form:option value="5"/>
    </form:select> <br>
    <form:label path="author">Author</form:label>
    <form:input path="author"/> <br>
    <form:label path="feedback">FeedBack</form:label>
    <form:textarea path="feedback"/>
    <button type="submit">Comment</button>
</form:form>
<c:if test="${message!=null}">
    <h5>${message}</h5>
</c:if>

<hr>
<h6>+5 So awesome</h6>
<c:forEach items="${comments}" var="c">
    <c:if test="${c.rating==5}">
        <p>Author: ${c.author}</p>
        <p>${c.feedback}</p>
        ${c.likes}
        <a href="/like/${c.id}">Like</a>
    </c:if>
</c:forEach>
<hr>
<h6>+4 Great</h6>
<c:forEach items="${comments}" var="c">
<c:if test="${c.rating==4}">
    <p>Author: ${c.author}</p>
    <p>${c.feedback}</p>
    ${c.likes}
    <a href="/like/${c.id}">Like</a>
</c:if>
</c:forEach>
<hr>
<h6>+3 Normal</h6>
<c:forEach items="${comments}" var="c">
<c:if test="${c.rating==3}">
    <p>Author: ${c.author}</p>
    <p>${c.feedback}</p>
    ${c.likes}
    <a href="/like/${c.id}">Like</a>
</c:if>
</c:forEach>
<hr>
<h6>+2 Bad</h6>
<c:forEach items="${comments}" var="c">
<c:if test="${c.rating==2}">
    <p>Author: ${c.author}</p>
    <p>${c.feedback}</p>
    ${c.likes}
    <a href="/like/${c.id}">Like</a>
</c:if>
</c:forEach>
<hr>
<h6>+1 Very Bad</h6>
<c:forEach items="${comments}" var="c">
<c:if test="${c.rating==1}">
    <p>Author: ${c.author}</p>
    <p>${c.feedback}</p>
    ${c.likes}
    <a href="/like/${c.id}">Like</a>
</c:if>
</c:forEach>
<hr>

<script>
    let query = 'https://api.nasa.gov/planetary/apod?api_key=5gSi3acf8I8KaajQhqBRFYMOos0p20Fevu7YeRgR';
    let request = new XMLHttpRequest();
    request.open('GET', query);
    request.onload = function () {
        if (request.status === 200) {
            let response = JSON.parse(request.responseText);
            document.getElementById('img-of-the-day').setAttribute('src', response.url);
        }
    };
    request.send();
</script>
</body>
</html>
