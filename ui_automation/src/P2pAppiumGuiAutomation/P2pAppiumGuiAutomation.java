/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P2pAppiumGuiAutomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lakshmangunupudi
 */
public class P2pAppiumGuiAutomation {

    /**
     * @param args the command line arguments
     */
    
    

    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, IOException, Exception {
        
        
       try {
            if (args.length < 3) {
                System.out.println("Plese Use syntax <Exe> <Appname> <App Version> <USB ID FOR MOBILE 1 > [USB ID FOR MOBILE 1]");
                System.exit(0);
            }
           
            String appname = args[0];
            String funcname = args[1];
            String mobilID1 = args[2];
   
            Class[] classes = P2pAppiumGuiAutomation.getClasses(appname);
            
            for (Class cla : classes) {
            
                if (cla.getName().toLowerCase().contains(funcname.toLowerCase())) {
                  
                    Class<?> c = Class.forName(cla.getName());
                    Object object=null;
                    if (args.length == 3) {
                        Constructor<?> cons = c.getConstructor(String.class);
                        object = cons.newInstance(mobilID1);
                    } else {
                       Constructor<?> cons = c.getConstructor(String.class,String.class);
                       object = cons.newInstance(mobilID1, args[3]);
                    }
                    executeFunctionality obj = (executeFunctionality)object;
                    try{
                        obj.execute();
                    }catch(Exception Ex)
                    {
                        System.out.println("Exception while running the script "+cla.getName());
                    }
                }
                 
            }
        } catch (IllegalArgumentException | SecurityException ex) {
            Logger.getLogger(P2pAppiumGuiAutomation.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    /**
     * Scans all classes accessible from the context class loader which belong
     * to the given package and subpackages.
     *
     * @param packageName The base package
     * @return The classes
     * @throws ClassNotFoundException
     * @throws IOException
     */
    private static Class[] getClasses(String packageName)
            throws ClassNotFoundException, IOException {
        //ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        
        ClassLoader classLoader =ClassLoader.getSystemClassLoader();
       
        assert classLoader != null;
        
        
        URL jar_file = classLoader.getResource("P2pAppiumGuiAutomation");
       
        String jarname = jar_file.getFile().split(".jar")[0];
        String name = jarname.split("file:")[1];
        return findClasses(name+".jar", packageName);
            
        
    }


public static Class[] findClasses(String jarName,String packageName) 
throws ClassNotFoundException{
    
    ArrayList<Class> classes = new ArrayList<> ();

    packageName = packageName.replaceAll("\\." , "/");
    File f=new File(jarName);
    if(f.exists()){
        try{
            
            JarInputStream jarFile = new JarInputStream(
                    new FileInputStream(jarName));
            JarEntry jarEntry;

            while(true) {
                jarEntry=jarFile.getNextJarEntry ();
                if(jarEntry == null){
                    break;
                }
                
                if((jarEntry.getName ().startsWith (packageName)) &&
                        (jarEntry.getName ().endsWith (".class")) ) {
                    classes.add(Class.forName(jarEntry.getName().
                            replaceAll("/", "\\.").
                            substring(0, jarEntry.getName().length() - 6)));
                    
                }
            }
        }
        catch( IOException | ClassNotFoundException e){
        }
        Class[] classesA = new Class[classes.size()];
        classes.toArray(classesA);
        return classesA;
    }else
        return null;
}
    
}