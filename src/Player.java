import java.util.Scanner;

public class Player {
    private int damage;
    private int healthy;
    private int money;
    private String name,cName;
    private Inventory ınv;
    private int rHealthy;
    Scanner scanner=new Scanner(System.in);
    public Player(String name) {
        this.name = name;
        this.ınv=new Inventory();
    }
    public void selectCha() {
        switch (chaMenu()) {
            case 1:
                initPlay("Samuray",5,21,15);
                break;
            case 2:
                initPlay("Okçu",7,18,20);
                break;
            case 3:
                initPlay("Şövalye",8,24,5);
                break;
            default:
                initPlay("Samuray",5,21,15);
                break;
        }
        System.out.println("Karakter: " +getcName() +"\t Hasar : " +getDamage() + "\t Sağlık : " +getHealthy() + "\t Para :" +getMoney());
    }
    public int getTotalDamage() {
        return this.getDamage()+this.getInv().getDamage();
    }
    public void initPlay(String cName,int dmg,int hlthy,int mny) {
        setcName(cName);
        setDamage(dmg);
        setHealthy(hlthy);
        setMoney(mny);
        setrHealthy(hlthy);
    }
    public int  chaMenu() {
        System.out.println("Lütfen bir karakter seçiniz : ");
        System.out.println("1-) Samuray \t Hasar : 5 \t Sağlık : 21 \t Para : 15");
        System.out.println("2-) Okçu \t     Hasar : 7 \t Sağlık : 18 \t Para : 20");
        System.out.println("3-) Şövalye \t Hasar : 8 \t Sağlık : 24 \t Para : 5");
        System.out.print("Seçiminiz : ");
        int chaID=scanner.nextInt();
        while (chaID < 1 || chaID > 3 ) {
            System.out.println("Lütfen geçerli bir karakter seçiniz ");
            chaID=scanner.nextInt();
        }
        return chaID;
    }

    public Inventory getInv() {
        return ınv;
    }

    public void setInv(Inventory ınv) {
        this.ınv = ınv;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public int getrHealthy() {
        return rHealthy;
    }

    public void setrHealthy(int rHealthy) {
        this.rHealthy = rHealthy;
    }
}
