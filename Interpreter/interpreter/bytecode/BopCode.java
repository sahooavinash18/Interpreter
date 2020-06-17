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
 * This class performs a binary operation on top two arguments on the runStack and result is pushed back into runStack
 */

public class BopCode extends ByteCode 
{
    String operator;
    
    public void runvm(VirtualMachine virtualMachine) {
        
	int operandtwo = virtualMachine.popRunStack();
	int operandone = virtualMachine.popRunStack();
	
            if (operator.equals("==")) 
            {
                if (operandone == operandtwo) 
                {
                    virtualMachine.pushRunStack(1);
                }
                else {
                    virtualMachine.pushRunStack(0);
                }
            }
            else if (operator.equals("!=")) 
            {
                if (operandone != operandtwo) {
                    virtualMachine.pushRunStack(1);
                }
                else 
                {
                    virtualMachine.pushRunStack(0);
                }
            }
            else if (operator.equals(">")) 
            {
                if (operandone > operandtwo) 
                {
                    virtualMachine.pushRunStack(1);
                }
                else 
                {
                    virtualMachine.pushRunStack(0);
                }
            }
            else if (operator.equals(">=") )
            {
                if (operandone >= operandtwo) 
                {
                    virtualMachine.pushRunStack(1);
                }
                else 
                {
                    virtualMachine.pushRunStack(0);
                }
            }
            else if (operator.equals("<")) 
            {
                if (operandone < operandtwo) 
                {
                    virtualMachine.pushRunStack(1);
                }
                else 
                {
                    virtualMachine.pushRunStack(0);
                }
            }
            else if (operator.equals("<=")) 
            {
                if (operandone <= operandtwo) 
                {
                    virtualMachine.pushRunStack(1);
                }
                else 
                {
                    virtualMachine.pushRunStack(0);
                }
            }
            else if (operator.equals("+")) 
            {
		virtualMachine.pushRunStack(operandone + operandtwo);
            }
            else if (operator.equals("-")) 
            {
		virtualMachine.pushRunStack(operandone - operandtwo);
            }
            else if (operator.equals("*")) 
            {
		virtualMachine.pushRunStack(operandone * operandtwo);
            }
            else if (operator.equals("/")) 
            {
		virtualMachine.pushRunStack(operandone / operandtwo);
            }
    }
    
    public void init(Vector<String> byteCodetype) 
    {
        operator          = byteCodetype.get(1);
	this.byteCodetype = byteCodetype.get(0);
    }
    
}