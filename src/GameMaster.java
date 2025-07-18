import java.util.ArrayList;
public class GameMaster {
    public static void main(String[] args) {
        Hero hero = new Hero("勇者",100,"剣");
        ArrayList<Character> allyParty = new ArrayList<>();
        ArrayList<Monster> enemyParty = new ArrayList<>();

        try {
            allyParty.add(hero);
            allyParty.add(new Wizard("魔法使い",60,20));
            allyParty.add(new Thief("盗賊",70));

            enemyParty.add(new Matango("お化けキノコ",45));
            enemyParty.add(new Goblin("ゴブリン",50));
            enemyParty.add(new Slime("スライム",40));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("---味方パーティ---");
        for(Character character : allyParty) {
            character.showStatus();
        }
        System.out.println("---敵パーティ---");
        for(Monster monster : enemyParty) {
            monster.showStatus();
        }

        System.out.println("\n味方の総攻撃！");
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                try {
                    allyParty.get(i).attack(enemyParty.get(j));
                } catch (IllegalArgumentException e) {
                    enemyParty.get(j).setHp(0);
                    System.out.println("エラー: " + e.getMessage());
                }
            }
        }
        System.out.println("\n敵の総攻撃！");
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                try {
                    enemyParty.get(i).attack(allyParty.get(j));
                } catch (IllegalArgumentException e) {
                    allyParty.get(j).setHp(0);
                    System.out.println("エラー: " + e.getMessage());
                }
            }
        }
        System.out.println("\nダメージを受けた" + allyParty.get(0).getName() + "が突然光りだした！");
        System.out.println(allyParty.get(0).getName() + "はスーパーヒーローに変身した！");
        allyParty.set(0, new SuperHero((Hero)allyParty.get(0)));
        for(int i = 0; i < enemyParty.size(); i++) {
            try {
                allyParty.get(0).attack(enemyParty.get(i));
            } catch (IllegalArgumentException e) {
                enemyParty.get(i).setHp(0);
                System.out.println(e.getMessage());
            }
        }
        System.out.println("---味方パーティ最終ステータス---");
        for(Character character : allyParty) {
            character.showStatus();
            if(character.isAlive()) {
                System.out.println("生存状況：生存");
            }else{
                System.out.println("生存状況：戦闘不能");
            }
        }
        System.out.println("---敵パーティ最終ステータス---");
        for(Monster monster : enemyParty) {
            monster.showStatus();
            if(monster.isAlive()) {
                System.out.println("生存状況：生存");
            }else{
                System.out.println("生存状況：討伐済み");
            }
        }
    }
}