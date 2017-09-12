package q2;

import java.util.Random;

/**
 * Play.
 * 
 * @author jay
 * @version 1.0
 */
public class Play {
    /**
     * total tie.
     */
    private static int tie;
    /**
     * total win.
     */
    private static int win;
    /**
     * total lose.
     */
    private static int lose;

    /**
     * person's play.
     */
    private String personPlay;
    /**
     * computer's play.
     */
    private String computerPlay;
    /**
     * random generated number using generator.
     */
    private int computerInt;
    /**
     * result of play.
     */
    private String result;
    /**
     * range of permitted number used for generator.
     */
    private final int outcome = 3;

    /**
     * constructor for the object of type Play.
     * 
     * @param play
     *            play
     */
    public Play(String play) {
        personPlay = play;
        if (!personPlay.equalsIgnoreCase("Rock")
                && !personPlay.equalsIgnoreCase("Paper")
                && !personPlay.equalsIgnoreCase("Scissors")) {
            throw new IllegalArgumentException(
                    "Please enter only rock / paper / scissors");
        }
    }

    /**
     * get player's play.
     * 
     * @return pesonPlay
     */
    public String getPPlay() {
        return personPlay;
    }

    /**
     * generate computer's play.
     * 
     * @return computer's play
     */
    public String getCPlay() {
        Random generator = new Random();
        computerInt = generator.nextInt(outcome);
        switch (computerInt) {
        case 0:
            computerPlay = "rock";
            break;
        case 1:
            computerPlay = "paper";
            break;
        case 2:
            computerPlay = "scissors";
            break;
        default:
            break;
        }
        return computerPlay;
    }

    /**
     * result of the play.
     * 
     * @return result
     */
    public String getResult() {
        if (personPlay.equalsIgnoreCase(computerPlay)) {
            result = "It's a tie!";
            tie++;
        } else if (personPlay.equalsIgnoreCase("rock")) {
            if (computerPlay.equalsIgnoreCase("scissors")) {
                result = "Rock crushes scissors.  You win!!";
                win++;
            } else if (computerPlay.equalsIgnoreCase("paper")) {
                result = "Paper eats rock. You lose!!";
                lose++;
            }
        } else if (personPlay.equalsIgnoreCase("paper")) {
            if (computerPlay.equalsIgnoreCase("scissors")) {
                result = "Scissors cuts paper. You lose!!";
                lose++;
            } else if (computerPlay.equalsIgnoreCase("rock")) {
                result = "Paper eats rock. You win!!";
                win++;
            }
        } else if (personPlay.equalsIgnoreCase("scissors")) {
            if (computerPlay.equalsIgnoreCase("paper")) {
                result = "Scissors cuts paper. You win!!";
                win++;
            } else if (computerPlay.equalsIgnoreCase("rock")) {
                result = "Rock breaks scissors. You lose!!";
                lose++;
            }
        }
        return result;
    }

    /**
     * get amount of wins.
     * 
     * @return win
     */
    public int getWin() {
        return win;
    }

    /**
     * get amount of loses.
     * 
     * @return lose
     */
    public int getLose() {
        return lose;
    }

    /**
     * get amount of ties.
     * 
     * @return tie
     */
    public int getTie() {
        return tie;
    }

}