import java.util.*;
public class WaterJug_Generic_BestCaseOriented
{
    int ar[][];
    int ini[];
    int fin[];
    int n;
    int quant[];
    int pos=0;
    int answers[][]=new int[1000000][2];
    int count=0;
    public int check(int arr[],int st)
    {
        int k;
        for(int i=0;i<=pos;i++)
        {
            k=1;
            for(int j=0;j<n;j++)
            {
                if(ar[i][j]!=arr[j])
                {
                    k=0;
                    break;
                }
            }
            if(k==1 && st>ar[i][n])
            return 0;
        }
        return 1;
    }
    
    public void cal(int arr[],int st,int cn)
    {
        if(true)
        {
            int k=1;
            for(int i=0;i<n;i++)
            {
                if(arr[i]!=fin[i])
                {
                    k=0;
                    break;
                }
            }
            if(k==1)
            {
                System.out.println(st +" "+ cn + "$$");
                answers[count][0]=cn;
                answers[count][1]=st;
                count++;
            }
        }
        
        if(true)
        {
            int ar1[]=new int[n];
            for(int i=0;i<n;i++)
            {
               if(arr[i]==0)
               continue;
               for(int j=0;j<n;j++)
               {
                   if(i==j)
                   continue;
                   if(arr[j]==quant[j])
                   continue;
                   
                   for(int p=0;p<n;p++)
                   ar1[p]=arr[p];
                   
                   while(ar1[j]<quant[j] && ar1[i]!=0)
                   {
                       ar1[i]--;
                       ar1[j]++;
                   }
                   if(check(ar1,st+1)==1)
                   {
                        int y=pos++;
                        for(int p=0;p<n;p++)
                        ar[y][p]=ar1[p];
                        ar[y][n]=st+1;
                        ar[y][n+1]=cn;
                        
                        for(int ss=0;ss<n+2;ss++)
                        System.out.print(ar[y][ss]+" ");
                        System.out.print(" - "+y+" - ");
                        
                        System.out.println();
                        
                        cal(ar1,st+1,y);
                   }
               }
            }
        }
        
        if(true)
        {
            int ar1[]=new int[n];
            for(int i=0;i<n;i++)
            {
                if(arr[i]!=0)
                {
                    for(int j=0;j<n;j++)
                    ar1[j]=arr[j];
                    
                    ar1[i]=0;
                    if(check(ar1,st+1)==1)
                    {
                        int y=pos++;
                        for(int p=0;p<n;p++)
                        ar[y][p]=ar1[p];
                        ar[y][n]=st+1;
                        ar[y][n+1]=cn;
                        
                        for(int ss=0;ss<n+2;ss++)
                        System.out.print(ar[y][ss]+" ");
                        System.out.print(" - "+y+" - ");
                        System.out.println();
                        
                        cal(ar1,st+1,y);
                    }
                }
            }
        }
        
        if(true)
        {
            int ar1[]=new int[n];
            for(int i=0;i<n;i++)
            {
                if(arr[i]!=quant[i])
                {
                    for(int j=0;j<n;j++)
                    ar1[j]=arr[j];
                    
                    ar1[i]=quant[i];
                    if(check(ar1,st+1)==1)
                    {
                        int y=pos++;
                        for(int p=0;p<n;p++)
                        ar[y][p]=ar1[p];
                        ar[y][n]=st+1;
                        ar[y][n+1]=cn;
                        
                        for(int ss=0;ss<n+2;ss++)
                        System.out.print(ar[y][ss]+" ");
                        System.out.print(" - "+y+" - ");
                        System.out.println();
                        
                        cal(ar1,st+1,y);
                    }
                }
            }
        }
        
    }
    
    public void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Number of jugs");
        n=sc.nextInt();
        ini=new int[n];
        fin=new int[n];
        quant=new int[n];
        ar=new int[1000000][n+2];
        System.out.println("Enter the Quantities of jugs");
        for(int i=0;i<n;i++)
        System.out.println((i+1)+"th jug - "+(quant[i]=sc.nextInt()));
        
        System.out.println("Enter the Initial Quantities of the Jugs");
        for(int i=0;i<n;i++)
        System.out.println((i+1)+"th jug - "+(ini[i]=sc.nextInt()));
        
        System.out.println("Enter the Final Quantities of the Jugs");
        for(int i=0;i<n;i++)
        System.out.println((i+1)+"th jug - "+(fin[i]=sc.nextInt()));
        
        for(int i=0;i<n;i++)
        ar[pos][i]=ini[i];
        ar[pos][n]=1;
        ar[pos][n+1]=-9999;
        pos++;
        
        cal(ini,1,0);
        int min=answers[0][1],p=0;
        
        System.out.println("--------------------------------------------");
        for(int i=0;i<count;i++)
        {
            System.out.println(answers[i][0]+" "+answers[i][1]);
            if(answers[i][1]<min)
            {
                min=answers[i][1];
                p=i;
            }
        }
        System.out.println("--------------------------------------------");
        String str="";
        p=answers[p][0];
        while(true)
        {
            System.out.println(p);
            if(p==-9999)
            break;
            
            // str="\n"+str;
            String st="";
            for(int i=0;i<n;i++)
            st=st+" "+ar[p][i];
            str=st+"\n"+str;
            p=ar[p][n+1];
            boolean a=true;
        }
        System.out.println(str);
    }
}
