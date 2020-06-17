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

// This is ByteCode abstract class which initializes ByteCode object

public abstract class ByteCode 
{
    String byteCodetype;
    
    
    public String typeName() 
    {
        return byteCodetype;
    }

    public String labelName() 
    {
        return null;
    }
    
    public void setAddress(int address) 
    {
    }
    
    public abstract void init(Vector<String> argVector);
    
    public abstract void runvm(VirtualMachine virtualMachine);
}
