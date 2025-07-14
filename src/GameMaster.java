public class GameMaster {
    public static void main(String[] args) {
        Hero h = new Hero("勇者",100,"剣");
        Character[] ArrayList1 = new Character[3];
        ArrayList1[0] = h;
        ArrayList1[1] = new Wizard("魔法使い",60,114514);
        ArrayList1[2] = new Thief("盗賊",70);

        Monster[] ArrayList2 = new Monster[3];
        ArrayList2[0] = new Matango("お化けキノコ",45,'A');
        ArrayList2[1] = new Goblin("ゴブリン",50,'A');
        ArrayList2[2] = new Slime("スライム",40,'A');

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
        ArrayList1[0] = new SuperHero(h);
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
        ArrayList1[0].isAlive();
        ArrayList1[1].showStatus();
        ArrayList1[1].isAlive();
        ArrayList1[2].showStatus();
        ArrayList1[2].isAlive();
        System.out.println("---敵パーティ最終ステータス---");
        ArrayList2[0].showStatus();
        ArrayList2[0].isAlive();
        ArrayList2[1].showStatus();
        ArrayList2[1].isAlive();
        ArrayList2[2].showStatus();
        ArrayList2[2].isAlive();
    }
}