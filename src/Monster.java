public abstract class Monster implements Creature{
    String name;
    private int hp;
    private char suffix = 'A';
    public Monster(String name, int hp) {
        if (hp < 0) {
            throw new IllegalArgumentException("初期設定に誤りがあるため、キャラクターを作成できませんでした");
        }
        this.name = name;
        this.hp = hp;
    }
    public char getSuffix() {
        return this.suffix;
    }
    public int getHp() {
        return this.hp;
    }
    public void setHp(int hp) {
        if (hp < 0) {
            throw new IllegalArgumentException("");
        }
        this.hp = hp;
    }
    public final boolean isAlive(){
        if (this.hp > 0) {
            return true;
        }else{
            return false;
        }
    }
    public void showStatus(){
        System.out.println(this.name + this.suffix + "：HP" + this.hp);
    }
}