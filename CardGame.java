import java.util.Scanner;
import java.util.Random;

class CardGame {
    public static final int PLAYER = 0;
    public static final int COMPUTER = 1;

    public static void main(String[] args){
        int useCard = 0;

        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        CardGudge gudge = new CardGudge();

        Player player = new Player();
        Player computer = new Player();

        while(Player.flag == 0){
            player.new_card();
            computer.new_card();
        }

        while(true){

            System.out.println("Player：");
            player.showCard();
            System.out.println("Computer：");
            computer.showCard();

            do{
                System.out.print("どのカードを使用しますか？ ： ");
                useCard = sc.nextInt();
            }while(useCard < 1 || useCard > player.card_max);

            for(int i = 0; i < 100; i++){System.out.println();}

            Card playerUseCard = player.putCard(useCard-1); //Playerが出すカード
            Card computerUseCard = computer.putCard(rnd.nextInt(computer.card_max)); //Computerが出すカード
            System.out.println("\t---------------");
            System.out.println("\t| Player  ：" + playerUseCard);
            System.out.println("\t|         vs");
            System.out.println("\t| Computer：" + computerUseCard);
            System.out.println("\t---------------");

            try{Thread.sleep(1000);} catch(InterruptedException e){}

            gudge.Gudge(player, computer, playerUseCard, computerUseCard);

            System.out.println("\t-------------------");
            System.out.println("\t| Player-HP  ：" + player.getHP() + " |");
            System.out.println("\t| Computer-HP：" + computer.getHP() + " |");
            System.out.println("\t-------------------");

            if(player.card_max == 0)break;
        }

        System.out.println("終了！");
        if(player.getHP() == computer.getHP())
            System.out.println("結果は引き分け！");
        if(player.getHP() > computer.getHP())
            System.out.println("結果は Player の勝ち！おめでとう！");
        if(player.getHP() < computer.getHP())
            System.out.println("結果は Computer の勝ち！ざんねん…");
    }
}