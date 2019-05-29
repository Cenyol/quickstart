package com.cenyol.demo;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        getVmDescByServerName("demo")
                .forEach( desc -> System.out.println( desc.id() + ":" + desc.displayName()));
    }

    /**
     * 获取指定服务名的本地JMX VM 描述对象
     * @param serverName
     * @return
     */
    public static List<VirtualMachineDescriptor> getVmDescByServerName(String serverName){
        List<VirtualMachineDescriptor> vmDescList = new ArrayList<>();
        if (isEmpty(serverName)){
            return vmDescList;
        }
        List<VirtualMachineDescriptor> vms = VirtualMachine.list();
        for (VirtualMachineDescriptor desc : vms) {
            if (desc.displayName().contains(serverName)) {
                vmDescList.add(desc);
            }
        }
        return vmDescList;
    }

    public static boolean isEmpty(String string) {
        return string != null && string.length() == 0;
    }
}
