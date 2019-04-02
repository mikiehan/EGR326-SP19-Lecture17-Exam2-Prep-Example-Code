package strategy;

public class Queen extends Character{
    private int choice;
    private static WeaponBehavior[] weapons = {
            new KnifeBehavior(),
            new BowAndArrowBehavior(),
            new AxeBehavior(),
            new SwordBehavior()};

    public Queen(){
        choice = 0;
    }

    @Override
    public void setWeapon() {
        weapon = weapons[choice++];
        if(choice == weapons.length) {
            choice = 0;
        }
    }

    @Override
    public void fight() {
        setWeapon();
        weapon.useWeapon();
    }
}
