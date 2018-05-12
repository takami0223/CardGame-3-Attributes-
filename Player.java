import java.util.Random;

public class Player {
    public static final int CARD_MAX = 10; // カードの最大値
    public static final int NORMAL = 0; // ノーマルカードの生成
    public static final int SPECIAL = 10; // スペシャルカードの生成
    public static final int ALL_TYPE = 3;

    Card[] cards; // 所持するCard の配列(Player)
    private int hp = 50; // 体力
    static int flag = 0;
    int card_max = CARD_MAX;
    int checkType = 0;
    int number = 0;

    Random rnd = new Random();

    void new_card(){
        flag = 0;
        cards = new Card[card_max];

        for(int i = 0; i < card_max; i++){
            cards[i] = new Card(NORMAL);
            if(i == rnd.nextInt(CARD_MAX)){
                flag = 1;
                cards[i] = new Card(SPECIAL);
            }
        }
    }

    void new_number(){
        for(int i = 0; i < card_max; i++){
            if(cards[i].number != SPECIAL){
                cards[i].number = rnd.nextInt(9)+1;
            }
        }
    }

    void fixed_card(){
        checkType = rnd.nextInt(ALL_TYPE);
        number = rnd.nextInt(9)+1;
        for(int i = 0; i < card_max; i++){
            if(cards[i].number != SPECIAL){
                cards[i].type = checkType;
                cards[i].number = number;
            }
        }
    }

    void showCard(){
        for(int i = 0; i < card_max; i++){
            System.out.print("No." + (i+1) + " : ");
            if(cards[i].number == SPECIAL)
                System.out.println("\u001b[33m" + cards[i] + "\u001b[00m");
            else
                System.out.println(cards[i]);
        }
    }

    void subHP(int subtractionHP){
        hp -= subtractionHP;
    }

    int getHP(){
        return hp;
    }

    Card putCard(int usedcard){
        Card attackCard = cards[usedcard];
        card_max--;

        for(int i = usedcard; i < card_max; i++){
            cards[i] = cards[i+1];
        }
        return attackCard;
    }
}