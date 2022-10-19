<%@ page contentType="text/html;charset=UTF-8" %><%
    String userInput = (String) request.getAttribute( "userInput" ) ;
%>
<html>
<head>
    <title>Java web</title>
</head>
<body>
<h1>Servlet API</h1>
<p>
    Сервлеты в Java - разновидность классов, использующихся для
    сетевых задач. В частности HttpServlet - для веб-разработки.
    Подключение - Maven - javax.servlet-api<br/>
    В более поздних версиях серверов - jakarta.servlet
</p>
<p>
    Интеграция в проект: создаем папку java в main (выбрать из
    предложенного списка). В ней - пакет, заложенный в проект
    step.learning<br/>
    Создаем класс ViewServlet, наследуем HttpServlet, перегружаем
    метод doGet(...)<br/>
    Подключаем сервлет к серверу, задаем ему маршрут<br/>
    1) через web.xml - централизация (все описания в одном месте),
    гарантированный порядок обработки, более старая поддержка <br/>
    2) при помощи аннотации @WebServlet - проще в реализации<br/>
</p>
<p>
    Особенности: добавление в веб-проект классов создает неоднозначность.
    В контейнер сервера (деплой) передаются скомпилированные классы
    (.class) - компилирует Студия. А выполняются они сервером, используя
    свой JDK. Поэтому ВАЖНО чтобы JDK сервера и проекта совпадали.
    Причем, не все версии серверов поддерживают все версии JDK, обычно
    именно версия сервера ограничивает выбор.
</p>
<p>
    Сервлеты, в простейшем случае, используются для скрытия технологий,
    при помощи которых создан сайт.
    Внутреннее перенаправление (редирект) - перевод запроса на другой
    обработчик, но без изменения URL запроса:
    /servlet (Browser) -->(forward)--> /WEB-INF/servlets.jsp (Server)
</p>
<p>
    Внешний редирект (302) - перенаправление с изменением URL.<br/>
    Проблема: при ответе на запрос POST (отправку формы) обновление страницы
    вызывает повторную отправку формы (выдав предупреждение). Такое поведение
    недопустимо. В ответ на POST запрос сервер должен вернуть редирект,
    после чего браузер повторяет запрос методом GET.
</p>
<form method="post">
    Введите строку: <label><input name="userInput" /></label>
    <input type="submit" value="Отправить" />
</form>
<p>
    <% if( userInput != null ) { %>
    Ранее было введено <b><%= userInput %></b>
    <% } %>
</p>
</body>
</html>