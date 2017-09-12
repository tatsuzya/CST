package comp1510;

import java.util.Scanner;

/**
 * Player.
 * 
 * @author jay
 * @version 1.0
 */
public class Player {
    private String name;
    private String team;
    private int jerseyNumber;

    /**
     * readPlayer.
     */
    public void readPlayer() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Name: ");
        name = scan.nextLine();
        System.out.println("Team: ");
        team = scan.nextLine();
        System.out.println("Jersey number: ");
        jerseyNumber = scan.nextInt();
    }

    /**
     * compare the inputs.
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        Player x = (Player) o;
        if (x.name.equals(this.name)) {
            if (x.team.equals(this.team)) {
                if (x.jerseyNumber == (this.jerseyNumber)) {
                    return true;
                }
            }
        } else if (x.team.equals(this.team)) {
            if (x.jerseyNumber == (this.jerseyNumber)) {
                return true;
            }
        }
        return false;
    }
}