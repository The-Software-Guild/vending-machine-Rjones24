package VendingMachine.dao;

import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
@Component
public class AuditDaoImpl implements AuditDao {
    public static final String AUDIT = "VendingMachine/audit.txt";

    @Override
    public void writeAuditEntry(String entry) throws VendingPersistenceException {
        PrintWriter out;
        try {
            out = new PrintWriter((new FileWriter(AUDIT, true)));
        } catch (IOException e) {
            throw new VendingPersistenceException("Could not persist audit information.", e);
        }
        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp + " : " + entry);
        out.flush();
    }
}
