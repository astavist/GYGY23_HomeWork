package org.gameSale;

public class Game {
    private int gameId;
    private String name;
    private double price;
    private double priceAfterDiscount;

    public Game(int gameId, String name, double price) {
        this.gameId = gameId;
        this.name = name;
        this.price = price;
    }


    public Game(int gameId, String name, double price, double priceAfterDiscount) {
        this.gameId = gameId;
        this.name = name;
        this.price = price;
        this.priceAfterDiscount = priceAfterDiscount;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPriceAfterDiscount() {
        return priceAfterDiscount;
    }

    public void setPriceAfterDiscount(double priceAfterDiscount) {
        this.priceAfterDiscount = priceAfterDiscount;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameId=" + gameId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", priceAfterDiscount=" + priceAfterDiscount +
                '}';
    }
}
