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
 * This class gets the element from the top of the stack. If it is 0, branch to label else execute bytecode.
 */

public class FalseBranchCode extends ByteCode 
{
    String labelName;
    int    newAddr;
    
    public void runvm(VirtualMachine virtualMachine) 
    {
	if(virtualMachine.popRunStack() == 0) 
        {
	   virtualMachine.setPC(newAddr - 1);
	}
    }

    public void setAddress(int address) 
    {
	newAddr = address;
    }
    
    public String labelName() 
    {
        //System.out.println("labelName123 " + labelName);
	return labelName;
    }
    
    public void init(Vector<String> byteCodetype) 
    {
	labelName              = byteCodetype.get(1);
        this.byteCodetype      = byteCodetype.get(0);
    }
   
}