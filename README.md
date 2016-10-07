# PersonSorter

####Requirement

We have a person class:

class Person{
  String ssn;
  Date dateOfBirth;
  String firstName;
  String lastName;
  Double heightIn;
  Double weightLb;
}

And we are building a webpage that can display people sorted by any of the Person fields.

Sample request: /people?sortField=dateOfBirth&ascending=false

Please implement this method to sort the results:

static List<Person> sort(Iterable<Person> people, String sortField, String ascending){
}

####Inital thoughts and logic 
1. I debated between using one comparator which can hide all the logic of comparing different types 
of properties vs individual comparator. I implemented using individual comparator as they are small 
classes and doing single thing. Furthermore, testing individual comparator was easy and I build on 
top of it. 

2. I used static map to resolve sortedField to comparator over nested if else loop as its easy to 
maintain and update code. Map at most can contain 100 types of comparator which is not too bad on 
memory side.

####Installation 

1. Check out git repo. 
2. Used maven to build, test, and package. 
3. I used intellij so might have some project files plz ignore. 
4. Used Junit4 to test classes over mokito as this are simple pojo. 

