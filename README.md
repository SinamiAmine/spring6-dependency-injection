Spring 6
--------
* Using JPA Entities :
  * Create New Package "Domain"
  * Create An Class "Author" & "Book"

* JPA RelationShip :
  * Book have many Author and Author have many book (ManyToMany)


    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

    @ManyToMany
    @JoinTable(
            name = "author_book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors;	

* Equality In Hibernate

    - Generate HashCode & Equal And select id for each entity
    - Implement ToString()

* Spring Data Repository
    - Create New Package (Repositories)
    - Create Author And Book Repositories
    - For Each Repo extends CrudRepositoy<Author,Long>

* Initializing Data With spring
    - Create Class BoostrapData And Anootate It by @Component
    - Implement CommandLineRunner
    - Re-Define run methode
    - Inject Repositories to the constructor
    - Use Them To Init Data

* Introduction to H2 DataBase :
    - In Application.Properties Configure this paramas
      #spring.h2.console.enabled=true
      #get url dataBase from the console of terminal like this one
      #Go to http://localhost:8080/h2-console/login.jsp
      #Paste Url
      #Connect (y)
* Spring MVC :
    - MVC is a common design pattern for GUI and web applications
  # Model : Simple POJO with collection of properties which may or may not be used by the
  		  view 
  # View : Dara as requested by the client , Implemented with JSP, Thymleaf,Jackson,etc
           can be HTML,JSON,XML,TEXT, etc ..
  # Controller : Java class implemented to handle request mapping. Should be a 'traffic cop'
                  and contain minimal business logic,Typically work in conjunction with a service,
  				whoch contain business logic
* Create Service Layer :
    - Create an package 'Services'
    - Annontate it by @Service
* Configuring Spring Controller
    - Create an class for the controller
    - Annotate It By @Controller
    - Inject Service Interface Impl in the controller


@Controller
public class BookController {
private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books",bookService.findAll());
        return "books";
    }
}

* Thymleaf Template

    - Add This Dependancy

       <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-thymeleaf</artifactId>
       </dependency>

* Dependancy Injection With Spring
    * SOLID Principles of OOP
      # S -> Single Reponsibility Principle
             / Every Class should have a single Responsibility
      	   / There should never be more than one reason for a class to change
      	   / Your Classes should be small.no more than a screen full of code
      	   / Avoid 'god' classes
      	   / Split big classes into smaller classes
      	   / My 2000 line method tested "Fine"
      # O -> Open Closed Principle
      	   / Your classes should be open for extension
      	   / But closed for modification
      	   / You should be able to extend a classes behavior , without modifiying it
      	   / Use private variables with getters , setters - ONLY when you need them
      	   / Use abstract base classes  
      # L -> Liskov Substitution Principles
      	   / Objects in a program would be replaceable with instances of their subtypes
      	     WITHOUT altering the correctness of the program
      	   / Violations will often fail the "Is a" test
      	   / A Square "is a" rectangle
      	   / However,a Rectangle 'is not' a square
      # I -> Interface Segregation Principle
      	   / Make fine grained interfaces that are client specific
      	   / Many client specific interfaces are better than on 'General Purpose' interface
      	   / Keep your components focused and minimize dependencies between them
      	   / Notice relationship to the single responsability Principle?
      	   / Le Avoid 'god' interfaces
      # D -> Dependancy inversion Principle
             / Abstractions should not depend upon details
      	   / Details should depend upon abstractions
      	   / Important that higher level and lower level obkects depend on the same abstract interaction
      	   / This is not the same as Dependancy injection - which is how objects obtain dependent objects
			   
				
    
