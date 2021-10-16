/*
 *  File Name:    FTClientTest.java
 *  Project Name: GUIClient
 *
 *  Copyright (c) 2021 Bradley Willcott
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * ****************************************************************
 * Name: Bradley Willcott
 * ID:   M198449
 * Date: 16 Oct 2021
 * ****************************************************************
 */

package com.bewsoftware.tafe.java3.at2.seven.gui.util;

import com.bewsoftware.tafe.java3.at2.seven.common.Constants;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author <a href="mailto:bw.opensource@yahoo.com">Bradley Willcott</a>
 */
public class FTClientTest
{

    private static final String[] CSV_DATA =
    {
        "ID,Title,Studio,Status,Sound,Versions,RecRetPrice,Rating,Year,Genre,Aspect",
        "1,10,Warner Brothers,Out,1.0,\"4:3, LBX, 16:9\",19.98,R,1979,Comedy,2.35:1",
        "1758,12 Angry Men,MGM/UA,Out,1.0,LBX,19.98,NR,1957,Drama,1.66:1",
        "3,12 Monkeys: Collector's Edition,Universal,Cancelled,5.1,\"LBX, 16:9\",29.98,R,1995,Drama,1.85:1",
        "2,12 Monkeys (DTS),Universal,Out,DTS,\"LBX, 16:9\",34.98,R,1995,SciFi,1.85:1",
        "730,12 Monkeys (Special Edition/ Dolby Digital)/ Jackal,Universal,Out,5.1,\"LBX, 16:9\", 34.98, R, 1978, Action / Adventure, VAR"

    };

    @BeforeAll
    public static void setUpClass()
    {
    }

    @AfterAll
    public static void tearDownClass()
    {
    }

    public FTClientTest()
    {
    }

    @BeforeEach
    public void setUp()
    {
    }

    @AfterEach
    public void tearDown()
    {
    }

    /**
     * Test of sendFile method, of class FTClient.
     */
    @Test
    public void testSendFile()
    {
        System.out.println("Testing sendFile");
        String filename = "TestMovies.csv";
        String destinationDir = "downloads";
        List<String> rows = Arrays.asList(CSV_DATA);
        String host = "localhost";
        int port = Constants.SERVER_PORT;
        assertTrue(FTClient.sendFile(filename, destinationDir, rows, host, port));
    }

}
