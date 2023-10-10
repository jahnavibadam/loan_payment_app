package com.natwest.PersonalLoanDocsService.model;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;


public class ZipFileContent {

    private String id;
    private String pathToFolder;
    private List<String> filesInFolder;

    public ZipFileContent() {
    }

    public ZipFileContent(String id, String pathToFolder, List<String> filesInFolder) {
        this.id = id;
        this.pathToFolder = pathToFolder;
        this.filesInFolder = filesInFolder;
    }

    public String getPathToFolder() {
        return pathToFolder;
    }

    public void setPathToFolder(String pathToFolder) {
        this.pathToFolder = pathToFolder;
    }

    public List<String> getFilesInFolder() {
        return filesInFolder;
    }

    public void setFilesInFolder(List<String> filesInFolder) {
        this.filesInFolder = filesInFolder;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
