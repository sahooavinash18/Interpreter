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

 //This class write value on top of stack in output

public class WriteCode extends ByteCode 
{

    public void runvm(VirtualMachine virtualMachine) 
    {
	System.out.println(virtualMachine.peekRunStack());
    }
    
    public void init(Vector<String> byteCodetype) 
    {
	this.byteCodetype = byteCodetype.get(0);
    }
}