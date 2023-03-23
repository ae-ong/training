<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
** 파일 업로드/다운로드 **<br/>
<%@ taglib prefix="sform"  uri="http://www.springframework.org/tags/form"%>
<sform:form enctype="multipart/form-data">
업로드 할 파일 선택 <input type="file" name="file">
<sform:errors path="file" cssStyle="color:red"/><p/>
<input type="submit" value="업로드 확인"/>
</sform:form>
</body>
</html>