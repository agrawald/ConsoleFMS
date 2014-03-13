package com.fms.driver;

import com.fms.models.Usage;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * Created by e7006722 on 13/03/14.
 */
public class UsageDriver extends GenericDriver {
    public static void usageOps()
    {
        while(true)
        {
            switch(displayUsageMenu())
            {
                case 1: addUsage();
                    break;
                case 2: updateUsage();
                    break;
                case 3: deleteUsage();
                    break;
                case 4: allUsage();
                    break;
                case 5: findUsage();
                    break;
                case 6: findUsageByFacilityId();
                    break;
                case 7: usageInspectionOps();
                    break;
                case 8: return;
                default:invalidOption();
                    break;
            }
        }
    }

    private static void usageInspectionOps() {
        InspectionDriver.inspectionOps();
    }

    private static void findUsageByFacilityId() {
        System.out.println("Facility Id? ");
        int id = console.nextInt();
        List<Usage> usages = usageSvc.findByFacilityId(id);
        display(usages);
    }

    private static void display(List<Usage> usages)
    {
        if(CollectionUtils.isEmpty(usages))
            System.err.println("Not usage record found.");
        else
            for(Usage usage: usages)
                System.out.println(usage.toString());
    }

    private static void allUsage() {
        List<Usage> usages = usageSvc.findAll();
        display(usages);
    }

    private static void deleteUsage() {
        System.out.print("Usage id? ");
        int id = console.nextInt();
        if(usageSvc.findById(id)==null)
            System.err.println("Usage("+id+") not found");
        else
        {
            usageSvc.delete(new Usage(id));
            System.out.println("Usage("+id+") deleted");
        }
    }

    private static void findUsage() {
        System.out.println("Usage Id? ");
        int id = console.nextInt();
        Usage usage = usageSvc.findById(id);
        if(usage==null)
            System.err.println("Usage("+id+") not found");
        else
            System.out.println(usage.toString());
    }

    private static Usage get(Integer id)
    {
        Usage usage = new Usage();
        if(id!=null)
            usage.setId(id);

        System.out.println("Facility id? ");
        usage.setFacilityId(console.nextInt());
        System.out.println("Start Date? ");
        usage.setStartDate(console.next());
        System.out.println("End Date? ");
        usage.setEndDate(console.next());
        return usage;
    }

    private static void updateUsage() {
        System.out.println("Usage Id? ");
        int id = console.nextInt();
        if(usageSvc.findById(id)==null)
            System.err.println("Usage("+id+") not found.");
        else
        {
            usageSvc.update(get(id));
            System.out.println("Usage("+id+") updated.");
        }
    }

    private static void addUsage() {
        usageSvc.save(get(null));
        System.out.println("Usage added.");
    }

    private static int displayUsageMenu() {
        System.out.println("Facility Usage Operations");
        System.out.println();
        System.out.println("1. Add a usage");
        System.out.println("2. Update a usage");
        System.out.println("3. Delete a usage");
        System.out.println("4. All usage records");
        System.out.println("5. Find usage by id");
        System.out.println("6. Find usage by facility id");
        System.out.println("7. Usage Inspection Operations");
        System.out.println("8. Back");
        System.out.print("Choice: ");
        return console.nextInt();
    }
}
