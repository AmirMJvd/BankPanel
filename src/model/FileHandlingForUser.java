package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandlingForUser {
    public void readFile(){
        File file = new File("users.txt");
        try {
            String name;
            String password;
            String username;
            String phoneNumber;
            String email;
            String type;
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                name = scanner.nextLine();
                password = scanner.nextLine();
                username = scanner.nextLine();
                phoneNumber = scanner.nextLine();
                email = scanner.nextLine();
                type = scanner.nextLine();
                if (type.equals("کاربر")) {
                    UsersOnline usersOnline = new UsersOnline(name,password,username,phoneNumber,email,type);
                    usersOnline.setUsersOnlineList();
                }
            }
            scanner.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void writeFile(){
        File file = new File("users.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            FileWriter fileWriter = new FileWriter("users.txt");
            for (UsersOnline usersOnline : UsersOnline.usersOnlineList) {
                fileWriter.write(String.format("%s%n",usersOnline.getName()));
                fileWriter.write(String.format("%s%n",usersOnline.getPassword()));
                fileWriter.write(String.format("%s%n",usersOnline.getUsername()));
                fileWriter.write(String.format("%s%n",usersOnline.getPhoneNumber()));
                fileWriter.write(String.format("%s%n",usersOnline.getEmail()));
                fileWriter.write(String.format("%s%n",usersOnline.getType()));
            }
            fileWriter.close();
            UsersOnline.usersOnlineList.clear();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
