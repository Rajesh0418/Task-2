import java.util.*;  
class StudentGradeCalculator
{
    public static String  studentGradeCalculator(int average) //this method returns the grade of a student based on their average marks
    {
        if(average>90 && average<100)
        {
            return "A";
        }
        else if(average>80 && average<=90)
        {
            return "B";
        }
        else if(average>70 && average<=80)
        {
            return "C";
        }
        else if(average>60 && average<=70)
        {
            return "D";
        }
        else if(average>50 && average<=60)
        {
            return "E";
        }
        else
        {
            return "F";
        }
    }
    public static void main(String args[])
    {
        ArrayList<Integer> allIds=new ArrayList<Integer>(); //storing the all ID's of the students
        ArrayList<String> addName=new ArrayList<String>();  //storing the all Name's of the students
        ArrayList<Integer> addTotalMarks=new ArrayList<Integer>(); //storing the all TotalMarks of the students
        ArrayList<String> addGrade=new ArrayList<String>(); //storing the all Grade's of the students
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter how many students data you want to store : "); //how students data you want to store
        int noOfStudents=sc.nextInt();
        System.out.print("Enter number of subjects : "); //No. of subjects
        int noOfSubjects=sc.nextInt();
        int subject=0;
        for(int j=0;j<noOfStudents;j++)
        {
             int total=0;
             System.out.println();
             System.out.print("Enter Student "+(j+1)+ " name : ");  
             String s=sc.next();
             addName.add(s);  //adding Name to the arraylist of addName
             System.out.print("Enter Student "+(j+1)+ " id : ");
             int id=sc.nextInt();
             allIds.add(id);   //adding allIds to the arraylist of allIds
             System.out.println("Enter  "+s+" obtained marks : ");
             for(int i=0;i<noOfSubjects;i++)
             {
                  System.out.print("Subject "+(i+1)+" marks : ");
                  subject=sc.nextInt();
                  if(subject>100)        //if user enters above 100 this will not take
                  {
                      System.out.println("Please enter the marks in only out of '100' ");
                      i--;   //this decrement operation is used for user can enter the same subject marks again..because user enters the INVALID data
                      continue;
                  }
                  else if(subject<35)     //if student marks is less than 35, then he fail in that subject
                  {
                      System.out.println("The student "+(j+1)+"  is FAIL in subject "+(i+1));
                      break;
                  }
                  total+=subject;
             }
             System.out.println((s)+" got : "+total+"/"+(100*noOfSubjects));
             addTotalMarks.add(total);   //adding Totalmarks to the arraylist of addTotalMarks
             int average=total/noOfSubjects;
             System.out.println("The average percentage of the "+(s)+" : "+(average));
             String avg=studentGradeCalculator(average);
             System.out.print("The "+(s)+" GRADE is : "+avg);
             addGrade.add(avg);   //adding Grade to the arraylist of addGrade
             System.out.print("\n");
             System.out.println("---------------------------------------");
        }
        boolean t=true;
        do{                           
           System.out.println();
           System.out.println("1.Display the all students status");
           System.out.println("2.Remove a student data");
           System.out.println("3.Add a new student data");
           System.out.println("4.Particular student status");
           System.out.print("Enter your choice : ");
           int choice=sc.nextInt();
           System.out.println();
           int findId=0;
           switch(choice)
           {
              case 1:
                       System.out.println("Name\tId\tGrade\tTotalMarks");
                       System.out.println("---------------------------------");
                       for(int i=0;i<allIds.size();i++)      //printing all the data in the tabular form
                       {
                           System.out.println(addName.get(i)+"\t"+allIds.get(i)+"\t  "+addGrade.get(i)+"\t  "+addTotalMarks.get(i));
                       } 
                       break;
              case 2:
                       System.out.print("Enter an ID of the student to remove : ");
                       int removeId=sc.nextInt();
                       findId=allIds.indexOf(removeId);
                       allIds.remove(findId);
                       addName.remove(findId);
                       addTotalMarks.remove(findId);
                       addGrade.remove(findId);
                       System.out.println("Student data is deleted in the records ");
                       break;
              case 3: 
                       System.out.print("Student Name : ");
                       String newName=sc.next();
                       addName.add(newName);
                       System.out.print("Student Id : ");
                       int newId=sc.nextInt();
                       allIds.add(newId);
                       int total1=0;
                       for(int k=0;k<noOfSubjects;k++)
                       {
                           System.out.print("Subject "+(k+1)+" marks : ");
                           subject=sc.nextInt();
                           if(subject>100)
                           {
                              System.out.println("Please enter the marks in only out of '100' ");
                               k--;
                               continue;
                           }
                           else if(subject<35)
                           {
                               System.out.println("The student "+(allIds.size()+k-1)+"  is FAIL in subject "+(k+1));
                               break;
                           }
                           total1+=subject;
                       }
                       System.out.println(newName+" got : "+total1+"/"+(100*noOfSubjects));
                       addTotalMarks.add(total1);
                       int average=total1/noOfSubjects;
                       String avg=studentGradeCalculator(average);
                       System.out.println("The "+(newName)+" GRADE is : "+avg);
                       addGrade.add(avg);
                       System.out.println("Student data is added in the records ");
                       System.out.print("\n");
                       System.out.println("---------------------------------------");
                       break;
               case 4:
                       System.out.print("Enter ID of the student to retrive the data  : "); //to retrive a particular student data
                       int parId=sc.nextInt();
                       System.out.println();
                       findId=allIds.indexOf(parId);
                       System.out.println("Name\tId\tGrade\tTotalMarks");
                       System.out.println("----------------------------------");
                       System.out.println(addName.get(findId)+"\t"+allIds.get(findId)+"\t  "+addGrade.get(findId)+"\t  "+addTotalMarks.get(findId));
                       break;
           }
           System.out.println();
           System.out.print("Any modications for enter '1'...else '0' : "); //any modifications then enter '1' else '0'
           int modify=sc.nextInt();
           if(modify==1)
           {
               t=true;
               System.out.println();
           }
           else if(modify==0) t=false;
        }while(t);
        
    }
}