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
 * This class loads literal value n
 */

public class LitCode extends ByteCode 
{
    int    litValue;
    String litId;
    
    public void runvm(VirtualMachine virtualMachine) 
    {
	virtualMachine.pushRunStack(litValue);
    }

    public void init(Vector<String> byteCodetype) 
    {   
        litValue          = Integer.parseInt(byteCodetype.get(1));
	this.byteCodetype = byteCodetype.get(0);
    }
}