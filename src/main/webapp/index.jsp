<%@ page language="java" import="java.util.*" contentType="text/html; charset=GB2312" %>
<html>
<body>
<h2>Hello World!����build</h2>


springmvc�ϴ��ļ�
<form name="form1" action="/manage/product/upload.do" method="post" enctype="multipart/form-data">
    <input type="file" name="upload_file" />
    <input type="submit" value="springmvc�ϴ��ļ�" />
</form>


���ı�ͼƬ�ϴ��ļ�
<form name="form2" action="/manage/product/richtext_img_upload.do" method="post" enctype="multipart/form-data">
    <input type="file" name="upload_file" />
    <input type="submit" value="���ı�ͼƬ�ϴ��ļ�" />
</form>


</body>
</html>
