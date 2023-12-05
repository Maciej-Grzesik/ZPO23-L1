public enum LessonType {
    LECTURE, EXERCISES, LABORATORY
}


public enum CompletionType {
    EXAM, CREDIT 
}


public class Subject {
    private int ects;
    private int hours;
    private int semester;
    private LessonType lessonType;
    private CompletionType completionType;

    public Subject(int ects, int hours, int semester, LessonType lessonType, CompletionType completionType) {
        this.ects = ects;
        this.hours = hours;
        this.semester = semester;
        this.lessonType = lessonType;
        this.completionType = completionType;
    }
}