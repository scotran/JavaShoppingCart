# Virtual Shopping Cart :money_with_wings:

A virtual shopping web application built using Java Servlet and JSP technologies and MySQL for database. The project features Model, View, and Controller (MVC) architecture.

This project allows users to create accounts and login to individual accounts. Accounts start with $1000, and users are able to add items to the cart in the shopping page. Users can finalize and purchase items in the cart, and items appear in the inventory. Inventory and balance are stored in the database.

**Preview images** :small_red_triangle_down:
<details>
<summary>Some images of the web application </summary>

* Login Portal

![Login](https://github.com/NotTheBest/JavaShoppingCart/blob/master/preview-images/login.png?raw=true)

* Sign Up Portal

![Sign Up](https://github.com/NotTheBest/JavaShoppingCart/blob/master/preview-images/signup.png?raw=true)

* Shopping Page 1

![Shopping page](https://github.com/NotTheBest/JavaShoppingCart/blob/master/preview-images/shop1.png?raw=true)

* Cart 1

![Cart](https://github.com/NotTheBest/JavaShoppingCart/blob/master/preview-images/cart1.png?raw=true)

* Cart 2

![Cart](https://github.com/NotTheBest/JavaShoppingCart/blob/master/preview-images/cart2.png?raw=true)

* Inventory 1

![Inventory](https://github.com/NotTheBest/JavaShoppingCart/blob/master/preview-images/inventory1.png?raw=true)

* Inventory 2

![Inventory](https://github.com/NotTheBest/JavaShoppingCart/blob/master/preview-images/inventory2.png?raw=true)
</details>

## Installing

1. Clone repository

* Database
1. To link with database, change **sqlurl**, **sqluser**, and **sqlpass** variables in **UserDao** and **InventoryDao** to respective database url, username, and password of local MySQL database.
2. Execute sql scripts in **mysql-scripts** folder to create **shoppingcart** database and **user** and **inventory** tables. You might have to execute each section of the sql script file separately.

* To Run
1. Run project inside IDE environment with embedded **Apache Tomcat** server

OR

1. Create **WAR** file with Maven by using `mvn package` in project directory or in IDE and place **WAR** file in **Apache Tomcat** home directory **webapps** folder and start Tomcat server (more information can be found online)

Application will be found at url: `localhost:8080/shoppingcart/login.jsp` depending on local environment and current page

## About

This project was a personal project to learn more about Java web development and database management.

A small summary of the skills showcased during this project: :small_red_triangle_down:

* Java Servlet, JSP, JSTL, HTML5, CSS and similar topics
* HTTP data transfer
* Maven project organization and command usage for more productivity
* MySQL syntax, basics, usage, connectivity, and similar
* JDBC with MySQL and safe database practices
* Software/web application development processes
* MVC architecture along with DAO, model, service layers, and similar
* Login security, caching, database lookup, and similar
* Shopping cart functions and design
* Web application debugging
* Apache Tomcat capabilities, functions, command line commands, and similar
* The cost of a mystical banana :banana:
* More! :)
