import java.io.*;
import java.util.Map;

public class SaveToFileExample {
    public static void main(String[] args) {
        // Załadowana mapa z metody readFromFile
        Map<Double, ComplexNumber> timeComplex = ComplexNumber.readFromFile("data.dat");
        //System.out.println(timeComplex);
        String filepath = "output_data.out"; // Ścieżka do pliku wyjściowego

        //Zapis do pliku
        saveToFile(filepath, true, timeComplex);
    }

    public static void saveToFile(String filepath, boolean overwrite, Map<Double, ComplexNumber> timeComplex) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath, !overwrite))) {
            bw.write("# t mod arg\n");
            for (Map.Entry<Double, ComplexNumber> entry : timeComplex.entrySet()) {
                double t = entry.getKey();
                ComplexNumber cn = entry.getValue();
                double module = cn.getModule();
                double argument = cn.getArgument();

                bw.write(String.format("%.5f %.5f %.5f\n", t, module, argument));
            }
            System.out.println("Dane zostały zapisane do pliku: " + filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}