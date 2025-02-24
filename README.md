# Documentation for Hangman Game
## Short Report:
### Project Overview: 
The project is a simple console-based implementation of the classic game Hangman. The game reads a random word from a text file and prompts the user to guess letters. The user is allowed up to 6 incorrect guesses (lives) before they lose the game.

### Design Choices:
- **Dictionary File:** The _20 000_ words for the game are stored in a text file _(dictionary.txt)_, which is read into the program and a random word is selected.
- **Input Validation:** The program ensures that the user input is a valid single letter (no numbers or multiple characters).
- **Graphical Representation:** A simple ASCII art of a hangman is displayed to show the progress of the player's failure. The hangman changes with each incorrect guess.
- **Input/Output:** The user interacts with the game through the console, entering one letter at a time. The game gives feedback in the form of remaining lives and the current state of the word (with underscores and guessed letters).

### Challenges Encountered:
- **Input Handling:** Ensuring that user inputs are valid (only a single letter) and correctly processed was tricky.
- **Hangman Drawing:** Dynamically updating the hangman figure to reflect the player's status was a creative challenge.
- **Game Loop Management:** Managing the state of the game, including checking for the player's win/lose conditions, updating the word display, and handling user input effectively.
- **File Reading:** Loading words from an external file (dictionary.txt) required careful handling of file operations to prevent crashes or incorrect data parsing.



##  Algorithms and Data Structures Used
### Main Algorithm:
1. **Word Selection:** The game reads a list of words from a dictionary file (dictionary.txt), and randomly selects one to be guessed by the player.
2. **Word Display:** The word is initially hidden, with each character replaced by an underscore (_). As the player guesses correctly, the correct letters are revealed in the word.
3. **User Input Validation:** The game continuously asks the player for input until they enter a valid single character.
4. **Game Loop:** The game runs in a loop until the player either guesses the word completely or runs out of lives. After each incorrect guess, the number of lives decreases.
5. **Game End Conditions:** The game ends either when the player guesses the word correctly or when they run out of lives. The hangman drawing changes with each wrong guess.

### Data Structures:
1. **ArrayList<String> words:** This stores the list of words read from the dictionary file. It is used to randomly select a word for the game.
2. **char[] textArray:** This is an array representing the characters of the selected word.
3. **char[] myAnswers:** This array stores the player's current progress in guessing the word. Initially, it is filled with ? characters, which are replaced with correct guesses.
4. **int lives:** A variable that tracks the player's remaining lives.



## Improvements Made to the Initial Implementation
- **Error Handling for Invalid Input:** In the initial implementation, the code was prone to issues if a user inputted more than one character or a non-alphabetic character. I added an input validation check that ensures the user enters a valid single alphabetic character.
- **Hangman Visualization:** I improved the ASCII art to provide a more detailed and progressive representation of the hangman, making the game visually engaging.
- **Game Flow Enhancements:** Improved the display logic to show the word's progress clearly after each guess and ensured that the game only continues while the player has lives left and hasn't solved the word.


## Files Used for Input and Output
### Input:
-**dictionary.txt:** The game reads a dictionary file containing a list of words. Each line in the file corresponds to one word. The file is located at src/dictionary.txt and is read into the game using a Scanner. The word is randomly selected from this file to be used in the game.
### Output:
- The game outputs the current state of the word after each guess, along with the remaining lives. It also outputs an ASCII hangman drawing to show the player's progress.
- The console displays messages for both correct and incorrect guesses and informs the player if they win or lose.


## Additional Explanations
**ASCII Hangman Drawing:** The hangman is drawn progressively as the player makes incorrect guesses. Each stage of the drawing corresponds to a number of lives remaining. For example, when the player has 6 lives left, no hangman is drawn; after each wrong guess, parts of the hangman (head, body, arms, etc.) are drawn.
**Edge Case Handling:** The game handles edge cases such as:
* Invalid input: The player must input exactly one alphabetic character at a time.
* Case-insensitivity: The game doesn't differentiate between uppercase and lowercase letters.
* No repeated guesses: If the user guesses the same letter more than once, the game doesn't penalize the player again.
