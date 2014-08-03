package com.filebrowser.filetree;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TreeFileLoader {

    private static final String STARTING_PATH = "/Users/rajkiranveluri/Desktop/MyFolder";

    public static void main(String[] args) {
        TreeFileLoader tt = new TreeFileLoader();
        FileNode<File> rootNode = tt.getTree(STARTING_PATH);
        
        
        
        
       tt.printTree(rootNode);
      //  System.out.println(rootNode);
        
    }

    /**
     * Traverses the tree starting from the root node and
     * prints out the paths to files and directories associated
     * each node.
     *
     * @param rootNode Tree's root node.
     */
    private void printTree(FileNode<File> rootNode) {
        for(FileNode<File> node : rootNode.getChildren()) {
            System.out.println(node.getPayload().getPath());
            if(node.getPayload().isDirectory()) {
                printTree(node);
            }
        }
    }

    /**
     * Loads the tree representing the directory structure under the starting directory path specified.
     *
     * @param startingDirPath Base directory.
     * @return A Node<File> representing.
     */
    private FileNode<File> getTree(String startingDirPath) {
        FileNode<File> rootNode = new FileNode<File>(new File(startingDirPath));
        rootNode.setChildren(this.getSubTree(rootNode));
        return rootNode;
    }

    /**
     * Gets all sub-trees under the node passed.
     *
     * @param dirNode A directory tree node.
     * @return A list of Nodes<File> containing the whole sub-tree.
     */
    private List<FileNode<File>> getSubTree(FileNode<File> dirNode) {
        List<FileNode<File>> children = new LinkedList<FileNode<File>>();
        for(File entry : getFilesDirsDir(dirNode.getPayload())) {
            FileNode<File> node = new FileNode<File>(new File(entry.getPath()));
         //   node.setParent(dirNode);
            children.add(node);
            if(entry.isDirectory()) {
                node.setChildren(getSubTree(node));
            }
        }
        return children;
    }

    /**
     * Obtains files and directories under the specified directory.
     *
     * @param dir
     * @return
     */
    private List<File> getFilesDirsDir(File dir) {
        List<File> filesDirs = new LinkedList<File>();
        for(File f : dir.listFiles())
            filesDirs.add(new File(f.getPath()));
        return filesDirs;
    }
    
    
    public String getJsonTree(FileNode<File> rootNode){
    	
    	Gson gson = new GsonBuilder().create();
       
        String json = gson.toJson(rootNode);
        //System.out.println(jon);
        
       return json;
    }
    /**
     * Returns a JSON string representation of the tree whose root is startingPath
     *
     * @param startingPath The root whose JSON string representation is to be fetched
     * @return The JSON string representation of the tree
     */
    public String getJsonTreeFromStartingPath(String startingPath){
    	
        FileNode<File> rootNode = getTree(startingPath);
        
        
        
        
       return getJsonTree(rootNode);
    }
}