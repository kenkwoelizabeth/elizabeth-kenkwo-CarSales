## Car Dealership Application

![car1](https://github.com/kenkwoelizabeth/elizabeth-kenkwo-CarSales/assets/46757955/97e7735d-dcbb-4a15-9f4a-64696d7a03c4)
![car2](https://github.com/kenkwoelizabeth/elizabeth-kenkwo-CarSales/assets/46757955/a455c7c0-c9c0-4fe0-bc0f-6e14a20d207f)
![car3](https://github.com/kenkwoelizabeth/elizabeth-kenkwo-CarSales/assets/46757955/953f1603-8e3d-4e1a-82ed-5f72a558f581)



Lizzy Autos is a car dealership website where clients could be able to book for the payment and 
pickup of their car at the dealership center, to keep track of prospective car purchase made by clients.


The application has 4 main models (car, customer, sales representative, invoice) designed with
unidirectional relationship, and an additional model for users and Role.





## Contents
- [Run Locally](#run-locally)
- [Presentation Slides](doc/presentation.pdf)
- [Daily Progress](#daily-progress)
- [Technical Architecture](doc/Lizzy-Autos-Technical-Architechture.pdf)
- [Wire Frame](doc/Lizzy-autos-wireframe.pdf)
- [Technical Challenges](#technical-challenges)
- [Future Improvements](#future-improvements)
## Run Locally
- To clone the project you write on the command line
  - git clone https://github.com/kenkwoelizabeth/elizabeth-kenkwo-CarSales.git

- My database connection (application.properties file)
  - server.port=8091

- Use MySQL
  - spring.datasource.url=jdbc:mysql://localhost:3306/cardb?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false
  - spring.datasource.username=root
  - spring.datasource.password=password
  - spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect

- Hibernate ddl auto (create, create-drop, validate, update)
  - spring.jpa.hibernate.ddl-auto=update
  - logging.level.web=trace



## Daily Progress
- July 13th (100% done)
  - Prepare my presentation slide
  - Arrange my technical architecture
  - Arrange my wireframe


- July 13th (90% done)
  - Worked on my rest controller for car class
  - inline styling for my receipt page
  - Reorganize some classes in my application

- July 10th (85% done)
  - Worked on CRUD operation for my user
  - Linked my user to thymeleaf

- July 10th (80% done)
  - Complete my receipt page
  - Attached role to my user class
  - Started working on my README page


- June 30th (72% done)
  - Continue working on my security redirection.
  - Rearranging my project to fit the requirements
  - Started working on my receipt page


- June 29th (65% done)
  - Completed the CRUD for all my models.
  - Implemented security in my project.


- June 28th (60% done)
  - Implemented junit testing to test the functionality of my application.
  - Attached my SBA frontend project to my application.


## Technical Challenges

- Spring security: Ran into issues where I thought I was having a bug unbeknownst to me just little adjustment needed in the security configuration file.
- Thyme leaf:  You have to be meticulous to handle your mappings in Thyme leaf, had issues template parsing was a problem due to syntax error.
- CSS: Styling refuse to work in one of my template due to spring security, I had to fall back to inline CSS for just that one file.


## Future Improvements
- Create a car payment page
- Create buttons for their relationship
- Having detailed pictures of each car
