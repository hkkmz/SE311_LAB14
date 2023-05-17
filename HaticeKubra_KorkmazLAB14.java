import java.util.ArrayList;
import java.util.*;

/*
    Hatice Kübra Korkmaz
    20160601107
 */
class Student {
    private static String name;
    private static int grade;
    public static String getName() {return name;}
    public static int getGrade(){return grade;}

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
}
//
abstract class CalculateGrade {

    ArrayList<Integer> grades = new ArrayList<Integer>();

    // These are Primitive Operations which will be overridden
    // by the subclasses. They are all abstract.
    protected abstract Boolean checkGrade();
    protected abstract Boolean printGrade();
    protected abstract Boolean adjustGrade();
    protected abstract Boolean calculateGrade();
    protected int _grade;
    public int getGrade() { return _grade;}
    // This is our template method.
    public void check() {
        prepareApplication ();
        Boolean status = checkGrade() && printGrade() &&
                adjustGrade() && calculateGrade();
        finalizeApplication(status);
    }
    // These are our concrete template operations.
    protected void prepareApplication () {
        System.out.println("Prepared grading criterias");
    }
    protected void finalizeApplication(Boolean status) {
        if ( status)
            System.out.println("Student passed");
        else
            System.out.println("Student failed");
    }
}

class CalculatebyMean extends  CalculateGrade {
    public	CalculatebyMean(int grade) { _grade = grade;}
    //other methods
    protected Boolean checkGrade() {
        System.out.println("Initializing grade...");
        return true;
    }
    protected Boolean printGrade() {
        System.out.println("Grade of the student "+Student.getName()+" is: "+Student.getGrade() );
        return true;
    }
    protected Boolean adjustGrade() {
        Collections.sort(this.grades);
        System.out.println("Adjusted the grade...");
        return true;
    }
    protected Boolean calculateGrade() {
        Double average = grades.stream().mapToInt(val -> val).average().orElse(0.0);
        System.out.println("Student "+Student.getName()+(Student.getGrade() < average?" Failed":" Passed"));
        //Student.getGrade() > average?true:false;
        if(Student.getGrade()>average){
            return true;
        }else
            return false;
    }
}

class CalculatebyMedian extends CalculateGrade {
    public CalculatebyMedian(int grade) { _grade = grade;}
    protected Boolean checkGrade() {
        System.out.println("Initializing grade...");
        return true;
    }
    protected Boolean printGrade() {
        System.out.println("Grade of the student "+Student.getName()+" is: "+Student.getGrade() );
        return true;
    }
    protected Boolean adjustGrade() {
        Collections.sort(this.grades);
        System.out.println("Adjusted the grade...");
        return true;
    }
    protected Boolean calculateGrade() {
        double middle = (grades.get(grades.size()/2) + grades.get(grades.size()/2 - 1))/2;
        System.out.println("Student "+Student.getName()+(Student.getGrade() < middle?" Failed":" Passed"));
        if(Student.getGrade()>middle){
            return true;
        }else
            return false;
    }
}

class CalculatebyStandarts extends CalculateGrade {
    public CalculatebyStandarts(int grade) { _grade = grade;}
    protected Boolean checkGrade() {
        System.out.println("Initializing grade...");
        return true;
    }
    protected Boolean printGrade() {
        System.out.println("Grade of the student "+Student.getName()+" is: "+Student.getGrade() );
        return true;
    }
    protected Boolean adjustGrade() {
        Collections.sort(this.grades);
        System.out.println("Adjusted the grade...");
        return true;
    }
    protected Boolean calculateGrade() {
        System.out.println("Student "+Student.getName()+(Student.getGrade() < 60?" Failed":" Passed"));
        if(Student.getGrade()>60){
            return true;
        }else
            return false;
    }
}

public class HaticeKubraKorkmaz {
    public static void main(String[] args) {
        Student st1 = new Student("Kubra",80);
        Student st2 = new Student("Ali",70);
        Student st3 = new Student("Veli",90);
        Student st4 = new Student("Ayse",60);
        Student st5 = new Student("Fatma",100);

        ArrayList<Integer> grades = new ArrayList<Integer>();
        /*
        grades.add(st1.getGrade());
        grades.add(st2.getGrade());
        grades.add(st3.getGrade());
        grades.add(st4.getGrade());
        grades.add(st5.getGrade());
        */

        grades.add(80);
        grades.add(70);
        grades.add(90);
        grades.add(60);
        grades.add(100);

        CalculateGrade c = new CalculatebyMean(80);
        c.check();
        c = new CalculatebyMedian(80);
        c.check();
        c = new CalculatebyStandarts(80);
        c.check();

    }
}


