// ============================================================
// Java Interfaces + Inheritance Teaching Example
// File: UniversityDemo.java
// ============================================================

interface Teachable {

    void teach();

    default void conductClass() {
        System.out.println("Conducting a class...");
    }

    static void showTeachingPolicy() {
        System.out.println("changed by S1     ");
    }
}

interface Researcher {

    void conductResearch();

    void publishPaper();
}

interface ScholarshipEligible {

    boolean isEligibleForScholarship();

    default void showScholarshipMessage() {
        System.out.println("Student can apply for scholarship.");
    }
}

// Interface inheritance
interface AdvancedResearcher extends Researcher {

    void attendConference();
}

// Abstract class
abstract class Person {

    protected int id;
    protected String name;
    protected String email;

    public Person(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public void displayBasicInformation() {
        System.out.println("ID    : " + id);
        System.out.println("Name  : " + name);
        System.out.println("Email : " + email);
    }

    public abstract void showRole();
}

// Person -> Student
class Student extends Person {

    protected String course;

    public Student(int id, String name, String email, String course) {
        super(id, name, email);
        this.course = course;
    }

    @Override
    public void showRole() {
        System.out.println("Role : Student");
    }

    public void attendLecture() {
        System.out.println(name + " is attending a lecture.");
    }
}

// Multilevel inheritance:
// Person -> Student -> UGStudent
class UGStudent extends Student {

    private int year;

    public UGStudent(
            int id,
            String name,
            String email,
            String course,
            int year) {

        super(id, name, email, course);
        this.year = year;
    }

    @Override
    public void showRole() {
        System.out.println("Role : Undergraduate Student");
    }

    public void writeExam() {
        System.out.println(name + " is writing an examination.");
    }
}

// Class extends a class and implements multiple interfaces
class GraduateStudent
        extends Student
        implements AdvancedResearcher, ScholarshipEligible {

    private String researchTopic;

    public GraduateStudent(
            int id,
            String name,
            String email,
            String course,
            String researchTopic) {

        super(id, name, email, course);
        this.researchTopic = researchTopic;
    }

    @Override
    public void showRole() {
        System.out.println("Role : Graduate Student");
    }

    @Override
    public void conductResearch() {
        System.out.println(
                name + " is researching: " + researchTopic);
    }

    @Override
    public void publishPaper() {
        System.out.println(
                name + " published a research paper.");
    }

    @Override
    public void attendConference() {
        System.out.println(
                name + " is attending an international conference.");
    }

    @Override
    public boolean isEligibleForScholarship() {
        return true;
    }
}

// Another child of Person
class Employee extends Person {

    protected double salary;

    public Employee(
            int id,
            String name,
            String email,
            double salary) {

        super(id, name, email);
        this.salary = salary;
    }

    @Override
    public void showRole() {
        System.out.println("Role : Employee");
    }

    public void work() {
        System.out.println(name + " is working.");
    }
}

// Employee -> Professor
// Professor also implements multiple interfaces
class Professor
        extends Employee
        implements Teachable, AdvancedResearcher {

    private String specialization;

    public Professor(
            int id,
            String name,
            String email,
            double salary,
            String specialization) {

        super(id, name, email, salary);
        this.specialization = specialization;
    }

    @Override
    public void showRole() {
        System.out.println("Role : Professor");
    }

    @Override
    public void teach() {
        System.out.println(
                name + " is teaching " + specialization);
    }

    @Override
    public void conductResearch() {
        System.out.println(
                name + " is conducting research in "
                        + specialization);
    }

    @Override
    public void publishPaper() {
        System.out.println(
                name + " published a research paper.");
    }

    @Override
    public void attendConference() {
        System.out.println(
                name + " is attending a conference.");
    }

    // Override interface default method
    @Override
    public void conductClass() {
        System.out.println(
                name + " is conducting an advanced class.");
    }
}

// Employee -> Administrator
class Administrator extends Employee {

