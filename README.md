# JetsProject

# Overview
Create an app that allows users to select various options from a menu regarding a fleet of jets. The original fleet is imported from a CSV text file however the user has options to add a base jet and delete jets form the array. There are five unique flying objects that extend the Jet class, two of which are implementation classes that implement specialized interfaces based on their class.

# Technologies Used
- Java
- Eclipse
- Git

# Lessons Learned
- Created a CSV text file to hold five flying objects which included: name, model, speed, range, and price. Then created five separate class shells to match the flying objects. These five shells all extended the abstract Jet class which included getters and setters for each variable, a toString(), hashCode(), equals(Object), and a no-arg fly() method.

- The CargoJet and FighterJet classes each had special interfaces for they implemented CargoCarrier and CombatReady with no-arg constructor for loadCargo() and fight(), respectively. These methods ultimately printed out a basic String of text to the screen when called.

- The fly() method calculated the flight time of each jet based on the range divided by speed and rounding outputs to the nearest hundredth and also included the toString() to provide all details of the specific flying object called. 

- The JetsApplication contained a main method to launch the program. The main menu was setup using a switch inside a do while loop, the same as my FoodTruckApp. Selections were made by the user inputting a number and a Scanner taking the input and calling the method selected. All methods in JetsApplication were very basic and included a call to the AirField where the "real work" was performed, followed by a call back to printMenu() until the user selected '9. Quit'. 

- The AirField class holds the bulk of the code and was the only class permitted to interact with the fleet of flying objects. The AirField read the Jet types from the jets.txt file and populated an ArrayList declared as fleet. In the readFromFile() method Jets were added to the fleet as a newJet and put into their appropriate class identifier based on the first column of the CSV file using if / else if statements in a while loop. After creating the fleet a getter and setter was created for the fleet list in order to call the fleet throughout the app. 
- Note: I did not close the scanner in this class because I kept returning errors following the end of user input. This did not appear to affect the code from performing to the required criteria. 

- listFleet() method calls the getFleet() then loops through the size of the fleet printing each Jet's toString() on a separate line.

- flyAll() method loops through the list of jets and prints the flight time of each Jet along with corresponding toString() with each Jet on a separate line. The for loop iterates through the fleet using .size() as the end of the loop. Based on the variable 'i' and which number its on in the loop, a Jet is assigned 'jet' and its fly() method is called.

- fastestJet() and longRange() use the same logic and steps to find either the fastest and longest range Jet and printing that Jet's toString(). The for loop and nested if statements use the same logic as the method to print the top rated truck for my FoodTruckApp, just substituting variable names and using get() vs [] to assign and sort through each object in the ArrayList vs Array, respectively.

- loadAllCargoJets() and dogfight() use the same logic as well. These methods are identical to fastestJet() and longRange() except for the last three lines whose if statement determines if any  jet in the fleet is an 'instanceof' a CargoJet or FighterJet. If so, each jet that is calls their loadCargo() or fight() method.

- addJet() is a series of instructions to enter the same parameters as our base PassengerJet. The Scanner takes these parameters which are a mixture of String, double, int, and long and assigns them as model, speed, range, and price. A new PassengerJet is instantiated with the input parameters passed through via a .add() method and added to our ArrayList.

- removeJet() asks the user which Jet they would like to remove, looping through and printing each Jet in the ArrayList and displaying their place in the list as defined plus one (i.e. [0] would print as "1."). The selection is read by the Scanner and a one is subtracted so the correct Jet will be removed from the list using the .remove() method. A confirmation message is printed and the remaining fleet's toString() is printed to the screen using a for each loop based on the Jets still left.