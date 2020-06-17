package interpreter;

import interpreter.bytecode.*;
import java.io.*;
import java.util.*;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    Program program;
    
    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */
    public ByteCodeLoader(String file) throws IOException {
	try {
            System.out.println("programfile  " + file);
	    
	    program = new Program();
            Vector<String> arguments = new Vector();
            String line;
            this.byteSource = new BufferedReader(new FileReader(file));
            StringTokenizer stk;
            ByteCode bytecode;

            line = byteSource.readLine();
            do 
            {
                if (line != null) 
                {
                    stk = new StringTokenizer(line);
                
                    while(stk.hasMoreElements()) 
                    {
		    arguments.add((String) stk.nextElement());
                    }
                
                    String byteCodeClass = CodeTable.getClassName(arguments.get(0));
                    //System.out.println("byteCodeClass " + byteCodeClass);
                    bytecode = (ByteCode)(Class.forName("interpreter.bytecode." + byteCodeClass).newInstance());
                    bytecode.init(arguments);
                    program.load(bytecode, line);
                    arguments.removeAllElements();
                    line = byteSource.readLine();
                }
	    } while(line != null);
        } catch (Exception e) 
          {
            System.out.println("Exception in ByteCodeLoader " + e.getMessage());
	  }
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab THE correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    
    public Program loadCodes() 
    {
        //System.out.println("inside loadCodes ");
        program.resolveAddrs();
	return program;
    } 
}
