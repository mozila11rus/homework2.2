import Exception.*;
public class Main {
    public static void main(String[] args) {
        String string = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        Main main = new Main();
        String[][] matrix = new String[4][4];
        try {
            matrix = main.stringToArray(string);
        } catch (IndexOutOfArrayException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(main.stringArrayToSumInt(matrix));
        } catch (NotANumber e) {
            e.printStackTrace();
        }
    }
    private String[][] stringToArray (String string) {
        int count = 0;
        String[][] str = new String[4][4];
        String[] subString = string.split("\\s");
        if (subString.length > (str.length * str.length)) {
            throw new IndexOutOfArrayException("Размер матрицы полученный из передаваемой строки больше чем 4Х4");
        } else {
            for (int i = 0; i < str.length; i++) {
                for (int j = 0; j < str.length; j++) {
                    str[i][j] = subString[count];
                    count++;
                }
            }
            return str;
        }
    }

    private int stringArrayToSumInt(String[][] string) {
        int sumInt = 0;
        boolean isNumber;
        for (int i = 0; i < string.length; i++) {
            for (int j = 0; j < string.length; j++) {
                try {
                    sumInt += Integer.parseInt(string[i][j]);
                    isNumber = true;
                } catch (NumberFormatException e) {
                    isNumber = false;
                }
                if (!isNumber) {
                    throw new NotANumber("В одной из ячеек массива не число");
                }
            }
        }
        return sumInt / 2;}
}
