import java.util.Scanner;
class Quiz
{
    public static char[] answers={'1','3','3','4','4'};
    public static int score=0;
    public static String[] questions=new String[5];
    public static String[] options=new String[5];
    public static char[] userans=new char[5];
    public static void main(String[] args)
    {
        quizApp();
    }
    public static void quizApp()
    {
        while(true)
        {
            System.out.println("=========================================================");
            System.out.println("\t\tQuiz Application");
            System.out.println("=========================================================");
            System.out.println("Time will be 5 Seconds for each Question");
            System.out.println("Score Will be Calculated \nCorrect Answer (+2) Wrong Answer (-1) Skip (0)");
            System.out.println("--------------------------------------");
            System.out.println("\t1.Mentor");
            System.out.println("\t2.Player");
            System.out.print("\tEnter Your Choice:");
            Scanner sc=new Scanner(System.in);
            int choice=sc.nextInt();
            System.out.println("---------------------------------------");
            if(choice==1)
                playQuiz();
            else if(choice==2)
                playQuiz();
            else    
                System.out.println("\tEnter Valid Choice(1 or 2)");
            sc.close();
        }
    }
    public static void playQuiz()
    {
        getQuestions();
    }
    public static void getQuestions()
    {
        
        questions[0]="Who invented C ?";
        questions[1]="Who invented C++ ?";
        questions[2]="Who invented Java ?";
        questions[3]="Who invented Phython ?";
        questions[4]="Who invented Rust ?";

        
        options[0]="\n1.Denis Richie\n2.Graydon Hoare\n3.Bjarne Stroustrup\n4.Guido Van Rossum";                 
        options[1]="\n1.Denis Richie\n2.Graydon Hoare\n3.Bjarne Stroustrup\n4.Guido Van Rossum"; 
        options[2]="\n1.Denis Richie\n2.Graydon Hoare\n3.James Gosling\n4.Guido Van Rossum";  
        options[3]="\n1.Denis Richie\n2.Graydon Hoare\n3.Bjarne Stroustrup\n4.Guido Van Rossum";  
        options[4]="\n1.Denis Richie\n2.James Gosling\n3.Bjarne Stroustrup\n4.Graydon Hoare";  
    
        int i=0;
        dispQuestions(i);
    }
    public static void dispQuestions(int i)
    {
        int status;
        Scanner sc=new Scanner(System.in);
        while(i<questions.length)
        {
            long start_time=System.currentTimeMillis();
            long end=start_time+5000;//5seconds
            System.out.println("Question : "+(i+1));
            System.out.print(questions[i]);
            System.out.print(options[i]);
            while(true)
            {
                System.out.print("\nDo You Want to Skip The Question (Y/N):");
                char skip=sc.next().charAt(0);
                if(skip=='n'||skip=='N')
                    break;
                else if(skip=='y'|| skip=='Y') 
                {
                    i++;
                    System.out.println("--------------------------------------");
                    dispQuestions(i);
                }
            }
            status=0;
            System.out.print("Player Ans : ");
            userans[i]=sc.next().charAt(0);
            long playeranstime=System.currentTimeMillis();
            if(playeranstime<end)
            {
                if(userans[i]==answers[i])
                        status=1;
                else  
                        status=2;
            }
            if(status==1)
            {
                score+=2; 
                System.out.println("\n\tRight Answer ");
                System.out.println("\tScore : "+score);
                System.out.println("--------------------------------------");
                i++;
            }     
            else if(status==2)
            {
                score+=-1; 
                System.out.println("\n\tWrong Answer\n\tCorrect Answer is : "+answers[i]);
                System.out.println("\tScore : "+score);
                System.out.println("--------------------------------------");
                i++;
            }
            else if(status==0)
            {
                System.out.println("\nSorry Time Out " );  
                System.out.println("\tScore : "+score); 
                System.out.println("--------------------------------------"); 
                i++;
            }
        }
        System.out.println("Total Score Obtained :"+score+"/10");
        if(score > 0)
            System.out.println("Percentage           : "+(score*100/10)+"%");     
        else if(score<=0)
            System.out.println("Percentage         : 0%");
        System.out.println("---------------------------------------");
        System.out.print("\nDo You Want to Play Again(Y/N):");
        char ch=sc.next().charAt(0);
        if(ch=='n'||ch=='N')
            System.exit(0);
        else
        {
            score=0; 
            quizApp();
        }     
    }
}