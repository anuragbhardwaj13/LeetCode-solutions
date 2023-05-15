//{ Driver Code Starts
import java.util.*;



class Get_Min_From_Stack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
					//System.out.println(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
		
	}
}



// } Driver Code Ends


class GfG
{
    Stack<Integer> s=new Stack<>();;
    Stack<Integer> ss=new Stack<>(); 
   

    /*returns min element from stack*/
    int getMin()
    {
	// Your code here
	 if(ss.isEmpty()){
            return -1;
        }
        return ss.peek();
    }
    
    /*returns poped element from stack*/
    int pop()
    {
	// Your code here
	if(s.isEmpty()){
            return -1;
        }else{
            int x=s.pop();
            if(x==ss.peek()){
                ss.pop();
            
            }
            return x;
        }
    }

    /*push element x into the stack*/
    void push(int val)
    {
	// Your code here
	  if(s.isEmpty()){
            s.push(val);
            ss.push(val);
        }else{
            s.push(val);
            if(ss.peek()>=val){
                ss.push(val);
            }
        }
    }	
}

