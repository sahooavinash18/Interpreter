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
 * used for GOTO, CALL and FALSEBRANCH
 */

public class LabelCode extends ByteCode 
{
    String labelName;
    
    public void runvm(VirtualMachine virtualMachine) 
    {
    }
    
    public String labelName() 
    {
	return labelName;
    }

    public void init(Vector<String> byteCodetype) 
    {
        labelName             = byteCodetype.get(1);
	this.byteCodetype     = byteCodetype.get(0);
    }
}
