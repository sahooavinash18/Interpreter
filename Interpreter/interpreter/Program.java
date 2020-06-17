package interpreter;

import java.util.ArrayList;
import interpreter.bytecode.*;
import java.io.IOException;
import java.util.*;

public class Program {
     
    private ArrayList<ByteCode> program;
    private ArrayList<String> origProgram;
    HashMap<String, Integer> resolveMap; 
    
    // constructor for program
    public Program() {
        program        = new ArrayList<>();
        resolveMap     = new HashMap();
        origProgram    = new ArrayList<>();
    }
    
    
    // load throws IOException
    // loads the bytecode
    // instantiate bytecode
    public void load(ByteCode bytecode, String originalLine) throws IOException 
    {
        if("LABEL".equals(bytecode.typeName())) 
        {
	    resolveMap.put(bytecode.labelName(), program.size());
	}

	program.add(bytecode);
	origProgram.add(originalLine);	
    }
     
     
     /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * @param program Program object that holds a list of ByteCodes
     */
     public void resolveAddrs() {
         //System.out.println("here2 ");
	 
         int j = 0;
         while(j <= program.size() -1) 
         {
            ByteCode bytecode   = program.get(j);
	    String byteCodetype = bytecode.typeName();
            //System.out.println("type " + byteCodetype);
            
	    if("GOTO".equals(byteCodetype)) 
            {
		String key = bytecode.labelName();
		(program.get(j)).setAddress(resolveMap.get(key));
	    }
            else if("FALSEBRANCH".equals(byteCodetype))
            {
                String key = bytecode.labelName();
		(program.get(j)).setAddress(resolveMap.get(key));
            }
            else if("CALL".equals(byteCodetype))
            {
                String key = bytecode.labelName();
		(program.get(j)).setAddress(resolveMap.get(key));
            }
            j = j + 1;
         }
     }
     
     // Returns the bycode at pc location
     protected ByteCode getCode(int pc) 
     {
	 return program.get(pc);
     }
     
     // Printing of line, created by bytecode at pc location
     public void getBytecode(int pc) 
     {
	 System.out.println(origProgram.get(pc));
     }
     
     public int getSize() {
        return this.program.size();
    } 
}
