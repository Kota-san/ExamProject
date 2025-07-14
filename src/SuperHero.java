public class SuperHero extends Hero {
    public SuperHero(Hero h){
        super(h.getName(),h.getHp(),h.getWeapon());
    }
    @Override
    public void attack(Creature target) {
        System.out.println(this.getName() + "は" + this.getWeapon() + "で攻撃！" + target.getName() + "に25のダメージを与えた！");
        target.setHp(target.getHp() - 25);
    }
}