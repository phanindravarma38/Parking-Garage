package cs414.a4.phanisag.utils;

import java.rmi.RMISecurityManager;
import java.security.Permission;

public class MyRMISecurityManager extends RMISecurityManager{
    @Override
    public void checkPermission(Permission perm) {
        return;
    }
}
