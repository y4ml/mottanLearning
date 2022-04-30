public class CalcBmi {
    //BMIを計算するための変数を用意する
    private double weight;
    private double height;

    //計算して結果を返す。
    public double getBmi() {
        double resBmi = getWeight() / (getHeight() * getHeight());
        //小数第３位を四捨五入して返す
        return Math.round(resBmi*100.0)/100.0;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }


    //引数で数値を受け取って変数に格納する。
    public CalcBmi(double height, double weight) {
        setWeight(weight);
        setHeight(height);
    }

}
