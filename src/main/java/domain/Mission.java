package domain;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;

public class Mission {
    private String name;
    private List<String> backendCrew;
    private List<String> frontendCrew;
    
    public Mission(String name) {
        this.name = name;
        backendCrew = new ArrayList<>();
        frontendCrew = new ArrayList<>();
    }
    
    public List<String> getBackendCrew() {
        return backendCrew;
    }
    
    public List<String> getFrontendCrew() {
        return frontendCrew;
    }
    
    public void renewBackendList(List<String> newList) {
        if(!backendCrew.isEmpty()) {
            backendCrew.clear();
        }
        backendCrew.addAll(newList);   
    }
    
    public void renewFrontendList(List<String> newList) {
        if(!frontendCrew.isEmpty()) {
           frontendCrew.clear(); 
        }
        frontendCrew.addAll(newList);   
    }
    
    public String getName() {
        return name;
    }
}
