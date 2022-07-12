package com.tms.quannguyen.practice.utils.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DP
{
    @DataProvider (name = "data-provider")
     public Object[][] dpMethod(){
        return new Object[][] {{"Value Passed"}};
     } 
}
