package com.fms;

import com.fms.driver.FacilityDriver;
import com.fms.driver.GenericDriver;
import com.fms.driver.UserDriver;

/**
 * Created by e7006722 on 13/03/14.
 */
public class FMSMain {
    public static void main(String[] args) {
        GenericDriver.init();
        while(true)
        {
            switch(GenericDriver.displayMenu())
            {
                case 1: FacilityDriver.facilityOps();
                    break;
                case 2: UserDriver.userOps();
                    break;
                case 3: return;
                default:
                    GenericDriver.invalidOption();
                    break;
            }
        }
    }
}
