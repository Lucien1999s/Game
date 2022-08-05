package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Invigilator {
    public boolean unprocessedData = false;
    private int count;
    private String Number,question;
    public synchronized int reportSituation(String Number,String question)  {
        while (unprocessedData){
            try {
                wait();
            }catch (InterruptedException e){}
        }
        String answer = "";
        this.Number=Number;
        this.question = question;
        System.out.println(Number+"的題目:"+question);
        try {
            BufferedReader cr =
                    new BufferedReader(new InputStreamReader(System.in));
            answer = cr.readLine();
        } catch (IOException e) {}

        if (answer.equals(question)) {
            count = 10;
            System.out.println("答對!");
        } else {
            count = 0;
            System.out.println("答錯!");
        }
        System.out.println(Number+"那，得 "+count+"分");

        unprocessedData = true;
        notify();
        return count;
    }
    public synchronized int getCount(){
        while (!unprocessedData){
            try {
                wait();
            }catch (InterruptedException e){}
        }
        int value = count;
        unprocessedData = false;
        notify();
        return value;
    }
}
