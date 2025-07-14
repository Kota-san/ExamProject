public class Goblin extends Monster{
    public Goblin(String name, int hp, char suffix) {
        super(name, hp, suffix);
    }
    public String getName() {
        return this.name;
    }
    @Override
    public void attack(Creature target) {
        System.out.println(this.name + this.suffix + "はナイフで切りつけた！" + target.getName() + "に8のダメージを与えた！");
        target.setHp(target.getHp() - 8);
    }
}