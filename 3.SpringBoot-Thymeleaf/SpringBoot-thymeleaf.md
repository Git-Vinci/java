# SpringBoot-thymeleaf

[TOC]

## thymeleaf

Thymeleaf是一个现代服务器端Java模板引擎，适用于Web和独立环境，能够处理HTML，XML，JavaScript，CSS甚至纯文本。

Thymeleaf的主要目标是提供一种优雅且高度可维护的模板创建方式。为实现这一目标，它以*自然模板*的概念为基础，将其逻辑注入模板文件，其方式不会影响模板被用作设计原型。这改善了设计沟通，缩小了设计和开发团队之间的差距。



在SpringBoot项目中，thymeleaf模板位置在`templates`目录下，模板文件后缀`.html`

```html
.....
<html xmlns:th="http://www.thymeleaf.org">
.....
```



基本使用方式：

1. 显示数据（数据来自Controller方法）

   `<input th:value="${变量名}" value="预览值"/>`

   `<span th:text="${变量名}">预览值</span>`

   `<span th:utext="${变量名}">预览值</span>`

   th:*   th:src   th:href  th:value  th:width  th:height  所有在HTML标签中可以出现的属性都可以写成th:*，在页面显示时，th:value 将变成value属性

   `<input th:value="${变量名}" value="预览值"/>`  

   经过模板引擎处理之后：

   `<input value="变量值"/>`




HTML标签中所有的属性都有对应的`th:`开头的属性

`th:text`  表示显示文本内容到标签体中(转义：`<`输出`&lt;`)

```
th:text="<input/>"  实际输出  &lt;input/&gt;
```



`th:utext` 表示显示文本内容到标签体中(不转义)

```
th:utext="<input/>"  实际输出 文本框
```



`th:classappend` 向标签原有的`class`属性中追加新的样式名称

```html
<table class="table" th:classappend="'table-hover'"></table>
输出结果：
<table class="table table-hover"></table>


<table class="table" th:class="'table-hover'"></table>
输出结果：
<table class="table-hover"></table>
```





`th:each` 用来将标签循环输出

```html
<div th:each="变量 : ${集合}">
  div将被循环多次
</div>
```



`th:if` 用来做判断输出（没有else）

```html
<div th:if="${#list.size(depts)>0}">
  <!--当depts集合长度大于0时输出的HTML内容-->
</div>
<!--如果if条件不成立时，div标签将不输出-->

<div th:unless="${#list.size(depts)>0}">
  <!--当depts集合长度小于等于0时输出的HTML内容-->
</div>
```

`th:unless` 与`th:if`相反（当条件不成立时才会输出标签）



## 表达式

### 简单表达：

- 变量表达式： `${...}`

  ```html
  <span th:text="${title}">运行之后title变量的值将显示在此</span>
  <span th:text="${dept.name}">显示部门名称</span>
  <span th:text="${depts[0].id}">dpets集合中第0个部门的编号</span>
  <span th:text="${map['key']}">访问map集合中指定key的值</span>
  ```

- 选择变量表达式： `*{...}`

  和`th:object`一同使用，表示直接使用对象中的指定属性

  ```html
  <tr th:each="dept : ${depts}" th:object="${dept}">
  	<td th:text="${dept.id}">表示使用dept.id属性</td>
    
  	<td th:text="${dept.id}">表示使用dept.id属性</td>
  	<td th:text="*{id}">表示使用dept.id属性</td>
  </tr>
  ```

- 消息表达式： `#{...}`

  需要添加消息资源文件，用来读取消息资源文件中的属性值

- 链接网址表达式： `@{...}`

  用作超链接的地址转化

  ```html
  <!--解决webjars资源引入时版本号问题，版本自动添加-->
  <link th:href="@{/webjars/bootstrap/css/bootstrap.min.css}" rel="stylesheet"/>
  
  <!--简化链接中的多个参数问题-->
  <a th:href="@{/index(p1=${变量1}, p2=${变量2})}">链接</a>
  结果:
  <a href="/index?p1=值1&p2=值2">链接</a>
  
  
  <!--解决链接中的字符串和变量混合使用-->
  <a th:href="@{|/index${变量}|}">链接</a>
  结果：
  <a href="/index变量值">链接</a>
  ```

  


### 字面

`<input th:value="${'字符串值'}"/>`

- 文本文字：`'one text'`，`'Another one!'`，...
- 数值文字：`0`，`34`，`3.0`，`12.3`，...
- 布尔文字：`true`，`false`
- 空文字： `null`

### 文字操作

- 字符串连接： `+`

  ```html
  <span th:text="'name：'+${name}"></span>
  
  输出(name变量值是"张三")：
  <span>name：张三</span>
  
  <span th:text="3+2-5"></span>
  输出：
  <span>0</span>
  ```

- 字面替换： `|The name is ${name}|`

  `<a th:href="@{'/index.html?name='+${变量}+'&age='+${age}}">首页</a>`

  `<a th:href="@{|/index.html?name=${变量}&age=${age}|}">首页</a>`

### 算术运算

- 二元运算符：`+`，`-`，`*`，`/`，`%`
- 负号（一元运算符）： `-`

### 布尔运算

- 二元运算符：`and`，`or`

- 布尔否定（一元运算符）： `!`，`not`

  ```html
  <div th:if="${age}>=18">成年人</div>
  
  <div th:if="!(${age}>=18)">未成年人</div>
  <div th:if="not(${age}>=18)">未成年人</div>
  ```

  

### 比较和平等

- 比较：`>`，`<`，`>=`，`<=`（`gt`，`lt`，`ge`，`le`）

  ```html
  <span th:if="${age}>=18">成年人</span>
  <span th:if="${age} ge 18">成年人</span>
  
  <span th:if="${age ge 18}">成年人</span>
  ```

- 平等：`==`，`!=`（`eq`，`ne`）

### 条件判断

- IF-THEN： `(if) ? (then)`

  ```html
  <span th:text="${age ge 18}?'成年人'"></span>
  <span th:text="(${age} ge 18)?'成年人'"></span>
  ```

- IF-THEN-ELSE： `(if) ? (then) : (else)`

  ```html
  <span th:text="${age ge 18}?'成年人':'未成年人'"></span>
  ```

- 默认： `(value) ?: (defaultvalue)`

  ```html
  <span th:text="${stu.age}?:'无效年龄'">age有值输出值，否则输出“无效年龄”</span>
  ```

### 特殊代替

- 无操作： `_` 

  ```html
  <span th:text="${stu.name}_">无姓名</span>
  <!--stu.name值没有则输出“无姓名”，否则输出有效name属性值-->
  ```

  



### 循环属性

```html
<div th:each="item,state : ${items}">
  <span th:text="${item.name}">项的名称</span>
  
  <span th:text="${state.index}">循环的下标(从0开始)</span>
  <span th:text="${state.count}">循环的次数(从1开始)</span>
  <span th:text="${state.first}">item是否是第一项</span>
  <span th:text="${state.last}">item是否是最后一项</span>
  <span th:text="${state.odd}">item是否是偶数项</span>
  <span th:text="${state.even}">item是否是奇数项</span>
</div>
```



附加：

带参数的链接

```html
<a th:href="@{/index.html(pageNum=${pageInfo.pageNum},pageSize=${pageInfo.pageSize})}">新增员工信息</a>

最终生成：

<a href="/index.html?pageNum=1&amp;pageSize=5">新增员工信息</a>
```

