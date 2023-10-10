package ro.fortech.academy.debts.persistence;

import ro.fortech.academy.debts.business.entities.Recovery;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecoveryDataAccessObject {
    public List<Recovery> loadAllRecoveries() {
        List<Recovery> recoveries = new ArrayList<>();
        try (FileReader fileReader = new FileReader("resources/recoveries-in.txt")) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String currentLine = bufferedReader.readLine();
            while (!"---".equals(currentLine)) {
                Recovery currentRecovery = readRecoveries(bufferedReader);
                recoveries.add(currentRecovery);
                currentLine = bufferedReader.readLine();
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        return recoveries;
    }


    private Recovery readRecoveries(BufferedReader bufferedReader) throws IOException {
        String cntrNumber = bufferedReader.readLine();
        String dbtrName = bufferedReader.readLine();
        String dbtTotal = bufferedReader.readLine();
        String payorNot = bufferedReader.readLine();
        String payingWay = bufferedReader.readLine();
        String payingDate = bufferedReader.readLine();
        String percentageDiscount = bufferedReader.readLine();
        String installmentsNumber = bufferedReader.readLine();
        return new Recovery(cntrNumber, dbtrName, dbtTotal, payorNot, payingWay, payingDate, percentageDiscount, installmentsNumber);
    }
}
