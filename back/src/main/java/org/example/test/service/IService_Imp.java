package org.example.test.service;




import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
@Service
public class IService_Imp  implements IService {

    @Override
    public int calculateSum(List<String> lines) {
        int sum = 0;

        for (String line : lines) {
            String digitsOnly = line.replaceAll("[^0-9]", ""); // Supprime tout sauf les chiffres

            if (digitsOnly.length() >= 2) {
                int calibrationValue = Integer.parseInt(
                        digitsOnly.charAt(0) + "" + digitsOnly.charAt(digitsOnly.length() - 1)
                );
                sum += calibrationValue;
            }
            else
                if (digitsOnly.length()== 1)
                {
                    sum += Integer.parseInt(digitsOnly+digitsOnly);
                }
        }

        return sum;

    }
    public int calculateSumFromFile(String filePath) throws IOException {
        int sum = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String digitsOnly = line.replaceAll("[^0-9]", "");
                if (digitsOnly.length() >= 2) {
                    // Combiner le premier et le dernier chiffre
                    int calibrationValue = Integer.parseInt(
                            digitsOnly.charAt(0) + "" + digitsOnly.charAt(digitsOnly.length() - 1)
                    );
                    sum += calibrationValue;
                }else
                if (digitsOnly.length()== 1)
                {
                    sum += Integer.parseInt(digitsOnly+digitsOnly);
                }
            }
        }
        return sum;
    }
}

