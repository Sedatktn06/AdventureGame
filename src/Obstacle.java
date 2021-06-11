import java.util.Random;

public class Obstacle {
    private String name;
    private int damage,award,healthy,maxNumber;

    public Obstacle(String name, int damage,int healthy,int award, int maxNumber) {
        this.name = name;
        this.damage = damage;
        this.award = award;
        this.healthy = healthy;
        this.maxNumber = maxNumber;
    }
    public int count() {
        Random random=new Random();
        return random.nextInt(maxNumber)+1 ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }
}
