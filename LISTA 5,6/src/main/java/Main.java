public class Main {
    public static void main(String[] args) {
        Courses courses = new Courses();

        courses.addSubject("MAT101", "Matematyka", 5, 60, 1, LessonType.LECTURE, CompletionType.EXAM);
        courses.addSubject("PHY101", "Fizyka", 4, 45, 1, LessonType.LABORATORY, CompletionType.CREDIT);
        courses.addSubject("CS101", "Podstawy programowania", 6, 75, 2, LessonType.EXERCISES, CompletionType.EXAM);

        courses.exportSubjectsToJson("courses.json");
    }
}
