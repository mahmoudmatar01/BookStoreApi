# **Book Store REST API** 🪙🪙

## **Main Aim** 
  🔸Manage a library of books by adding a lot of books. I can also modify a book and I can also delete it from my
    database if I want. I can also display all the books to the user. The user can also do authentication to obtain an
    account.

## **Platforms we support**
  🔸Web
  🔸Android
  🔸IOS
## **Project Hierarchy** 
![Screenshot 9_8_2023 7_41_09 PM](https://github.com/mahmoudmatar01/BookStoreApi/assets/95046457/e31e4284-36c8-4dff-a128-f373dcfb615c)

# **Main Services & Functionalities**
   🔹Security: User Authentication and Authrization.
   
   🔹Adding Books: Adding a wide variety of books for users .
   
   🔹Update Book: Update book details such as author birth date.
   
   🔹View All Books: Return all Books to user to read them.
   
   🔹Remove Book: Remove spacific book from our book library.


# **📌Technical Sector**
   🔹Excetion Handling is provided to handle any errors.
   
   🔹Unit tests are provided to Test Functionalities.

   🔹Loggers to facilitate tracking and error handling 

   🔹Solid principles and Design Patterns

   🔹Enums and Constants to ease the work & clean the code.

   🔹Using Mappers and Helpers 

   🔹Utilizing Docker, as Our App ensures cross-platform compatibility.

### Request and Response of Each one :

 ### 🔸A backend "/api/books/" EndPoint:  

   **-Type:** GET

   **-Response Body:** will return all Books in library



  ### 🔸A backend "/api/books/" EndPoint:  
  
   **-Type:** Post

   **-Request Body:** 
                  BookDto(
                   "title":....,
                   "author":...,
                   "description":....,
                   "price":.....,
                   "quantity":....,)
     
   **-Response Body:** To add new book 



  ### 🔸A backend "/api/books/{id}" EndPoint: 

  **-Type:** GET
  
  **-Request:** retuen spacific book by its id

  ### 🔸A backend "/api/books/{id}" EndPoint: 

  **-Type:** DELETE
  
  **-Request:** remmove spacific book by its id
 
   ### 🔸A backend "/api/books/{id}" EndPoint: 
  
   **-Type:** Put

   **-Request Body:** 
                  NewBookDto(
                   "title":....,
                   "author":...,
                   "description":....,
                   "price":.....,
                   "quantity":....,)
  
   **-Request:** update spacific book data 

   > [NOTE THAT]
   > Request type here is json         
       


# **Tools & Technologies💡**
  
  🔸Programming Language: Java 
  
  🔸Backend Framework: Spring Boot 
  
  🔸API Documentation: Swagger 
  
  🔸Logger: SLF4J & Singleton design pattern classs
  
  🔸Docker
  






