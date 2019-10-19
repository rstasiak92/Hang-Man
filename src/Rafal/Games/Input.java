package Rafal.Games;

import java.util.Scanner;

public class Input {

    private NewGame game;

    public Input(NewGame game){
        this.game = game;
    }

public boolean userInput (){
    Scanner scanner = new Scanner(System.in);
    char c = scanner.next(".").charAt(0);
    c = Character.toLowerCase(c);

    while (!Character.isLetter(c)) {
            System.out.println("You can enter only letters! \n\nPlease enter a letter");
            c = scanner.next(".").charAt(0);}
        if (Character.isLetter(c)){
            return game.userGuessing(c);
    }
    return false;
}
}
