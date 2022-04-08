package com.haurui;

import static org.junit.Assert.assertTrue;

import com.haurui.entity.Student;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        Student steven = new Student(1, "steven");
        System.out.println(steven);
    }
}
