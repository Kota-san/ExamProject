public final class Slime extends Monster {
    private String name;
    private int hp;
    public Slime(String name, int hp, char suffix) {
        super(name, hp, suffix);
    }
    public String getName() {
        return this.name;
    }
    @Override
    public void attack(Creature target) {
        System.out.println(this.name + this.suffix + "は体当たり攻撃！" + target.getName() + "に6のダメージを与えた！");
        target.setHp(target.getHp() - 6);
    }
}