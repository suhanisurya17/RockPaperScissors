/*
Title: Rock Paper Scissors - ICS4U Coding Assignment #1
Name: Suhani Surya
Date: February 22nd - 23rd, 2024
Project Description: This project is a rock paper scissors program where the computer randomly generates its play and the user can play along. It has
                     several features like input validation, choosing how many rounds to play and collecting points for every round won.
 */
package activities; //package declaration
import java.util.Scanner; //importing the scanner class from the java utilities package
import java.util.Random; //importing the random class from the java utilities package
public class RockPaperScissors //class header
{
    public static void main(String[] args) //main method header
    {
        //CREATING ALL THE OBJECTS
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        Scanner input = new Scanner(System.in);//creating a new scanner object called "input"
        Random rand = new Random(); //creating a new random object called "rand"

        //INITIALIZING ALL THE VARIABLES
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        int choice; //this is the variable that holds the user's number choice of 1,2,3
        int rounds; //this is the integer type variable that holds the number of rounds the user wishes to play
        String response; //this String data type variable holds the user's response to if they would like to play again
        char responseChar; //this is the character type variable that will hold the first character of the response variable in case the user types the whole word
        int userWins = 0, compWins = 0; //these two integer type variables will act as accumulator variables to store the number of times the user won the game vs the computer

        //BEGINNING OF THE DO WHILE LOOP
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        do {//I used a do while loop because if the user is playing the game, they need to play at least one round so a do-while loop is great for that
            System.out.print("How many round(s) would you like to play: "); //asks the user how many rounds they would like to play
            rounds = input.nextInt();//assigns their input the rounds variable

            System.out.println("You will play " + rounds + " rounds with the computer.");//prints out how many rounds they will play

            //BEGINNING OF THE FOR LOOP
            //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            for (int i = 1; i <= rounds; i++) //for loop that iterates exactly as many times as rounds they are playing
            {
                System.out.println("\nRound " + i + ":");//this line prints the current round number
                System.out.print("Choose \"1\" for Rock, \"2\" for Paper, \"3\" for Scissors: "); //this line tells the user to enter a value to choose what item they will be playing
                choice = input.nextInt();//assigns their input to choice
                int computerChoice = rand.nextInt(3) + 1; //this is generating a random integer between 1 and 3 using the random class and assigning it to computerChoice

                //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                while(choice > 3 || choice < 1) //i have a while loop here for input validation to make sure that the user does not choose a value that is not 1, 2, or 3
                {                               //my condition here is that if the choice is less than one or greater than three
                    System.out.print("That is not a valid input. Enter \"1\" for Rock, \"2\" for Paper, \"3\" for Scissors: ");
                    //this error message pops up, prompting the user to enter only numbers that are allowed
                    choice = input.nextInt();//assigns their input to choice
                }
                //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                if(choice == 1) //if the choice = 1
                {
                    System.out.println("You chose Rock and");//user has chosen to play rock and this statement will print
                }
                else if(choice == 2) //if the user decides to play paper and inputs 2, this message will appear
                {
                    System.out.println("You chose Paper and");
                }
                else// if(choice == 3)
                // this is an else statement. i made it an else statement because we already had input validation in the while loop above, so it is confirmed that the user
                // would've already entered either 1, 2 or 3
                {
                    System.out.println("You chose Scissors and");
                }

                //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                if(computerChoice == 1) //if the computer choice is 1, this message will display
                {
                    System.out.println("the computer has chosen Rock.");
                }
                else if(computerChoice == 2)//if the computer choice is 2, this message will display
                {
                    System.out.println("the computer has chosen Paper.");
                }
                else if(computerChoice == 3)//if the computer choice is 3, this message will display
                {
                    System.out.println("the computer has chosen Scissors.");
                }

                //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                if(choice == 1 && computerChoice == 2) //scenario 1: if the user chooses rock and computer chooses paper, computer wins
                {
                    System.out.println("Paper covers rock. The computer wins!");
                    compWins++; //add one to the compWins accumulator variable
                }
                else if(choice == 1 && computerChoice == 3)//scenario 2: if the user chooses rock and computer chooses scissors, user wins
                {
                    System.out.println("Rock smashes scissors. You win!");
                    userWins++;//add one (increment) the userWins accumulator variable
                }
                else if(choice == 2 && computerChoice == 1)//scenario 3: if the user chooses paper and computer chooses rock, user wins
                {
                    System.out.println("Paper covers rock. You win!");
                    userWins++;//add one (increment) the userWins accumulator variable
                }
                else if(choice == 2 && computerChoice == 3)//scenario 4: if the user chooses paper and computer chooses scissors, computer wins
                {
                    System.out.println("Scissors cut paper. The computer wins!");
                    compWins++;//add one to the compWins accumulator variable
                }
                else if(choice == 3 && computerChoice == 1)//scenario 5: if the user chooses scissors and computer chooses rock, computer wins
                {
                    System.out.println("Rock smashes scissors. The computer wins!");//scenario 6: if the user chooses scissors and computer chooses rock, computer wins
                    compWins++;//add one to the compWins accumulator variable
                }
                else if(choice == 3 && computerChoice == 2)//scenario 7: if the user chooses scissors and computer chooses paper, user wins
                {
                    System.out.println("Scissors cut paper. You win!");
                    userWins++;//add one (increment) the userWins accumulator variable
                }
                else if(choice == computerChoice)//scenario 8: both the computer and user play the same item so it is a tie
                {
                    System.out.println("It's a tie!");//prints this statement and notice there are no incrementer variables here because when there is a tie, no one gets the point
                }
            }//END OF FOR LOOP

            //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            System.out.println("\nThe final score is:");//this statement prints out this message
            System.out.println("You: " + userWins); //this statement displays the user's score
            System.out.println("Computer: " + compWins);//this statement displays the computer's score

            //IF STATEMENT
            //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            if(userWins > compWins) //if the number of wins the user has is greater than that of the computer,
            {
                System.out.println("You win!");//print this message
            }
            else if(compWins > userWins)//else if makes this condition exclusive. the condition is that if the number of wins the computer has is greater than that of the user,
            {
                System.out.println("The computer wins!");//print this message
            }
            else//the trailing else statement will only execute if the compWins = userWins
            {
                System.out.println("It's a tie!");//prints that it is a tie
            }

            //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            input.nextLine();//this statement clears the keyboard buffer
            System.out.print("\nWould you like to play again (y-yes or n-no): ");//this statement asks the user if they want to play again
            response = input.nextLine();//assigns their answer to the String variable named response
            response = response.toLowerCase();//this statement turns all the String, regardless of case, into lowercase so the code can compare them
            responseChar = response.charAt(0);//assigning the response's first index or first letter to the char data type variable called responseChar
            //in case the user typed in "yes" or uppercase, or misspelled yes because as long as the responseChar has the first character, that is all that matters

            //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            while (!(responseChar == 'y') && !(responseChar == 'n')) //while the responseChar is not equal to 'y' or 'n' (INPUT VALIDATION)
            {
                System.out.print("That is not a valid response. Please enter (y-yes or n-no): ");//this statement prints an error message to the user and prompts them to enter a valid response
                response = input.nextLine();//this statement assigns their new response to responseChar
                response = response.toLowerCase();//this statement turns all the String, regardless of case, into lowercase so the code can compare them
                responseChar = response.charAt(0);//responseChar is assigned to the first index of response
            }
            System.out.println();//printing an empty line for formatting
        }

        while (responseChar == 'y');//the entire do while loop is hinged on the condition that the user enters y. if not, the code will break out of the do while loop
        //END OF DO WHILE LOOP
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        System.out.println("Thank you for playing rock, paper, scissors. Have a nice day.");//this statement thanks the user for playing after
        //they have chosen to not play more rounds of rock paper scissors

        input.close();//this statement closes the keyboard to save memory

    }//END OF MAIN METHOD
}//END OF CLASS
