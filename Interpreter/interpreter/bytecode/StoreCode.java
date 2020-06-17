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

 // This class gets value from top of the stack and stores value in offset n from the start of the current frame

public class StoreCode extends ByteCode 
{
    int offsetVal;
    String idVal;
    
    public void runvm(VirtualMachine virtualMachine) 
    {
	virtualMachine.store(offsetVal);
    }

    public void init(Vector<String> byteCodetype) 
    {
        idVal             = byteCodetype.get(2);
        offsetVal         = Integer.parseInt(byteCodetype.get(1));
	this.byteCodetype = byteCodetype.get(0);
    }
    
}
