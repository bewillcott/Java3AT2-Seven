/*
 *  File Name:    Server.java
 *  Project Name: SocketServer
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
 * Date: 10 Oct 2021
 * ****************************************************************
 */

package com.bewsoftware.tafe.java3.at2.seven.server.socket;

import com.bewsoftware.tafe.java3.at2.seven.common.CSVFileEvent;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.bewsoftware.tafe.java3.at2.seven.common.Constants.*;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;
import static java.nio.file.StandardOpenOption.WRITE;

/**
 * The Socket Server handles the back-end side of the Chat echo service.
 *
 * @author <a href="mailto:bw.opensource@yahoo.com">Bradley Willcott</a>
 *
 * @since 1.0
 * @version 1.0
 */
public class Server
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT))
        {
            log("\n%1$s", DOUBLE_LINE);
            log("%1$sJava3 AT2 Seven - Socket Server (%2$s)", TITLE_INDENT, VERSION);
            log("%1$s\n", DOUBLE_LINE);
            log("Server is listening on port #%1$d", serverSocket.getLocalPort());
            log("%1$s\n", LINE);

            boolean serverAlive = true;
            int sessionNumber = 0;

            while (serverAlive)
            {
                try (Socket clientSocket = serverSocket.accept())
                { // wait, listen and accept connection
                    sessionNumber++;
                    String clientHostName = clientSocket.getInetAddress().getHostName(); // client name
                    int clientPortNumber = clientSocket.getLocalPort(); // port used

                    log("[%1$d] Connected from %2$s on #%3$d", sessionNumber, clientHostName, clientPortNumber);

                    try (ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());)
                    {
                        CSVFileEvent fileEvent = (CSVFileEvent) inputStream.readObject();

                        Path filePath = Path.of(fileEvent.getDestinationDirectory(),
                                fileEvent.getFilename());

                        if (!new File(fileEvent.getDestinationDirectory()).exists())
                        {
                            new File(fileEvent.getDestinationDirectory()).mkdirs();
                        }

                        try (PrintWriter fileWriter = new PrintWriter(
                                Files.newBufferedWriter(filePath, CREATE, WRITE,
                                        TRUNCATE_EXISTING)))
                        {
                            for (String line : fileEvent.getFileData())
                            {
                                fileWriter.println(line);
                            }
                        }

                        log("Successfully saved incoming file to: %1$s", filePath);

                    } catch (ClassNotFoundException ex)
                    {
                        log("%1$s", ex);
                        serverAlive = false;
                    }
                }
            }
        } catch (IOException ex)
        {
            log("IOException occurred: \n%1$s", ex);
        }
    }
}
