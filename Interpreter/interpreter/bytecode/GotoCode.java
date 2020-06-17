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
 * GOTO label
 */

public class GotoCode extends ByteCode 
{
    String labelName;
    int    newAddress;
    
    public void runvm(VirtualMachine virtualMachine) 
    {
	virtualMachine.setPC(newAddress - 1);
    }
    
    public String labelName() 
    {
	return labelName;
    }
    
    public void setAddress(int address) 
    {
	newAddress = address;
    }
    
    public void init(Vector<String> byteCodetype) 
    {
        labelName              = byteCodetype.get(1);
	this.byteCodetype      = byteCodetype.get(0);
    }
}
