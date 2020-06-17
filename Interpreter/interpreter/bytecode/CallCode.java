/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.bytecode;

/**
 *
 * @author avinashsahoo
 */

import java.util.Vector;
import interpreter.VirtualMachine;

/**
 * Transfer goes to the function
 */

public class CallCode extends ByteCode 
{
    String functionName;
    int    resolveAddr;
    
    
    public void runvm(VirtualMachine virtualMachine) 
    {
	virtualMachine.pushReturnAddrs();
	virtualMachine.setPC(resolveAddr - 1);
    }
    
    public String labelName() 
    {
        //System.out.println("label name "  + functionName);
	return functionName; 
    }
    
    public void setAddress(int resolvedAddress) 
    {
	resolveAddr = resolvedAddress;
    }
    
    public void init(Vector<String> byteCodetype) 
    {
        functionName      = byteCodetype.get(1);
	this.byteCodetype = byteCodetype.get(0);
    }
 
}
