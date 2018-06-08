# Team Tracker

By Garnett Puett. 6.08.2018.

## Description

A web app that allows users to set up teams for a weekend hack-a-thon.

### Specs
| Spec | Input | Output |
| --- | --- | --- |
|**The program will let the user input the name of a new team**| "Hackers" | "Hackers" |
|**The program will let the user input the description of a new team***| "Epicodus students ready to code!" | "Epicodus students ready to code!" |
|**The program will list all teams and allow the user to click on each for details**| "click Hackers" | "Hackers, Epicodus students ready to code!, Sarah, Clark" |
|**The program will let the user add members to teams**| "John" | "Sarah, Clark, John" |
|**The program will let the user change the name of created teams**| "Hackers -> Slackers" | "Slackers" |
|**The program will let the user change the description of created teams**| "Student -> Epicodus Students" | "Epicodus Students" |
|**The program will allow the user to delete a team**| "delete" | "delete" |
|**The program will allow the user to edit a member name**| "John" | "Johnny" |
|**The program will allow the user to delete a member**| "delete" | "delete" |


### Setup/Installation
* Clone this repository
* Open the project in IDEA of your choosing
* Run App.java
* Open your browser and travel to <a href="http://localhost:4567">localhost:4567</a>

### Known Bugs
* Routes that return null will create error messages in the run terminal, no actual run issue will occur.

## Technologies Used
* Java
* Spark
* Handlebars/Moustache
* H2
* SQL

## License
This software is licensed under the MIT license.

Copyright (c) 2018 **Garnett Puett**