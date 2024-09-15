import java.util.Scanner;
class CalculatorEngine
{
    static char[]symbols={'/','*','-','+'};
    static String number;
    static double[]arr_numbers;
    static char[]arr_symbols;
    static int l, k;
    public static void main(String[]args)
    {
        System.out.println("\fPlease, enter an expression: ");
        number=new Scanner(System.in).nextLine()+" ";
        arr_symbols=new char[getNumberOfSymbols()];
        arr_numbers=new double[getNumberOfSymbols()+1];
        try
        {
            System.out.println("The answer is "+calculate());        
        }
        catch(Exception e)
        {
            System.out.println("Error in the expression!!!!!");
        }
    }

    public static int getNumberOfSymbols()
    {
        int count=0;
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<number.length();j++)
            {
                if(number.charAt(j)==symbols[i])
                    count++;
            }
        }
        return count;
    }    

    public static double calculate()
    {
        String num=number.charAt(0)=='-'||number.charAt(0)=='+'?"0":""; 
        double ans=0;
        try
        {
            ans=Double.parseDouble(number);
        }
        catch(Exception e)
        {
        }    
        int a=0;
        for(int i=0;i<number.length();i++)
        {
            if(!checkSymbol(number.charAt(i))&&number.charAt(i)!=' ')
                num+=number.charAt(i);
            else 
            {
                arr_numbers[a]=Double.parseDouble(num);
                num="";
                if(a<arr_symbols.length)
                    arr_symbols[a++]=number.charAt(i);
            }
        }  
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<arr_symbols.length;j++)
            {                
                if(arr_symbols[j]==symbols[i])
                {
                    switch(arr_symbols[j])
                    {
                        case '/':
                        ans=arr_numbers[j]/arr_numbers[j+1];
                        break;
                        case '*':
                        ans=arr_numbers[j]*arr_numbers[j+1];
                        break;
                        case '+':
                        ans=arr_numbers[j]+arr_numbers[j+1];
                        break;
                        case '-':
                        ans=arr_numbers[j]-arr_numbers[j+1];
                    }
                    update(ans,j); 
                    j=-1;
                }
            }
        }
        return ans;
    }

    public static boolean checkSymbol(char c)
    {
        for(int i=0;i<4;i++)
        {
            if(symbols[i]==c)
                return true;
        }
        return false;
    }

    public static void update(double ans,int j)
    {
        int a=0;
        for(int i=0;i<arr_symbols.length;i++)
        {
            if(i!=j)
                arr_symbols[a++]=arr_symbols[i];
        }
        arr_symbols[a]='.';
        a=0;
        for(int i=0;i<arr_numbers.length;i++)
        {
            if(i==j)
                arr_numbers[a++]=ans;
            if(i!=j&&i!=j+1)
                arr_numbers[a++]=arr_numbers[i];
        }
    }
}