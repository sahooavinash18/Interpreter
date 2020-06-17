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

 //This class is used to load method in virtual machine

public class LoadCode extends ByteCode 
{
    int    offsetVal;
    String variable;
    
    public void runvm(VirtualMachine virtualMachine) 
    {
	virtualMachine.load(offsetVal);
    }

    public void init(Vector<String> typeOffsetVar) 
    {
        variable      = typeOffsetVar.get(2);
        offsetVal     = Integer.parseInt(typeOffsetVar.get(1));
	byteCodetype  = typeOffsetVar.get(0);
    }
 
}
