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


 //This class takes current function and pops the current frame out

public class ReturnCode extends ByteCode 
{
    int address;

    public void runvm(VirtualMachine virtualMachine) 
    {
	virtualMachine.popFrame();
	address = virtualMachine.popReturnAddrs();
	virtualMachine.setPC(address);
    }
    
    public void init(Vector<String> byteCodetype) 
    {
        String functionName;
        
	this.byteCodetype = byteCodetype.get(0);
    }
}
