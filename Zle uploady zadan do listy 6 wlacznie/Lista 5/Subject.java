/**
 * Typ wyliczeniowy reprezentujący rodzaj zajec
 */
public enum LessonType {
    LECTURE, EXERCISES, LABORATORY
}

/**
 * Typ wyliczeniowy reprezentujący typ zaliczenia przedmiotu
 */
public enum CompletionType {
    EXAM, CREDIT 
}

/**
 * Klasa reprezentująca przedmiot w programie studiów
 */
public class Subject {
    private int ects;
    private int hours;
    private int semester;
    private LessonType lessonType;
    private CompletionType completionType;

    /**
     * Konstruktor klasy Subject
     *
     * @param ects           Liczba punktów ECTS przypisana do przedmiotu.
     * @param hours          Liczba godzin zajęć przypisana do przedmiotu.
     * @param semester       Numer semestru, na którym odbywa się przedmiot.
     * @param lessonType     Rodzaj lekcji (LECTURE, EXERCISES, LABORATORY).
     * @param completionType Typ zakończenia przedmiotu (EXAM, CREDIT).
     */
    public Subject(int ects, int hours, int semester, LessonType lessonType, CompletionType completionType) {
        this.ects = ects;
        this.hours = hours;
        this.semester = semester;
        this.lessonType = lessonType;
        this.completionType = completionType;
    }
}