    public Administrator(
            int id,
            String name,
            String email,
            double salary) {

        super(id, name, email, salary);
    }

    @Override
    public void showRole() {
        System.out.println("Role : Administrator");
    }

    public void manageDepartment() {
        System.out.println(
                name + " is managing the department.");
    }
}

// Another class implementing the same interface
class OnlineProfessor implements Teachable {

    @Override
    public void teach() {
        System.out.println(
                "Online professor is teaching online.");
    }
}

// Main class
public class UniversityDemo {

    // Interface-based polymorphism
    public static void startTeaching(Teachable teacher) {
        teacher.teach();
    }

    public static void main(String[] args) {

        System.out.println(
                "========== GRADUATE STUDENT ==========");

        GraduateStudent gs =
                new GraduateStudent(
                        101,
                        "Rahul",
                        "rahul@university.com",
                        "M.Tech Computer Science",
                        "Artificial Intelligence");

        gs.displayBasicInformation();
        gs.showRole();
        gs.attendLecture();
        gs.conductResearch();
        gs.publishPaper();
        gs.attendConference();
        gs.showScholarshipMessage();

        System.out.println(
                "\n========== PROFESSOR ==========");

        Professor professor =
                new Professor(
                        201,
                        "Dr. Sharma",
                        "sharma@university.com",
                        120000,
                        "Machine Learning");

        professor.displayBasicInformation();
        professor.showRole();
        professor.work();
        professor.teach();
        professor.conductClass();
        professor.conductResearch();
        professor.publishPaper();
        professor.attendConference();

        System.out.println(
                "\n========== UNDERGRADUATE STUDENT ==========");

        UGStudent ug =
                new UGStudent(
                        102,
                        "Amit",
                        "amit@university.com",
                        "B.Tech Computer Science",
                        3);

        ug.displayBasicInformation();
        ug.showRole();
        ug.attendLecture();
        ug.writeExam();

        System.out.println(
                "\n========== ADMINISTRATOR ==========");

        Administrator admin =
                new Administrator(
                        301,
                        "Priya",
                        "priya@university.com",
                        80000);

        admin.displayBasicInformation();
        admin.showRole();
        admin.work();
        admin.manageDepartment();

        System.out.println(
                "\n========== CLASS POLYMORPHISM ==========");

        Person p1 = gs;
        Person p2 = professor;
        Person p3 = ug;
        Person p4 = admin;

        p1.showRole();
        p2.showRole();
        p3.showRole();
        p4.showRole();

        System.out.println(
                "\n========== INTERFACE POLYMORPHISM ==========");

        Researcher researcher = gs;

        researcher.conductResearch();
        researcher.publishPaper();

        Teachable teacher = professor;

        teacher.teach();
        teacher.conductClass();

        ScholarshipEligible scholarshipStudent = gs;

        System.out.println(
                "Scholarship eligible: "
                        + scholarshipStudent.isEligibleForScholarship());

        System.out.println(
                "\n========== STATIC INTERFACE METHOD ==========");

        Teachable.showTeachingPolicy();

        System.out.println(
                "\n========== SAME INTERFACE, DIFFERENT CLASSES ==========");

        startTeaching(professor);

        OnlineProfessor onlineProfessor =
                new OnlineProfessor();

        startTeaching(onlineProfessor);

        System.out.println(
                "\n========== INSTANCEOF ==========");

        if (gs instanceof Student) {
            System.out.println(
                    "GraduateStudent IS-A Student");
        }

        if (gs instanceof Person) {
            System.out.println(
                    "GraduateStudent IS-A Person");
        }

        if (gs instanceof Researcher) {
            System.out.println(
                    "GraduateStudent IS-A Researcher");
        }

        if (professor instanceof Employee) {
            System.out.println(
                    "Professor IS-A Employee");
        }

        if (professor instanceof Teachable) {
            System.out.println(
                    "Professor IS-A Teachable");
        }
    }
}
