package org.example.test.service;




import java.io.IOException;
import java.util.List;

public interface IService {
    public int calculateSum(List<String> lines);
    public int calculateSumFromFile(String filePath) throws IOException;




}
