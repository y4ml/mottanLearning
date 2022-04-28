

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RecordBmi {

    //BMIを計算するための変数を用意する
    public double weight;
    public double height;

    //計算して結果を返す。
    public double getBmi() {
        double resBmi = this.weight / (this.height * this.height);
        //小数第３位を四捨五入して返す
        return Math.round(resBmi*100.0)/100.0;
    }

    //引数で数値を受け取って変数に格納する。
    public RecordBmi(double height, double weight) {
        this.weight = weight;
        this.height = height;
    }

    public static void main(String[] args) {
        //入力の準備
        Scanner scanner = new Scanner(System.in);

        //リストの準備
        var recordName = new ArrayList<String>();
        var recordHeight = new ArrayList<Double>();
        var recordWeight = new ArrayList<Double>();

        //無限ループ（名前に0が入力されるまで）
        for (var i = 1;; i++) {
            int sw1 = 0;
            int sw2 = 0;
            String inputValue;
            double height = 0;
            double weight = 0;

            //名前の入力の要求
            System.out.println("名前を入力してください（" + i + "件目）");
            String name = scanner.next();

            //0が入力されたら入力ループを脱出
            if (name.equals("0")) {
                break;
            }

            //身長の入力の要求
            //正しい数値が入力されるまで入力を要求
            while (sw1 == 0) {
                System.out.println("身長を入力してください(cm)");
                try {
                    height = Double.parseDouble(scanner.next()) / 100;
                    sw1 = 1;
                } catch (Exception e) {
                    //誤った入力を受けた時の処理
                    System.out.println("＊＊正しい数値を入力してください＊＊");
                    sw1 = 0;
                }
            }

            //体重の入力の要求
            //正しい数値が入力されるまで入力を要求
            while (sw2 == 0) {
                System.out.println("体重を入力してください(kg)");
                try {
                    weight = Double.parseDouble(scanner.next());
                    sw2 = 1;
                } catch (Exception e) {
                    //誤った入力を受けた時の処理
                    System.out.println(e + "＊＊正しい数値を入力してください＊＊");
                    sw2 = 0;
                    break;
                }
            }

            //リストに追加
            recordName.add(name);
            recordHeight.add(height);
            recordWeight.add(weight);

        }
        scanner.close();

        //テーブル表示の準備
        System.out.println("\n＊＊リストを表示します＊＊");
        System.out.println("＊＊＊＊＊＊＊＊＊＊＊＊＊");
        System.out.printf("%10s %15s %15s %7s", "NAME", "Height(cm)", "Weight(kg)", "BMI");
        System.out.println("");
        System.out.println("--------------------------------------------------");

        //レコードの数だけ繰り返して表示
        for (var i = 0; i <= recordName.size() - 1; i++) {
            RecordBmi cal = new RecordBmi(recordHeight.get(i), recordWeight.get(i));
            System.out.format("%10s %15s %15s %7s",
                    recordName.get(i), recordHeight.get(i)*100, recordWeight.get(i), cal.getBmi());
            System.out.println("");
        }

    }
}
