<%@ page language="java" import="java.util.*" contentType="text/html; charset=GB2312" %>
<html>
<body>
<h2>Hello World!测试build</h2>


springmvc上传文件
<form name="form1" action="/manage/product/upload.do" method="post" enctype="multipart/form-data">
    <input type="file" name="upload_file" />
    <input type="submit" value="springmvc上传文件" />
</form>


富文本图片上传文件
<form name="form2" action="/manage/product/richtext_img_upload.do" method="post" enctype="multipart/form-data">
    <input type="file" name="upload_file" />
    <input type="submit" value="富文本图片上传文件" />
</form>


</body>
</html>
