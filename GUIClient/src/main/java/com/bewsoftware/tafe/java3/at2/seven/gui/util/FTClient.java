/*
 *  File Name:    FTClient.java
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

import com.bewsoftware.tafe.java3.at2.seven.common.CSVFileEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.file.Path;
import java.util.List;

import static com.bewsoftware.tafe.java3.at2.seven.common.Constants.log;

/**
 * This class handles the transferring of CSV files to the SocketServer.
 *
 * @author <a href="mailto:bw.opensource@yahoo.com">Bradley Willcott</a>
 *
 * @since 1.0
 * @version 1.0
 */
public class FTClient
{
    /**
     * Sending CSVFileEvent object.
     *
     * @param filename       file path of file being sent
     * @param destinationDir server-side directory to store file in
     * @param rows           the data to send
     * @param host           SocketServer host name
     * @param port           Server port number
     *
     * @return {@code true} if successful
     */
    public static boolean sendFile(String filename, String destinationDir,
            List<String> rows, String host, int port)
    {
        boolean rtn = false;

        CSVFileEvent fileEvent = new CSVFileEvent();
        Path filePath = Path.of(filename);
        String fileName = filePath.getFileName().toString();
        String fileDir = filePath.getParent() != null
                ? filePath.getParent().toString() : "";
        fileEvent.setDestinationDirectory(destinationDir);
        fileEvent.setFilename(fileName);
        fileEvent.setSourceDirectory(fileDir);
        fileEvent.setFileData(rows.toArray(new String[rows.size()]));

        //Now writing the CSVFileEvent object to socket
        try (Socket socket = new Socket(host, port);
                ObjectOutputStream outputStream
                = new ObjectOutputStream(socket.getOutputStream());)
        {
            outputStream.writeObject(fileEvent);
            log("File sent");
            rtn = true;
        } catch (IOException ex)
        {
            log("%1$s", ex);
        }

        return rtn;
    }

    private FTClient()
    {

    }
}
