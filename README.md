
# Java3 AT2 Question 7
This is a TAFE assignment for the Diploma in Software Development,
at the South Metropolitan TAFE, Rockingham, Western Australia.

This project contains a GUI application that reads any CSV file and
displays its contents inside a table. Further, it provides the option 
to upload the CSV file to a back-end server.

## Implementation

This project consists of three sub-projects/modules:

- [GUIClient][gc]
- [SocketServer][ss]
- [Common][c]

### GUI Client

**Note:** The original source code for this project was imported from
another of my projects: [**Java3AT2-Six**][jas].

This application allows the user to perform the following functions:

- Load a local CSV file into a table to view.
- Edit the data in the table.
- Save the modified data to a local file.
- Upload the data to a remote file, via the Socket Server.

Minimum specification for compatible CSV files:

1. Delimiter is a comma: ','
2. Quote character is the double quote: '"'
3. First line is the column headings/field names

All data is treated as plain text - no special treatment for numbers or 
dates when columns are sorted.

### Socket Server

**Note:** The original source code for this project was imported from
another of my projects: [**Java3AT2-Four**][jaf].

This server application provides basic file transfer functionality.  It will
only receive CSV files, storing them on the local file system.


### Common Library

**Note:** The original source code for this project was imported from
another of my projects: [**Java3AT2-Four**][jaf].

This is a non-executable jar, containing a collection of classes that are in 
'common' use across multiple projects.

[gc]:GUIClient
[ss]:SocketServer
[c]:Common
[jas]:https://github.com/bewillcott/Java3AT2-Six
[jaf]:https://github.com/bewillcott/Java3AT2-Four
