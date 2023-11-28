import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Courses {
    private Map<String, Subject> courses;

    /**
     * Konstruktor klasy Courses
     */
    public Courses(){
        this.courses = new HashMap<>();
    }

    /**
     * Metoda dodajaca kurs do mapy
     * @param name nazwa kursu, klucz mapy
     * @param ects liczba punktow ects
     * @param hours ilosc godzin
     * @param semester semest
     */
    public void addSubject(String name, int ects, int hours, int semester, LessonType lessonType, CompletionType completionType) {
        Subject add = new Subject(ects, hours, semester, lessonType, completionType);
        courses.put(name, add);
    }

    /**
     * Metoda usuwajaca kurs
     * @param name nazwa kursu do usuniecia
     */
    public void removeSubject(String name){
        if (courses.containsKey(name)) {
            courses.remove(name);
        } else {
            throw new IllegalArgumentException("There is no course under the name:" + name);
        }
    }

    /**
     * Metoda pozysukjaca informacje o kursach
     * @param name nazwa kursu
     */
    public void subjectInformation(String name){
        if (courses.containsKey(name)){
            System.out.println(courses.get(name));
        } else {
            throw new IllegalArgumentException("There's no course under the name: " + name);
        }
    }

    /**
     * Metoda pozyskujaca nazwy wszystkich kursow
     * @return nazwy kursow
     */
    public Set<String> getNames(){
        return courses.keySet();
    }
    /**
     * Metoda pozwalajaca na uaktualnienie kursu
     * @param name nazwa kursu
     * @param updated_name nowa nazwa kursu
     * @param ects nowa ilosc puntkow ects
     * @param hours nowa ilosc godzin
     * @param semester nowy semestr
     */
    public void updateSubject(String name, String updated_name, int ects, int hours, int semester) {
        if (courses.containsKey(name)) {
            Subject updated = new Subject(ects, hours, semester);
            courses.remove(name);
            courses.put(updated_name, updated);
        } else {
            throw new IllegalArgumentException("There's no course under the name: " + name);
        }
    }
}