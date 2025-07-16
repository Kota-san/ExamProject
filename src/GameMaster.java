public class GameMaster {
    public static void main(String[] args) {
        Hero hero = new Hero("勇者",100,"剣");
        Character[] ArrayList1 = new Character[3];
        Monster[] ArrayList2 = new Monster[3];

        try {
            ArrayList1[0] = hero;
            ArrayList1[1] = new Wizard("魔法使い",60,20);
            ArrayList1[2] = new Thief("盗賊",70);

            ArrayList2[0] = new Matango("お化けキノコ",45);
            ArrayList2[1] = new Goblin("ゴブリン",50);
            ArrayList2[2] = new Slime("スライム",40);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("---味方パーティ---");
        ArrayList1[0].showStatus();
        ArrayList1[1].showStatus();
        ArrayList1[2].showStatus();
        System.out.println("---敵パーティ---");
        ArrayList2[0].showStatus();
        ArrayList2[1].showStatus();
        ArrayList2[2].showStatus();

        System.out.println("味方の総攻撃！");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                try {
                    ArrayList1[i].attack(ArrayList2[j]);
                } catch (IllegalArgumentException e) {
                    ArrayList2[i].setHp(0);
                    System.out.println("エラー: " + e.getMessage());
                }
            }
        }
        System.out.println("敵の総攻撃！");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                try {
                    ArrayList2[i].attack(ArrayList1[j]);
                } catch (IllegalArgumentException e) {
                    ArrayList1[i].setHp(0);
                    System.out.println("エラー: " + e.getMessage());
                }
            }
        }
        System.out.println("ダメージを受けた" + ArrayList1[0].getName() + "が突然光りだした！");
        System.out.println(ArrayList1[0].getName() + "はスーパーヒーローに変身した！");
        ArrayList1[0] = new SuperHero(hero);
        for (int i = 0; i < 3; i++) {
            try {
                ArrayList1[0].attack(ArrayList2[i]);
            } catch (IllegalArgumentException e) {
                ArrayList2[i].setHp(0);
                System.out.println("エラー: " + e.getMessage());
            }
        }
        System.out.println("---味方パーティ最終ステータス---");
        ArrayList1[0].showStatus();
        if(ArrayList1[0].isAlive()) {
            System.out.println("生存状況：生存");
        }else{
            System.out.println("生存状況：戦闘不能");
        }
        ArrayList1[1].showStatus();
        if(ArrayList1[1].isAlive()) {
            System.out.println("生存状況：生存");
        }else{
            System.out.println("生存状況：戦闘不能");
        }
        ArrayList1[2].showStatus();
        if(ArrayList1[2].isAlive()) {
            System.out.println("生存状況：生存");
        }else{
            System.out.println("生存状況：戦闘不能");
        }
        System.out.println("---敵パーティ最終ステータス---");
        ArrayList2[0].showStatus();
        if(ArrayList2[0].isAlive()) {
            System.out.println("生存状況：生存");
        }else{
            System.out.println("生存状況：討伐済み");
        }
        ArrayList2[1].showStatus();
        if(ArrayList2[1].isAlive()) {
            System.out.println("生存状況：生存");
        }else{
            System.out.println("生存状況：討伐済み");
        }
        ArrayList2[2].showStatus();
        if(ArrayList2[2].isAlive()) {
            System.out.println("生存状況：生存");
        }else{
            System.out.println("生存状況：討伐済み");
        }
    }
}