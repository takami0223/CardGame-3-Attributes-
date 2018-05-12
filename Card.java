import java.util.Random;

public class Card{
    public static final int FIRE = 0;
    public static final int WATER = 1;
    public static final int GRASS = 2;
    public static final int ALL_TYPE = 3;
    public static final int SPECIAL_1 = 10;
    public static final int SPECIAL_2 = 11;
    public static final int SPECIAL_3 = 12;
    public static final int ALL_SPECIAL = 3;
    public static final int WIN = 1;
    public static final int LOSE = -1;

    int type;
    int number;

    Random rnd = new Random();

    Card(int check) {
        if(check == 0){
            /*---標準カードの生成---*/
            int checkType = rnd.nextInt(ALL_TYPE);

            if(checkType == FIRE)
                this.type = FIRE;
            if(checkType == WATER)
                this.type = WATER;
            if(checkType == GRASS)
                this.type = GRASS;

            number = rnd.nextInt(9)+1;
        }else{
            /*---spカードの生成---*/
            int checkSpecial = rnd.nextInt(ALL_SPECIAL)+10;

            if(checkSpecial == SPECIAL_1)
                this.type = SPECIAL_1;
            if(checkSpecial == SPECIAL_2)
                this.type = SPECIAL_2;
            if(checkSpecial == SPECIAL_3)
                this.type = SPECIAL_3;

            number = 10;
        }
    }

    int compareTo(Card c){

        /*---自分のカードが"火"---*/
        if(type == FIRE) {
            if(c.type == FIRE){
                if(number == c.number)return 0;
                if(number > c.number) return WIN;
                if(number < c.number) return LOSE;
            }
            else if(c.type == WATER) return LOSE;
            else if(c.type == GRASS) return WIN;
        }

        /*---自分のカードが'水'---*/
        else if(type == WATER) {
            if(c.type == FIRE) return WIN;
            else if(c.type == WATER){
                if(number == c.number)return 0;
                if(number > c.number) return WIN;
                if(number < c.number) return LOSE;
            }
            else if(c.type == GRASS) return LOSE;
        }

        /*---自分のカードが'草'---*/
        else if(type == GRASS) {
            if(c.type == FIRE) return LOSE;
            else if(c.type == WATER) return WIN;
            else if(c.type == GRASS) {
                if(number == c.number)return 0;
                if(number > c.number) return WIN;
                if(number < c.number) return LOSE;
            }
        }

        /*---自分のカードが'スペシャル'---*/
        else if(type == SPECIAL_1) return SPECIAL_1;
        else if(type == SPECIAL_2) return SPECIAL_2;
        else if(type == SPECIAL_3) return SPECIAL_3;

        return 100;
    }

    @Override
    public String toString() {
        if(type == FIRE)
            return "\033[31m" + "FIRE" + "[" + number + "]" + "\033[00m";
        else if(type == WATER)
            return "\033[34m" + "WATER" + "[" + number + "]" + "\033[00m";
        else if(type == GRASS)
            return "\033[32m" + "GRASS" + "[" + number + "]" + "\033[00m";
        else if(type == SPECIAL_1)
            return "\u001b[33m" + "SP_Allchenge(CARD)" + "[" + number + "]" + "\u001b[00m";
        else if(type == SPECIAL_2)
            return "\u001b[33m" + "SP_Allchenge(NUMBER)" + "[" + number + "]" + "\u001b[00m";
        else /*if(type == SPECIAL_3)*/
            return "\u001b[33m" + "SP_Allfixedchenge(CARD)" + "[" + number + "]" + "\u001b[00m";
    }
}