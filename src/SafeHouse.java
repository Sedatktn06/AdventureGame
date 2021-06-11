public class SafeHouse extends NormalLocation{

    SafeHouse(Player player) {
        super(player,"Güvenli ev");
    }

    @Override
    public boolean getLocation() {
        player.setHealthy(player.getrHealthy());
        System.out.println("Canınız doldu");
        System.out.println("Şuan güvenli evdesiniz");
        return true;
    }
}
