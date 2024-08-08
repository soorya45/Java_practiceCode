

class LengthException extends Exception {
    LengthException(String message) {
        super(message);
    }
}

class FailedException extends Exception {
    FailedException(String message) {
        super(message);
    }
}

class NotFirstClassException extends Exception {
    NotFirstClassException(String message) {
        super(message);
    }
}

class FirstClassException extends Exception {
    FirstClassException(String message) {
        super(message);
    }
}

class Student {
    private String name;
    private int[] subjectMarks = new int[3];

    public Student(String name, int[] subjectMarks) {
        this.name = name;
        this.subjectMarks = subjectMarks;
    }

    public void calculateAverageAndCheck() throws LengthException, FailedException, NotFirstClassException, FirstClassException {
        if (name.length() > 7) {
            throw new LengthException("Name length should not exceed 7 characters.");
        }

        int totalMarks = 0;
        for (int mark : subjectMarks) {
            totalMarks += mark;
        }

        double average = totalMarks / 3.0;
        if (average < 50) {
            throw new FailedException("Average marks less than 50. Student failed.");
        } else if (average >= 50 && average < 75) {
            throw new NotFirstClassException("Average marks between 50 and 75. Student did not achieve first class.");
        } else {
            throw new FirstClassException("Average marks greater than or equal to 75. Student achieved first class.");
        }
    }
}
public class Test7_2 {
    public static void main(String[] args) {
        String studentName = "Soorya";
        int[] marks = {31, 49, 45};
        try {
            Student student = new Student(studentName, marks);
            student.calculateAverageAndCheck();
            System.out.println("Student passed with first class.");
        } catch (LengthException | FailedException | NotFirstClassException | FirstClassException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}