package strategy;

public abstract class Character {
    protected WeaponBehavior weapon;
    public abstract void setWeapon();
    public void fight(){
        setWeapon();
        weapon.useWeapon();
    }
}
