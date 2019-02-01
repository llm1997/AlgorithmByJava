package SatckAndQueue;

import java.util.Scanner;
import java.util.Stack;

//问题描述：设计一个有getMin功能的栈，要求入栈、出栈、getMin的时间复杂度为o(1)
//算法思想：
//1.使用2个栈，一个保存当前栈中的元素（正常栈）stackData，一个保存每一步的最小值StackMin
//2.正常入栈：假设元素A进栈，先压进stackData，然后元素A与stackMin栈顶元素B比较，若stackMin为空或者A小于或等于B，则A进栈，否则不做任何处理
//3.正常出栈：stackData栈顶元素A出栈，比较stackMin栈顶元素B，若A大于B，则A出栈，stackMin不做任何处理，若A小于或者等于B，则A和B都出栈
//4.获取最小值getMin:直接获取栈顶元素
public class Stack_getMin{
    private Stack<Integer> statckData;
    private Stack<Integer> stackMin;

    //构造函数
    public Stack_getMin(){
        this.statckData=new Stack<Integer>();
        this.stackMin=new Stack<Integer>();

    }

    //进栈
    public  void push(int newNum)
    {
        if(this.stackMin.isEmpty())
        {
            this.stackMin.push(newNum);
        }
        else if(newNum<=this.getMin())
        {
            this.stackMin.push(newNum);
        }
        this.statckData.push(newNum);
    }

    //出栈
    public int pop()
    {
        if(this.statckData.isEmpty())
        {
            throw new RuntimeException("your stack is empty.");
        }
        int value=this.statckData.pop();
        if(value==this.getMin())
        {
            this.stackMin.pop();
        }
        return value;
    }

    //获取最小值
    public int getMin()
    {
        if(this.stackMin.isEmpty())
        {
            throw new RuntimeException("your stack is empty.");
        }
        return this.stackMin.peek();
    }

    //测试
    public static void main(String[] args)
    {
        Stack_getMin sg=new Stack_getMin();
        int newNum;

        menus();
        Scanner sc=new Scanner(System.in);
        int flag=sc.nextInt();
        while (flag!=4)
        {

            switch (flag)
            {
                case 1:System.out.println("请输入您想入栈的数:");newNum=sc.nextInt();sg.push(newNum);break;
                case 2:sg.pop();System.out.println("出栈成功！当前栈大小:"+sg.statckData.size());break;
                case 3:System.out.println("当前最小值:"+sg.getMin());break;

            }
            menus();flag=sc.nextInt();
        }

    }

    //菜单函数
    public static void menus()
    {
        System.out.println("1.入栈  2.出栈");
        System.out.println("3.最小  4.退出");
    }
}
