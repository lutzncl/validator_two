# Message Processing Application
This is a small JSR-303 custom annotation program to validate the benefit income supplied by citizens.

It is based on the following assumptions 
a) Amount can be up to 2 decimal digits
b) Amount is considered in pounds i.e 45.24 is 45 pounds and 25 pennies
c) Amounts with a WEEK or a MONTH selected as frequency are accepted as is

##Approach
Hibernate validator is used for its implementation of JSR-303.
For easy dependency management maven has been selected.
The build follows a basic MVC structure without a view.
The App class, containing the main method functions as a placeholder for future extensions.


##On execution:
Run as JUnit Test to check the outcome of validations.
Tests match correct number of constraint violations triggered.

##Next Steps (To-Do list):
1) Add more meaningful tests.
2) Consider additional checks.
3) Create GUI to input the fields, ideally with the Spring framework.
