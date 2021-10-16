/*
 *  File Name:    CSVFileEvent.java
 *  Project Name: Common
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

package com.bewsoftware.tafe.java3.at2.seven.common;

import java.io.Serializable;

/**
 * This class is used to transfer a file between the client and the server.
 * <p>
 * <b>Note:</b>
 * This code was sourced from:
 * <a href="http://www.coderpanda.com/java-socket-programming-file-transfer-through-socket-in-java/">
 * http://www.coderpanda.com/java-socket-programming-file-transfer-through-socket-in-java/</a>
 * <p>
 * Renamed from FileEvent, and modified to hold String[] instead of byte[].
 *
 * @author <a href="mailto:bw.opensource@yahoo.com">Bradley Willcott</a>
 *
 * @since 1.0
 * @version 1.0
 */
public class CSVFileEvent implements Serializable
{
    private static final long serialVersionUID = -1681097114526781414L;

    private String destinationDirectory;

    private String[] fileData;

    private String filename;

    private String sourceDirectory;

    public CSVFileEvent()
    {
    }

    public String getDestinationDirectory()
    {
        return destinationDirectory;
    }

    public void setDestinationDirectory(String destinationDirectory)
    {
        this.destinationDirectory = destinationDirectory;
    }

    public String[] getFileData()
    {
        return fileData;
    }

    public void setFileData(String[] fileData)
    {
        this.fileData = fileData;
    }

    public String getFilename()
    {
        return filename;
    }

    public void setFilename(String filename)
    {
        this.filename = filename;
    }

    public String getSourceDirectory()
    {
        return sourceDirectory;
    }

    public void setSourceDirectory(String sourceDirectory)
    {
        this.sourceDirectory = sourceDirectory;
    }
}
