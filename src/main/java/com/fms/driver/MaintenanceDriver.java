package com.fms.driver;

import com.fms.models.Maintenance;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * Created by e7006722 on 13/03/14.
 */
public class MaintenanceDriver extends GenericDriver {
    public static void maintenanceOps()
    {
        while(true)
        {
            switch(displayMaintenanceMenu())
            {
                case 1: addMaintenance();
                    break;
                case 2: updateMaintenance();
                    break;
                case 3: deleteMaintenance();
                    break;
                case 4: allMaintenance();
                    break;
                case 5: findMaintenance();
                    break;
                case 6: findMaintenanceByFacilityId();
                    break;
                case 7: maintenanceProblemOps();
                    break;
                case 8: return;
                default:invalidOption();
                    break;
            }
        }
    }

    private static void maintenanceProblemOps() {
        ProblemDriver.problemOps();
    }

    private static void findMaintenanceByFacilityId() {
        System.out.println("Facility Id? ");
        int id = console.nextInt();
        List<Maintenance> maintenances = maintenanceSvc.findByFacilityId(id);
        display(maintenances);
    }

    private static void display(List<Maintenance> maintenances)
    {
        if(CollectionUtils.isEmpty(maintenances))
            System.err.println("Not maintenance record found.");
        else
            for(Maintenance maintenance: maintenances)
                System.out.println(maintenance.toString());
    }

    private static void allMaintenance() {
        List<Maintenance> maintenances = maintenanceSvc.findAll();
        display(maintenances);
    }

    private static void deleteMaintenance() {
        System.out.print("Maintenance id? ");
        int id = console.nextInt();
        if(maintenanceSvc.findById(id)==null)
            System.err.println("Maintenance("+id+") not found");
        else
        {
            maintenanceSvc.delete(new Maintenance(id));
            System.out.println("Maintenance("+id+") deleted");
        }
    }

    private static void findMaintenance() {
        System.out.println("Maintenance Id? ");
        int id = console.nextInt();
        Maintenance maintenance = maintenanceSvc.findById(id);
        if(maintenance==null)
            System.err.println("Maintenance("+id+") not found");
        else
            System.out.println(maintenance.toString());
    }

    private static Maintenance get(Integer id)
    {
        Maintenance maintenance = new Maintenance();
        if(id!=null)
            maintenance.setId(id);

        System.out.println("Facility id? ");
        maintenance.setFacilityId(console.nextInt());
        System.out.println("Start Date? ");
        maintenance.setStartDate(console.next());
        System.out.println("End Date? ");
        maintenance.setEndDate(console.next());
        System.out.println("Cost? ");
        maintenance.setCost(console.nextInt());
        return maintenance;
    }

    private static void updateMaintenance() {
        System.out.println("Maintenance Id? ");
        int id = console.nextInt();
        if(maintenanceSvc.findById(id)==null)
            System.err.println("Maintenance("+id+") not found.");
        else
        {
            maintenanceSvc.update(get(id));
            System.out.println("Maintenance("+id+") updated.");
        }
    }

    private static void addMaintenance() {
        maintenanceSvc.save(get(null));
        System.out.println("Maintenance added.");
    }

    private static int displayMaintenanceMenu() {
        System.out.println("Facility Maintenance Operations");
        System.out.println();
        System.out.println("1. Add a maintenance");
        System.out.println("2. Update a maintenance");
        System.out.println("3. Delete a maintenance");
        System.out.println("4. All maintenance records");
        System.out.println("5. Find maintenance by id");
        System.out.println("6. Find maintenance by facility id");
        System.out.println("7. Maintenance Problem Operations");
        System.out.println("8. Back");
        System.out.print("Choice: ");
        return console.nextInt();
    }
}
