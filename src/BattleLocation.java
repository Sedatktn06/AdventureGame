public abstract class BattleLocation extends Location {
    protected Obstacle obstacle;
    protected String award;
    BattleLocation(Player player,String name,Obstacle obstacle,String award) {
        super(player);
        this.name=name;
        this.obstacle=obstacle;
        this.award=award;
    }
    public boolean getLocation() {
        int obsCount=obstacle.count();
        System.out.println("Şuan buradasınız : "+this.getName());
        System.out.println("Dikkatli ol! Burada "+obsCount +" tane " +obstacle.getName() +" bulunuyor!");
        System.out.println("<S>avaş veya <K>aç :");
        String selectCase=scanner.nextLine();
        selectCase=selectCase.toUpperCase();
        if (selectCase.equals("S")){
            if (combat(obsCount)){
                System.out.println(this.getName()+" bölgesindeki tüm düşmanları temizlediniz");
                if (this.award.equals("Food") && player.getInv().isFood()==false) {
                    System.out.println(this.award+" kazandınız!");
                    player.getInv().setFood(true);
                }
                else if (this.award.equals("Water") && player.getInv().isWater()==false) {
                    System.out.println(this.award+" kazandınız!");
                    player.getInv().setWater(true);
                }
                else if (this.award.equals("Firewood") && player.getInv().isFirewood()==false) {
                    System.out.println(this.award+" kazandınız!");
                    player.getInv().setFirewood(true);
                }
                return true;
            }
           if (player.getHealthy()<=0) {
               System.out.println("Öldünüz");
               return false;
           }
        }
        return true;
    }
    public boolean combat(int obsCount) {
        for (int i=0;i<obsCount;i++) {
            int defObsHealth=obstacle.getHealthy();
            playerStats();
            enemyStasts();
            while (player.getHealthy() > 0 && obstacle.getHealthy()>0){
                System.out.print("<V>ur veya <K>aç : ");
                String selCase=scanner.nextLine();
                selCase=selCase.toUpperCase();
                if(selCase.equals("V")) {
                    System.out.println("Siz vurdunuz");
                    obstacle.setHealthy(obstacle.getHealthy()-player.getTotalDamage());
                   afterHit();
                   if (obstacle.getHealthy()>0){
                       System.out.println();
                       System.out.println("Canavar size vurdu");
                       player.setHealthy(player.getHealthy()-(obstacle.getDamage()-player.getInv().getArmor()));
                       afterHit();
                   }

                }
                else {
                    return false;
                }
            }
            if (obstacle.getHealthy()<=0 && player.getHealthy()>0){
                System.out.println("Düşmanı yendiniz : ");
                player.setMoney(obstacle.getAward()+player.getMoney());
                System.out.println("Güncel paranız : "+player.getMoney());
                obstacle.setHealthy(defObsHealth);
            }
            else{
                return false;
            }
            System.out.println("------------------------");
        }
        return true;
    }
    public void afterHit() {
        System.out.println("Oyuncu canı : "+player.getHealthy());
        System.out.println(obstacle.getName()+" canı : "+obstacle.getHealthy());
    }
    public void playerStats() {
        System.out.println("Oyuncu değerleri : \n--------------");
        System.out.println("Can : "+player.getHealthy());
        System.out.println("Hasar : "+player.getTotalDamage());
        System.out.println("Para : "+player.getMoney());
        if (player.getInv().getDamage()>0) {
            System.out.println("Silah : "+player.getInv().getwName());
        }
        if (player.getInv().getArmor()>0) {
            System.out.println("Silah : "+player.getInv().getaName());
        }
    }
    public void enemyStasts() {
        System.out.println(obstacle.getName() +" Değerleri\n--------------");
        System.out.println("Can : "+obstacle.getHealthy());
        System.out.println("Hasar : " +obstacle.getDamage());
        System.out.println("Ödül : "+obstacle.getAward());

    }
}
