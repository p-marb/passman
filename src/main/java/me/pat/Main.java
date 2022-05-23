package me.pat;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        System.out.println("Type either CREATE or FIND to make or search a password.");
        PDB pdb = new PDB();
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){

            String str = scan.next();
            if(str.equalsIgnoreCase("CREATE")){
                System.out.println("Please type your password.");
                String password = scan.next();
                System.out.println("Please type the username for this password.");
                String username = scan.next();
                System.out.println("Please type the name you wish this password to be under.");
                String name = scan.next();

                //code to create password.
                Password pwd = PDB.createPassword(username, password, name);
                System.out.println("Created password (ID: + " + pwd.getId() + ").");


            } else if(str.equalsIgnoreCase("FIND")){
                System.out.println("Please type a name or a username to find a password.");
                String next = scan.next();
                //code to find password.

                List<Password> pwdResult = PDB.findPassword(next);

                if(!pwdResult.isEmpty()){
                    for(int i = 0; i < pwdResult.size(); i++){
                        Password pwd = pwdResult.get(i);
                        System.out.printf("Found password: \n" +
                                "ID: " + pwd.getId() + "\n" +
                                "Name: " + pwd.getName() + "\n" +
                                "Username: " + pwd.getUsername() + "\n" +
                                "Password: " + pwd.getPassword() + "\n" +
                                "--------------\n");
                    }
                } else {
                    System.out.println("Could not find password.");

                }

            } else {
                System.out.println("Type either CREATE or FIND to make or search a password.");
            }
        }
    }

}
