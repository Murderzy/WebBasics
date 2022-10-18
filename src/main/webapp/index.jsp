<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <% String home = "/WebBasics"; %>
    <meta charset="UTF-8"/>
    <title>JSP Basics</title>
    <style>
        input[type=radio] {
            visibility: hidden;
        }
        input[type=radio]:checked + label {
            border: 1px solid salmon;
            font-weight: bold;
        }
        label {
            cursor: pointer;
            font-size: larger;
            font-variant: all-petite-caps;
        }
        img{
            height: 150px;
            width: 190px;
        }
    </style>
</head>
<body>
<h2>JSP - Java Server Pages</h2>
<button><a href="reg.jsp">Reg</a></button>
<p>
    1. Новый проект и запуск:
    Проект создаем по шаблону Web-App (JSP,...)
    либо по архетипу Maven (...-webapp)
    Признаки правильной установки:
    наличие папки webapp, в ней папка WEB-INF и файл index.jsp
    (возможно index.html, тогда его нужно переименовать в index.jsp)
    В папке webapp создаем папку img, добавляем в нее картинки
</p>
<p>
    2. Конфигурация запуска
    Для запуска веб-проектов есть несколько серверов (веб-сервер + сервер приложения)
    <img src="img/GlassFish_logo.svg.png" alt="Glassfish server" />
    <img src="img/Apache-Tomcat-8.5.5-1.png" alt="Tomcat server" />
    Их нужно установить (отдельно, с IDE обычно не поставляются)
    В конфигурации запуска нужно выбрать расположение сервера и артефакт: то, что
    будет деплоиться-выгружаться на сервер.
</p>
<p>
    3. Кодировка
    Устанавливаем кодировку всех файлов проекта: File - Settings - Editor>File Encodings
    Выставляем все на UTF-8
    Указываем кодировку для браузера: &lt;meta charset="UTF-8" />
    Указываем кодировку для "сборщика" &lt;%@ page contentType="text/html;charset=UTF-8" %>
</p>
<p>
    Суть JSP - "смешивание" возможностей Java и HTML.
    &lt;% ... %&gt; - контейнер для Java кода,
    <% int x = 10 ; %>
    &lt;%= ... %&gt; - выражение (вывод результата)
    x = <%= x %>
</p>
<p>
    Основными дополнениями можно считать:
    подключение файлов и как следствие разбиение страниц
    <jsp:include page="WEB-INF/fragment.jsp"/>

    Условная верстка
        <% if(x < 10) { %>
    <b> x < 10 </b>
        <% } else { %>
    <i> x >= 10 </i>
        <% } %>
    <br/>
    Циклы и обработка массивов
        <% String[] arr = new String[] { "Some", "Words", "in", "array" } ; %>
    <h3>Содержимое массива: </h3>
    <% for( String str : arr ) { %>
    <b><%= str %></b><br/>
    <% } %>
    Задание: создать массив допустимых языков сайта, создать элемент
    переключения (выбора) языка<br/>
    <% String[] langs = new String[] {"ua","eng","ru"}; %>
    <% for( String lang : langs ) { %>
    <input type="radio" name="lang" id="lang-<%=lang%>" />
    <label for="lang-<%=lang%>"><%= lang %></label>
    <br/>
    <% } %>
</p>
</body>
<jsp:include page="WEB-INF/footer.jsp"></jsp:include>
</html>
