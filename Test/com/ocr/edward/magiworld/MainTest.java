package com.ocr.edward.magiworld;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void Given_ChikenInStandardInput_When_MenuIsRun_Then_DisplayCorrectProcess() {
        System.setIn(new ByteArrayInputStream("1\n".getBytes()));
        order = new Order();
        order.runMenu();
        String output = outContent.toString().replace("\r\n", "\n");
        assertEquals(output.endsWith("Vous avez choisi comme menu : poulet\n"), true);
        assertEquals(output.length() > "Vous avez choisi comme menu : poulet\n".length(), true);
    }

}