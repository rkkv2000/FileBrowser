FileBrowser
===========

The objective of this is to create a user friendly File Browser


How to test FileBrowserService.

1) Deploy FileBrowserService in Tomcat 7.
2) Download the Firefox plugin POSTER
3) In POSTER set the request method to POST and type in the url in the following format:
    http://localhost:8080/FileBrowserService/service/getFileTree/<root of the directory for which the JSON is requested>
    As an example, for /Users/rajkiranveluri/Desktop/MyFolder
    the request url would be: http://localhost:8080/FileBrowserService/service/getFileTree/Users/rajkiranveluri/Desktop/MyFolder
    
    In Windows, for C:/MyFolder, the request url would be:
    http://localhost:8080/FileBrowserService/service/getFileTree/C:/MyFolder

    As a response, the JSON string containing the tree would be returned.
    
