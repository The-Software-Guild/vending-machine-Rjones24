package Service;

import DAO.AuditDao;
import DAO.VendingPersistenceException;

public class VendingAuditDaoStubImpl implements AuditDao {
    @Override
    public void writeAuditEntry(String entry) throws VendingPersistenceException {
        //exist for test purpose
    }
}
