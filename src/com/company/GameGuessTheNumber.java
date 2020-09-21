package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameGuessTheNumber {
    public static String gamerName;
    public static int desiredNumber;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to the 'Guess the number!'");

        // the loop till gamer want to play. To quit game enter 'no' in any case.
        do {
            System.out.println("Do you wanna play?");
            if (reader.readLine().trim().equalsIgnoreCase("no")) {
                break;
            }
            System.out.print("Enter your name: ");
            gamerName = reader.readLine();
            System.out.println("The game generates integer from 0 to 1000. Try to guess it with minimal amount of tryings!");
            System.out.println("Let's get it!");
            desiredNumber = 1 + (int) (Math.random() * 1000); // generated number
            int gamerNumber;
            int tryingCounter = 1;
            // the loop until gamer guess the desiredNumber
            do {
                System.out.print("You suppose that desired number is ... ");

                // the loop until gamer enter integer or string "finish"
                do {
                    try {
                        String input = reader.readLine();
                        if (input.trim().equalsIgnoreCase("finish")) {
                            System.out.printf("Player %s leaves the game with amount of tryings: %d \n", gamerName, tryingCounter);
                            System.out.println("Do you want see the desired number?");
                            if (reader.readLine().trim().equalsIgnoreCase("yes")) {
                                System.out.println("Desired number = " + desiredNumber);
                            }
                            return;
                        }
                        gamerNumber = Integer.parseInt(input);
                        break;
                    } catch (Exception e) {
                        System.out.println("Enter integer to continue or 'finish' leave the game");
                    }
                } while (true);

                if (gamerNumber > desiredNumber) {
                    System.out.printf("Try %d: The desired number is LESS than yours\n", tryingCounter);
                    tryingCounter++;
                    System.out.println("Try again!");
                } else if (gamerNumber < desiredNumber) {
                    System.out.printf("try %d: The desired number is GRATER than yours\n", tryingCounter);
                    tryingCounter++;
                    System.out.println("Try again!");
                }
            } while (gamerNumber != desiredNumber);
            if (tryingCounter <= 9) {
                System.out.printf("Congratulations, player %s! You are smart and lucky! You've guessed the number %d with amount of tryings = %d\n", gamerName, desiredNumber, tryingCounter);
            } else if (tryingCounter <= 10) {
                System.out.printf("Congratulations, player %s! You are smart! You've guessed the number %d with amount of tryings = %d\n", gamerName, desiredNumber, tryingCounter);
            } else if (tryingCounter < 15) {
                System.out.printf("Not bad, player %s!You've guessed the number %d with amount of tryings = %d. But if you want to play better, you have to read about Binary Search! :)\n", gamerName, desiredNumber, tryingCounter);
            } else {
                System.out.printf("It's could be better..., player %s!You've guessed the number %d with amount of tryings = %d. You have to read about Binary Search! :)\n", gamerName, desiredNumber, tryingCounter);
            }
        } while (true);
        System.out.println("Bye-Bye, my friend.");
        reader.close();
    }

}
