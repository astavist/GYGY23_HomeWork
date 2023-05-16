package org.gameSale;

public class UserManager {
    private int subCount = 0;
    public void addPlayer(User user) {
        System.out.println(user.getFirstName() + " oyuncusu sisteme eklendi.");
        subCount++;
        System.out.println("Kayıtlı oyuncu sayısı: " + subCount);
        System.out.println("-------------");
    }
    public void deletePlayer(User user) {
        System.out.println(user.getFirstName() + " oyuncusu sistemden silindi.");
        subCount--;
        System.out.println("Kayıtlı oyuncu sayısı: " + subCount);
        System.out.println("-------------");
    }
    public void updatePlayer(User user) {
        System.out.println(user.getFirstName() + " oyuncusunun bilgileri güncellendi.");
        System.out.println("-------------");
    }
}
