package example;

public class wordThread extends Thread{
    static int quantity=5;
    int total = 0;
    Invigilator a;
    String Number;
    public wordThread(Invigilator a,String Number){
        this.a=a;
        this.Number = Number;
    }
    public synchronized void run(){
        for(int i=0;i<quantity;i++){
            String question = GenerateRandomString.getRandomString(6);
            int count = a.reportSituation(Number,question);
            total+=count;
        }
    }
}
