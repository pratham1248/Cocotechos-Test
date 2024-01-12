import java.util.*;

class Student {
    String name;
    Map<String, Integer[]> subjects; 

    public Student(String name) {
        this.name = name;
        this.subjects = new HashMap<>();
    }
}

public class Question8 {
    public static void main(String[] args)
    {
        int numStudents = 20;
        List<Student> studentList = new ArrayList<>();

        // Generate random data for each student
        for (int i = 1; i <= numStudents; i++) {
            Student student = new Student("Student" + i);
            for (String subject : Arrays.asList("English", "Hindi", "Math1", "Math2", "Science")) {
                int totalMarks=0;
                if(subject.equals("English"))
                {
                    totalMarks=100;
                } 
                if(subject.equals("Hindi"))
                {
                    totalMarks=100;
                } 
                if(subject.equals("Math1"))
                {
                    totalMarks=70;
                } 
                if(subject.equals("Math2"))
                {
                    totalMarks=70;
                } 
                if(subject.equals("Science"))
                {
                    totalMarks=100;
                } 
                int marksScored = (int) (Math.random() * (totalMarks + 1)); // Random marks scored between 0 and total marks
                student.subjects.put(subject, new Integer[]{totalMarks, marksScored});
            }
            studentList.add(student);
        }

        String[] subject={"English", "Hindi", "Math1", "Math2", "Science"};
        // Find the top five students based on total marks
        Collections.sort(studentList, (s1, s2) -> {
            int totalMarks1=0;
            for(int i=0;i<5;i++)
            {
                totalMarks1=totalMarks1+s1.subjects.get(subject[i])[1];
            }
            int totalMarks2=0;
            for(int i=0;i<5;i++)
            {
                totalMarks2=totalMarks2+s2.subjects.get(subject[i])[1];
            }
            return Integer.compare(totalMarks2, totalMarks1);
        });

        // Display the top five students
        System.out.println("Top Five Students:");
        for (int i = 0; i < 5; i++) {
            Student student = studentList.get(i);
            int totalMarks=0;
            for(int j=0;j<5;j++)
            {
                totalMarks=totalMarks+student.subjects.get(subject[j])[1];
            }
            System.out.println(student.name + " - Total Marks: " + totalMarks);
        }

    }

}
