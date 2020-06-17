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
 * VM should dump the runStack, checks and Turns on or off 
 */

public class DumpCode extends ByteCode 
{
    String vmstate;

    public void runvm(VirtualMachine virtualMachine) 
    {
        System.out.println("state " + vmstate);
        
        if("ON".equals(vmstate)) 
        {
	    virtualMachine.dumpON();
        }
        else 
        {
	    virtualMachine.dumpOFF();
        }
    }
    
    public void init(Vector<String> byteCodetype) 
    {
        vmstate              = byteCodetype.get(1);
	this.byteCodetype    = byteCodetype.get(0);
    }
    
}