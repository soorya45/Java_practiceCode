import java.util.Scanner;

public class sampppppp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int e = 0;
        int f = 0;
        int rubrics = 0;
        int percentage;
        int qa;
        int ia1;
        int ia2;
        int ia3;
        int Total = 0;

        
        System.out.println("----");
        System.out.println("----");
        
        System.out.print("Enter Attendance percentage: ");
        percentage = scan.nextInt();
        int attendanceMarks = calculateAttendance(percentage);
        Total += attendanceMarks;
        
        // Consume the newline character left in the buffer
        scan.nextLine();

        System.out.print("Enter QA mark: ");
        qa = scan.nextInt();
        System.out.print("Enter IA1 mark: ");
        ia1 = scan.nextInt();
        ia1 = Math.round(0.375f * ia1);
        System.out.print("Enter IA2 mark: ");
        ia2 = scan.nextInt();
        ia2 = Math.round(0.375f * ia2);
        
        // Consume the newline character left in the buffer
        scan.nextLine();
        System.out.println("******************************************");
        // IA3 course
        System.out.print("Did you complete the course? (yes/no): ");
        String status = scan.nextLine();
        int course = (status.equalsIgnoreCase("yes")) ? 10 : 0;
        System.out.println("******************************************");
        
        // IA3 innovation
        System.out.println("INNOVATION ");
        System.out.println("******************************************");
        System.out.print("Is the case study idea innovative? (yes/no): ");
        String innovativeIdea = scan.nextLine();
        
        if (innovativeIdea.equalsIgnoreCase("yes")) {
            a = 3;
        } else {
            System.out.print("Is the case study implementation innovative? (yes/no): ");
            String innovativeImplementation = scan.nextLine();
            
            if (innovativeImplementation.equalsIgnoreCase("yes")) {
                a = 2;
            } else {
                System.out.print("Is the case study useful? (yes/no): ");
                String usefulCaseStudy = scan.nextLine();
                
                if (usefulCaseStudy.equalsIgnoreCase("yes")) {
                    a = 1;
                } else {
                    System.out.print("Is the case study copied from the internet? (yes/no): ");
                    String copiedFromInternet = scan.nextLine();
                    
                    if (copiedFromInternet.equalsIgnoreCase("yes")) {
                        a = 0;
                    } else {
                        a = 0; 
                    }
                }
            }
        }
        System.out.println("******************************************");
        
        // IA3 Presentation and Viva
        System.out.println("PRESENTATION AND VIVA ");
        System.out.println("******************************************");
        System.out.print("Is there Clarity on the work and were all viva questions answered and the implementation bug-free and 100%? (yes/no): ");
        String clarityAndAnswers = scan.nextLine();
        if (clarityAndAnswers.equalsIgnoreCase("yes")) {
                b = 5;
        }

        if (b < 5) {
            // Clarity on the work and answering few viva questions, 80% implementation
            System.out.print("Is there Clarity on the work and were few viva questions answered and the implementation 80% complete? (yes/no): ");
            String someClarityAndAnswers = scan.nextLine();
            if (someClarityAndAnswers.equalsIgnoreCase("yes")) {
                    b = 4;
            }
        }
        if (b < 4) {
            // Clarity on the work, 50% implementation
            System.out.print("Is there Clarity on the work and the implementation 50% complete? (yes/no): ");
            String clarity = scan.nextLine();
            if (clarity.equalsIgnoreCase("yes")) {
                    b = 3;
            }
        }
        if (b < 3) {
            // Not clear on the work or less than 50% implementation
            b = 1;
        }
        System.out.println("******************************************");
        // IA3 Report
        System.out.println("REPORT ");
        System.out.println("******************************************");
        System.out.print("Well Formatted, Content Coverage, Grammar and Spelling (yes/no): ");
        String Well = scan.nextLine();
        if (Well.equalsIgnoreCase("yes")) {
                c = 5;
        }

        if (c < 5) {

            System.out.print("Content Coverage, Grammar and Spelling(yes/no): ");
            String Content = scan.nextLine();
            if (Content.equalsIgnoreCase("yes")) {
                    c = 4;
            }
        }
        if (c < 4) {

            System.out.print("Content Coverage(yes/no): ");
            String lack = scan.nextLine();
            if (lack.equalsIgnoreCase("yes")) {
                    c = 3;
            }
        }
        if (c < 3) {
            c = 1;
        }
        System.out.println("******************************************");
        // IA3 GCI
        System.out.println("GCI ");
        System.out.println("******************************************");
        System.out.print("Friendly GUI, Handling all kinds of input and output with following minimum requirements Layout-2, Listener-2, components-3, dialogue boxes-2(yes/no): ");
        String Friendly = scan.nextLine();
        if (Friendly.equalsIgnoreCase("yes")) {
                d = 5;
        }

        if (d < 5) {

            System.out.print("Missing one or two given requirements(yes/no): ");
            String Missing = scan.nextLine();
            if (Missing.equalsIgnoreCase("yes")) {
                    d = 4;
            }
        }
        if (d < 4) {

            System.out.print("Improper GCI(yes/no): ");
            String Improper = scan.nextLine();
            if (Improper.equalsIgnoreCase("yes")) {
                    d = 3;
            }
        }
        if (d < 3) {
            d = 1;
        }
        System.out.println("******************************************");
        // IA3 Database
        System.out.println("DATABASE ");
        System.out.println("******************************************");
        System.out.print("Proper usage of Object Oriented Concepts(yes/no): ");
        String Proper = scan.nextLine();
        if (Proper.equalsIgnoreCase("yes")) {
                e = 5;
        }

        if (e < 5) {

            System.out.print("Successful storage and retrieval of data(yes/no): ");
            String Successful = scan.nextLine();
            if (Successful.equalsIgnoreCase("yes")) {
                    e = 4;
            }
        }
        if (e < 4) {

            System.out.print("Creation of relational database yet no functionaliti(yes/no): ");
            String Creation = scan.nextLine();
            if (Creation.equalsIgnoreCase("yes")) {
                    e = 3;
            }
        }
        if (e < 3) {
            e = 1;
        }
        System.out.println("******************************************");
        // IA3 Concept Used
        System.out.println("CONCEPT USED ");
        System.out.println("******************************************");
        System.out.print("Appropriate implication of the following concepts:Interface/Abstract,Exception Handling(yes/no): ");
        String Abstract = scan.nextLine();
        if (Abstract.equalsIgnoreCase("yes")) {
                f = 7;
        }

        if (f < 7) {

            System.out.print("Inconsistency between concept used and application relevancy(yes/no): ");
            String application = scan.nextLine();
            if (application.equalsIgnoreCase("yes")) {
                    f = 5;
            }
        }
        if (f < 5) {

            System.out.print("Concept used yet application relevancy is not achieved(yes/no): ");
            String yet = scan.nextLine();
            if (yet.equalsIgnoreCase("yes")) {
                    f = 3;
            }
        }
        if (f < 3) {
            f = 2;
        }
        
        rubrics = course + a + b + c + d + e + f;
        ia3 = Math.round(0.375f * rubrics);
        Total += qa + ia1 + ia2 + ia3;
        System.out.println("IA3: " + rubrics);
        System.out.println("Total Marks: " + Total);

        scan.close();
    }

    public static int calculateAttendance(int percentage) {
        int attendanceMarks;

        if (percentage >= 95 && percentage <= 100) {
            attendanceMarks = 5;
        } else if (percentage >= 90 && percentage < 95) {
            attendanceMarks = 4;
        } else if (percentage >= 85 && percentage < 90) {
            attendanceMarks = 3;
        } else if (percentage >= 80 && percentage < 85) {
            attendanceMarks = 2;
        } else {
            attendanceMarks = 0;
        }
        return attendanceMarks;
    }
}
