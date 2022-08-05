package example;

import java.util.Scanner;

public class Main {
        static int totals = 0;
        static int questioner = 2;
        static wordThread[] questions;
        public static void main(String[] args) {
            Invigilator a = new Invigilator();
            System.out.println("打字訓練:包含英文和數字，每題六個字元隨機排序，共十題，請依相應字元逐一輸入");
            System.out.print("普通模式請輸入\"normal\"，計時模式請隨便輸入:");

            Scanner scanner = new Scanner(System.in);
            String choose = scanner.next();

            long start = System.currentTimeMillis();
            questions = new wordThread[questioner];
            for(int i=1;i<=questioner;i++){
                questions[i-1] = new wordThread(a,"出題者"+i);
            }
            for (int i=0;i<questioner;i++){
                questions[i].start();
            }
            for (int i=0;i<questioner*wordThread.quantity;i++){
                totals+=a.getCount();
                System.out.println("目前分數:"+totals);
            }
            System.out.println("\n最終分數:");

            for(int i=0;i<questioner;i++){
                System.out.println(questions[i].Number+":"+questions[i].total);
            }
            long end = System.currentTimeMillis();
            long extra = (end-start)/5000;
            System.out.println("------------------------");
            if (choose.equals("normal")){
                System.out.println("普通模式加總--");
                System.out.println("總成績:"+totals);
            }else {
                System.out.println("計時模式加總--");
                System.out.println("花費"+(end-start)/1000+"秒,扣"+extra*5+"/5 = "+extra+"分");
                System.out.println("總成績:"+(totals-extra));
            }
    }
}
