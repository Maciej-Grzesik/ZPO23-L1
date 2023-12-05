package src;

/**
 * Klasa reprezentująca przedmiot w programie studiów
 */
public class Subject {
    private final int ects;
    private final int hours;
    private final int semester;
    private final LessonType lessonType;
    private final CompletionType completionType;

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

    public LessonType getLessonType() {
        return lessonType;
    }

    public int getEcts() {
        return ects;
    }

    public int getHours() {
        return hours;
    }

    public CompletionType getCompletionType() {
        return completionType;
    }

    public int getSemester() {
        return semester;
    }
}