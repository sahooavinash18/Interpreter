package interpreter;

import interpreter.bytecode.ByteCode;
import java.util.Stack;

public class VirtualMachine {
    
    private RunTimeStack runStack;
    private Stack returnAddrs; // push/pop when call/return functions
    private Program program; //bytecode program
    private int pc; //The program counter
    private boolean isRunning; //true while the VM is running
    
    boolean dump;
    boolean dumpStatus;
    
    //Constructor for VirtualMachine
    protected VirtualMachine(Program program) 
    {
        //initialize dump, dumpStatus and program
        this.program  = program;
        dump          = true;
	dumpStatus    = false;
    }
    
    public void executeProgram() 
    {
	
	runStack      = new RunTimeStack();
	returnAddrs   = new Stack();
	isRunning     = true;
        pc = 0;
        
        do {
	    // here we have taken help of dumpStatus to print DUMP ON	
            ByteCode code = program.getCode(pc);
		
		if(dump) 
                {
		    program.getBytecode(pc);
		}
                else if(dumpStatus  && !dump) 
                {
		    dumpStatus = false;
		}
		code.runvm(this);
		
		if(dump) 
                {
		    if(!dumpStatus) 
                    {
			System.out.println("DUMP ON");
			dumpStatus = true;
		    }
		    runStack.dump();
		}
		pc = pc +1;
                
	} while(isRunning);
    }
    
    //getter and setter methods for PC
    public int getPC() 
    {
        return pc;
    }
    
    public void setPC(int newPC) 
    {
        pc = newPC;
    }

    public void halt() 
    {
        isRunning = false; 
        dump = false;
    }
    
    public void dumpON() 
    {
        dump = true;
    }
    
    public void dumpOFF() 
    {
        dump = false;
    }
    
    public void pushRunStack(int runstack) 
    {
        runStack.push(runstack);
    }
    
    public int popRunStack() 
    {
        return runStack.pop();
    }
    
    public void pushReturnAddrs() 
    {
        returnAddrs.push(pc);
    }
    
    public int popReturnAddrs() 
    {
        return (Integer) returnAddrs.pop();
    }
    
    public void store(int integer) 
    {
        runStack.store(integer);
    }
    
    public void load(int integer) 
    {
        runStack.load(integer);
    }
    
    public void popFrame() 
    {
        runStack.popFrame();
    }
    
    public void pushFrame(int frameNum) 
    {
        runStack.newFrameAt(runStack.size() - frameNum);
    }
    
    public int peekRunStack() 
    {
        return runStack.peek();
    }
    
}
