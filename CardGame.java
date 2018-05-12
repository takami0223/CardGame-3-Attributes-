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

            System.out.println("Player�F");
            player.showCard();
            System.out.println("Computer�F");
            computer.showCard();

            do{
                System.out.print("�ǂ̃J�[�h���g�p���܂����H �F ");
                useCard = sc.nextInt();
            }while(useCard < 1 || useCard > player.card_max);

            for(int i = 0; i < 100; i++){System.out.println();}

            Card playerUseCard = player.putCard(useCard-1); //Player���o���J�[�h
            Card computerUseCard = computer.putCard(rnd.nextInt(computer.card_max)); //Computer���o���J�[�h
            System.out.println("\t---------------");
            System.out.println("\t| Player  �F" + playerUseCard);
            System.out.println("\t|         vs");
            System.out.println("\t| Computer�F" + computerUseCard);
            System.out.println("\t---------------");

            try{Thread.sleep(1000);} catch(InterruptedException e){}

            gudge.Gudge(player, computer, playerUseCard, computerUseCard);

            System.out.println("\t-------------------");
            System.out.println("\t| Player-HP  �F" + player.getHP() + " |");
            System.out.println("\t| Computer-HP�F" + computer.getHP() + " |");
            System.out.println("\t-------------------");

            if(player.card_max == 0)break;
        }

        System.out.println("�I���I");
        if(player.getHP() == computer.getHP())
            System.out.println("���ʂ͈��������I");
        if(player.getHP() > computer.getHP())
            System.out.println("���ʂ� Player �̏����I���߂łƂ��I");
        if(player.getHP() < computer.getHP())
            System.out.println("���ʂ� Computer �̏����I����˂�c");
    }
}