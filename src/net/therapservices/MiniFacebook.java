package net.therapservices;

import net.therapservices.controller.UserCont;
import net.therapservices.domain.Friendship;
import net.therapservices.domain.User;

import java.util.List;
import java.util.Scanner;

public class MiniFacebook {

    public static void main(String[] args) {
        UserCont userController = new UserCont();
        while (true) {
            System.out.println("choose option :");
            System.out.println("1)Insert User\n" +
                               "2)Delete user\n" +
                               "3)Get user by id\n" +
                               "4)Get All User\n" +
                               "5)Add Status\n" +
                               "6)Find Mutual Friend\n" +
                               "7)Exit");

            Scanner input = new Scanner(System.in);
            int key = input.nextInt();
            if (key == 7)
                break;
            switch (key) {
                case 1:
                    userController.addUser();
                    break;
                case 2:
                    System.out.print("user id: ");
                    input = new Scanner(System.in);
                    userController.deleteUser(input.nextLine());
                    break;
                case 3:
                    System.out.print("user id: ");
                    input = new Scanner(System.in);
                    System.out.println(userController.getUserById(input.nextLine()));
                    break;
                case 4:
                    List<User> allUser = userController.getAllUser();
                    for (User user : allUser) {
                        System.out.println("user = " + user);
                    }
                    break;
                case 5:
                    userController.addStatus();
                    break;
                case 6:
                    System.out.print("user id: ");
                    input = new Scanner(System.in);
                    String userId = input.nextLine();
                    System.out.print("friend id id: ");
                    input = new Scanner(System.in);
                    String friendId = input.nextLine();
                    List<Friendship> mutualFriends = userController.getMutualFriend(userId, friendId);
                    System.out.println("mutual friend of 1 and 4");
                    for (Friendship mutualFriend : mutualFriends) {
                        System.out.println("mutualFriend = " + mutualFriend.getFriendId());
                    }
                    break;
                default:
                    break;

            }
        }
    }
}
