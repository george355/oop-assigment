Author: George Ciobanu (C20363281)

This is a program for Searching words or phrases between two files.
The program includes a GUI for the selection of the files and for inputing the searched term.
When clicked on the select files button, a menu will pop up and the user will have to select the path and the files he/she chooses.
When the files have been selected their content will be placed into 2 different string.
The user can also just choose one file for the search.
When the user inputs a word into the search bar those 2 files will be searched word by word and if any words match the description of the user, they will pop up on the screen
There is going to be a count running in the background to see which files contains more matches and a message will pop up with the rezult.

Additional Features:
As additional features i decided to print the words around the match for the user to get a better rezults on the search.


Classes use in my program.
control:
This is just a main class to get the program started.

file_selector:
This class is where the GUI is created and where there is an ActionEvent which calls other classes.

finder:
The finder class is used for finding the user inputed word in the selected text and printing it out.

chooser:
Chooser class is used for selecting the file and storing it into a string

If i had more time I would have tried to add a dictionary to the program so that the user inputed word will be checked with the dictionary to be sure there is no typing errors.


GITHUB link 
https://github.com/george355/oop-assigment

YOUTUBE link
https://youtu.be/ksd7zcNSkGs