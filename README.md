1. 新建post数据库，导入post.sql。
2. 模拟XSS，运行xss module中的`XssApplication`，然后打开`localhost:8084/readPost.html`。
3. 模拟SQL注入，运行sql-injection中的`SQLInjectionApplication`，然后打开`localhost:8083/login.html`。
4. 模拟csrf，启动csrf-defence module中application，端口是8081，此为被攻击网站，启动csrf-attack中的CSRFApplication，端口为8082，此为攻击网站。
