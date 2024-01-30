package APCSUnit5;
import java.util.*;

public class FractionQuizGame {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while(!(sc.nextLine().equals("quit"))) {
                FractionQuizGame first = new FractionQuizGame();
                FractionQuizGame second = new FractionQuizGame();
                int choice = (int)(Math.random() * 4)+1;
                FractionQuizGame answer;
                if(choice == 0) {
                    answer = new FractionQuizGame(FractionQuizGame.add(first, second));
                    System.out.println(first.getNum() + "/" + first.getDemon() +" + "+ second.getNum() + "/" + second.getDemon() + " =");
                } else if(choice == 1) {
                    answer = new FractionQuizGame(FractionQuizGame.substract(first, second));
                    System.out.println(first.getNum() + "/" + first.getDemon() +" - "+ second.getNum() + "/" + second.getDemon() + " =");
                } else if(choice == 2) {
                    answer = new FractionQuizGame(FractionQuizGame.multiply(first, second));
                    System.out.println(first.getNum() + "/" + first.getDemon() +" * "+ second.getNum() + "/" + second.getDemon() + " =");
                } else {
                    answer = new FractionQuizGame(FractionQuizGame.divide(first, second));
                    System.out.println(first.getNum() + "/" + first.getDemon() +" / "+ second.getNum() + "/" + second.getDemon() + " =");
                }
                String str = sc.nextLine();
                System.out.println(answer.getNum() + "/"+ answer.getDemon());
                FractionQuizGame response =  new FractionQuizGame(str);
                if(FractionQuizGame.compare(response, answer)) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Wrong Answer!");
                }
                
            }
            sc.close();
            System.out.println("Game Finished");
        }


        private Double numerator;
        private Double denominator;
        public FractionQuizGame() {
            numerator = (double)(int)(Math.random()*9)+1;
            denominator = (double)(int)(Math.random()*9)+1;
        }
        public FractionQuizGame(Double num, Double den) {
            if(den != 0) {
                denominator = den;
                numerator = num;
            } else {
                System.out.println("Math error");
            }
        }
        public FractionQuizGame(String str) {
            numerator = Double.parseDouble(str.split("/")[0]);
            if(Double.parseDouble(str.split("/")[1]) != 0) {
                denominator = Double.parseDouble(str.split("/")[1]);
            } else {
                System.out.println("Math error");
            }
        }
        
        public FractionQuizGame(FractionQuizGame f) {
            denominator = f.getDemon();
            numerator = f.getNum();
        }
        public Double getNum() {
            return numerator;
        } 
        public Double getDemon() {
            return denominator;
        }
        public String toString() {
            String x = numerator + "/" + denominator;
            return x;
        }
        public Double toDouble() {
            Double x = numerator/denominator;
            return x;
        }
        public void reduce() {
            denominator = denominator/GCF(denominator, numerator);
            numerator = numerator/GCF(denominator, numerator);
        }
        public void setNum(Double newNum) {
            numerator = newNum;
        }
        public void setDenom(Double newDenom) {
            denominator = newDenom;
        }
        public static FractionQuizGame multiply(FractionQuizGame x, FractionQuizGame y) {
            FractionQuizGame a = new FractionQuizGame(x.getNum()*y.getNum(), x.getDemon()*y.getDemon());
            a.reduce();
            return a;
        }
        public static FractionQuizGame divide(FractionQuizGame x, FractionQuizGame y) {
            FractionQuizGame a = new FractionQuizGame(x.getNum()*y.getDemon(), x.getDemon()*y.getNum());
            a.reduce();
            return a;
        }
        public static FractionQuizGame add(FractionQuizGame x, FractionQuizGame y) {
            if(x.getNum() == 0) return y;
            if(y.getNum() == 0) return x;
            double num = x.getNum()*y.getDemon() + y.getNum()*x.getDemon();
            double denom = x.getDemon()*y.getDemon();
            FractionQuizGame a = new FractionQuizGame(num, denom);
            a.reduce();
            return a;
        }
        public static FractionQuizGame substract(FractionQuizGame x, FractionQuizGame y) {
            double num = x.getNum()*y.getDemon() - y.getNum()*x.getDemon();
            double denom = x.getDemon()*y.getDemon();
            FractionQuizGame a = new FractionQuizGame(num, denom);
            a.reduce();
            return a;
        }
        private double GCF(double a, double b) {
            if (a == 0) return b;
            return GCF(b % a, a);
        }
        public static boolean compare(FractionQuizGame x, FractionQuizGame y) {
            return (Double.valueOf(x.getNum()).compareTo(Double.valueOf(y.getNum())) == 0 && Double.valueOf(x.getDemon()).compareTo(Double.valueOf(y.getDemon())) == 0);
        }
}
