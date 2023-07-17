## Car Dealership Application

Lizzy Autos is a car dealership website where clients could be able to book for the payment and 
pickup of their car at the dealership center, to keep track of prospective car purchase made by clients.

The application is design to showcase different cars available in the dealership having cars, customers, 
sales representative and sales invoice, it could be modifies to fit any dealership requirements.





## Contents
-[Run Locally](#run-locally)
- [Presentation Slides]
- [Daily Progress](#daily-progress)
- [Technical Architecture](doc/Lizzy-Autos-Technical-Architechture.pdf)
- [Wire Frame](doc/Lizzy-autos-wireframe.pdf)
- [Technical Challenges](#technical-challenges)
- [Lessons Learned](#lessons-learned)
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



