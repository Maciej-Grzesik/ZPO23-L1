public class coursesTest {
    public static void main(String[] args){
        Courses courses = new Courses();
        courses.addSubject("Algebra", 3,30,1);
        courses.addSubject("Zawansowane Programowanie Obiektowe", 3,30,5);
        courses.addSubject("Filozofia", 2,30,2);
        System.out.println(courses.getNames());
        courses.subjectInformation("Algebra");
        courses.removeSubject("Filozofia");
        System.out.println(courses.getNames());
        courses.updateSubject("Algebra", "Algebra Liniowa", 5, 45, 5);
        courses.subjectInformation("Algebra Liniowa");
    }
}
