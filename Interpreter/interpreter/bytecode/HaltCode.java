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
 * To execute HALT
 */

public class HaltCode extends ByteCode 
{
    
    public void runvm(VirtualMachine virtualMachine) 
    {
	virtualMachine.halt();
    }

    public void init(Vector<String> byteCodetype) 
    {
	this.byteCodetype = byteCodetype.get(0);
    }
    
}