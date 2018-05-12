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

        /*---�����J�[�h�œ����i���o�[�̎�---*/
        }
        /*---�v���C���[����������---*/
        if(playerUseCard.compareTo(computerUseCard) == WIN){
            System.out.println("��Player��" + playerUseCard + "�̏���!��");
            try{Thread.sleep(1000);} catch(InterruptedException e){}
            if(playerUseCard.type == computerUseCard.type){
                subHP = playerUseCard.number - computerUseCard.number;
                computer.subHP(subHP);
                System.out.println("��Computer�� '" + subHP + "' �_���[�W!��");
            }else{
                computer.subHP(3);
            try{Thread.sleep(1000);} catch(InterruptedException e){}
        if(playerUseCard.compareTo(computerUseCard) == LOSE){
            if(playerUseCard.type == computerUseCard.type){
                subHP = computerUseCard.number - playerUseCard.number;
                player.subHP(subHP);
                System.out.println("��Player�� '" + subHP + "' �_���[�W!��");
            }else{
                player.subHP(3);
                System.out.println("��Player�� '3' �_���[�W!��");
            }
            try{Thread.sleep(1000);} catch(InterruptedException e){}
        }
            System.out.println("����Player��" + playerUseCard + "�ɂ���đS�J�[�h���`�F���W�I����");
            try{Thread.sleep(1000);} catch(InterruptedException e){}
        if(computerUseCard.compareTo(playerUseCard) == SPECIAL_1){
            System.out.println("����Computer��" + computerUseCard + "�ɂ���đS�J�[�h���`�F���W�I����");
            player.new_card();
            computer.new_card();
            try{Thread.sleep(1000);} catch(InterruptedException e){}
        }

        /*---�v���C���[�� SPECIAL_2 ���g������---*/
        if(playerUseCard.compareTo(computerUseCard) == SPECIAL_2){
            System.out.println("����Player��" + playerUseCard + "�ɂ���đS�m�[�}���J�[�h�̋������`�F���W�I����");
            player.new_number();
            computer.new_number();
            try{Thread.sleep(1000);} catch(InterruptedException e){}
        }
        /*---�R���s���[�^�� SPECIAL_2 ���g������---*/
        if(computerUseCard.compareTo(playerUseCard) == SPECIAL_2){
            System.out.println("����Computer��" + computerUseCard + "�ɂ���đS�m�[�}���J�[�h�̋������`�F���W�I����");
            player.new_number();
            computer.new_number();
            try{Thread.sleep(1000);} catch(InterruptedException e){}
        }

        /*---�v���C���[�� SPECIAL_3 ���g������---*/
        if(playerUseCard.compareTo(computerUseCard) == SPECIAL_3){
            computer.fixed_card();
            System.out.println("����Player��" + playerUseCard + "�ɂ���ā���");
            try{Thread.sleep(1000);} catch(InterruptedException e){}
            if(computer.checkType == FIRE)
                System.out.println("����Computer�̑S�m�[�}���J�[�h�̃^�C�v��" + "\033[31m" +  " FIRE " + "\033[00m" +"����");
            if(computer.checkType == WATER)
                System.out.println("����Computer�̑S�m�[�}���J�[�h�̃^�C�v��" + "\033[34m" + " WATER " + "\033[00m" + "����");
            if(computer.checkType == GRASS)
                System.out.println("����Computer�̑S�m�[�}���J�[�h�̃^�C�v��" + "\033[32m" + " GRASS " + "\033[00m" + "����");
            try{Thread.sleep(1000);} catch(InterruptedException e){}
            System.out.println("����Computer�̑S�m�[�}���J�[�h�̋�����'" + computer.number + "'�Ƀ`�F���W�I����");
            try{Thread.sleep(1000);} catch(InterruptedException e){}
        }
        /*---�R���s���[�^�� SPECIAL_3 ���g������---*/
        if(computerUseCard.compareTo(playerUseCard) == SPECIAL_3){
            player.fixed_card();
            System.out.println("����Computer��" + computerUseCard + "�ɂ���ā���");
            try{Thread.sleep(1000);} catch(InterruptedException e){}
            if(player.checkType == FIRE)
                System.out.println("����Player�̑S�m�[�}���J�[�h�̃^�C�v��" + "\033[31m" + " FIRE " + "\033[00m" + "����");
            if(player.checkType == WATER)
                System.out.println("����Player�̑S�m�[�}���J�[�h�̃^�C�v��" + "\033[34m" + " WATER " + "\033[00m" + "����");
            if(player.checkType == GRASS)
                System.out.println("����Player�̑S�m�[�}���J�[�h�̃^�C�v��" + "\033[32m" + " GRASS " + "\033[00m" + "����");
            try{Thread.sleep(1000);} catch(InterruptedException e){}
            System.out.println("����Player�̑S�m�[�}���J�[�h�̋�����'" + player.number + "'�Ƀ`�F���W�I����");
            try{Thread.sleep(1000);} catch(InterruptedException e){}
        }
    }
}