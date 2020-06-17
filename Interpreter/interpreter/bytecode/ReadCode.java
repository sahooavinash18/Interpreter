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
import java.io.*;
import interpreter.VirtualMachine;

 // This class reads and puts integer on top of stack

public class ReadCode extends ByteCode 
{
    
    public void runvm(VirtualMachine virtualMachine) 
    {
        BufferedReader inline;
	try {
	    System.out.print("Enter input value : ");
	    inline = new BufferedReader(new InputStreamReader(System.in));
	    String outline = inline.readLine();
	    virtualMachine.pushRunStack(Integer.parseInt(outline));
	} catch(Exception e) 
            {
              System.out.print("Exception occured in ReadCode " + e.getMessage());
            }
    }

    public void init(Vector<String> byteCodetype) 
    {
	this.byteCodetype = byteCodetype.get(0);
    }
    
}
