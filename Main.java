import java.util.Scanner;

public class Main {

    public static void main (String[] args) {
        System.out.println("Welcome to blackjack!");
        Scanner scanner = new Scanner(System.in);
        String input = "";
        boolean playGame = false;

        while (!playGame) {
            System.out.println("\nDo you want to play? (Y/N)?");
            input = scanner.nextLine();
            System.out.println(input);
            if (input.equals("n") || input.equals("N")) {
                break;
            }
            else if (input.equals("y") || input.equals("Y")) {
                playGame = true;
            }
            else {
                System.out.println("Invalid input");
            }
        }

        //Receives an input of how much the player wants to bet.
        int bet = 0;

        if (playGame) {
            System.out.println("\nHow much would you like to bet?");
            bet = scanner.nextInt();
            scanner.nextLine();
        }

        while (playGame) {
            System.out.println("\nLet's start!");

            //Creates a standard deck of 52 cards and shuffles it.
            Deck standardDeck = new Deck();
            standardDeck.createDeck();
            standardDeck.shuffle();

            //Creates a hand for the player and dealer.
            Deck playerHand = new Deck();
            Deck dealerHand = new Deck();

            //Draws 2 cards for the player and dealer.
            playerHand.drawCard(standardDeck);
            dealerHand.drawCard(standardDeck);
            playerHand.drawCard(standardDeck);
            dealerHand.drawCard(standardDeck);

            System.out.println("Drawing cards... \n");
            System.out.println("Your hand is: \n" + playerHand);
            System.out.println("The value of your hand is: " + playerHand.valueOfHand());

            //The player's turn.
            while (playerHand.valueOfHand() <= 21) {
                boolean validInput = false;

                while (!validInput) {
                    System.out.println("\nDo you want to hit or stand? (H/S)");
                    input = scanner.nextLine();
                    System.out.println(input);

                    if (input.equals("h") || input.equals("H")) {
                        validInput = true;
                    }
                    else if (input.equals("s") || input.equals("S")) {
                        validInput = true;
                    }
                    else {
                        System.out.println("Invalid input");
                    }
                }

                if (input.equals("h") || input.equals("H")) {
                    playerHand.drawCard(standardDeck);
                    System.out.println("\nYour hand is: \n" + playerHand);
                    System.out.println("The value of your hand is: " + playerHand.valueOfHand());
                }

                else {
                    break;
                }
            }

            //The dealer's turn.
            if (playerHand.valueOfHand() <= 21) {
                while (dealerHand.valueOfHand() <= 15) {
                    dealerHand.drawCard(standardDeck);
                }
            }

            System.out.println("\nThe dealer's hand is: \n" + dealerHand);
            System.out.println("The value of the dealer's hand is: " + dealerHand.valueOfHand());

            //Win condition if neither the player or dealer busted.
            if (playerHand.valueOfHand() <= 21 && dealerHand.valueOfHand() <= 21) {
                if (playerHand.valueOfHand() > dealerHand.valueOfHand()) {
                    System.out.println("\nYou won!");
                    bet = bet * 3 / 2;
                    System.out.println("You earned: " + bet / 3);
                    System.out.println("Your bet is now: " + bet);
                }
                else if (playerHand.valueOfHand() < dealerHand.valueOfHand()) {
                    System.out.println("\nThe dealer won!");
                    System.out.println("You lost your bet of: " + bet);
                    bet = bet / 2;
                    System.out.println("Your bet is now: " + bet);
                }

                else if (playerHand.valueOfHand() == dealerHand.valueOfHand()) {
                    System.out.println("\nIt's a push!");
                    System.out.println("You retain your bet of: " + bet);

                }
            }

            //Win condition if the dealer busted.
            else if(playerHand.valueOfHand() < 21 && dealerHand.valueOfHand() > 21) {
                System.out.println("\nThe dealer busted!");
                bet = bet * 2;
                System.out.println("You doubled your bet and earned: " + bet / 2);
                System.out.println("Your bet is now: " + bet);
            }

            //Win condition if the player busted.
            else if(playerHand.valueOfHand() > 21 && dealerHand.valueOfHand() < 21) {
                System.out.println("\nYou busted and lost!");
                System.out.println("You lost your bet of: " + bet);
                bet = 0;
            }

            //Asks the player if he/she wants to play again.
            playGame = false;

            while (!playGame) {
                System.out.println("\nDo you want to play again? (Y/N)");
                input = scanner.nextLine();
                System.out.println(input);

                if (input.equals("n") || input.equals("N")) {
                    break;
                }

                else if (input.equals("y") || input.equals("Y")) {
                    playGame = true;
                }

                else {
                    System.out.println("Invalid input");
                }
            }

            //Asks the player if he/she wants to bet again.
            if(playGame) {
                System.out.println("\nYour bet is currently: " + bet);

                if (bet == 0) {
                    System.out.println("\nHow much would you like to bet?");
                    bet = scanner.nextInt();
                    scanner.nextLine();
                }

                else {
                    boolean increaseBet = false;
                    while (!increaseBet) {
                        System.out.println("\nDo you want to increase your bet? (Y/N)");
                        input = scanner.nextLine();
                        System.out.println(input);
                        if (input.equals("n") || input.equals("N")) {
                            break;
                        }
                        else if (input.equals("y") || input.equals("Y")) {
                            increaseBet = true;
                        }
                        else {
                            System.out.println("Invalid input");
                        }
                    }

                    if (increaseBet) {
                        System.out.println("\nHow much would you like to add to your bet?");
                        int addToBet = scanner.nextInt();
                        scanner.nextLine();
                        bet = bet + addToBet;
                    }
                }
                System.out.println("\nRestarting...");
            }

            else {
                break;
            }
        }
        System.out.println("\nQuiting the game...");
    }
}
