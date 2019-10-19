package Rafal.Games;


class NewGame {

        private String wordToGuess;
        private String correctGuesses;
        private String misses;
        private int guessAttempts;
        private static final int MAX_Guesses = 9;


    public NewGame(String wordToGuess) {
            this.wordToGuess = wordToGuess;
            correctGuesses = "";
            misses = "";
            guessAttempts = 0;
    }

        public boolean userGuessing(char letter) {
            boolean isHit = wordToGuess.indexOf(letter) != -1;
            if (correctGuesses.indexOf(letter) != -1 || misses.indexOf(letter) != -1) {
                System.out.printf("\nSorry, you have already used %s letter\n\n",letter);
            }
            if (isHit) {
                correctGuesses += letter;
            } else {
                misses += letter;
                guessAttempts ++;
            }
            return isHit;
        }

     private int getCurrentTries(){
         return MAX_Guesses - guessAttempts;
     }

     public boolean isGameOver(){

        return isWin() || isLoose();
     }

    private boolean isLoose() {

        return getCurrentTries() <= 0;
    }

    private boolean isWin() {
        return processDisplay().contentEquals(wordToGuess);
    }

    public String remainingTries(){
        int tries = getCurrentTries();
        return String.format("You have %s tries left", tries);
    }


    public void informUser() throws Exception {
        if (isLoose()) {
            System.out.printf("Sorry you used all %d chances. Game Over.", MAX_Guesses);
        } else if (isWin()){
            System.out.printf("Congratulations!! You won!! The word to guess was %s",wordToGuess);
        } else {
            throw new Exception("Game is still in progress");
        };
    }
    public  String processDisplay(){
        String progress  = "";
            for (char letter : wordToGuess.toCharArray() ) {
                char display = '-';
                if (correctGuesses.indexOf(letter) != -1){
                    display = letter;
                }
                progress += display;
            }
        return progress;
    }

    public void getCurrentProcess() {
        if (!isWin()) {
            System.out.printf("Please try to guess:\n %s", processDisplay());
        }
    }
}



