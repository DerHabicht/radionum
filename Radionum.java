import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class Radionum {
    static boolean isValid(int n) {
        Integer d = null;
        boolean c = false;

        while (n > 0) {
            if ((d != null) && (d == (n % 10))) {
                if (c)
                    return false;
                c = true;
            } else {
                c = false;
            }

            d = n % 10;
            n /= 10;
        }

        return true;
    }

    static ArrayList<Integer> generateValidNumberList() {
        ArrayList<Integer> numberList = new ArrayList<>();

        for (int i = 10; i <= 99; ++i)
            if (isValid(i))
                numberList.add(i);

        for (int i = 1000; i <= 9999; ++i)
            if (isValid(i))
                numberList.add(i);

        for (int i = 100000; i <= 999999; ++i)
            if (isValid(i))
                numberList.add(i);

        return numberList;
    }

    static String format(ArrayList<Integer> numberList) {
        StringBuilder formattedListBuilder = new StringBuilder();

        for (Integer i : numberList) {
            formattedListBuilder.append(i.toString());
            formattedListBuilder.append("\n");
        }


        return formattedListBuilder.toString();
    }
    
    public static void main(String args[]) throws IOException {
        long t0 = System.nanoTime();

        ArrayList<Integer> numberList = generateValidNumberList();
        /*
        String formattedList = format(numberList);

        BufferedWriter out = new BufferedWriter(new FileWriter("valid_station_numbers-java.txt"));
        out.write(formattedList);
        out.close();
        */

        long t1 = System.nanoTime();

        long dt = (t1 - t0) / 1000000;
        System.out.println(dt);
    }
}
