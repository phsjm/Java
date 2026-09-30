/*
 * 【プログラム名】 輸液滴下計算アプリケーション
 * 【概要】
 *   輸液の総量、予定時間、滴下係数を受け取り、
 *   1分間あたりの滴下数および、クレンメ調整用の5秒間あたりの滴下数を計算するクラス。
 *   コンソールからの入力を受け付け、オブジェクト指向の設計（クラス・コンストラクタ・メソッド）の練習として作成。
 */

import java.io.*;

class InfusionOrder {
    int totalMl;
    int totalHours;
    int dropFactor;

    public InfusionOrder(int ml, int hours, int factor) {
        totalMl = ml;
        totalHours = hours;
        dropFactor = factor;
    }

    public int calculateRate() {
        int totalMinutes = totalHours * 60;
        int rate = (totalMl * dropFactor) / totalMinutes; 
        return rate;
    }

    public double calculateDripPer5Sec() {
        int ratePerMinute = calculateRate();
        double ratePer5Sec = ratePerMinute / 12.0;
        return ratePer5Sec;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("輸液量を記載してください（例: 500）。");
        String infusionStr = br.readLine(); 
        int infusionMl = Integer.parseInt(infusionStr); 
        
        System.out.println("点滴を落とす時間を記載してください（例: 8）。");
        String dripStr = br.readLine();
        int dripHours = Integer.parseInt(dripStr);
        
        System.out.println("滴下係数を入力してください（成人セットなら20、小児なら60など）。");
        String factorStr = br.readLine();
        int dropFactor = Integer.parseInt(factorStr);
        
        InfusionOrder order = new InfusionOrder(infusionMl, dripHours, dropFactor);
        
        int result = order.calculateRate();
        double result5Sec = order.calculateDripPer5Sec();
        
        System.out.println("----------------------------------------");
        System.out.println("1分間の滴下数は、約 " + result + " 滴です。");
        System.out.println("5秒間では、約 " + result5Sec + " 滴です。");
    }
}
