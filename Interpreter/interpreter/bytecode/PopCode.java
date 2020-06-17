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

 //This class gets top n levels from stack

public class PopCode extends ByteCode 
{
    int popval;
    
    public void runvm(VirtualMachine virtualMachine) 
    {
        int i = 0;
        while (i <= popval -1)
        {
            virtualMachine.popRunStack();
            i = i + 1;
        }
    }

    public void init(Vector<String> typeAndPop) 
    {
        popval            = Integer.parseInt(typeAndPop.get(1));
	byteCodetype      = typeAndPop.get(0);
    }
    
}
