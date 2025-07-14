public class Wizard extends Character{
    private String name;
    private int hp;
    private int mp;
    public Wizard(String name, int hp,int mp){
        super(name, hp);
        this.mp = mp;
    }
    public int getMp() {
        return this.mp;
    }
    public void setMp(int mp) {
        if (mp <= 0) {
            mp = 0;
        }
        this.mp = mp;
    }
    @Override
    public void attack(Creature target) {
        System.out.println(this.name + "は火の玉を放った！" + target.getName() + "に3のダメージを与えた！");
        target.setHp(target.getHp() - 3);
        this.mp -= 1;
    }
}