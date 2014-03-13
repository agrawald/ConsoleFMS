package com.fms.driver;

import com.fms.services.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

/**
 * Created by e7006722 on 13/03/14.
 */
public abstract class GenericDriver {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    static Scanner console  = new Scanner(System.in);
    static FacilitySvc facilitySvc;
    static MaintenanceSvc maintenanceSvc;
    static InspectionSvc inspectionSvc;
    static ProblemSvc problemSvc;
    static UsageSvc usageSvc;
    static UserSvc userSvc;

    public static int displayMenu()
    {
        System.out.println("Facility Management System");
        System.out.println();
        System.out.println("Please select from the following options...");
        System.out.println("1. Facility Operations");
        System.out.println("2. User Operations");
        System.out.println("3. Exit");
        System.out.println();
        System.out.print("Choice: ");
        return console.nextInt();
    }

    public static void init()
    {
        facilitySvc = (FacilitySvc) context.getBean("facilitySvc");
        maintenanceSvc = (MaintenanceSvc) context.getBean("maintenanceSvc");
        inspectionSvc = (InspectionSvc) context.getBean("inspectionSvc");
        problemSvc = (ProblemSvc) context.getBean("problemSvc");
        usageSvc = (UsageSvc) context.getBean("usageSvc");
        userSvc = (UserSvc) context.getBean("userSvc");
    }

    public static void invalidOption()
    {
        System.err.println("Invalid option.");
    }
}
