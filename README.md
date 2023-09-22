# Natflix streaming

## About
This is a movies listing system. <br />
It's backend is built using Java Spring Boot REST APIs with spring data JPA and spring security. <br />
It's frontend is built using React typescript.

It has 2 user roles

1. Admin
2. Customer

Both can login from the same login page.
Admin cannot be added from the website.
Customers can be registered from this website.

Admin can add documentaries, movies and tv-series with details and images.
Tv series also has episodes.

## How to run the application

* Clone this project <br />
* Open a terminal in folder natflix/target <br />
* Run `java -jar natflix-0.0.1-SNAPSHOT.jar` <br />
* Now you can use it at http://localhost:8080/ <br />

# frontend 

Frontend code can be found at below link
https://github.com/aggarrohit/Natflix-Frontend

# Test Users

Admin
email : admin_new@natflix.com
password : Passw0r!

Customer
Go to the registration page and register user with any email and password having atleast one small case character, one upper case character, one special character and minimum 8 character long.

note: please note that admin can login only after one customer is registered.

# Documents
Folder ProjectManagement has documents related to management of project <br />
  1. [Class Diagram](https://drive.google.com/file/d/1d8JlJGuhwyw8wyKZgsVljEfyCTpIP0jk/view?usp=sharing) <br />
  2. [Use case Diagram](https://drive.google.com/file/d/1eTQCHT4-9IVckzkuNYeqIF1ydA1xLUMo/view?usp=sharing)<br />
  3. Stories and tasks - Trello [Click here](https://trello.com/invite/b/u8MhPoJW/ATTIc5593c74efd0fef6e4f267666677ee8d6A505073/natflix)<br />
 

# Java Version
17.0.2

# React Version
18.2.0
     
