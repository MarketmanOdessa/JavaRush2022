package com.javarush.task.task37.task3709.connectors;

import com.javarush.task.task37.task3709.security.SecurityChecker;

public class SecurityProxyConnector implements Connector {
    private SimpleConnector con;
    private SecurityChecker che = new SecurityChecker() {
        @Override
        public boolean performSecurityCheck() {
            System.out.println("SECURITY OK!");
            return true;
        }
    };

    private String s;
    public SecurityProxyConnector(String s) {
        con = new SimpleConnector(s);
    }

    @Override
    public void connect() {
       if (che.performSecurityCheck() == true) {
           con.connect();
       }
    }
}
