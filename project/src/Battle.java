import java.util.Objects;
import java.util.Scanner;

public class Battle {
    Player player;
    Player enemy;

    /**
     * Constructor
     */
    public Battle(Player player, Player enemy){
        this.enemy = enemy;
        this.player = player;
    }

    /**
     * Commences battle sequence
     */
    public void sequence(){
        System.out.println("A battle has begun between you and " + enemy.name + ", level: " + enemy.level);
        while(!win() && !loss()){ // While battle is not over
            playerTurn();
            if(win()){ // We don't want martyrdom
                break;
            }
            enemyTurn();
        }
        System.out.println("Battle sequence ended");
        System.out.println("-----------------------------------------------");
        player.health = player.totalHealth; // We will make it so the health regenerates for now
    }

    /**
     * Asks the player what they want to do and completes action
     */
    public void playerTurn(){
        Scanner action = new Scanner(System.in);
        String decision = "";

        System.out.println("What would you like to do?");
        System.out.println("Attack?");
        System.out.println("Block?");
        System.out.println("Parry?");
        System.out.println("Heal?");


        while(decision.equals("")) {
            decision = action.next();
            switch (decision.toLowerCase()) {
                case "attack" -> {
                    if(player.attack(enemy)){
                        System.out.println("Attack successful");
                        System.out.println(enemy.name + " Health: " + enemy.health);
                        System.out.println("-------------------------------------------------");
                    }
                    else{
                        System.out.println("Attack missed");
                        System.out.println("-------------------------------------------------");
                    }
                }
                case "block" ->
                    //TODO: make block
                        throw new UnsupportedOperationException();
                case "parry" ->
                    //TODO: make parry
                        throw new UnsupportedOperationException();
                case "heal" ->
                    //TODO: make heal
                        throw new UnsupportedOperationException();
                case "win" ->
                    //TODO: make heal
                        enemy.alive = false;
                default -> decision = "";
            }
        }
    }

    /**
     * Enemy's turn
     * For now they are just going to be an absolute bot
     */
    public void enemyTurn(){
        if(enemy.attack(player)){
            System.out.println("Attack against you was successful");
            System.out.println(player.name + " Health: " + player.health);
            System.out.println("-------------------------------------------------");
        }
        else{
            System.out.println("Attack missed");
            System.out.println("-------------------------------------------------");
        }

    }

    /**
     * @return status of victory
     */
    public boolean win(){
        if(player.winBattle(enemy)){
            System.out.println("You have won, exp rewarded");
            player.exp += (enemy.level + 1) * 30;
            if(player.exp >= player.level * 100){
                player.exp = player.exp - (player.level * 100);
                player.levelUp();
            }
            return true;
        }
        return false;
    }

    /**
     * @return status of loss
     */
    public boolean loss(){
        if(!player.isAlive()){
            System.out.println("You have died");
            return true;
        }
        return false;
    }
}
