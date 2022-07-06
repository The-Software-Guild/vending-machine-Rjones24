package VendingMachine.Service;

import VendingMachine.dao.AuditDao;
import VendingMachine.dao.VendingPersistenceException;

public class VendingAuditDaoStubImpl implements AuditDao {
    @Override
    public void writeAuditEntry(String entry) throws VendingPersistenceException {
        //exist for test purpose
    }
}
