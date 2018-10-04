import java.io.ObjectStreamClass;
import java.io.ObjectStreamField;
import java.util.Scanner;

public class ObjectReader {
    public static void main(String[] args) {
        ObjectStreamClass studentInfo= ObjectStreamClass.lookup(Students.class);

        ObjectStreamField[] studentsFields = studentInfo.getFields();
        for (ObjectStreamField oj: studentsFields) {
            System.out.println(" " + oj.getName() + " " + oj.getType() + " "+oj.getTypeCode());
        }
        System.out.println("\n------------------------------------------------------\n");

        ObjectStreamClass smartPhoneInfo = ObjectStreamClass.lookup(SmartPhone.class);
        ObjectStreamField[] smartPhoneFields = smartPhoneInfo.getFields();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the class name student/smartphone:\n");
        String classOption = scanner.next();
        Boolean smartPhone = classOption.toLowerCase().contains("smartphone"), student = classOption.toLowerCase().contains("student");
        if(!smartPhone && !student){
            System.err.println("Please Select valid class");
            System.exit(0);
        }
        System.out.println("Enter the variable name/type/value for searching:\n");
        String useroption = scanner.next();
        if(classOption.toLowerCase().contains("smartphone")){
           getObjectReader(smartPhoneFields,useroption);
        }else{
            getObjectReader(studentsFields,useroption);
        }


    }

    static void getObjectReader(ObjectStreamField[] objectStreamClass,String useroption){
        for (ObjectStreamField oj: objectStreamClass) {
            if(useroption.toLowerCase().equals(oj.getName().toLowerCase()) || useroption.toLowerCase().equals(String.valueOf(oj.getTypeCode()).toLowerCase()) || oj.getName().toLowerCase().contains(useroption.toLowerCase())){
                System.out.println(" " + oj.getName() + " " + oj.getType() + " "+oj.getTypeCode());
            }
        }
    }
}
