package org.gameSale;

public class SalePlace {
    private User user;
    private Game game;
    private Campaign campaign;

    public SalePlace() {
    }

    public SalePlace(User user, Game game) {
        this.user = user;
        this.game = game;
    }

    public SalePlace(Campaign campaign) {
        this.campaign = campaign;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void sell(User user, Game game) {
        System.out.println("-------------");
        System.out.println(user.getFirstName() + " oyuncusu "
                + game.getName() + " oyununu "
                + game.getPrice() + " fiyatıyla satın aldı." );
        System.out.println("-------------");
    }

    public void sell(Campaign campaign) {
        System.out.println("-------------");
        System.out.println(campaign.getUser().getFirstName() + " oyuncusu "
                + getCampaign().getGame().getName() + " oyununu "
                + getCampaign().getGame().getPriceAfterDiscount() + " indirimli fiyatıyla satın aldı.");
        System.out.println("-------------");
    }



}
