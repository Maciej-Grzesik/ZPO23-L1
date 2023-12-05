import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Courses {
    private final Map<String, Subject> courses;

    /**
     * Konstruktor klasy Courses
     */
    public Courses() {
        this.courses = new HashMap<>();
    }

    /**
     * Metoda dodajaca kurs do mapy
     *
     * @param name     nazwa kursu, klucz mapy
     * @param ects     liczba punktow ects
     * @param hours    ilosc godzin
     * @param semester semest
     */
    public void addSubject(String code, String name, int ects, int hours, int semester, LessonType lessonType, CompletionType completionType) {
        Subject add = new Subject(name,ects, hours, semester, lessonType, completionType);
        courses.put(code, add);
    }

    /**
     * Metoda usuwajaca kurs
     *
     * @param code nazwa kursu do usuniecia
     */
    public void removeSubject(String code) {
        if (courses.containsKey(code)) {
            courses.remove(code);
        } else {
            throw new IllegalArgumentException("There is no course under the code:" + code);
        }
    }

    /**
     * Metoda pozysukjaca informacje o kursach
     *
     * @param name nazwa kursu
     */
    public void subjectInformation(String name) {
        if (courses.containsKey(name)) {
            System.out.println(courses.get(name));
        } else {
            throw new IllegalArgumentException("There's no course under the name: " + name);
        }
    }

    /**
     * Metoda pozyskujaca nazwy wszystkich kursow
     *
     * @return nazwy kursow
     */
    public Set<String> getNames() {
        return courses.keySet();
    }

    /**
     * Metoda pozwalajaca na uaktualnienie kursu
     *
     * @param name         nazwa kursu
     * @param updated_name nowa nazwa kursu
     * @param ects         nowa ilosc puntkow ects
     * @param hours        nowa ilosc godzin
     * @param semester     nowy semestr
     */
    public void updateSubject(String name, String updated_name, int ects, int hours, int semester, LessonType type, CompletionType completion) {
        if (courses.containsKey(name)) {
            Subject updated = new Subject(name, ects, hours, semester, type, completion);
            courses.remove(name);
            courses.put(updated_name, updated);
        } else {
            throw new IllegalArgumentException("There's no course under the name: " + name);
        }
    }

    /**
     * Metoda wykorzystująca strumienie do podliczenia calkowitej liczby godzin danego typu zajec
     * oraz sumy godzin i punktow ECTS zajec konczacych sie egzaminem
     *
     * @param lessonType Typ zajec, dla ktorego chcemy obliczyc calkowita liczbe godzin
     */
    public void calculateHoursAndECTSSum(LessonType lessonType) {
        long totalHoursOfType = courses.values().stream()
                .filter(subject -> subject.getLessonType() == lessonType)
                .mapToLong(Subject::getHours)
                .sum();

        long totalHoursAndECTSOfExamSubjects = courses.values().stream()
                .filter(subject -> subject.getCompletionType() == CompletionType.EXAM)
                .mapToLong(Subject::getHours)
                .sum();

        int totalECTSOfExamSubjects = courses.values().stream()
                .filter(subject -> subject.getCompletionType() == CompletionType.EXAM)
                .mapToInt(Subject::getEcts)
                .sum();

        System.out.println("Total hours of " + lessonType + ": " + totalHoursOfType);
        System.out.println("Total hours of subjects ending with exam: " + totalHoursAndECTSOfExamSubjects);
        System.out.println("Total ECTS of subjects ending with exam: " + totalECTSOfExamSubjects);
    }
    public void exportSubjectsToJson(String filePath) {
        JSONArray subjectsArray = new JSONArray();

        for (Map.Entry<String, Subject> entry : courses.entrySet()) {
            Subject subject = entry.getValue();
            JSONObject subjectObject = new JSONObject();

            subjectObject.put("kod", entry.getKey());
            subjectObject.put("nazwa", subject.getName());
            subjectObject.put("ects", subject.getEcts());
            subjectObject.put("liczba_godzin", subject.getHours());
            subjectObject.put("semestr", subject.getSemester());
            subjectObject.put("typ", subject.getLessonType().toString());
            subjectObject.put("forma_zaliczenia", subject.getCompletionType().toString());

            subjectsArray.add(subjectObject);
        }

        try (FileWriter file = new FileWriter(filePath)) {
            file.write(subjectsArray.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void importSubjectsFromJson(String filePath) {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(filePath)) {
            JSONArray subjectsArray = (JSONArray) parser.parse(reader);

            for (Object obj : subjectsArray) {
                JSONObject jsonObject = (JSONObject) obj;

                String kod = (String) jsonObject.get("kod");
                String nazwa = (String) jsonObject.get("nazwa");
                int ects = Math.toIntExact((Long) jsonObject.get("ects"));
                int hours = Math.toIntExact((Long) jsonObject.get("liczba_godzin"));
                int semester = Math.toIntExact((Long) jsonObject.get("semestr"));

                LessonType lessonType = LessonType.valueOf((String) jsonObject.get("typ"));
                CompletionType completionType = CompletionType.valueOf((String) jsonObject.get("forma_zaliczenia"));

                courses.put(kod, new Subject(nazwa, ects, hours, semester, lessonType, completionType));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
