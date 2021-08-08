# GO学习

## 一、变量

​	go申明变量的一般语法：

```
var 变量名字 类型 = 表达式

//例子
	c := 100	//:=语法声明变量，必须指定初始值
	var d = 100.2 //指定值初始化
	var a int   //零值初始化 int类型为0，string类型为""，布尔类型为false
	var b int = 3 //完全化申明变量，使用较少
```

​	申明一组变量：

```
var i, j, k int
var b, f, s = true, 2.3, "four"
```

