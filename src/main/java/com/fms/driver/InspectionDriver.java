package com.fms.driver;

import com.fms.models.Inspection;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * Created by e7006722 on 13/03/14.
 */
public class InspectionDriver extends GenericDriver {
    public static void inspectionOps()
    {
        while(true)
        {
            switch(displayInspectionMenu())
            {
                case 1: addInspection();
                    break;
                case 2: updateInspection();
                    break;
                case 3: deleteInspection();
                    break;
                case 4: allInspection();
                    break;
                case 5: findInspection();
                    break;
                case 6: findInspectionByUsageId();
                    break;
                case 7: return;
                default:invalidOption();
                    break;
            }
        }
    }

    private static void findInspectionByUsageId() {
        System.out.println("Usage Id? ");
        int id = console.nextInt();
        List<Inspection> inspections = inspectionSvc.findByUsageId(id);
        display(inspections);
    }

    private static void display(List<Inspection> inspections)
    {
        if(CollectionUtils.isEmpty(inspections))
            System.err.println("Not inspection record found.");
        else
            for(Inspection inspection: inspections)
                System.out.println(inspection.toString());
    }

    private static void allInspection() {
        List<Inspection> inspections = inspectionSvc.findAll();
        display(inspections);
    }

    private static void deleteInspection() {
        System.out.print("Inspection id? ");
        int id = console.nextInt();
        if(inspectionSvc.findById(id)==null)
            System.err.println("Inspection("+id+") not found");
        else
        {
            inspectionSvc.delete(new Inspection(id));
            System.out.println("Inspection("+id+") deleted");
        }
    }

    private static void findInspection() {
        System.out.println("Inspection Id? ");
        int id = console.nextInt();
        Inspection inspection = inspectionSvc.findById(id);
        if(inspection==null)
            System.err.println("Inspection("+id+") not found");
        else
            System.out.println(inspection.toString());
    }

    private static Inspection get(Integer id)
    {
        Inspection inspection = new Inspection();
        if(id!=null)
            inspection.setId(id);

        System.out.println("Usage id? ");
        inspection.setUsageId(console.nextInt());
        System.out.println("Details? ");
        inspection.setDetails(console.next());
        return inspection;
    }

    private static void updateInspection() {
        System.out.println("Inspection Id? ");
        int id = console.nextInt();
        if(inspectionSvc.findById(id)==null)
            System.err.println("Inspection("+id+") not found.");
        else
        {
            inspectionSvc.update(get(id));
            System.out.println("Inspection("+id+") updated.");
        }
    }

    private static void addInspection() {
        inspectionSvc.save(get(null));
        System.out.println("Inspection added.");
    }

    private static int displayInspectionMenu() {
        System.out.println("Inspection Operations");
        System.out.println();
        System.out.println("1. Add a inspection");
        System.out.println("2. Update a inspection");
        System.out.println("3. Delete a inspection");
        System.out.println("4. All inspection records");
        System.out.println("5. Find inspection by id");
        System.out.println("6. Find inspection by usage id");
        System.out.println("7. Back");
        System.out.print("Choice: ");
        return console.nextInt();
    }
}
