import java.util.Random;

public class Player {
    String name;
    int level;
    int totalHealth;
    int health;
    int damage;

    int luck;

    int exp;

    int weariness;

    boolean alive = true;

    public Player(int level){
        this.level = level;
        this.totalHealth = 90 + level * 10;
        this.health = totalHealth;
        this.damage = 15 + level * 5;
        this.luck = level;
        this.exp = 0;

    }

    /**
     * Player attack.
     * @param enemy to be attacked
     * @return damage dealt (-1 if unsuccessful)
     */
    public boolean attack(Player enemy){
        Random chance = new Random();
        int success = chance.nextInt(100);
        if(success <  80 - enemy.luck){
            enemy.attacked(chance.nextInt(damage));
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Player attack.
     * @param damage dealt to player
     * Will set to dead if health goes below 0 on attack
     */
    public void attacked(int damage){
        this.health -= damage;
        if(health <= 0){
            this.alive = false;
        }
    }

    /**
     * @return living status of player
     */
    public boolean isAlive(){
        return this.alive;
    }

    /**
     * @return status of victory
     * Adds exp if battle is won
     * TODO: make more efficient leveling system
     */
    public boolean winBattle(Player enemy){
        return !enemy.isAlive();
    }
    /**
     * Levels up player and stats
     * TODO: have player decide upgrade
     */
    public void levelUp(){
        level++;
        totalHealth += 10;
        damage += 5;
        luck += 1;
    }





}
