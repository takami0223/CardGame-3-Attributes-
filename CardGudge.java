class CardGudge {
    public static final int FIRE = 0;
    public static final int WATER = 1;
    public static final int GRASS = 2;
    public static final int WIN = 1;
    public static final int LOSE = -1;
    public static final int SPECIAL_1 = 10;
    public static final int SPECIAL_2 = 11;
    public static final int SPECIAL_3 = 12;

    int subHP = 0;

    void Gudge(Player player, Player computer, Card playerUseCard, Card computerUseCard) {

        /*---同じカードで同じナンバーの時---*/
        }
        /*---プレイヤーが勝った時---*/
        if(playerUseCard.compareTo(computerUseCard) == WIN){
            System.out.println("＞Playerの" + playerUseCard + "の勝ち!＜");
            try{Thread.sleep(1000);} catch(InterruptedException e){}
            if(playerUseCard.type == computerUseCard.type){
                subHP = playerUseCard.number - computerUseCard.number;
                computer.subHP(subHP);
                System.out.println("＞Computerに '" + subHP + "' ダメージ!＜");
            }else{
                computer.subHP(3);
            try{Thread.sleep(1000);} catch(InterruptedException e){}
        if(playerUseCard.compareTo(computerUseCard) == LOSE){
            if(playerUseCard.type == computerUseCard.type){
                subHP = computerUseCard.number - playerUseCard.number;
                player.subHP(subHP);
                System.out.println("＞Playerに '" + subHP + "' ダメージ!＜");
            }else{
                player.subHP(3);
                System.out.println("＞Playerに '3' ダメージ!＜");
            }
            try{Thread.sleep(1000);} catch(InterruptedException e){}
        }
            System.out.println("＞＞Playerの" + playerUseCard + "によって全カードがチェンジ！＜＜");
            try{Thread.sleep(1000);} catch(InterruptedException e){}
        if(computerUseCard.compareTo(playerUseCard) == SPECIAL_1){
            System.out.println("＞＞Computerの" + computerUseCard + "によって全カードがチェンジ！＜＜");
            player.new_card();
            computer.new_card();
            try{Thread.sleep(1000);} catch(InterruptedException e){}
        }

        /*---プレイヤーが SPECIAL_2 を使った時---*/
        if(playerUseCard.compareTo(computerUseCard) == SPECIAL_2){
            System.out.println("＞＞Playerの" + playerUseCard + "によって全ノーマルカードの強さがチェンジ！＜＜");
            player.new_number();
            computer.new_number();
            try{Thread.sleep(1000);} catch(InterruptedException e){}
        }
        /*---コンピュータが SPECIAL_2 を使った時---*/
        if(computerUseCard.compareTo(playerUseCard) == SPECIAL_2){
            System.out.println("＞＞Computerの" + computerUseCard + "によって全ノーマルカードの強さがチェンジ！＜＜");
            player.new_number();
            computer.new_number();
            try{Thread.sleep(1000);} catch(InterruptedException e){}
        }

        /*---プレイヤーが SPECIAL_3 を使った時---*/
        if(playerUseCard.compareTo(computerUseCard) == SPECIAL_3){
            computer.fixed_card();
            System.out.println("＞＞Playerの" + playerUseCard + "によって＜＜");
            try{Thread.sleep(1000);} catch(InterruptedException e){}
            if(computer.checkType == FIRE)
                System.out.println("＞＞Computerの全ノーマルカードのタイプを" + "\033[31m" +  " FIRE " + "\033[00m" +"＜＜");
            if(computer.checkType == WATER)
                System.out.println("＞＞Computerの全ノーマルカードのタイプを" + "\033[34m" + " WATER " + "\033[00m" + "＜＜");
            if(computer.checkType == GRASS)
                System.out.println("＞＞Computerの全ノーマルカードのタイプを" + "\033[32m" + " GRASS " + "\033[00m" + "＜＜");
            try{Thread.sleep(1000);} catch(InterruptedException e){}
            System.out.println("＞＞Computerの全ノーマルカードの強さを'" + computer.number + "'にチェンジ！＜＜");
            try{Thread.sleep(1000);} catch(InterruptedException e){}
        }
        /*---コンピュータが SPECIAL_3 を使った時---*/
        if(computerUseCard.compareTo(playerUseCard) == SPECIAL_3){
            player.fixed_card();
            System.out.println("＞＞Computerの" + computerUseCard + "によって＜＜");
            try{Thread.sleep(1000);} catch(InterruptedException e){}
            if(player.checkType == FIRE)
                System.out.println("＞＞Playerの全ノーマルカードのタイプを" + "\033[31m" + " FIRE " + "\033[00m" + "＜＜");
            if(player.checkType == WATER)
                System.out.println("＞＞Playerの全ノーマルカードのタイプを" + "\033[34m" + " WATER " + "\033[00m" + "＜＜");
            if(player.checkType == GRASS)
                System.out.println("＞＞Playerの全ノーマルカードのタイプを" + "\033[32m" + " GRASS " + "\033[00m" + "＜＜");
            try{Thread.sleep(1000);} catch(InterruptedException e){}
            System.out.println("＞＞Playerの全ノーマルカードの強さを'" + player.number + "'にチェンジ！＜＜");
            try{Thread.sleep(1000);} catch(InterruptedException e){}
        }
    }
}