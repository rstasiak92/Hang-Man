package Rafal.Games;


public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello Guest! \n In this game you will have nine attempts to gues the word I think of :) \n Please enter a letter");
        NewGame game = new NewGame("programmer");
        Input input = new Input(game);
        while (!game.isGameOver()){
            playGame(game, input);
        }
        game.informUser();
    }


    private static void playGame(NewGame game, Input input) {
        boolean isHit = input.userInput();
        if (isHit){
            System.out.printf("Great you got a point\n%s\n\n",game.remainingTries());
        } else {
            System.out.printf("Sadly you missed :(\n%s\n",game.remainingTries());}
        game.getCurrentProcess();
    }
}

