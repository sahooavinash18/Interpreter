package interpreter;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;

/**
 * Records and processes the stack of active frames
 * When we call a function we'll push a new frame on the stack
 * when we return from a function we'll pop the top frame
 */

public class RunTimeStack {
    
    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;
    
    // Constructor for RunTimeStack
    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
	framePointer.add(0);
    }
    
    //print the runStack
    public void printStack() {
	int frameStart, frameEnd;
        int frameIndex = 0;
	Stack<Integer> tempStack = new Stack();
        
	do
        {
	  tempStack.push(framePointer.pop());
	} while(!framePointer.isEmpty());
    
	frameStart = tempStack.pop();
	framePointer.push(frameStart);
        
        //check if end of frame is also the end of runStack
	do {
	    
	    if(tempStack.isEmpty()) 
            {
		frameEnd = runTimeStack.size();
	    } 
            else 
            {
		frameEnd = tempStack.peek() - 1;
	    }

	    if(frameStart > frameEnd || runTimeStack.isEmpty()) 
            {
		System.out.print("[] ");
	    } 
            else 
            {
		if(frameIndex == frameStart) 
                {
		    System.out.print("[");
		}
                
                if(frameStart < frameEnd + 1) 
                {
		    System.out.print(runTimeStack.get(frameIndex));
		}
                
                if(frameIndex + 1 <= frameEnd - 1)
                {
		    System.out.print(",");
		}
                
                if(frameIndex + 1 >= frameEnd) 
                {
		    System.out.print("] ");
		}
		frameIndex = frameIndex + 1;
	    }
            
	    if(frameIndex >= frameEnd) 
            {
                if (!tempStack.isEmpty()) 
                {
                    frameStart = tempStack.pop();
                    framePointer.push(frameStart);
                }
	    }
	} while(frameIndex < runTimeStack.size());
        
	System.out.println();
    }
    
    //dumping of runtime stack
    public void dump() 
    {
	printStack();
    }
    
    public int peek() 
    {
        return runTimeStack.get(runTimeStack.size() - 1);
    }
    
    public int pop() 
    {
	return runTimeStack.remove(runTimeStack.size() - 1);
    }
    
    public int push(int num) 
    {
	runTimeStack.add(num);
	return num;
    }
    
    public void newFrameAt(int offset) 
    {
	framePointer.push(offset);
    }
    
    //push the value from top of the frame to the top of runtime stack
    public void popFrame() 
    {
        int pushValue, oldFrame, j;
	pushValue = runTimeStack.get(runTimeStack.size() - 1);
	oldFrame = framePointer.pop();
        j = runTimeStack.size();
        
        while (j > oldFrame)
        {
	    runTimeStack.remove(j - 1);
            j = j - 1;
	}
        
	push(pushValue);
    }
    
    //Returns the value popped from top of stack
    public int store(int offset) 
    {
        int location;
	location = framePointer.peek() + offset;
	return(runTimeStack.set(location, pop()));
    }
    
    //Returns the value pushed from top of stack
    public int load(int offset) {
        int retValue;
	retValue = runTimeStack.get(offset + framePointer.peek());
	return push(retValue);
    }
    
    public Integer push(Integer num) {
	runTimeStack.add(num);
	return num;
    }
    
    public int size() {
	return runTimeStack.size();
    }
    
}
