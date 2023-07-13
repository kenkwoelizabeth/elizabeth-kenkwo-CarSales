## Car Dealership Application

Lizzy Autos is a car dealership website where clients could be able to book for the payment and 
pickup of their car at the dealership center, to keep track of prospective car purchase made by clients.

The application is design to showcase different cars available in the dealership having cars, customers, 
sales representative and sales invoice, it could be modifies to fit any dealership requirements.





## Contents

- [Case Study Rubrics]
- [Presentation Slides]
- [Daily Progress]
- [User Stories](#user-stories)
    - [Admin](#admin)
    - [User](#user)
- [Technical Architecture]
- [Wire Frame]
- [Schema Diagram]
- [Jira]
- [Technical Challenges](#technical-challenges)
- [Lessons Learned](#lessons-learned)
- [Future Improvements](#future-improvements)

## Daily Progress
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


## User Stories

### Admin

- As an admin, I want to log in with an admin privilege so that I can edit the list of cars, update
  the make , model, price, etc.

  - Tasks:
    1. Create a database and a User table containing username, password and privilege.
    2. Login screen asking for username and password.
    3. Check if the username exists in the User table
    4. Check if the password matches the entry in the table
    5. Assign the privilege to the current user login session
    6. If login is successful, show the main screen with options according to login privilege.
  - Question: How to encrypt the password?


