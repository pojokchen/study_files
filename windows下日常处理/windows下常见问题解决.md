# windows下cmd中git log十六进制输出

​	现象：

![image-20200908225001593](windows下常见问题解决.assets/image-20200908225001593.png)

​	解决办法：

​	

```cmd
git config --global i18n.commitencoding utf-8 //设置提交注释utf-8提交到服务器，防止提交在服务器上乱码
LESSCHARSET=utf-8 //在windows系统环境变量中添加该变量
```

​	解决后：

![image-20200908225137264](windows下常见问题解决.assets/image-20200908225137264.png)