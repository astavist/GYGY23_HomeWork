package org.gameSale;

public class Campaign {
    private int id;
    private User user;
    private Game game;
    private double discount;

    public Campaign() {
    }

    public Campaign(int id, User user, Game game, double discount) {
        this.id = id;
        this.user = user;
        this.game = game;
        this.game.setPriceAfterDiscount(game.getPrice()*(100-discount)/100);
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "id=" + id +
                ", user=" + user +
                ", game=" + game +
                ", discount=" + discount +
                '}';
    }
}
