package org.gameSale;

public class Main {
    public static void main(String[] args) {
//        Oyunların oluşturulması
        Game game1 = new Game(1,"Rust",150);
        Game game2 = new Game(2,"GTA 5",190);
        Game game3 = new Game(3,"HALO",260);

//        Kullanıcıların oluşturulması
        User user1 = new User(1,"Samet","Yılmaz","yilmazsamet@gmail.com",
                "asdfgh","12121229388","17/10/1998");
        User user2 = new User(2,"Ayşe", "Özgüven","ayseozguven@gmail.com",
                "sdfgfg", "123123123","12/23/1242");

//        Kullanıcıların eklenmesi
        UserManager manager1 = new UserManager();
        manager1.addPlayer(user1);
        manager1.deletePlayer(user1);
        manager1.addPlayer(user2);
        manager1.updatePlayer(user2);
        manager1.addPlayer(user1);

//        Mernis database'inden kullanıcı authentication işlemi
        Mernis mernis1 = new Mernis();
        mernis1.verifyIfCitizen(user1);
        mernis1.verifyIfCitizen(user2);

//        Kampanya tanımlanması(yüzdelik olarak indirim örn: %18)
        Campaign campaign1 = new Campaign(1,user1,game2,18);
        Campaign campaign2 = new Campaign(2,user2,game3,32);

//        Satış işlemleri
        SalePlace sale1 = new SalePlace();
        SalePlace sale2 = new SalePlace(campaign1);
        SalePlace sale3 = new SalePlace(campaign2);
        sale1.sell(user1,game1); //normal satış işlemi
        sale2.sell(campaign1);//user1, campaign1'i kullanarak game2'yi satın alıyor
        sale3.sell(campaign2);//user2, campaign2'yi kullanarak game3'ü satın alıyor




    }
}