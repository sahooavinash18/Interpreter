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

 //This class create a new frame from runStack 

public class ArgsCode extends ByteCode
{
    int argumentCount;
    
    public void runvm(VirtualMachine virtualMachine) 
    {
	virtualMachine.pushFrame(argumentCount);
    }
    
    public void init(Vector<String> byteCodetype) 
    {
        argumentCount     = Integer.parseInt(byteCodetype.get(1));
	this.byteCodetype = byteCodetype.get(0);
    }
}