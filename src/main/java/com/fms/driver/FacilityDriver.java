package com.fms.driver;

import com.fms.models.Facility;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * Created by e7006722 on 13/03/14.
 */
public class FacilityDriver extends GenericDriver{
    private static int displayFacilityMenu()
    {
        System.out.println("Facility Operations");
        System.out.println();
        System.out.println("Please select from the following options...");
        System.out.println("1. Add a facility");
        System.out.println("2. Update a facility");
        System.out.println("3. Delete a facility");
        System.out.println("4. All facilities");
        System.out.println("5. Find facility by Id");
        System.out.println("6. Facility maintenance operations");
        System.out.println("7. Facility Usage operations");
        System.out.println("8. Back");
        System.out.println();
        System.out.print("Choice: ");
        return console.nextInt();
    }

    private static void findFacility() {
        System.out.print("Facility id? ");
        int id = console.nextInt();
        Facility facility = facilitySvc.findById(id);
        if(facility==null)
            System.err.println("Facility("+id+") not found.");
        else
            System.out.println(facility.toString());
    }

    private static void allFacilities() {
        List<Facility> facilities = facilitySvc.findAll();
        if(CollectionUtils.isEmpty(facilities))
            System.err.println("There are no facilities available.");
        else
            for(Facility facility: facilities)
                System.out.println(facility.toString());
    }

    private static void facilityUsageOps() {
        UsageDriver.usageOps();
    }

    private static void facilityMaintenanceOps() {
        MaintenanceDriver.maintenanceOps();
    }

    private static void deleteFacility() {
        System.out.print("Facility id?");
        int id = console.nextInt();
        if(facilitySvc.findById(id)!=null)
        {
            facilitySvc.delete(new Facility(id));
            System.out.println("Facility("+id+") deleted.");
        }
        else
            System.err.println("Facility("+id+") not found.");
    }

    private static Facility getFacility(Integer id)
    {
        Facility facility = new Facility();

        if(id!=null)
            facility.setId(id);
        System.out.print("Facility name?");
        facility.setName(console.next());
        System.out.print("In Use?");
        facility.setInUse(String.valueOf(console.nextBoolean()));
        System.out.print("Available Capacity?");
        facility.setAvailableCapacity(console.nextInt());
        System.out.print("Down Time?");
        facility.setDownTime(console.next());
        System.out.print("Details?");
        facility.setDetails(console.next());
        return facility;
    }

    private static void updateFacility() {
        System.out.print("Facility id?");
        int id = console.nextInt();
        if(facilitySvc.findById(id)!=null)
        {
            facilitySvc.update(getFacility(id));
            System.out.println("Facility("+id+") updated.");
        }
        else
            System.err.println("Facility("+id+") not found.");
    }

    private static void addFacility() {
        facilitySvc.save(getFacility(null));
        System.out.println("Facility added.");
    }

    public static void facilityOps()
    {
        while(true)
        {
            switch(displayFacilityMenu())
            {
                case 1: addFacility();
                    break;
                case 2: updateFacility();
                    break;
                case 3: deleteFacility();
                    break;
                case 4: allFacilities();
                    break;
                case 5: findFacility();
                    break;
                case 6: facilityMaintenanceOps();
                    break;
                case 7: facilityUsageOps();
                    break;
                case 8: return;
                default:invalidOption();
                    break;
            }
        }
    }
}
