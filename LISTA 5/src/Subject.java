public class Subject {
    private int ects;
    private int hours;
    private int semester;

    public Subject(int ects, int hours, int semester){
        this.ects = ects;
        this.hours = hours;
        this.semester = semester;
    }
    public int getEcts() {
        return ects;
    }
    public int getHours() {
        return hours;
    }
    public int getSemester() {
        return semester;
    }
    public String toString() {
        return ", ECTS: " + ects + ", Godziny: " + hours + ", Semestr: " + semester;
    }
}
