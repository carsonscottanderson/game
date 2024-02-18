import java.util.Scanner;

public class MainMenu {
    Player player;
    public MainMenu(){
        player = new Player(1);
        Scanner user = new Scanner(System.in);
        System.out.println("Welcome");
        System.out.println("Player Name?");
        player.name = user.next();
    }

    public void standard(){
        Scanner user = new Scanner(System.in);
        String decision = "";
        System.out.println(player.name);
        System.out.println("Level: " + player.level);
        System.out.println("Total Health: " + player.health);
        System.out.println("Luck: " + player.luck);
        System.out.println("EXP: " + player.exp);
        System.out.println("Damage: " + player.damage);
        System.out.println("------------------------");
        System.out.println("What would you like to do?");
        System.out.println("Battle?");
        System.out.println("------------------------");

        while(decision.equals("")){
            decision = user.next();
            if(decision.equalsIgnoreCase("battle")){
                Player enemy = new Player(0);
                enemy.name = "Beast";
                Battle quickMatch = new Battle(player, enemy);
                quickMatch.sequence();
            }
            standard();
        }
    }
}
