package com.fms.driver;

import com.fms.models.Problem;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * Created by e7006722 on 13/03/14.
 */
public class ProblemDriver extends GenericDriver{
    public static void problemOps()
    {
        while(true)
        {
            switch(displayProblemMenu())
            {
                case 1: addProblem();
                    break;
                case 2: updateProblem();
                    break;
                case 3: deleteProblem();
                    break;
                case 4: allProblem();
                    break;
                case 5: findProblem();
                    break;
                case 6: findProblemByMaintenanceId();
                    break;
                case 7: return;
                default:invalidOption();
                    break;
            }
        }
    }

    private static void findProblemByMaintenanceId() {
        System.out.println("Maintenance Id? ");
        int id = console.nextInt();
        List<Problem> problems = problemSvc.findByMaintenanceId(id);
        display(problems);
    }

    private static void display(List<Problem> problems)
    {
        if(CollectionUtils.isEmpty(problems))
            System.err.println("Not problem record found.");
        else
            for(Problem problem: problems)
                System.out.println(problem.toString());
    }

    private static void allProblem() {
        List<Problem> problems = problemSvc.findAll();
        display(problems);
    }

    private static void deleteProblem() {
        System.out.print("Problem id? ");
        int id = console.nextInt();
        if(problemSvc.findById(id)==null)
            System.err.println("Problem("+id+") not found");
        else
        {
            problemSvc.delete(new Problem(id));
            System.out.println("Problem("+id+") deleted");
        }
    }

    private static void findProblem() {
        System.out.println("Problem Id? ");
        int id = console.nextInt();
        Problem problem = problemSvc.findById(id);
        if(problem==null)
            System.err.println("Problem("+id+") not found");
        else
            System.out.println(problem.toString());
    }

    private static Problem get(Integer id)
    {
        Problem problem = new Problem();
        if(id!=null)
            problem.setId(id);

        System.out.println("Maintenance id? ");
        problem.setMaintenanceId(console.nextInt());
        System.out.println("Details? ");
        problem.setDetails(console.next());
        System.out.println("Resolved On? ");
        problem.setResolvedOn(console.next());
        System.out.println("Is Resolved? ");
        problem.setIsResolved(console.next());
        System.out.println("Found On? ");
        problem.setFoundOn(console.next());

        return problem;
    }

    private static void updateProblem() {
        System.out.println("Problem Id? ");
        int id = console.nextInt();
        if(problemSvc.findById(id)==null)
            System.err.println("Problem("+id+") not found.");
        else
        {
            problemSvc.update(get(id));
            System.out.println("Problem("+id+") updated.");
        }
    }

    private static void addProblem() {
        problemSvc.save(get(null));
        System.out.println("Problem added.");
    }

    private static int displayProblemMenu() {
        System.out.println("Facility Problem Operations");
        System.out.println();
        System.out.println("1. Add a problem");
        System.out.println("2. Update a problem");
        System.out.println("3. Delete a problem");
        System.out.println("4. All problem records");
        System.out.println("5. Find problem by id");
        System.out.println("6. Find problem by maintenance id");
        System.out.println("7. Back");
        System.out.print("Choice: ");
        return console.nextInt();
    }
}
