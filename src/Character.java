public abstract class Character implements Creature{
    private String name;
    private int hp;
    public Character(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }
    public String getName() {
        return this.name;
    }
    public int getHp() {
        return this.hp;
    }
    public void setHp(int hp) {
        if (hp < 0) {
            throw new IllegalArgumentException("初期設定に誤りがあるため、キャラクターを作成できませんでした");
        }
        this.hp = hp;
    }
    public final boolean isAlive(){
        if (this.hp > 0) {
            System.out.println("生存状況：生存");
            return true;
        }else{
            System.out.println("生存状況：死亡");
            return false;
        }
    }
    public void showStatus(){
        System.out.println(this.name + "：HP" + this.hp);
    }
}