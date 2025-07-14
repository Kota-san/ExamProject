public class Goblin extends Monster{
    public Goblin(String name, int hp) {
        super(name, hp);
    }
    public String getName() {
        return this.name;
    }
    @Override
    public void attack(Creature target) {
        System.out.println(this.name +  this.getSuffix() + "はナイフで切りつけた！" + target.getName() + "に8のダメージを与えた！");
        target.setHp(target.getHp() - 8);
    }
}