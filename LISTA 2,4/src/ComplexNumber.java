import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
import java.util.stream.Collectors;

/**
 * Klasa reprezentujaca liczbe zespolona dziedziczaca po klasie Vector2D
 */
class ComplexNumber extends Vector2D {
    /**
     * Konstruktor klasy ComplexNumber
     * @param x skladowa rzeczywista liczby zespolone
     * @param y skladowa urojona liczby zespolonej
     */
    public ComplexNumber(double x, double y){
        super(x, y);
    }
    /**
     * metoda zwracajaca skladowa rzeczywista liczby zespolonej
     * @return skladowa rzeczywista liczby zespolonej
     */
    public double Re() {
        return getX();
    }
    /**
     * metoda zwracajaca skladowa urojona liczby zespolonej
     * @return skladowa urojona liczby zespolonej
     */
    public double Im() {
        return getY();
    }
    /**
     * metoda zwracajaca tekstowa reprezentacje wykladnicza liczby zespolonej
     * @return tekstowa reprezentacja wykladnicza liczby zespolonej
     */
    public String exp() {
        return getModule() + "e(" + getArgument() + "i)";
    }
    /**
     * metoda zwracajaca tekstowa reprezentacje biegunowa liczby zespolonej
     * @return tekstowa reprezentacja biegunowa liczby zespolonej
     */
    public String polar() {
        return "z = (" + getModule() + "," + getArgument() + ")";
    }
    /**
     * metoda statyczna sluzaca do dodawania dwoch liczb zespolonych
     * @param cn1 pierwsza liczba zespolona
     * @param cn2 druga liczba zespolona
     * @return wynik dodawania dwoch liczb zespolonych
     */
    public static ComplexNumber add(ComplexNumber cn1, ComplexNumber cn2) {
        double Im = cn1.Im() + cn2.Im();
        double Re = cn1.Re() + cn2.Re();
        return new ComplexNumber(Re, Im);
    }
    /**
     * metoda statyczna sluzaca do odejmowania dwoch liczb zespolonych
     * @param cn1 pierwsza liczba zespolona
     * @param cn2 druga liczba zespolona
     * @return wynik odejmowania dwoch liczb zespolonych
     */
    public static ComplexNumber subtract(ComplexNumber cn1, ComplexNumber cn2) {
        double Im = cn1.Im() - cn2.Im();
        double Re = cn1.Re() - cn2.Re();
        return new ComplexNumber(Re, Im);
    }
    /**
     * metoda statyczna sluzaca do mozenia dwoch liczb zespolonych
     * @param cn1 pierwsza liczba zespolona
     * @param cn2 druga liczba zespolona
     * @return wynik mnozenia dwoch liczb zespolonych
     */
    public static ComplexNumber multiply(ComplexNumber cn1, ComplexNumber cn2) {
        double Re = cn1.Re() * cn2.Re() - cn1.Im() * cn2.Im();
        double Im = cn1.Re() * cn2.Im() + cn1.Im() * cn2.Re();
        return new ComplexNumber(Re, Im);
    }
    /**
     * metoda statyczna sluzaca do dzielenia dwoch liczb zespolonych
     * @param cn1 pierwsza liczba zespolona
     * @param cn2 druga liczba zespolona
     * @return wynik dzielenia dwoch liczb zespolonych
     */
    public static ComplexNumber divide(ComplexNumber cn1, ComplexNumber cn2) {
        double div = cn2.Re() * cn2.Re() + cn2.Im() * cn2.Im();
        if (div == 0) {
            throw new ArithmeticException("Blad dzielenia przez zero");
        }
        double Re = (cn1.Re() * cn2.Re() + cn1.Im() * cn2.Im()) / div;
        double Im = (cn2.Re() * cn1.Im() - cn1.Re() * cn2.Im()) / div;
        return new ComplexNumber(Re, Im);
    }
    /**
     * metoda obliczajaca potege n liczby zespolonej
     * @param n potega
     * @return wynik potegowania liczby zespolonej
     */
    public ComplexNumber power(int n){
        double module = Math.pow(this.getModule(), n);
        double argument = this.getArgument() * n;
        double Re = module * Math.cos(argument);
        double Im = module * Math.sin(argument);
        return new ComplexNumber(Re, Im);
    }
    /**
     * metoda porownujaca dwie liczby zespolone
     * @param obj liczba zespolona do porownania
     * @return true, kiedy liczby zespolone sa rowne, false jesli nie sa
     */
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        ComplexNumber compare = (ComplexNumber) obj;
        return Re() == compare.Re() && Im() == compare.Im();
    }
    /**
     * metoda zwracajaca tekstowa reprezentacje liczby zespolonej
     * @return reprezentacja tekstowa liczby zespolonej
     */
    @Override
    public String toString() {
        return getX() + " + " + "i" + getY();
    }
    /**
     * Metoda pozwalajaca wprowadzic wartosci liczby zespolonej
     * @return nowa liczba zespolona
     * @throws InvalidComplexNumberFormat kiedy liczba zespolona wpisana jest w zlym formacie
     */
    public static ComplexNumber Input() throws InvalidComplexNumberFormat {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbe zespolona:");
        String input = scanner.nextLine().trim();

        String patternRe = "^([-+]?[0-9]*\\.?[0-9]+)$";
        String patternComplex = "^([-+]?[0-9]*\\.?[0-9]+)?\\s*([-+])?\\s*i\\s*([-+]?[0-9]*\\.?[0-9]*)?$";

        Pattern Real = Pattern.compile(patternRe);
        Pattern Complex = Pattern.compile(patternComplex);

        Matcher matchRe = Real.matcher(input);
        Matcher matchComplex = Complex.matcher(input);

        if (matchRe.find()) {
            double real = Double.parseDouble(input);
            return new ComplexNumber(real, 0); // Tworzenie liczby zespolonej z częścią rzeczywistą
        } else if (matchComplex.find()) {
            double real = Double.parseDouble(matchComplex.group(1) != null ? matchComplex.group(1) : "0");
            double imaginary = Double.parseDouble(matchComplex.group(3) != null ? matchComplex.group(3) : "0");

            if (matchComplex.group(2) != null && matchComplex.group(2).equals("-")) {
                imaginary *= -1; // Zmiana znaku części urojonej, jeśli jest "-"
            }

            return new ComplexNumber(real, imaginary); // Tworzenie liczby zespolonej z częścią rzeczywistą i urojoną
        } else {
            throw new InvalidComplexNumberFormat("Nieprawidłowy format liczby zespolonej");
        }
    }

    /**
     * Metoda odczytująca zawartość pliku o formacie podanym w zadaniu
     * @param filepath str: sciezka do pliku
     * @return Posortowana Mape względem kluczy (czasu) z wartościami odpowiadającymi liczbom zespolonym
     * @throws IOException podczas błedu odczytu input/output
     */
    public static Map<Double, ComplexNumber> readFromFile(String filepath){
        File data = new File(filepath);
        Map<Double, ComplexNumber> time_complex = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(data))) {
            String line;
            String[] arr;
            while ((line = br.readLine()) != null) {
                if (line.trim().indexOf("# t x+yi") == 0)
                    continue;
                arr = line.split(" ");
                String complexStr = arr[1];
                String[] complexParts = complexStr.split("(?=[+-])");//!!!!!!

                double x = 0.0;
                double y = 0.0;

                for (String part : complexParts) {
                    if (part.contains("i")) {
                        y = Double.parseDouble(part.replaceAll("i", ""));
                    } else {
                        x = Double.parseDouble(part);
                    }
                }
                ComplexNumber cn = new ComplexNumber(x, y);
                time_complex.put(Double.parseDouble(arr[0]), cn);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return time_complex.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    /**
     * Metoda zapisujaca do pliku wartosci czasu modulu i ergumentu dla zbioru liczb zespolonych
     * @param filepath str: sciezka do pliku
     * @param overwrite bool: true - jesli plik ma byc nadpisany w przeciwnym wypadku false
     * @param time_complex Map<Double, ComplexNumber>: mapa z czasem jako klucz i wartością ComplexNumber
     * @throws IOException podczas błedu odczytu input/output
     */
    public static void saveToFile(String filepath, boolean overwrite, Map<Double, ComplexNumber> time_complex) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath, !overwrite))) {
            bw.write("# t mod arg\n");
            for (Map.Entry<Double, ComplexNumber> entry : time_complex.entrySet()) {
                double t = entry.getKey();
                ComplexNumber cn = entry.getValue();
                double module = cn.getModule();
                double argument = cn.getArgument();

                bw.write(String.format("%.5f %.5f %.5f\n", t, module, argument));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}