package com.fms.driver;

import com.fms.models.User;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * Created by e7006722 on 13/03/14.
 */
public class UserDriver extends GenericDriver {
    public static void userOps()
    {
        while(true)
        {
            switch(displayUserMenu())
            {
                case 1: addUser();
                    break;
                case 2: updateUser();
                    break;
                case 3: deleteUser();
                    break;
                case 4: allUser();
                    break;
                case 5: findUser();
                    break;
                case 6: findUserByFacilityId();
                    break;
                case 7: return;
                default:invalidOption();
                    break;
            }
        }
    }

    private static void findUserByFacilityId() {
        System.out.println("Facility Id? ");
        int id = console.nextInt();
        List<User> users = userSvc.findByFacilityId(id);
        display(users);
    }

    private static void display(List<User> users)
    {
        if(CollectionUtils.isEmpty(users))
            System.err.println("Not user record found.");
        else
            for(User user: users)
                System.out.println(user.toString());
    }

    private static void allUser() {
        List<User> users = userSvc.findAll();
        display(users);
    }

    private static void deleteUser() {
        System.out.print("User id? ");
        int id = console.nextInt();
        if(userSvc.findById(id)==null)
            System.err.println("User("+id+") not found");
        else
        {
            userSvc.delete(new User(id));
            System.out.println("User("+id+") deleted");
        }
    }

    private static void findUser() {
        System.out.println("User Id? ");
        int id = console.nextInt();
        User user = userSvc.findById(id);
        if(user==null)
            System.err.println("User("+id+") not found");
        else
            System.out.println(user.toString());
    }

    private static User get(Integer id)
    {
        User user = new User();
        if(id!=null)
            user.setId(id);

        System.out.println("Facility id? ");
        user.setFacilityId(console.nextInt());
        System.out.println("Name? ");
        user.setName(console.next());

        return user;
    }

    private static void updateUser() {
        System.out.println("User Id? ");
        int id = console.nextInt();
        if(userSvc.findById(id)==null)
            System.err.println("User("+id+") not found.");
        else
        {
            userSvc.update(get(id));
            System.out.println("User("+id+") updated.");
        }
    }

    private static void addUser() {
        userSvc.save(get(null));
        System.out.println("User added.");
    }

    private static int displayUserMenu() {
        System.out.println("User Operations");
        System.out.println();
        System.out.println("1. Add a user");
        System.out.println("2. Update a user");
        System.out.println("3. Delete a user");
        System.out.println("4. All user records");
        System.out.println("5. Find user by id");
        System.out.println("6. Find user by facility id");
        System.out.println("7. Back");
        System.out.print("Choice: ");
        return console.nextInt();
    }
}
