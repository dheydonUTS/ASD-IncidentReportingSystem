package controller;

import java.util.ArrayList;
import static java.util.Collections.min;

/**
 *
 * @author dom_h
 */
public class allocateTicket {
    private int minimum =2147483647;
    public int nextFreeStaff(ArrayList<int[]> staff){
        ArrayList<Integer> tasks = new ArrayList<Integer>() ;
        for(int i = 0; i < staff.size(); i++){                                  // Get # of tasks in array
            tasks.add(staff.get(i)[1]);
        }
        minimum = min(tasks);                                                   // Find smallest number of tasks
        return (int)staff.get(tasks.indexOf(minimum))[0] ;                      // return the ID of staff at pos of minimum
    }
}
